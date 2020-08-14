package com.microservice.entities.infrastructure.rest.spring.swagger.api.impl;

import java.util.UUID;
import javax.validation.Valid;

import com.microservice.entities.application.service.EntityService;
import com.microservice.entities.domain.impl.Entity;
import com.microservice.entities.infrastructure.rest.spring.mapper.DtoMapper;
import com.microservice.entities.infrastructure.rest.spring.swagger.api.spec.EntityApi;
import com.microservice.entities.infrastructure.rest.spring.swagger.dto.EntityRequestDto;
import com.microservice.entities.infrastructure.rest.spring.swagger.dto.EntityResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EntityApiImpl implements EntityApi {

  DtoMapper dtoMapper;
  EntityService entityService;

  @Override
  public ResponseEntity<Void> entityIdDelete(String id) {
    entityService.delete(UUID.fromString(id));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EntityResponseDto> entityIdGet(String id) {
    Entity entity = entityService.get(UUID.fromString(id));
    return new ResponseEntity<>(dtoMapper.entityToEntityDto(entity), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> entityIdPut(String id, @Valid EntityRequestDto body) {
    entityService.modify(dtoMapper.entityDtoToEntity(id, body));
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EntityResponseDto> entityPost(@Valid EntityRequestDto body) {
    Entity entity = entityService.save(dtoMapper.entityDtoToEntity(body));
    return new ResponseEntity<>(dtoMapper.entityToEntityDto(entity), HttpStatus.OK);
  }
}
