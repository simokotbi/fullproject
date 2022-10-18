package com.ahmed.fullproject.controller.impl;

import com.ahmed.fullproject.controller.AccountController;
import com.ahmed.fullproject.dto.AccountDTO;
import com.ahmed.fullproject.entity.Account;
import com.ahmed.fullproject.mapper.AccountMapper;
import com.ahmed.fullproject.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/account")
@RestController
public class AccountControllerImpl implements AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AccountControllerImpl(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO save(@RequestBody AccountDTO accountDTO) {
        Account account = accountMapper.asEntity(accountDTO);
        return accountMapper.asDTO(accountService.save(account));
    }

    @Override
    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable("id") Integer id) {
        Account account = accountService.findById(id).orElse(null);
        return accountMapper.asDTO(account);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        accountService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AccountDTO> list() {
        return accountMapper.asDTOList(accountService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AccountDTO> pageQuery(Pageable pageable) {
        Page<Account> accountPage = accountService.findAll(pageable);
        List<AccountDTO> dtoList = accountPage
                .stream()
                .map(accountMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, accountPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AccountDTO update(@RequestBody AccountDTO accountDTO, @PathVariable("id") Integer id) {
        Account account = accountMapper.asEntity(accountDTO);
        return accountMapper.asDTO(accountService.update(account, id));
    }
}