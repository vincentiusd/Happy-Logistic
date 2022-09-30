package com.happy.demo.dto.customer;

import javax.persistence.Column;

public class CustomerGridDTO {

    private Long id;

    private String username;

    private String name;

    private String phone;

    private String address;

    public CustomerGridDTO() {
    }

    public CustomerGridDTO(Long id, String username, String name, String phone, String address) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
