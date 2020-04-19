package com.universe.planets.infrastructure.rest.spring.config;

import com.universe.planets.application.repository.PlanetRepository;
import com.universe.planets.application.service.PlanetService;
import com.universe.planets.application.service.impl.PlanetServiceImpl;
import com.universe.planets.infrastructure.rest.spring.mapper.EntityMapper;
import com.universe.planets.infrastructure.rest.spring.repository.PlanetSpringRepository;
import com.universe.planets.infrastructure.rest.spring.repository.impl.PlanetRepositoryImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.universe.planets.infrastructure.rest.spring.repository")
@EntityScan("com.universe.planets.infrastructure.rest.spring.entity")
public class PlanetsConfiguration {

  @Bean
  public PlanetService planetService(PlanetRepository planetRepository) {
    return PlanetServiceImpl.builder().planetRepository(planetRepository).build();
  }

  @Bean
  public PlanetRepository planetRepository(EntityMapper entityMapper,
      PlanetSpringRepository planetSpringRepository) {
    return PlanetRepositoryImpl.builder().entityMapper(entityMapper)
        .planetSpringRepository(planetSpringRepository).build();
  }

}
