package com.kavitameena.cabmanagement.dto;

import com.kavitameena.cabmanagement.model.City;
import com.kavitameena.cabmanagement.model.Rider;

import java.util.Date;

public class RideRequestDTO {

    private Rider rider;
    private City source;
    private City destination;
    //private Date travelDate; // past date invalid, future booking - stretch goal

    public RideRequestDTO(Rider rider, City source, City destination) {
        this.rider = rider;
        this.source = source;
        this.destination = destination;
        //this.travelDate = travelDate;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
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
