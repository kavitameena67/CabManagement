package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.database.CabDAL;
import com.kavitameena.cabmanagement.database.CityDAL;
import com.kavitameena.cabmanagement.dto.CabDTO;
import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.CabState;
import com.kavitameena.cabmanagement.model.City;
import com.kavitameena.cabmanagement.repository.ICabRepository;
import com.kavitameena.cabmanagement.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CabService implements ICabService {

    private static final Logger logger = LoggerFactory.getLogger(CabService.class);

    private UniqueIDGenService idGen;
    private CabDAL cabRepository;
    private CityDAL cityRepository;

    public CabService(CabDAL cabRepository, CityDAL cityRepository) {
        this.cabRepository = cabRepository;
        this.cityRepository = cityRepository;
    }

    public Cab addCab(CabDTO newCab) {
        long cabId = UniqueIDGenService.getNextId();
        Cab cabEntity = new Cab(cabId, newCab.getNumberPlate(), newCab.getDriver(), true, CabState.IDLE );
        Cab savedcab = cabRepository.addCab(cabEntity);
        if (savedcab == null) {
           // failed to add new cab
        }
        return savedcab;
    }

    public Cab updateCabLocation(long cabId, long cityId) {
        Cab cabEntity = cabRepository.findCabById(cabId);
        City city = cityRepository.findCityById(cityId);
        if (city == null) {
            // this city is not onboarded
            return cabEntity;
        }
        cabEntity.setCurrCity(city);
        Cab savedCab = cabRepository.addCab(cabEntity);
        return savedCab;
    }

    public Cab updateCabState(long cabId, String state) {
        CabState newState = CabState.valueOf(state);
        Cab cabEntity = cabRepository.findCabById(cabId);
        if (newState == null) {
            // invalid input
            return null;
        }
        CabState oldState = cabEntity.getCurrentCabState();
        if (newState.equals(oldState)) {
            // no update
            return cabEntity;
        }
        cabEntity.setCurrentCabState(newState);
        Cab savedCab = cabRepository.addCab(cabEntity);
        return savedCab;
    }

    public List<Cab> getAllCabsInCity(City city) {
        List<Cab> cabs = cabRepository.findCabsByCity(city);
        return cabs;
    }
}
