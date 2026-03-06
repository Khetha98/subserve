package co.za.subserve.subserve_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {

    @Id
    private String id;

    private String userId;

    private String serviceType;

    private String description;

    private String documentUrl;

    private String status;

}
