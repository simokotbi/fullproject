package com.ahmed.fullproject.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ahmed.fullproject.dao.EmployeeRepository;
import com.ahmed.fullproject.entity.Employee;
import com.ahmed.fullproject.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public List<Employee> save(List<Employee> entities) {
        return (List<Employee>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(String.valueOf(id));
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return repository.findById(String.valueOf(Long.valueOf(id)));
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

  /*  @Override
    public Page<Employee> findAll(Pageable pageable) {
        Page<Employee> entityPage = (Page<Employee>) repository.findAll(pageable);
        List<Employee> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }*/

    @Override
    public Employee update(Employee entity, Integer id) {
        Optional<Employee> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}