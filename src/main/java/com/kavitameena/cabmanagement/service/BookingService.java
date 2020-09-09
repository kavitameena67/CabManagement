package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.dto.RideRequestDTO;
import com.kavitameena.cabmanagement.model.*;
import com.kavitameena.cabmanagement.strategy.BookingStrategy;
import com.kavitameena.cabmanagement.strategy.PricingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    private CabService cabService;
    private BookingStrategy bookingStrategy;
    private PricingStrategy pricingStrategy;

    public BookingService(CabService cabService, BookingStrategy bookingStrategy, PricingStrategy pricingStrategy) {
        this.cabService = cabService;
        this.bookingStrategy = bookingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    public Trip bookCab(RideRequestDTO rideRequestDTO) {

        Rider rider = rideRequestDTO.getRider();
        City source = rideRequestDTO.getSource();
        City destination = rideRequestDTO.getDestination();

        if ((rider == null) || (source == null) || (destination == null)) {
            // invalid request
            return null;
        }

        List<Cab> cabs = cabService.getAllCabsInCity(source);
        Cab cabAssigned = bookingStrategy.findCab(cabs);
        if (cabAssigned == null) {
            // no cabs available
            return null;
        }

        Double priceCalculated = pricingStrategy.calculatePrice(source, destination);
        if (priceCalculated == null) {
            // failed to calculate price
            return null;
        }

        Long tripId = UniqueIDGenService.getNextId();
        Trip tripCreated = new Trip(tripId, rider, cabAssigned, TripStatus.IN_PROGRESS, priceCalculated, source, destination);
        return tripCreated;
    }

}
