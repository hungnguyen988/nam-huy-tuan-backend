package com.example.namhuytuan.controller;

import com.example.namhuytuan.model.category.Category;
import com.example.namhuytuan.model.product.Product;
import com.example.namhuytuan.service.category.CategoryService;
import com.example.namhuytuan.service.category.ICategoryService;
import com.example.namhuytuan.service.product.IProductService;
import com.example.namhuytuan.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProductController {
    private final IProductService productService;

    @Autowired
    private CategoryService categoryService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) Long id) {
        List<Product> products;

        if (id != null) {
            Optional<Category> optionalCategory = categoryService.getCategoryById(id);
            if (optionalCategory.isEmpty()) {
                return ResponseEntity.notFound().build(); // 404 Not Found nếu không tìm thấy Category
            }
            products = productService.getProductsByCategory(optionalCategory.get());
        } else {
            products = productService.getAllProducts();
        }

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content nếu danh sách sản phẩm rỗng
        }

        return ResponseEntity.ok(products); // 200 OK nếu có sản phẩm
    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct); // 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(product); // 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}
