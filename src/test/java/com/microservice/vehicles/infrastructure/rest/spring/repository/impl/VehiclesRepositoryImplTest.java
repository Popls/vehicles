package com.microservice.vehicles.infrastructure.rest.spring.repository.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vehicles.application.repository.VehiclesRepository;
import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.entity.VehiclesEntity;
import com.microservice.vehicles.infrastructure.rest.spring.mapper.EntityMapper;
import com.microservice.vehicles.infrastructure.rest.spring.repository.VehiclesSpringRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VehiclesRepositoryImplTest {

  public final String INPUT_FILES_PATH = "src/test/resources/domain/model/";
  public final VehiclesSpringRepository vehiclesSpringRepository = Mockito
      .mock(VehiclesSpringRepository.class);
  public final EntityMapper entityMapper = Mockito.mock(EntityMapper.class);
  public VehiclesRepository vehiclesRepository;
  public List<Vehicles> vehicles;
  public List<VehiclesEntity> vehiclesEntities;
  public ObjectMapper objectMapper;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper();
    vehiclesRepository = VehiclesRepositoryImpl.builder()
        .vehiclesSpringRepository(vehiclesSpringRepository).entityMapper(entityMapper).build();
  }

  @Test
  public void saveAll() throws IOException {
    vehicles = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json")), Vehicles[].class));
    vehiclesEntities = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicleEntities.json")),
            VehiclesEntity[].class));
    when(vehiclesSpringRepository.saveAll(any())).thenReturn(vehiclesEntities);
    when(entityMapper.vehiclesListToVehiclesEntityList(anyList())).thenReturn(vehiclesEntities);
    when(entityMapper.vehiclesEntityListToVehiclesList(anyList())).thenReturn(vehicles);
    vehiclesRepository.saveAll(vehicles);
    verify(vehiclesSpringRepository, times(1)).saveAll(any());
    verify(entityMapper, times(1)).vehiclesListToVehiclesEntityList(any());
    verify(entityMapper, times(1)).vehiclesEntityListToVehiclesList(any());
  }

  @Test
  public void saveAllEmpty() throws IOException {
    vehicles = new ArrayList<>();
    vehiclesEntities = new ArrayList<>();
    when(vehiclesSpringRepository.saveAll(any())).thenReturn(vehiclesEntities);
    when(entityMapper.vehiclesListToVehiclesEntityList(anyList())).thenReturn(vehiclesEntities);
    when(entityMapper.vehiclesEntityListToVehiclesList(anyList())).thenReturn(vehicles);
    vehiclesRepository.saveAll(vehicles);
    verify(vehiclesSpringRepository, times(1)).saveAll(any());
    verify(entityMapper, times(1)).vehiclesListToVehiclesEntityList(any());
    verify(entityMapper, times(1)).vehiclesEntityListToVehiclesList(any());
  }

  @Test(expected = NullPointerException.class)
  public void saveAllNull() throws IOException {
    when(vehiclesSpringRepository.saveAll(any())).thenThrow(NullPointerException.class);
    when(entityMapper.vehiclesListToVehiclesEntityList(anyList())).thenReturn(null);
    when(entityMapper.vehiclesEntityListToVehiclesList(anyList())).thenReturn(null);
    vehiclesRepository.saveAll(null);
    verify(vehiclesSpringRepository, times(1)).saveAll(any());
    verify(entityMapper, times(1)).vehiclesListToVehiclesEntityList(any());
    verify(entityMapper, times(0)).vehiclesEntityListToVehiclesList(any());
  }

  @Test
  public void deleteAll() {
    doNothing().when(vehiclesSpringRepository).deleteAll();
    vehiclesRepository.deleteAll();
    verify(vehiclesSpringRepository, times(1)).deleteAll();
  }
}