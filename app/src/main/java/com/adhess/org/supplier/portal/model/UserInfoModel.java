package com.adhess.org.supplier.portal.model;

import java.util.List;

public class UserInfoModel {

    private String username;
    private String name;
    private String telephone;
    private String fax;
    private String email;

    private Address address;

    private String role;

    private List<String> authorities;


    public UserInfoModel(String username, String name, String telephone, String fax, String email, Address address, String role, List<String> authorities) {
        this.username = username;
        this.name = name;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.address = address;
        this.role = role;
        this.authorities = authorities;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", role='" + role + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
