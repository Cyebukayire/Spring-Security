package com.example.classbdemo.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.classbdemo.enumerations.EAccountStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "first name is compulsory")
    private String firstName;

    @NotNull(message = "last name is compulsory")
    private String lastName;

    private String fullName;

    @NotNull
    private String username;

    private String mobile;

    @NotNull
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private EAccountStatus status;

    @JsonIgnore
    @NotNull
    private String password;

    private String activationCode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

    public User(@NotNull(message = "first name is compulsory") String firstName,
                @NotNull(message = "last name is compulsory") String lastName, @NotNull String mobile,
                @NotNull @Email @Size(max = 100) String email, @NotNull @Size(min = 5, max = 100) String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public User(@NotNull(message = "first name is compulsory") String firstName,
                @NotNull(message = "last name is compulsory") String lastName,
                @NotNull @Email @Size(max = 100) String email, @NotNull @Size(min = 5, max = 100) String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public EAccountStatus getStatus() {
        return status;
    }

    public void setStatus(EAccountStatus status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
