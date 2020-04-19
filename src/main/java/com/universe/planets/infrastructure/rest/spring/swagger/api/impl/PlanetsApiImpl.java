package com.universe.planets.infrastructure.rest.spring.swagger.api.impl;

import java.util.List;

import com.universe.planets.application.service.PlanetService;
import com.universe.planets.domain.IPlanetDomain;
import com.universe.planets.infrastructure.rest.spring.mapper.DtoMapper;
import com.universe.planets.infrastructure.rest.spring.swagger.api.spec.PlanetsApi;
import com.universe.planets.infrastructure.rest.spring.swagger.dto.PlanetsSummariesDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PlanetsApiImpl implements PlanetsApi {

  private final PlanetService planetService;
  private final DtoMapper dtoMapper;

  @Override
  public ResponseEntity<PlanetsSummariesDto> planetsGet() {
    List<IPlanetDomain> planetDomainList = planetService.getPlanetsSummary();
    return new ResponseEntity<>(dtoMapper.iPlanetListToPlanetsSummariesDto(planetDomainList),
        HttpStatus.OK);
  }

}
