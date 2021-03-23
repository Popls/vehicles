package com.microservice.vehicles.infrastructure.rest.spring.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.entity.VehiclesEntity;
import org.junit.Before;
import org.junit.Test;

public class EntityMapperImplTest {

  public final String INPUT_FILES_PATH = "src/test/resources/domain/model/";
  public ObjectMapper objectMapper;
  public EntityMapper entityMapper;
  public List<Vehicles> vehicles;
  public List<VehiclesEntity> vehiclesEntities;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper();
    entityMapper = new EntityMapperImpl();
  }

  @Test
  public void vehiclesToVehiclesEntity() throws IOException {
    vehicles = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json")), Vehicles[].class));
    vehiclesEntities = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicleEntities.json")),
            VehiclesEntity[].class));
    assertEquals(objectMapper.writeValueAsString(vehiclesEntities.get(0)),
        objectMapper.writeValueAsString(entityMapper.vehiclesToVehiclesEntity(vehicles.get(0))));
  }

  @Test
  public void vehiclesToVehiclesEntityNull() throws IOException {
    assertNull(entityMapper.vehiclesToVehiclesEntity(null));
  }

  @Test
  public void vehiclesEntityToVehicles() throws IOException {
    vehicles = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json")), Vehicles[].class));
    vehiclesEntities = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicleEntities.json")),
            VehiclesEntity[].class));
    assertEquals(objectMapper.writeValueAsString(vehicles.get(0)),
        objectMapper
            .writeValueAsString(entityMapper.vehiclesEntityToVehicles(vehiclesEntities.get(0))));
  }

  @Test
  public void vehiclesEntityToVehiclesNull() throws IOException {
    assertNull(entityMapper.vehiclesEntityToVehicles(null));
  }

  @Test
  public void testVehiclesToVehiclesEntity() throws IOException {
    vehicles = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json")), Vehicles[].class));
    vehiclesEntities = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicleEntities.json")),
            VehiclesEntity[].class));
    assertEquals(objectMapper.writeValueAsString(vehiclesEntities),
        objectMapper.writeValueAsString(entityMapper.vehiclesListToVehiclesEntityList(vehicles)));
  }

  @Test
  public void testVehiclesToVehiclesEntityEmpty() throws IOException {
    vehicles = new ArrayList<>();
    vehiclesEntities = new ArrayList<>();
    assertEquals(objectMapper.writeValueAsString(vehiclesEntities),
        objectMapper.writeValueAsString(entityMapper.vehiclesListToVehiclesEntityList(vehicles)));
  }

  @Test
  public void testVehiclesToVehiclesEntityNull() throws IOException {
    assertNull(entityMapper.vehiclesListToVehiclesEntityList(null));
  }

  @Test
  public void testVehiclesEntityToVehicles() throws IOException {
    vehicles = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json")), Vehicles[].class));
    vehiclesEntities = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicleEntities.json")),
            VehiclesEntity[].class));
    assertEquals(objectMapper.writeValueAsString(vehicles),
        objectMapper
            .writeValueAsString(entityMapper.vehiclesEntityListToVehiclesList(vehiclesEntities)));
  }


  @Test
  public void testVehiclesEntityToVehiclesEmpty() throws IOException {
    vehicles = new ArrayList<>();
    vehiclesEntities = new ArrayList<>();
    assertEquals(objectMapper.writeValueAsString(vehicles),
        objectMapper.writeValueAsString(entityMapper.vehiclesEntityListToVehiclesList(vehiclesEntities)));
  }

  @Test
  public void testVehiclesEntityToVehiclesNull() throws IOException {
    assertNull(entityMapper.vehiclesEntityListToVehiclesList(null));
  }
}