package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.database.CabDAL;
import com.kavitameena.cabmanagement.database.CabHistoryDAL;
import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.CabSnapshot;
import com.kavitameena.cabmanagement.repository.ICabHistoryRepository;
import com.kavitameena.cabmanagement.repository.ICabRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabHistoryService implements ICabHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(CabHistoryService.class);

    private CabDAL cabRepository;
    private CabHistoryDAL cabHistoryRepository;

    public CabHistoryService(CabDAL cabRepository, CabHistoryDAL cabHistoryRepository) {
        this.cabRepository = cabRepository;
        this.cabHistoryRepository = cabHistoryRepository;
    }

    public List<CabSnapshot> getCabHistory(long cabId) {
        Cab cab = cabRepository.findCabById(cabId);
        if (cab == null) {
            // cab doesnt exist
            return null;
        }
        List<CabSnapshot> cabHistory = cabHistoryRepository.getCabHistory(cabId);
        return cabHistory;
    }
}
