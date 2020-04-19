package com.universe.planets.application.repository;

import java.util.List;

import com.universe.planets.domain.IPlanetDomain;

public interface PlanetRepository {

  List<IPlanetDomain> findAll();
  IPlanetDomain findById(Long id);
  IPlanetDomain save(IPlanetDomain planet);

}
