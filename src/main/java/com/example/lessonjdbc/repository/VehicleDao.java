package com.example.lessonjdbc.repository;

import com.example.lessonjdbc.model.Vehicle;

import java.util.List;

public interface VehicleDao {
    int count();

    int save(Vehicle book);

    int update(Vehicle book);

    int deleteById(Long id);

    List<Vehicle> findAll();

    List<Vehicle> findByProductionYearBetween(Long yearBeg, Long yearEnd);

    Vehicle findById(Long id);
}
