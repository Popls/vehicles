package com.microservice.vehicles.application.service;

import java.io.IOException;
import java.util.List;

import com.microservice.vehicles.domain.model.Vehicles;
import com.microservice.vehicles.infrastructure.rest.spring.exception.UnsuccessfullyException;

public interface VehiclesPoolingService {

  List<Vehicles> pool() throws IOException, InterruptedException, UnsuccessfullyException;

}
