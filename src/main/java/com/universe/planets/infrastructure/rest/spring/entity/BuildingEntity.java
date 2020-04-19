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
@Table(name = "building")
public class BuildingEntity implements Serializable {

  @Id
  private Long id;
  private String type;

  @OneToMany(targetEntity = CostEntity.class)
  private List<CostEntity> cost;

}
