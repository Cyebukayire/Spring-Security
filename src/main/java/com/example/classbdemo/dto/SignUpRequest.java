package com.example.classbdemo.dto;

import com.example.classbdemo.enumerations.ERoleName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("unused")
public class SignUpRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String mobile;

    @Email
    private String email;

    @NotBlank
    private String password;

    private ERoleName roleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ERoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(ERoleName roleName) {
        this.roleName = roleName;
    }

}

