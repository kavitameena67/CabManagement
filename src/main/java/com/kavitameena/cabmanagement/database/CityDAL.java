package com.kavitameena.cabmanagement.database;

import com.kavitameena.cabmanagement.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CityDAL {

    private static final Logger logger = LoggerFactory.getLogger(CityDAL.class);

    private Map<Long, City> cities = new HashMap<>();

    public City findCityById(Long cityId) {
        return cities.getOrDefault(cityId, null);
    }

    public List<City> findAll() {
        return new ArrayList<>(cities.values());
    }

    public City addCity(@NonNull final City newCity) {
        cities.put(newCity.getId(), newCity);
        return newCity;
    }

}
