package co.za.subserve.subserve_backend.model;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@ToString
public class ProductSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Long odooProductId;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private BigDecimal stock;
    private String category;
    @UpdateTimestamp
    private LocalDateTime lastSyncedAt;
    private boolean isActive;

    public UUID getId() {
        return id;
    }

    public Long getOdooProductId() {
        return odooProductId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getLastSyncedAt() {
        return lastSyncedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setOdooProductId(Long odooProductId) {
        this.odooProductId = odooProductId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLastSyncedAt(LocalDateTime lastSyncedAt) {
        this.lastSyncedAt = lastSyncedAt;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
