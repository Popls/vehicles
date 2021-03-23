package com.microservice.vehicles.infrastructure.rest.spring.mapper;

import java.util.List;

import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.entity.VehiclesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EntityMapper {

  public abstract List<VehiclesEntity> vehiclesListToVehiclesEntityList(List<Vehicles> vehicles);

  public abstract List<Vehicles> vehiclesEntityListToVehiclesList(List<VehiclesEntity> vehiclesEntity);

  public abstract VehiclesEntity vehiclesToVehiclesEntity(Vehicles vehicles);

  public abstract Vehicles vehiclesEntityToVehicles(VehiclesEntity vehiclesEntity);

}
