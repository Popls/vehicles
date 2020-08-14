package com.microservice.entities.infrastructure.rest.spring.repository.impl;

import java.util.UUID;

import com.microservice.entities.application.repository.EntityRepository;
import com.microservice.entities.domain.impl.Entity;
import com.microservice.entities.infrastructure.rest.spring.mapper.EntityMapper;
import com.microservice.entities.infrastructure.rest.spring.repository.EntitySpringRepository;
import org.springframework.stereotype.Repository;

import lombok.Builder;

@Repository
@Builder
public class EntityRepositoryImpl implements EntityRepository {

  private final EntityMapper entityMapper;
  private final EntitySpringRepository entitySpringRepository;

  @Override
  public Entity save(Entity entity) {
    return entityMapper.EntityEntityToEntity(
        entitySpringRepository.save(entityMapper.EntityToEntityEntity(entity)));
  }

  @Override
  public void delete(UUID uuid) {
    entitySpringRepository.deleteById(uuid);
  }

  @Override
  public Entity getById(UUID uuid) {
    return entityMapper.EntityEntityToEntity(entitySpringRepository.getById(uuid));
  }
}
