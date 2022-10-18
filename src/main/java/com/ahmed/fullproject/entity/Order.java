package com.ahmed.fullproject.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "`order`")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer orderId;
    private String orderStatus;
    private Double orderPrice;
    private Date entryDate;
    private String notes;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Product> products ;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Employee> employees;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
