package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.database.CityDAL;
import com.kavitameena.cabmanagement.model.City;
import com.kavitameena.cabmanagement.repository.ICityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    private static final Logger logger = LoggerFactory.getLogger(CityService.class);

    private CityDAL cityRepository;

    public CityService(CityDAL cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City addCity(String cityName) {
        long cityId = UniqueIDGenService.getNextId();
        City cityCreated = new City(cityId, cityName);
        City savedCity = cityRepository.addCity(cityCreated);
        if (savedCity != null) {
            // success save
        }
        return savedCity;
    }

    public List<City> getListOfAvailableCities() {
        return cityRepository.findAll();
    }
}
