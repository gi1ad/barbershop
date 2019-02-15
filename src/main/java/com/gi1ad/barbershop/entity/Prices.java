package com.gi1ad.barbershop.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "prices")
public class Prices {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(strategy = "increment",name = "increment")
    private long id;

    @Column(name = "price_image",nullable = false)
    private byte[] priceImage;


    public Prices(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getPriceImage() {
        return priceImage;
    }

    public void setPriceImage(byte[] priceImage) {
        this.priceImage = priceImage;
    }
}
