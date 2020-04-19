package com.universe.planets.infrastructure.rest.spring.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.universe.planets.infrastructure.rest.spring.entity.embeddedId.PlanetsResourcesId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "planet_resource")
public class PlanetsResourcesEntity implements Serializable {

  @EmbeddedId
  private PlanetsResourcesId id;
  private BigInteger amount;

}
