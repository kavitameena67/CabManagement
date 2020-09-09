package com.kavitameena.cabmanagement.model;

public class Trip {

    private Long id;
    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private City source;
    private City destination;

    public Trip(Long id, Rider rider, Cab cab, TripStatus tripStatus, Double price, City source, City destination) {
        this.id = id;
        this.rider = rider;
        this.cab = cab;
        this.tripStatus = tripStatus;
        this.price = price;
        this.source = source;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public City getSource() {
        return source;
    }

    public void setSource(City source) {
        this.source = source;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }
}
