package com.universe.planets.application.service;

import java.util.List;

import com.universe.planets.domain.IPlanetDomain;

public interface PlanetService {

  List<IPlanetDomain> getPlanetsSummary();
  IPlanetDomain getPlanetInfo(Long id);
  IPlanetDomain savePlanet(IPlanetDomain planet);

}
