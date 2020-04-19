package com.universe.planets.infrastructure.rest.spring.repository;

import com.universe.planets.infrastructure.rest.spring.entity.PlanetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetSpringRepository extends JpaRepository<PlanetEntity, Long> {

}
