package com.kavitameena.cabmanagement.repository;

import com.kavitameena.cabmanagement.model.Cab;
import com.kavitameena.cabmanagement.model.CabSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICabHistoryRepository {

    List<CabSnapshot> findByCab(Cab cab);
}
