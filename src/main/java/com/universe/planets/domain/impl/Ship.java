package com.universe.planets.domain.impl;

import java.util.Set;

import com.universe.planets.domain.IResourcesDomain;
import com.universe.planets.domain.ITransportDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ship implements ITransportDomain {

  private Long id;
  private Set<IResourcesDomain> cost;
  private IResourcesDomain[] loads;

}
