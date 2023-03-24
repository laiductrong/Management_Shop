package com.example.demo.repository;

import com.example.demo.models.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepos extends JpaRepository<CategoryEntity, String> {
}
