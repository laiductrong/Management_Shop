package com.example.demo.repository;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepos extends JpaRepository<Customer, Integer> {
}
