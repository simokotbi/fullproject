package com.ahmed.fullproject.dao;

import com.ahmed.fullproject.entity.Item;
import com.ahmed.fullproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}