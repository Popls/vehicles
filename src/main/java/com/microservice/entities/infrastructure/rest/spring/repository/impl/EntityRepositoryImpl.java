package com.microservice.entity.infrastructure.rest.spring.repository.impl;

import com.microservice.entity.application.repository.EntityRepository;
import com.microservice.entity.infrastructure.rest.spring.mapper.EntityMapper;
import com.microservice.entity.infrastructure.rest.spring.repository.EntitySpringRepository;
import org.springframework.stereotype.Repository;

import lombok.Builder;

@Repository
@Builder
public class EntityRepositoryImpl implements EntityRepository {

  private final EntityMapper entityMapper;
  private final EntitySpringRepository entitySpringRepository;

}
