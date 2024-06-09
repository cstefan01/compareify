package com.compareify.compareify.models;

import jakarta.persistence.*;

@Entity
@Table(name = "phone", schema = "compareify")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phone_model_id", nullable = false)
    private PhoneModel phoneModel;

    @Column(name="color", nullable = false)
    private String color;
    
    @Column(name="capacity", nullable = false)
    private String capacity;
    
    // Constructors
    public Phone(){}
    
    public Phone(String color,String capacity ) {
        this.color = color;
        this.capacity = capacity;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneModel getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(PhoneModel phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
