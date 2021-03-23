package com.microservice.vehicles.infrastructure.rest.spring.repository.impl;

import java.util.List;

import com.microservice.vehicles.application.repository.VehiclesRepository;
import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.entity.VehiclesEntity;
import com.microservice.vehicles.infrastructure.rest.spring.mapper.EntityMapper;
import com.microservice.vehicles.infrastructure.rest.spring.repository.VehiclesSpringRepository;
import org.springframework.stereotype.Repository;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Repository
@Builder
@Slf4j
public class VehiclesRepositoryImpl implements VehiclesRepository {

  private final EntityMapper entityMapper;
  private final VehiclesSpringRepository vehiclesSpringRepository;

  @Override
  public List<Vehicles> saveAll(List<Vehicles> vehicles) {
    log.debug("Mapping domain vehicles to entities vehicles {}", vehicles.toString());
    List<VehiclesEntity> vehiclesEntities = entityMapper.vehiclesListToVehiclesEntityList(vehicles);
    List<VehiclesEntity> vehiclesEntitiesSaved = vehiclesSpringRepository.saveAll(vehiclesEntities);
    log.debug("Mapping entities vehicles to domain vehicles {}", vehiclesEntitiesSaved.toString());
    return entityMapper.vehiclesEntityListToVehiclesList(vehiclesEntitiesSaved);
  }

  @Override
  public void deleteAll() {
    vehiclesSpringRepository.deleteAll();
  }

}
