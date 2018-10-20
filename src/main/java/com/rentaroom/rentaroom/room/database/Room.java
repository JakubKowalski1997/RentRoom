package com.rentaroom.rentaroom.room.database;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    private Long id;
    private double price;
    private String address;// TODO need to create Address class

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
