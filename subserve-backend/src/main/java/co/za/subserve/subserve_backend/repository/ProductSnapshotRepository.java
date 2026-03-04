package co.za.subserve.subserve_backend.repository;

import co.za.subserve.subserve_backend.model.ProductSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductSnapshotRepository extends JpaRepository<ProductSnapshot, UUID> {
    List<ProductSnapshot> findByIsActiveTrue();
}
