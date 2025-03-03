package com.example.namhuytuan.model.product;

import com.example.namhuytuan.model.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String price;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @Column(name = "is_best_seller")
    private boolean isBestSeller;
}

