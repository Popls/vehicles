package com.microservice.entity.infrastructure.rest.spring.entity;

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
@Table(name = "entity")
public class EntityEntity implements Serializable {

  @Id
  private Long id;
  private String name;

}
