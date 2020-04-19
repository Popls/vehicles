package com.universe.planets.infrastructure.rest.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.universe.planets.infrastructure")
public class PlanetsApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlanetsApplication.class, args);
  }

}
