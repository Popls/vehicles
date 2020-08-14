package com.microservice.entity.infrastructure.rest.spring.config;

import com.microservice.entity.application.service.impl.EntityServiceImpl;
import com.microservice.entity.application.repository.EntityRepository;
import com.microservice.entity.application.service.EntityService;
import com.microservice.entity.infrastructure.rest.spring.mapper.EntityMapper;
import com.microservice.entity.infrastructure.rest.spring.repository.EntitySpringRepository;
import com.microservice.entity.infrastructure.rest.spring.repository.impl.EntityRepositoryImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories("com.microservice.entity.infrastructure.rest.spring.repository")
@EntityScan("com.microservice.entity.infrastructure.rest.spring.entity")
public class Configuration {

}
