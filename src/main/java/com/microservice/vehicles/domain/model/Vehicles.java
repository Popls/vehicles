package com.microservice.vehicles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {

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
