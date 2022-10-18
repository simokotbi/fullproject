package com.ahmed.fullproject.dao;

import com.ahmed.fullproject.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {
}