package com.example.quickbazar.Controller;

import com.example.quickbazar.Entity.Product;
import com.example.quickbazar.Pojo.ProductPojo;
import com.example.quickbazar.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public String saveProduct(@RequestBody ProductPojo productPojo) throws IOException {
        productService.saveProduct(productPojo);
        return "Saved successfully";
    }

    @GetMapping("/findAll")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
