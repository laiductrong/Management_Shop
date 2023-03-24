package com.example.demo.repository;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepos extends JpaRepository<Customer, Integer> {
    //be used login
    List<Customer> findByPhonenumberAndName(String phoneNumber, String name);
}
