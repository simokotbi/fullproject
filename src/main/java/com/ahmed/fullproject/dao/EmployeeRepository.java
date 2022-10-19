package com.ahmed.fullproject.dao;

import com.ahmed.fullproject.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,String> {

    Optional<Employee> findByUsername(String username);

}