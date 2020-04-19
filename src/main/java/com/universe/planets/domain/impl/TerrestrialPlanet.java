package com.universe.planets.domain.impl;

import java.util.List;
import java.util.Set;

import com.universe.planets.domain.IBuildingDomain;
import com.universe.planets.domain.IPlanetDomain;
import com.universe.planets.domain.IResourcesDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TerrestrialPlanet implements IPlanetDomain {

  private Long id;
  private String name;
  private Set<IResourcesDomain> resources;
  private List<IBuildingDomain> buildings;

}
