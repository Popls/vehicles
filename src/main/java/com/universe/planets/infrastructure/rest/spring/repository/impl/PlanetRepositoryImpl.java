package com.universe.planets.infrastructure.rest.spring.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.universe.planets.application.repository.PlanetRepository;
import com.universe.planets.domain.IPlanetDomain;
import com.universe.planets.infrastructure.rest.spring.entity.PlanetEntity;
import com.universe.planets.infrastructure.rest.spring.mapper.EntityMapper;
import com.universe.planets.infrastructure.rest.spring.repository.PlanetSpringRepository;
import org.springframework.stereotype.Repository;

import lombok.Builder;

@Repository
@Builder
public class PlanetRepositoryImpl implements PlanetRepository {

  private final EntityMapper entityMapper;
  private final PlanetSpringRepository planetSpringRepository;

  @Override
  public List<IPlanetDomain> findAll() {
    List<PlanetEntity> planetEntities = planetSpringRepository.findAll();
    return planetEntities.stream()
        .map(planetEntity -> entityMapper.planetEntityToPlanetDomain(planetEntity))
        .collect(Collectors.toList());
  }

  @Override
  public IPlanetDomain findById(Long id) {
    PlanetEntity planetEntity = planetSpringRepository.findById(id).orElseThrow();
    return entityMapper.planetEntityToPlanetDomain(planetEntity);
  }

  @Override
  public IPlanetDomain save(IPlanetDomain planet) {
    PlanetEntity planetEntity = entityMapper.planetDomainToPlanetEntity(planet);
    planetEntity = planetSpringRepository.save(planetEntity);
    return entityMapper.planetEntityToPlanetDomain(planetEntity);
  }
}
