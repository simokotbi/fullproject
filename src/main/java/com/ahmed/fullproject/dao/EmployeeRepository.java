package com.ahmed.fullproject.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmed.fullproject.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String> {

    Optional<Employee> findByUsername(String username);

}