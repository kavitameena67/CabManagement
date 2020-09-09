package com.kavitameena.cabmanagement.model;

public class CabSnapshot {

    Long id;
    Cab cab;
    CabState newState; // keep only IDLE - State transitions
    City newCity; // when cab was IDLE, what was the source city
    long timeStamp;

    public CabSnapshot(Long id, Cab cab, long timeStamp) {
        this.id = id;
        this.cab = cab;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public CabState getNewState() {
        return newState;
    }

    public void setNewState(CabState newState) {
        this.newState = newState;
    }

    public City getNewCity() {
        return newCity;
    }

    public void setNewCity(City newCity) {
        this.newCity = newCity;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
