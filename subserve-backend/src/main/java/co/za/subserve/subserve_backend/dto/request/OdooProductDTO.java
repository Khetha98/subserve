package co.za.subserve.subserve_backend.dto.request;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OdooProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal stock;
    private String category;
    private String imageUrl;
    private String description;
}
