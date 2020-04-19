package com.universe.planets.domain;

import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

public interface IBuildingDomain extends IEntityDomain {

  Set<IResourcesDomain> getCost();

}
