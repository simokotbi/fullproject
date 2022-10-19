package com.ahmed.fullproject.dao;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmed.fullproject.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String> {

    Optional<Customer> findByUsername(String username);

    Object findAll(Pageable pageable);
}