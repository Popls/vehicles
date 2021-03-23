package com.microservice.vehicles.application.repository;

import java.util.List;

import com.microservice.vehicles.domain.model.Vehicles;

public interface VehiclesRepository {

  List<Vehicles> saveAll(List<Vehicles> vehicles);

  void deleteAll();

}
