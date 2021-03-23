CREATE TABLE vehicles (
	id                      VARCHAR(255),
  name                    VARCHAR(255),
  x                       NUMERIC,
  y                       NUMERIC,
  licence_plate           VARCHAR(255),
  range                   INTEGER,
  battery_level           INTEGER,
  helmets                 INTEGER,
  model                   VARCHAR(255),
  resource_image_id       VARCHAR(255),
  real_time_data          BOOLEAN,
  resource_type           VARCHAR(255),
  company_zone_id         INTEGER,
	PRIMARY KEY (id)
);