package com.kavitameena.cabmanagement.controllers;

import com.kavitameena.cabmanagement.dto.CabDTO;
import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.CabSnapshot;
import com.kavitameena.cabmanagement.model.CabState;
import com.kavitameena.cabmanagement.model.City;
import com.kavitameena.cabmanagement.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class CabController {

    private static final Logger logger = LoggerFactory.getLogger(CabController.class);

    private ICabService cabService;
    private ICityService cityService;
    private ICabHistoryService cabHistoryService;

    public CabController(ICabService cabService, ICityService cityService, ICabHistoryService cabHistoryService) {
        this.cabService = cabService;
        this.cityService = cityService;
        this.cabHistoryService = cabHistoryService;
    }

    @RequestMapping(value = "/cab", method = RequestMethod.POST)
    public ResponseEntity registerCab(@RequestBody final CabDTO cabDTO) {
        Cab savedCab = cabService.addCab(cabDTO);
        return ResponseEntity.ok(savedCab);
    }

    @RequestMapping(value = "/location", method = RequestMethod.POST)
    public ResponseEntity onboardLocation(@RequestBody final String cityName) {
        City savedCity = cityService.addCity(cityName);
        return ResponseEntity.ok(savedCity);
    }

    @RequestMapping(value = "/cab/{cabId}/location/{cityId}", method = RequestMethod.PUT)
    public ResponseEntity updateCabLocation(@PathVariable final long cabId, @PathVariable final long cityId) {
        Cab updatedCab = cabService.updateCabLocation(cabId, cityId);
        return ResponseEntity.ok(updatedCab);
    }

    @RequestMapping(value = "/cab/{cabId}/state", method = RequestMethod.PUT)
    public ResponseEntity updateCabState(@PathVariable final long cabId, @RequestBody final String cabState) {
        Cab updatedCab = cabService.updateCabState(cabId, cabState);
        return ResponseEntity.ok(updatedCab);
    }

    @RequestMapping(value = "/cab/{cabId}/history", method = RequestMethod.GET)
    public ResponseEntity fetchCabHistory(@PathVariable final long cabId) {
        List<CabSnapshot> cabHistory = cabHistoryService.getCabHistory(cabId);
        return ResponseEntity.ok(cabHistory);
    }

}
