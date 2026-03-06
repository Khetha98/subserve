package co.za.subserve.subserve_backend.dto.request;

import lombok.Data;

@Data
public class ServiceRequestDTO {

    private String userId;

    private String serviceType;

    private String description;

    private String documentUrl;

    private String phoneNumber;

}
