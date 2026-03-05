package co.za.subserve.subserve_backend.controller.productController;

import co.za.subserve.subserve_backend.model.ProductSnapshot;
import co.za.subserve.subserve_backend.service.productService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductSnapshot>> getProducts() {
        return ResponseEntity.ok(productService.getActiveProducts());
    }

    @PostMapping
    public ResponseEntity<List<ProductSnapshot>> getProducts(int id) {
        return ResponseEntity.ok(productService.getActiveProducts());
    }
}