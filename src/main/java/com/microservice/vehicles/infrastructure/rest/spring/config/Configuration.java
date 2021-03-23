package com.microservice.vehicles.infrastructure.rest.spring.config;

import java.net.http.HttpClient;
import java.time.Duration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.vehicles.application.repository.VehiclesRepository;
import com.microservice.vehicles.application.service.VehiclesPoolingService;
import com.microservice.vehicles.application.service.VehiclesService;
import com.microservice.vehicles.application.service.impl.VehiclesServiceImpl;
import com.microservice.vehicles.infrastructure.rest.spring.mapper.EntityMapper;
import com.microservice.vehicles.infrastructure.rest.spring.repository.VehiclesSpringRepository;
import com.microservice.vehicles.infrastructure.rest.spring.repository.impl.VehiclesRepositoryImpl;
import com.microservice.vehicles.infrastructure.rest.spring.service.VehiclesPoolingScheduler;
import com.microservice.vehicles.infrastructure.rest.spring.service.VehiclesPoolingServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories("com.microservice.vehicles.infrastructure.rest.spring.repository")
@EntityScan("com.microservice.vehicles.infrastructure.rest.spring.entity")
@EnableScheduling
public class Configuration {

  @Value("${pooling.url}")
  private String urlPooling;

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public VehiclesService vehiclesService(VehiclesRepository vehiclesRepository) {
    return VehiclesServiceImpl.builder().vehiclesRepository(vehiclesRepository).build();
  }

  @Bean
  public VehiclesRepository vehiclesRepository(EntityMapper entityMapper,
      VehiclesSpringRepository vehiclesSpringRepository) {
    return VehiclesRepositoryImpl.builder().entityMapper(entityMapper)
        .vehiclesSpringRepository(vehiclesSpringRepository).build();
  }

  @Bean
  public VehiclesPoolingService vehiclesPoolingService(ObjectMapper objectMapper) {
    HttpClient httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_1_1)
        .connectTimeout(Duration.ofSeconds(25))
        .build();
    return VehiclesPoolingServiceImpl.builder().objectMapper(objectMapper).client(httpClient)
        .url(urlPooling).build();
  }

  @Bean
  @ConditionalOnProperty(prefix = "scheduler", name = "enable")
  public VehiclesPoolingScheduler vehiclesPoolingScheduler(
      VehiclesPoolingService vehiclesPoolingService, VehiclesService vehiclesService) {
    return VehiclesPoolingScheduler.builder().vehiclesService(vehiclesService).vehiclesPoolingService(vehiclesPoolingService)
        .build();
  }

}
