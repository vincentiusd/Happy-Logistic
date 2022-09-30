package com.happy.demo.dto.account;


import javax.validation.constraints.NotBlank;


public class RegisterDTO {

    @NotBlank(message = "Field is required")
    private String username;

    @NotBlank(message = "Field is required")
    private String name;

    @NotBlank(message = "Field is required")
    private String address;

    @NotBlank(message = "Field is required")
    private  String phone;


    @NotBlank(message = "Field is required")
    private String password;

    @NotBlank(message = "Field is required")
    private String passwordConfirmation;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, String name, String address, String phone, String password, String passwordConfirmation) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
