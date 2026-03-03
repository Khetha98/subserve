package co.za.subserve.subserve_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class ProductSnapshotId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private UUID odooProductId;
    private String name;
    private String description;
    private String imageUrl;
    private String price;
    private String stock;
    private String category;
    private String lastSyncedAt;
    private boolean isActive;
}
