package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.dto.CabDTO;
import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICabService {

    public List<Cab> getAllCabsInCity(City city);
    public Cab addCab(CabDTO cab);
    public Cab updateCabLocation(long cabId, long cityId);
    public Cab updateCabState(long cabId, String state);
}
