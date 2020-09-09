package com.kavitameena.cabmanagement.model;

public class Cab {

    private Long id;
    private String numberPlate;
    private Driver driver; // assuming car owner is driver
    private City currCity;
    private CabState currentCabState;
    private boolean isAvailable;
    private long lastTripTime; // maintain min heap with oldest time at top

    public Cab(Long id, String numberPlate, Driver driver, boolean isAvailable, CabState currentCabState) {
        this.id = id;
        this.numberPlate = numberPlate;
        this.driver = driver;
        this.isAvailable = isAvailable;
        this.currentCabState = currentCabState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getLastTripTime() {
        return lastTripTime;
    }

    public void setLastTripTime(long lastTripTime) {
        this.lastTripTime = lastTripTime;
    }

    public City getCurrCity() {
        return currCity;
    }

    public void setCurrCity(City currCity) {
        this.currCity = currCity;
    }

    public CabState getCurrentCabState() {
        return currentCabState;
    }

    public void setCurrentCabState(CabState currentCabState) {
        this.currentCabState = currentCabState;
    }
}
