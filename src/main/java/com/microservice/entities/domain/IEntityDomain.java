package com.microservice.entities.domain;

import java.io.Serializable;
import java.util.UUID;

public interface IEntityDomain extends Serializable {

  UUID getId();

}
