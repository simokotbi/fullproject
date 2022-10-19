package com.ahmed.fullproject.service;

import com.ahmed.fullproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerService extends JpaRepository<Customer, Integer> {
}