package co.za.subserve.subserve_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class ServiceListing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID providerId;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String price;
}
