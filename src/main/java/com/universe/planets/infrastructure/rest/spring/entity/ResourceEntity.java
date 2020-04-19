package com.universe.planets.infrastructure.rest.spring.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "resource")
public class ResourceEntity implements Serializable {

  @Id
  private Long id;
  private String type;

}
