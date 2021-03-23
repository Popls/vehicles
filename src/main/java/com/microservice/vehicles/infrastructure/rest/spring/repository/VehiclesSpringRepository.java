package com.microservice.vehicles.infrastructure.rest.spring.repository;

import com.microservice.vehicles.infrastructure.rest.spring.entity.VehiclesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesSpringRepository extends JpaRepository<VehiclesEntity, String> {

}
