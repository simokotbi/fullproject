package com.ahmed.fullproject.entity;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer productId;

    private String productName;

    private double price;

    @ManyToMany
    @JoinColumn(name = "ItemId")
    Set<Item> items;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}