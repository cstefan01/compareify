package com.compareify.compareify.models;

import jakarta.persistence.*;

@Entity
@Table(name = "comparison", schema = "compareify")
public class Comparison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phone_id", nullable = false)
    private Phone phone;

    @Column(name="price", nullable = false)
    private Double price;
    
    @Column(length = 2048, name="url", nullable = false)
    private String url;
    
    @Column(length = 255, name="third_party", nullable = false)
    private String thirdParty;

    // Constructors
    public Comparison() {}

    public Comparison(Double price, String url, String thirdParty) {
        this.price = price;
        this.url = url;
        this.thirdParty = thirdParty;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getThirdParty(){
        return thirdParty;
    }
    
    public void setThirdParty(String thirdParty){
        this.thirdParty = thirdParty;
    }
}
