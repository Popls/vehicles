package com.microservice.entities.application.repository;

import java.util.UUID;

import com.microservice.entities.domain.impl.Entity;

public interface EntityRepository {

  Entity save(Entity iEntityDomain);

  void delete(UUID uuid);

  Entity getById(UUID uuid);

}
