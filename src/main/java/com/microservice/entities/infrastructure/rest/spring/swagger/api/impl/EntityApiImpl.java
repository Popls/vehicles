package com.microservice.entity.infrastructure.rest.spring.swagger.api.impl;

import javax.validation.Valid;

import com.microservice.entity.infrastructure.rest.spring.swagger.api.spec.EntityApi;
import com.microservice.entity.infrastructure.rest.spring.swagger.dto.EntityDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EntityApiImpl implements EntityApi {


  @Override
  public ResponseEntity<Void> entityIdDelete(String id) {
    return null;
  }

  @Override
  public ResponseEntity<EntityDto> entityIdGet(String id) {
    return null;
  }

  @Override
  public ResponseEntity<Void> entityIdPut(String id, @Valid EntityDto body) {
    return null;
  }

  @Override
  public ResponseEntity<Void> entityPost(String id, @Valid EntityDto body) {
    return null;
  }
}
