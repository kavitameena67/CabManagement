package com.kavitameena.cabmanagement.dto;

import com.kavitameena.cabmanagement.model.Driver;

public class CabDTO {

    private String numberPlate;
    private Driver driver;

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
