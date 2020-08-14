package com.microservice.entity.infrastructure.rest.spring.repository;

import java.util.UUID;

import com.microservice.entity.application.repository.EntityRepository;
import com.microservice.entity.infrastructure.rest.spring.entity.EntityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitySpringRepository extends JpaRepository<EntityEntity, UUID>,
    EntityRepository {

}
