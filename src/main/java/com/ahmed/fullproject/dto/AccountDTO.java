package com.ahmed.fullproject.dto;

import com.ahmed.fullproject.entity.Employee;

public class AccountDTO extends AbstractDTO<Integer> {
    private Integer accountId;
    private String userName;
    private String password;
    private Employee employee;

    public AccountDTO() {
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAccountId() {
        return this.accountId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }
}