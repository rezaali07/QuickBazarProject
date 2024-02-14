package com.example.quickbazar.Service;


import com.example.quickbazar.Entity.Product;
import com.example.quickbazar.Pojo.ProductPojo;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    void saveProduct(ProductPojo productPojo)  throws IOException;

    List<Product> findAll();

    Optional<Product> getSubCategoryById(Integer id);

    Optional<Product> getProductById(Integer id);

    void deleteProductById(Integer id);
}
