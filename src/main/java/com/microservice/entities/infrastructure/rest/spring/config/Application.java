package com.microservice.entity.infrastructure.rest.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.universe.planets.infrastructure")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
