package com.ahmed.fullproject.dto;

import com.ahmed.fullproject.entity.Employee;

import java.util.Date;
import java.util.Set;

public class OrderDTO extends AbstractDTO<Integer> {
    private Integer orderId;
    private String orderStatus;
    private Double orderPrice;
    private Date entryDate;
    private String notes;

    private Set<Employee> employees;

    public OrderDTO() {
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getOrderPrice() {
        return this.orderPrice;
    }

    public void setEntryDate(java.util.Date entryDate) {
        this.entryDate = entryDate;
    }

    public java.util.Date getEntryDate() {
        return this.entryDate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return this.notes;
    }



    public void setEmployees(java.util.Set<com.ahmed.fullproject.entity.Employee> employees) {
        this.employees = employees;
    }

    public java.util.Set<com.ahmed.fullproject.entity.Employee> getEmployees() {
        return this.employees;
    }
}