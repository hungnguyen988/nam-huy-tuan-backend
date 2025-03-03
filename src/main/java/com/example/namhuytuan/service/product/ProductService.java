package com.example.namhuytuan.service.product;

import com.example.namhuytuan.model.category.Category;
import com.example.namhuytuan.model.product.Product;
import com.example.namhuytuan.repository.product.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}

