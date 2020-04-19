package com.universe.planets.infrastructure.rest.spring.mapper;

import com.universe.planets.domain.IPlanetDomain;
import com.universe.planets.infrastructure.rest.spring.entity.PlanetEntity;
import org.mapstruct.Mapper;

//TODO all methods and logic
@Mapper(componentModel = "spring")
public abstract class EntityMapper {

  public IPlanetDomain planetEntityToPlanetDomain(PlanetEntity planetEntity) {
    return null;
  }

  public abstract PlanetEntity planetDomainToPlanetEntity(IPlanetDomain planetEntity);

}
