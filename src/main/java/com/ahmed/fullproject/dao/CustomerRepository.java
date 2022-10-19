package com.ahmed.fullproject.dao;

import com.ahmed.fullproject.entity.Customer;
import com.ahmed.fullproject.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String> {

    Optional<Customer> findByUsername(String username);

    Object findAll(Pageable pageable);
}