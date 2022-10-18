package com.ahmed.fullproject.dto;

import com.ahmed.fullproject.entity.Item;

import java.util.Set;

public class ProductDTO extends AbstractDTO<Integer> {
    private Integer productId;
    private String productName;
    private double price;
    private Set<Item> items;

    public ProductDTO() {
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setItems(java.util.Set<com.ahmed.fullproject.entity.Item> items) {
        this.items = items;
    }

    public java.util.Set<com.ahmed.fullproject.entity.Item> getItems() {
        return this.items;
    }
}