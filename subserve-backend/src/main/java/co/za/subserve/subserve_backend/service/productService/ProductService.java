package co.za.subserve.subserve_backend.service.productService;

import co.za.subserve.subserve_backend.model.ProductSnapshot;
import co.za.subserve.subserve_backend.repository.ProductSnapshotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductSnapshotRepository repository;
    private final ProductSyncService syncService;

    public List<ProductSnapshot> getActiveProducts() {

        syncService.syncIfNeeded();

        return repository.findByIsActiveTrue();
    }

    public ProductSnapshot getProductById(UUID id){
        return repository.findById(id).orElseThrow();
    }
}
