package co.za.subserve.subserve_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor // REQUIRED BY JPA
@AllArgsConstructor
public class SyncMetadata {

    @Id
    private String id; // "PRODUCT_SYNC"

    private LocalDateTime lastSyncedAt;

}
