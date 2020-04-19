package com.universe.planets.application.service.impl;

import java.util.List;

import com.universe.planets.application.repository.PlanetRepository;
import com.universe.planets.application.service.PlanetService;
import com.universe.planets.domain.IPlanetDomain;

import lombok.Builder;

@Builder
public class PlanetServiceImpl implements PlanetService {

  private PlanetRepository planetRepository;

  @Override
  public List<IPlanetDomain> getPlanetsSummary() {
    return planetRepository.findAll();
  }

  @Override
  public IPlanetDomain getPlanetInfo(Long id) {
    return planetRepository.findById(id);
  }

  @Override
  public IPlanetDomain savePlanet(IPlanetDomain planet) {
    return planetRepository.save(planet);
  }

}
