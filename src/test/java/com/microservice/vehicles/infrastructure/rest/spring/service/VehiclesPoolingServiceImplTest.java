package com.microservice.vehicles.infrastructure.rest.spring.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vehicles.application.service.VehiclesPoolingService;
import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.exception.UnsuccessfullyException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VehiclesPoolingServiceImplTest {

  public final String INPUT_FILES_PATH = "src/test/resources/domain/model/";
  private final HttpClient client = Mockito.mock(HttpClient.class);
  private final HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
  private final String url = "http://example.com";
  private VehiclesPoolingService vehiclesPoolingService;
  private ObjectMapper objectMapper;
  private String vehicles;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper();
    vehiclesPoolingService = new VehiclesPoolingServiceImpl(client, objectMapper, url);
  }

  @Test
  public void pool()
      throws IOException, InterruptedException, UnsuccessfullyException, JSONException {
    vehicles = Files.readString(Path.of(INPUT_FILES_PATH + "vehicle.json"));
    when(client.send(any(), any())).thenReturn(httpResponse);
    when(httpResponse.statusCode()).thenReturn(200);
    when(httpResponse.body()).thenReturn(vehicles);
    List<Vehicles> result = vehiclesPoolingService.pool();
    assertFalse(result.isEmpty());
  }

  @Test
  public void poolEmpty()
      throws IOException, InterruptedException, UnsuccessfullyException, JSONException {
    vehicles = "[]";
    when(client.send(any(), any())).thenReturn(httpResponse);
    when(httpResponse.statusCode()).thenReturn(200);
    when(httpResponse.body()).thenReturn(vehicles);
    List<Vehicles> result = vehiclesPoolingService.pool();
    assertTrue(result.isEmpty());
  }

  @Test(expected = UnsuccessfullyException.class)
  public void poolException()
      throws IOException, InterruptedException, UnsuccessfullyException, JSONException {
    when(client.send(any(), any())).thenReturn(httpResponse);
    when(httpResponse.statusCode()).thenReturn(500);
    when(httpResponse.body()).thenReturn("Error");
    vehiclesPoolingService.pool();
  }
}