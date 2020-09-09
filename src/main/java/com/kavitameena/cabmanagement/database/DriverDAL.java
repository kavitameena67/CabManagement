package com.kavitameena.cabmanagement.database;

import com.kavitameena.cabmanagement.controllers.CabController;
import com.kavitameena.cabmanagement.model.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DriverDAL {

    private static final Logger logger = LoggerFactory.getLogger(DriverDAL.class);

    private Map<Long, Driver> drivers = new HashMap<>();

    public Driver addDriver(@NonNull final Driver newDriver) {
        drivers.put(newDriver.getId(), newDriver);
        return newDriver;
    }

}
