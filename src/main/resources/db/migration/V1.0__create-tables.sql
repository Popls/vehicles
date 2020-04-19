CREATE TABLE resource (
	id INTEGER NOT NULL PRIMARY KEY,
	type VARCHAR(255) NOT NULL
);

CREATE TABLE building (
	id INTEGER NOT NULL PRIMARY KEY,
	type VARCHAR(255) NOT NULL
);

CREATE TABLE planet (
	id INTEGER NOT NULL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	type VARCHAR(255) NOT NULL
);

CREATE TABLE cost (
	resource_id INTEGER NOT NULL,
	building_id INTEGER NOT NULL,
	amount INTEGER NOT NULL,
	FOREIGN KEY (resource_id) REFERENCES resource(id),
  FOREIGN KEY (building_id) REFERENCES building(id),
	PRIMARY KEY (resource_id, building_id)
);

CREATE TABLE planet_resource (
	planet_id INTEGER NOT NULL,
	resource_id INTEGER NOT NULL,
	amount INTEGER NOT NULL,
  FOREIGN KEY (planet_id) REFERENCES planet(id),
	FOREIGN KEY (resource_id) REFERENCES resource(id),
	PRIMARY KEY (planet_id, resource_id)
);