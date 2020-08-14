package com.microservice.entity.domain;

import java.io.Serializable;
import java.util.UUID;

public interface IEntityDomain extends Serializable {

  UUID getId();

}
