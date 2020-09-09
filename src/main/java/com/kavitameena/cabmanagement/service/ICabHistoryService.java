package com.kavitameena.cabmanagement.service;

import com.kavitameena.cabmanagement.model.CabSnapshot;

import java.util.List;

public interface ICabHistoryService {

    public List<CabSnapshot> getCabHistory(long cabId);
}
