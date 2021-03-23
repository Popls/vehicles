package com.microservice.vehicles.infrastructure.rest.spring.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
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
import com.microservice.vehicles.application.service.VehiclesPoolingService;
import com.microservice.vehicles.application.service.VehiclesService;
import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.exception.UnsuccessfullyException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VehiclesPoolingSchedulerTest {

  public final String INPUT_FILES_PATH = "src/test/resources/domain/model/";
  public final VehiclesPoolingService vehiclesPoolingService = Mockito
      .mock(VehiclesPoolingService.class);
  public final VehiclesService vehiclesService = Mockito.mock(VehiclesService.class);
  public VehiclesPoolingScheduler vehiclesPoolingScheduler;
  public ObjectMapper objectMapper;
  public List<Vehicles> vehicles;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper();
    vehiclesPoolingScheduler = new VehiclesPoolingScheduler(vehiclesPoolingService,
        vehiclesService);
  }

  @Test
  public void schedule() throws IOException, InterruptedException, UnsuccessfullyException {
    vehicles = Arrays.asList(objectMapper
        .readValue(Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json")), Vehicles[].class));
    when(vehiclesPoolingService.pool()).thenReturn(vehicles);
    when(vehiclesService.saveAll(anyList())).thenReturn(vehicles);
    vehiclesPoolingScheduler.schedule();
    verify(vehiclesPoolingService, times(1)).pool();
    verify(vehiclesService, times(1)).saveAll(anyList());
  }

  @Test
  public void scheduleEmpty() throws IOException, InterruptedException, UnsuccessfullyException {
    vehicles = new ArrayList<>();
    when(vehiclesPoolingService.pool()).thenReturn(vehicles);
    when(vehiclesService.saveAll(anyList())).thenReturn(vehicles);
    vehiclesPoolingScheduler.schedule();
    verify(vehiclesPoolingService, times(1)).pool();
    verify(vehiclesService, times(1)).saveAll(anyList());
  }

  @Test
  public void scheduleNull() throws IOException, InterruptedException, UnsuccessfullyException {
    vehicles = null;
    when(vehiclesPoolingService.pool()).thenReturn(vehicles);
    when(vehiclesService.saveAll(anyList())).thenReturn(vehicles);
    vehiclesPoolingScheduler.schedule();
    verify(vehiclesPoolingService, times(1)).pool();
    verify(vehiclesService, times(1)).saveAll(any());
  }

  @Test(expected = UnsuccessfullyException.class)
  public void scheduleException()
      throws IOException, InterruptedException, UnsuccessfullyException {
    when(vehiclesPoolingService.pool()).thenThrow(new UnsuccessfullyException());
    vehiclesPoolingScheduler.schedule();
    verify(vehiclesPoolingService, times(1)).pool();
    verify(vehiclesService, times(0)).saveAll(any());
  }
}