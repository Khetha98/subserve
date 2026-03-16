package co.za.subserve.subserve_backend.service.productService;

import co.za.subserve.subserve_backend.dto.request.OdooProductDTO;
import co.za.subserve.subserve_backend.model.ProductSnapshot;
import co.za.subserve.subserve_backend.model.SyncMetadata;
import co.za.subserve.subserve_backend.repository.ProductSnapshotRepository;
import co.za.subserve.subserve_backend.repository.SyncMetadataRepository;
import co.za.subserve.subserve_backend.service.odooClientService.OdooClient;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSyncService {

    private final ProductSnapshotRepository productRepo;
    private final SyncMetadataRepository syncRepo;
    private final OdooClient odooClient;

    private static final long SYNC_INTERVAL_MINUTES = 15;
    private static final Logger log =
            LoggerFactory.getLogger(OdooClient.class);

    @PostConstruct
    public void init() {
        log.info("ProductSyncService initialized — running syncIfNeeded()");
        syncIfNeeded();
    }

    public void syncIfNeeded() {
        log.info("Checking if product sync is needed...");
        SyncMetadata meta = syncRepo.findById("PRODUCT_SYNC")
                .orElse(new SyncMetadata("PRODUCT_SYNC", LocalDateTime.MIN));
        log.info("Last synced at: {}", meta.getLastSyncedAt());

        //if (meta.getLastSyncedAt().plusMinutes(SYNC_INTERVAL_MINUTES)
                //.isBefore(LocalDateTime.now())) {
        if(true){
            log.info("Syncing products from Odoo...");
            List<OdooProductDTO> odooProducts = odooClient.fetchProducts();
            log.info("Fetched {} products from Odoo", odooProducts.size());

            productRepo.deleteAll(); // simple version for now
            odooProducts.forEach(dto -> {
                ProductSnapshot p = new ProductSnapshot();
                p.setOdooProductId(dto.getId());
                p.setName(dto.getName());
                p.setDescription(dto.getDescription());
                p.setPrice(dto.getPrice());
                p.setStock(dto.getStock());
                p.setCategory(dto.getCategory());
                p.setImage(dto.getImage());
                p.setActive(true);
                productRepo.save(p);
            });

            meta.setLastSyncedAt(LocalDateTime.now());
            syncRepo.save(meta);
            log.info("Product sync completed");
        } else {
            log.info("Sync not needed yet");
        }
    }
}
