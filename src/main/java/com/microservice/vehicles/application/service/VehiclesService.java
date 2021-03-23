package com.microservice.vehicles.application.service;

import java.util.List;

import com.microservice.vehicles.domain.model.Vehicles;

public interface VehiclesService {

  List<Vehicles> saveAll(List<Vehicles> vehicles);

}
