package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.dto.RideRequestDTO;
import com.kavitameena.cabmanagement.model.Trip;
import org.springframework.stereotype.Service;

@Service
public interface IBookingService {

    Trip bookCab(RideRequestDTO rideRequestDTO);

}
