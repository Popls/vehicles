package com.universe.planets.infrastructure.rest.spring.mapper;

import java.util.List;

import com.universe.planets.domain.IPlanetDomain;
import org.mapstruct.Mapper;

//TODO all methods and logic
@Mapper(componentModel = "spring")
public abstract class DtoMapper {

  public PlanetsSummariesDto iPlanetListToPlanetsSummariesDto(List<IPlanetDomain> planets) {
    return new PlanetsSummariesDto();
  }

}
