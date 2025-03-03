package com.example.namhuytuan.service.product;

import com.example.namhuytuan.model.category.Category;
import com.example.namhuytuan.model.product.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Category category);
    Product saveProduct(Product product);
    Product findById(Long id);
}
