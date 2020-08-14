package com.microservice.entities.infrastructure.rest.spring.config;

import com.microservice.entities.application.repository.EntityRepository;
import com.microservice.entities.application.service.EntityService;
import com.microservice.entities.application.service.impl.EntityServiceImpl;
import com.microservice.entities.infrastructure.rest.spring.mapper.DtoMapper;
import com.microservice.entities.infrastructure.rest.spring.mapper.EntityMapper;
import com.microservice.entities.infrastructure.rest.spring.repository.EntitySpringRepository;
import com.microservice.entities.infrastructure.rest.spring.repository.impl.EntityRepositoryImpl;
import com.microservice.entities.infrastructure.rest.spring.swagger.api.impl.EntityApiImpl;
import com.microservice.entities.infrastructure.rest.spring.swagger.api.spec.EntityApi;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories("com.microservice.entities.infrastructure.rest.spring.repository")
@EntityScan("com.microservice.entities.infrastructure.rest.spring.entity")
public class Configuration {

  @Bean
  public EntityService entityService(EntityRepository entityRepository) {
    return EntityServiceImpl.builder().entityRepository(entityRepository).build();
  }

  @Bean
  public EntityRepository entityRepository(EntityMapper entityMapper,
      EntitySpringRepository entitySpringRepository) {
    return EntityRepositoryImpl.builder().entityMapper(entityMapper)
        .entitySpringRepository(entitySpringRepository).build();
  }

}
