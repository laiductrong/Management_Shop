package com.example.demo.repository;

import com.example.demo.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepos extends JpaRepository<Receipt, Integer> {
}
