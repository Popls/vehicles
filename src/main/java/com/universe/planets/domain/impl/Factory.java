package com.universe.planets.domain.impl;

import java.util.Set;

import com.universe.planets.domain.IBuildingDomain;
import com.universe.planets.domain.IResourcesDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Factory implements IBuildingDomain {

  private Long id;
  private Set<IResourcesDomain> cost;

}
