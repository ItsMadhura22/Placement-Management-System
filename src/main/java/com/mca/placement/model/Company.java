package com.mca.placement.model;

import jakarta.persistence.*;

@Entity
public class Company {
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String role;
    private double packageAmount;

    // Constructors
    public Company() {}

    public Company(String name, String location, String role, double packageAmount) {
        this.name = name;
        this.location = location;
        this.role = role;
        this.packageAmount = packageAmount;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getPackageAmount() { return packageAmount; }
    public void setPackageAmount(double packageAmount) { this.packageAmount = packageAmount; }
    
}
