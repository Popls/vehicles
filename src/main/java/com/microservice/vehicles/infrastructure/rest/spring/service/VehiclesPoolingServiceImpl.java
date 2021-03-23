package com.microservice.vehicles.infrastructure.rest.spring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vehicles.application.service.VehiclesPoolingService;
import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.exception.UnsuccessfullyException;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
public class VehiclesPoolingServiceImpl implements VehiclesPoolingService {

  public final String INPUT_FILES_PATH = "src/test/resources/domain/model/";
  private final HttpClient client;
  private final ObjectMapper objectMapper;
  private final String url;

  @Override
  public List<Vehicles> pool() throws IOException, InterruptedException, UnsuccessfullyException {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();
    log.debug("Sending request to {}", url);
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    int statusCode = response.statusCode();
    log.debug("Response was {}", statusCode);
    if (statusCode != 200) {
      throw new UnsuccessfullyException();
    }
    return Arrays.asList(objectMapper.readValue(response.body(), Vehicles[].class));
  }
}
