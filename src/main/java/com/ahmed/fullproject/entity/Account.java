package com.ahmed.fullproject.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "account")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer accountId;
    private String userName;
    private String password;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(@NonNull Employee employee) {
        this.employee = employee;
    }
}
