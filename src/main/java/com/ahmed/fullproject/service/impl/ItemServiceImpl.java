package com.ahmed.fullproject.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ahmed.fullproject.dao.ItemRepository;
import com.ahmed.fullproject.entity.Item;
import com.ahmed.fullproject.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item save(Item entity) {
        return repository.save(entity);
    }

    @Override
    public List<Item> save(List<Item> entities) {
        return (List<Item>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Item> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>) repository.findAll();
    }

    @Override
    public Page<Item> findAll(Pageable pageable) {
        Page<Item> entityPage = repository.findAll(pageable);
        List<Item> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Item update(Item entity, Integer id) {
        Optional<Item> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}