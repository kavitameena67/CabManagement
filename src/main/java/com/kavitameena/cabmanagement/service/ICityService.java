package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICityService {

    public City addCity(String cityName);
    public List<City> getListOfAvailableCities();
}
