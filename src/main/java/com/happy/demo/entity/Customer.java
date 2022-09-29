package com.happy.demo.entity;

import javax.persistence.*;
import java.util.LinkedList;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "PhoneNumber", length = 20)
    private String phone;

    @Column(name = "Address")
    private String address;

    @OneToOne
    @JoinColumn(name = "Username")
    private Account account;

    public Customer() {
    }

    public Customer(Long id, String name, String phone, String address, Account account) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
