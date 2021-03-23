package com.microservice.vehicles.infrastructure.rest.spring.swagger.api.impl;

import com.microservice.vehicles.infrastructure.rest.spring.swagger.api.spec.StatusApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class VehiclesApiImpl implements StatusApi {
  @Override
  public ResponseEntity<Void> statusGet() {
    return ResponseEntity.ok().build();
  }
}
