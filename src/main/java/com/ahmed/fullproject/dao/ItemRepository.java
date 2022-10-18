package com.ahmed.fullproject.dao;

import com.ahmed.fullproject.entity.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> {
}