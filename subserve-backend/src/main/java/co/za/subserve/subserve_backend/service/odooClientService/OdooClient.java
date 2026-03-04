package co.za.subserve.subserve_backend.service.odooClientService;

import co.za.subserve.subserve_backend.dto.request.OdooProductDTO;
import co.za.subserve.subserve_backend.dto.response.OdooResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class OdooClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final Logger log =
            LoggerFactory.getLogger(OdooClient.class);

    private Integer authenticate() {

        Map<String, Object> request = Map.of(
                "jsonrpc", "2.0",
                "method", "call",
                "params", Map.of(
                        "service", "common",
                        "method", "login",
                        "args", List.of("subserve", "admin", "admin")
                ),
                "id", 1
        );

        ResponseEntity<Map> response =
                restTemplate.postForEntity(
                        "http://localhost:8069/jsonrpc",
                        request,
                        Map.class
                );

        Object result = response.getBody().get("result");

        if (result == null) {
            throw new RuntimeException("Odoo authentication failed");
        }

        return ((Number) result).intValue();
    }

    public List<OdooProductDTO> fetchProducts() {
        log.info("Authenticating with Odoo...");
        Integer uid = authenticate();
        log.info("Authenticated with UID: {}", uid);
        Map<String, Object> request = Map.of(
                "jsonrpc", "2.0",
                "method", "call",
                "params", Map.of(
                        "service", "object",
                        "method", "execute_kw",
                        "args", List.of(
                                "subserve",
                                uid,
                                "admin",
                                "product.template",
                                "search_read",
                                List.of(
                                        List.of(
                                                List.of("sale_ok", "=", true),
                                                List.of("active", "=", true),
                                                List.of("type", "in", List.of("consu", "product")),
                                                List.of("categ_id", "in", List.of(4)) // only Food category
                                        )
                                ),
                                Map.of(
                                        "fields", List.of(
                                                "id",
                                                "name",
                                                "list_price",
                                                "qty_available",
                                                "type",
                                                "sale_ok",
                                                "active",
                                                "categ_id",
                                                "description_sale"
                                        )
                                )
                        )
                ),
                "id", 2
        );

        ResponseEntity<OdooResponse> response =
                restTemplate.postForEntity(
                        "http://localhost:8069/jsonrpc",
                        request,
                        OdooResponse.class
                );
        log.info("Odoo raw result: {}", response.getBody().getResult());
        return mapToDTO(response.getBody());
    }


    private List<OdooProductDTO> mapToDTO(OdooResponse response) {

        if (response == null || response.getResult() == null) {
            return List.of();
        }

        return response.getResult().stream()
                .map(productMap -> {

                    Long id = ((Number) productMap.get("id")).longValue();

                    String name = (String) productMap.get("name");

                    String description = productMap.get("description_sale") instanceof String
                            ? (String) productMap.get("description_sale")
                            : null;

                    List<Object> categoryData = (List<Object>) productMap.get("categ_id");
                    String category = null;
                    if (categoryData != null && categoryData.size() > 1) {
                        category = categoryData.get(1).toString();
                    }

                    BigDecimal price = new BigDecimal(
                            productMap.get("list_price").toString()
                    );

                    BigDecimal stock = new BigDecimal(
                            productMap.get("qty_available").toString()
                    );

                    return new OdooProductDTO(id, name, price, stock, category, description);
                })
                .toList();
    }
}
