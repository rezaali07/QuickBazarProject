package com.example.quickbazar.Service.Impl;

import com.example.quickbazar.Entity.Category;
import com.example.quickbazar.Entity.Product;
import com.example.quickbazar.Entity.SubCategory;
import com.example.quickbazar.Pojo.ProductPojo;
import com.example.quickbazar.Repo.CategoryRepo;
import com.example.quickbazar.Repo.ProductRepo;
import com.example.quickbazar.Repo.SubCategoryRepo;
import com.example.quickbazar.Service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final SubCategoryRepo subCategoryRepo;

    private final String UPLOAD_DIRECTORY = new StringBuilder().append(System.getProperty("user.dir")).append("/QuickBazar-Images/Product-images").toString();

    @Override
    public void saveProduct(ProductPojo productPojo) throws IOException {
        Product product;
        if (productPojo.getId() != null) {
            product = productRepo.findById(productPojo.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + productPojo.getId()));
        } else {
            product = new Product();
        }

        product.setProductName(productPojo.getProductName());
        product.setProductBrand(productPojo.getProductBrand());
        product.setProductCondition(productPojo.getProductCondition());
        product.setPrice(productPojo.getPrice());
        product.setAddress(productPojo.getAddress());
        product.setProductDiscription(productPojo.getProductDiscription());

        Category category = categoryRepo.findById(productPojo.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + productPojo.getCategoryId()));

        SubCategory subCategory = subCategoryRepo.findById(Integer.valueOf(productPojo.getSubCategoryId()))
                .orElseThrow(() -> new IllegalArgumentException("Sub-Category not found with ID: " + productPojo.getSubCategoryId()));

        if (productPojo.getProductImage() != null) {
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productPojo.getProductImage());
            Files.write(fileNameAndPath, productPojo.getProductImage().getBytes());
        }
        product.setProductImage(productPojo.getProductImage());

        product.setCategory(category);
        product.setSubCategory(subCategory.getCategory());
        productRepo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getSubCategoryById(Integer id) {
        return productRepo.findById(id);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepo.findById(id);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepo.deleteById(id);
    }
}
