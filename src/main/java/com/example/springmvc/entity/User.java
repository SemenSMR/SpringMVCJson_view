package com.example.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserSummary.class)
    private Long id;
    @NotBlank
    @JsonView(Views.UserSummary.class)
    private String nameUsers;
    @Email
    @JsonView(Views.UserSummary.class)
    private String emailUsers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(Views.UserDetails.class)
    private List<Order> orders;

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameUsers(String nameUsers) {
        this.nameUsers = nameUsers;
    }

    public void setEmailUsers(String emailUsers) {
        this.emailUsers = emailUsers;
    }

    public Long getId() {
        return id;
    }

    public String getNameUsers() {
        return nameUsers;
    }

    public String getEmailUsers() {
        return emailUsers;
    }
}
