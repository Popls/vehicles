package com.microservice.entities.application.service;

import java.util.UUID;

import com.microservice.entities.domain.impl.Entity;

public interface EntityService {

  Entity save(Entity entity);

  Entity modify(Entity entity);

  void delete(UUID uuid);

  Entity get(UUID uuid);

}
