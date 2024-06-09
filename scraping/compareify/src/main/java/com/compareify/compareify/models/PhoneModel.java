package com.compareify.compareify.models;

import jakarta.persistence.*;

@Entity
@Table(name = "phone_model", schema = "compareify")
public class PhoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="model", nullable = false)
    private String model;
    
    @Column(name="brand", nullable = false)
    private String brand;
    
    @Column(name="description", nullable = false)
    private String description;
    
    @Column(name="image_url", nullable = false)
    private String imageUrl;
    
    // Constructors
    public PhoneModel(){}
    
    public PhoneModel(String model,String brand,String description,String imageUrl){
        this.model = model;
        this.brand = brand;
        this.description = description;
        this.imageUrl = imageUrl; 
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
