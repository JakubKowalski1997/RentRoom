package com.rentaroom.map.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Location {
    private Long id;

    private Long addressId;

    private Long geoLocationId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getGeoLocationId() {
        return geoLocationId;
    }

    public void setGeoLocationId(Long geoLocationId) {
        this.geoLocationId = geoLocationId;
    }
}
