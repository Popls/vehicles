package com.microservice.vehicles.application.service.impl;

import java.util.List;

import com.microservice.vehicles.application.repository.VehiclesRepository;
import com.microservice.vehicles.application.service.VehiclesService;
import com.microservice.vehicles.domain.model.Vehicles;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
public class VehiclesServiceImpl implements VehiclesService {

  private VehiclesRepository vehiclesRepository;

  @Override
  public List<Vehicles> saveAll(List<Vehicles> vehicles) {
    log.debug("Removing old vehicles");
    vehiclesRepository.deleteAll();
    log.debug("Saving vehicles {}", vehicles.toString());
    return vehiclesRepository.saveAll(vehicles);
  }

}
