package co.za.subserve.subserve_backend.repository;

import co.za.subserve.subserve_backend.model.SyncMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyncMetadataRepository extends JpaRepository<SyncMetadata, String> {

}
