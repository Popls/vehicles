package com.universe.planets.domain.impl;

import java.math.BigInteger;

import com.universe.planets.domain.IResourcesDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Water implements IResourcesDomain {

  private Long id;
  private BigInteger amount;

}
