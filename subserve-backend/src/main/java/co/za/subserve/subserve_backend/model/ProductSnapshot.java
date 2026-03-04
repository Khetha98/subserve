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
public class ProductSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID odooProductId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String imageUrl;
    private String price;
    private String stock;
    private String category;
    private String lastSyncedAt;
    private boolean isActive;
}
