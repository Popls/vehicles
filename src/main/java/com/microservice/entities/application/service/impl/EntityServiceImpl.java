package com.microservice.entities.application.service.impl;

import java.util.UUID;

import com.microservice.entities.application.repository.EntityRepository;
import com.microservice.entities.application.service.EntityService;
import com.microservice.entities.domain.impl.Entity;

import lombok.Builder;

@Builder
public class EntityServiceImpl implements EntityService {

  private EntityRepository entityRepository;

  @Override
  public Entity save(Entity entity) {
    entity.setId(UUID.randomUUID());
    return entityRepository.save(entity);
  }

  @Override
  public Entity modify(Entity entity) {
    return entityRepository.save(entity);
  }

  @Override
  public void delete(UUID uuid) {
    entityRepository.delete(uuid);
  }

  @Override
  public Entity get(UUID uuid) {
    return entityRepository.getById(uuid);
  }
}
