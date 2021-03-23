package com.microservice.vehicles.application.service.impl;

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

import javax.validation.constraints.Null;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vehicles.application.repository.VehiclesRepository;
import com.microservice.vehicles.application.service.VehiclesService;
import com.microservice.vehicles.domain.model.Vehicles;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VehiclesServiceImplTest {

  public final String INPUT_FILES_PATH = "src/test/resources/domain/model/";
  public VehiclesRepository vehiclesRepository = Mockito.mock(VehiclesRepository.class);
  public VehiclesService vehiclesService;
  public ObjectMapper objectMapper;
  public List<Vehicles> vehicles;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper();
    vehiclesService = VehiclesServiceImpl.builder().vehiclesRepository(vehiclesRepository).build();
  }

  @Test
  public void saveAllRegularCase() throws IOException {
    vehicles = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json")), Vehicles[].class));
    when(vehiclesRepository.saveAll(anyList())).thenReturn(vehicles);
    vehiclesService.saveAll(vehicles);
    doNothing().when(vehiclesRepository).deleteAll();
    verify(vehiclesRepository, times(1)).deleteAll();
    verify(vehiclesRepository, times(1)).saveAll(anyList());
  }

  @Test
  public void saveAllEmptyArray() throws IOException {
    vehicles = new ArrayList<>();
    when(vehiclesRepository.saveAll(anyList())).thenReturn(vehicles);
    vehiclesService.saveAll(vehicles);
    doNothing().when(vehiclesRepository).deleteAll();
    verify(vehiclesRepository, times(1)).deleteAll();
    verify(vehiclesRepository, times(1)).saveAll(anyList());
  }

  @Test(expected = NullPointerException.class)
  public void saveAllNullInput() throws IOException {
    when(vehiclesRepository.saveAll(anyList())).thenThrow(NullPointerException.class);
    vehiclesService.saveAll(null);
    doNothing().when(vehiclesRepository).deleteAll();
    verify(vehiclesRepository, times(1)).deleteAll();
    verify(vehiclesRepository, times(1)).saveAll(anyList());
  }

}