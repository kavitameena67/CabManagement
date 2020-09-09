package com.kavitameena.cabmanagement.controllers;

import com.kavitameena.cabmanagement.dto.RideRequestDTO;
import com.kavitameena.cabmanagement.model.Trip;
import com.kavitameena.cabmanagement.service.BookingService;
import com.kavitameena.cabmanagement.service.IBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rider")
public class TripController {

    private static final Logger logger = LoggerFactory.getLogger(TripController.class);

    private IBookingService bookingService;

    public TripController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/bookcab", method = RequestMethod.POST)
    public ResponseEntity bookCab(@RequestBody RideRequestDTO rideRequestDTO) {
        Trip tripCreated = bookingService.bookCab(rideRequestDTO);
        return ResponseEntity.ok(tripCreated);
    }

}
