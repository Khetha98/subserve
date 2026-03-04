package co.za.subserve.subserve_backend.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OdooResponse {

    private String jsonrpc;
    private Object id;
    private List<Map<String, Object>> result;
}
