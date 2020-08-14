package com.microservice.entity.domain.impl;

import java.util.UUID;

import com.microservice.entity.domain.IEntityDomain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Entity implements IEntityDomain {

  private UUID id;
  private String name;

}
