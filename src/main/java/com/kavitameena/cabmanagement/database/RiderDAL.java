package com.kavitameena.cabmanagement.database;

import com.kavitameena.cabmanagement.controllers.CabController;
import com.kavitameena.cabmanagement.exception.RiderAlreadyExistsException;
import com.kavitameena.cabmanagement.exception.RiderNotFoundException;
import com.kavitameena.cabmanagement.model.Rider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RiderDAL {

    private static final Logger logger = LoggerFactory.getLogger(RiderDAL.class);

    private Map<Long, Rider> riders = new HashMap<>();

    public Rider addRider(@NonNull final Rider newRider) {
        riders.put(newRider.getId(), newRider);
        return newRider;
    }

    public Rider getRider(@NonNull final String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderNotFoundException();
        }
        return riders.get(riderId);
    }
}
