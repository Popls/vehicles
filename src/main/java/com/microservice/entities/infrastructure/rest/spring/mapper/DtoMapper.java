package com.microservice.entities.infrastructure.rest.spring.mapper;

import java.util.UUID;

import com.microservice.entities.domain.impl.Entity;
import com.microservice.entities.infrastructure.rest.spring.swagger.dto.EntityRequestDto;
import com.microservice.entities.infrastructure.rest.spring.swagger.dto.EntityResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class DtoMapper {

  public abstract Entity entityDtoToEntity(EntityRequestDto entityDto);

  @Mapping(source = "s", target = "id")
  public abstract Entity entityDtoToEntity(String s, EntityRequestDto entityDto);

  public abstract EntityResponseDto entityToEntityDto(Entity entity);

  public String UUIDToString(UUID uuid){
    return uuid.toString();
  }

  public UUID StringToUUID(String s){
    return UUID.fromString(s);
  }

}
