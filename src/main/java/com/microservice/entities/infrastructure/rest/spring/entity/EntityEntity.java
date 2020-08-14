package com.microservice.entities.infrastructure.rest.spring.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entity")
@NoArgsConstructor
public class EntityEntity implements Serializable {

  @Id
  private UUID id;
  private String name;

}
