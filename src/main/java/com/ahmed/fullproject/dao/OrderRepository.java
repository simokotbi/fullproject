package com.ahmed.fullproject.dao;

import com.ahmed.fullproject.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
}