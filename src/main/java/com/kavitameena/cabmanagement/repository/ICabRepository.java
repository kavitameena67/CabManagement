package com.kavitameena.cabmanagement.repository;

import com.kavitameena.cabmanagement.model.Cab;

import com.kavitameena.cabmanagement.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICabRepository  {
    List<Cab> findByCity(City city);
}
