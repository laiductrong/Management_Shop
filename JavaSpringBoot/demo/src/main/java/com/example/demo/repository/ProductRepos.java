package com.example.demo.repository;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepos extends JpaRepository<Product, String> {
    //find product by name when user search
    List<Product> findByIdcategory (String idcategory);
}
