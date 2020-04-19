package com.universe.planets.infrastructure.rest.spring.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "planet")
public class PlanetEntity implements Serializable {

  @Id
  private Long id;
  private String name;
  private String type;

  @OneToMany(targetEntity = PlanetsResourcesEntity.class)
  private List<PlanetsResourcesEntity> planetsResourcesEntities;
  @OneToMany(targetEntity = BuildingEntity.class)
  private List<BuildingEntity> buildings;

}
