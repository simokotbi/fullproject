package com.ahmed.fullproject.service.impl;

import com.ahmed.fullproject.dao.ProductRepository;
import com.ahmed.fullproject.dto.ProductDTO;
import com.ahmed.fullproject.entity.Product;
import com.ahmed.fullproject.mapper.ProductMapper;
import com.ahmed.fullproject.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product entity) {
        return repository.save(entity);
    }

    @Override
    public List<Product> save(List<Product> entities) {
        return (List<Product>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Page<Product> entityPage = repository.findAll(pageable);
        List<Product> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Product update(Product entity, Integer id) {
        Optional<Product> optional = findById(id) );
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}