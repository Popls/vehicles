package com.microservice.vehicles.infrastructure.rest.spring.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@ToString
public class VehiclesEntity implements Serializable {

  @Id
  private String id;
  private String name;
  private Float x;
  private Float y;
  private String licencePlate;
  private Integer range;
  private Integer batteryLevel;
  private Integer helmets;
  private String model;
  private String resourceImageId;
  private Boolean realTimeData;
  private String resourceType;
  private Integer companyZoneId;

}
