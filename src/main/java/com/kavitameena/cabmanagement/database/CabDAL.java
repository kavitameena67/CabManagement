package com.kavitameena.cabmanagement.database;

import com.kavitameena.cabmanagement.controllers.CabController;
import com.kavitameena.cabmanagement.exception.CabAlreadyExistsException;
import com.kavitameena.cabmanagement.exception.CabNotFoundException;
import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.CabState;
import com.kavitameena.cabmanagement.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CabDAL {

    private static final Logger logger = LoggerFactory.getLogger(CabDAL.class);

    private Map<Long, Cab> cabs = new HashMap<>();
    private CabHistoryDAL cabHistoryDAL;

    public CabDAL(CabHistoryDAL cabHistoryDAL) {
        this.cabHistoryDAL = cabHistoryDAL;
    }

    public Cab addCab(@NonNull final Cab newCab) {
        cabs.put(newCab.getId(), newCab);
        return newCab;
    }

    public Cab findCabById(@NonNull final Long cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        return cabs.get(cabId);
    }

    public Cab updateCabCity(@NonNull final Long cabId, @NonNull final City newCity) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setCurrCity(newCity);
        return cabs.get(cabId);
    }

    public Cab updateCabState(@NonNull final Long cabId, @NonNull final CabState newCabState) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        // capture old cab state
        CabState oldCabState = cabs.get(cabId).getCurrentCabState();
        cabs.get(cabId).setCurrentCabState(newCabState);

        // Update ab availability based on cab state changes
        boolean isAvailable = (newCabState.equals(CabState.IDLE)) ? true : false;
        cabs.get(cabId).setAvailable(isAvailable);

        // capture cab state change snapshot
        if (!newCabState.equals(oldCabState)) {
            cabHistoryDAL.addCabSnapshot(cabs.get(cabId));
        }

        return cabs.get(cabId);
    }

    public List<Cab> findCabsByCity(@NonNull final City source) {
        List<Cab> result = new ArrayList<>();
        if (cabs == null || cabs.isEmpty()) return null;
        for (Cab cab : cabs.values()) {
            if ( cab.getCurrCity().equals(source) && cab.isAvailable()) {
                // && cab.getCurrentCabState().equals(CabState.IDLE)
                result.add(cab);
            }
        }
        return result;
    }

}
