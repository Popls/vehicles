package com.microservice.entity.application.service.impl;

import com.microservice.entity.application.repository.EntityRepository;
import com.microservice.entity.application.service.EntityService;

import lombok.Builder;

@Builder
public class EntityServiceImpl implements EntityService {

  private EntityRepository entityRepository;

}
