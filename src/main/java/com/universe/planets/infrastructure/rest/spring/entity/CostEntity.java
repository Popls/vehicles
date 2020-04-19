package com.universe.planets.infrastructure.rest.spring.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.universe.planets.infrastructure.rest.spring.entity.embeddedId.CostId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "cost")
public class CostEntity implements Serializable {

  @EmbeddedId
  private CostId id;
  private Integer amount;

}
