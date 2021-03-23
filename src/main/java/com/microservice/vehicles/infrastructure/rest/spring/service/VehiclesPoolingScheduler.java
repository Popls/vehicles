package com.microservice.vehicles.infrastructure.rest.spring.service;

import java.io.IOException;

import com.microservice.vehicles.application.service.VehiclesPoolingService;
import com.microservice.vehicles.application.service.VehiclesService;
import com.microservice.vehicles.infrastructure.rest.spring.exception.UnsuccessfullyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Builder
@Slf4j
public class VehiclesPoolingScheduler {

  private final VehiclesPoolingService vehiclesPoolingService;
  private final VehiclesService vehiclesService;

  @Scheduled(fixedDelayString = "${scheduler.fixedDelayInMillis}")
  @Transactional
  public void schedule() throws IOException, InterruptedException, UnsuccessfullyException {
    log.info("Pooling vehicles");
    vehiclesService.saveAll(vehiclesPoolingService.pool());
    log.info("Pooling vehicles have been saved");
  }

}
