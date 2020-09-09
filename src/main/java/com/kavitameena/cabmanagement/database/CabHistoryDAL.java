package com.kavitameena.cabmanagement.database;

import com.kavitameena.cabmanagement.controllers.CabController;
import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.CabSnapshot;
import com.kavitameena.cabmanagement.model.City;
import com.kavitameena.cabmanagement.service.UniqueIDGenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CabHistoryDAL {

    private static final Logger logger = LoggerFactory.getLogger(CabHistoryDAL.class);

    private Map<Long, ArrayList<CabSnapshot>> cabHistory = new HashMap<>();

    public void addCabSnapshot(Cab cab) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Long id = UniqueIDGenService.getNextId();
        CabSnapshot cabSnapshot = new CabSnapshot(id, cab, timestamp.getTime());
        cabHistory.computeIfAbsent(cabSnapshot.getId(), a -> new ArrayList<>()).add(cabSnapshot);
    }

    public List<CabSnapshot> getCabHistory(Long cabId) {
        return cabHistory.get(cabId);
    }
}
