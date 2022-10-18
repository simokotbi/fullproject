package com.ahmed.fullproject.service.impl;

import com.ahmed.fullproject.dao.AccountRepository;
import com.ahmed.fullproject.dto.AccountDTO;
import com.ahmed.fullproject.entity.Account;
import com.ahmed.fullproject.mapper.AccountMapper;
import com.ahmed.fullproject.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account entity) {
        return repository.save(entity);
    }

    @Override
    public List<Account> save(List<Account> entities) {
        return (List<Account>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        Page<Account> entityPage = repository.findAll(pageable);
        List<Account> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Account update(Account entity, Integer id) {
        Optional<Account> optional = findById(id) );
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}