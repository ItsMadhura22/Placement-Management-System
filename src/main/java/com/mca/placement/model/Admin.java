package com.mca.placement.model;


import jakarta.persistence.*;

@Entity
@Table(name="admin_users")

public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;

    private String username;
    private String password;

    public Admin(){}

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
