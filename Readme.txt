Travel planning


CREATE TABLE "Costs"
(
  "IdCosts" serial NOT NULL,
  "IdTravelRoute" integer,
  "IdCostsList" integer,
  "Price" real,
  "Note" character varying(255),
  CONSTRAINT "Costs_pkey" PRIMARY KEY ("IdCosts"),
  CONSTRAINT "Costs_IdCostsList_fkey" FOREIGN KEY ("IdCostsList")
      REFERENCES "CostsList" ("IdCostsList") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Costs_IdTravelRoute_fkey" FOREIGN KEY ("IdTravelRoute")
      REFERENCES "TravelRoute" ("IdTravelRoute") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Costs"
  OWNER TO postgres;

CREATE TABLE "CostsList"
(
  "IdCostsList" serial NOT NULL,
  "Name" character varying(255),
  CONSTRAINT "CostsList_pkey" PRIMARY KEY ("IdCostsList")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "CostsList"
  OWNER TO postgres;

CREATE TABLE "TravelRoute"
(
  "IdTravelRoute" serial NOT NULL,
  "IdProfile" integer,
  "IdCity" integer,
  "RouteOrder" integer,
  CONSTRAINT "TravelRoute_pkey" PRIMARY KEY ("IdTravelRoute"),
  CONSTRAINT "TravelRoute_IdCity_fkey" FOREIGN KEY ("IdCity")
      REFERENCES "City" ("IdCity") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "TravelRoute_IdProfile_fkey" FOREIGN KEY ("IdProfile")
      REFERENCES "Profile" ("IdProfile") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "TravelRoute"
  OWNER TO postgres;



CREATE TABLE "City"
(
  "IdCity" serial NOT NULL,
  "Name" character varying(255),
  CONSTRAINT "City_pkey" PRIMARY KEY ("IdCity")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "City"
  OWNER TO postgres;