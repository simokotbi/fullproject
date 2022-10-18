package com.ahmed.fullproject.dto;

import com.ahmed.fullproject.entity.Order;

import java.util.Set;

public class CustomerDTO extends AbstractDTO<Integer> {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Set<Order> orders;

    public CustomerDTO() {
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setOrders(java.util.Set<com.ahmed.fullproject.entity.Order> orders) {
        this.orders = orders;
    }

    public java.util.Set<com.ahmed.fullproject.entity.Order> getOrders() {
        return this.orders;
    }
}