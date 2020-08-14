package com.microservice.entities.infrastructure.rest.spring.mapper;

import com.microservice.entities.domain.impl.Entity;
import com.microservice.entities.infrastructure.rest.spring.entity.EntityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EntityMapper {

  public abstract EntityEntity EntityToEntityEntity(Entity entity);

  public abstract Entity EntityEntityToEntity(EntityEntity entityEntity);

}
