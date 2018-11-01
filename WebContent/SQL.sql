--CREATE SCHEMA dat108obl3;
--DROP TABLE IF EXISTS dat108Obl3.deltagerliste;

CREATE TABLE dat108Obl3.deltagerliste(
kjonn BOOLEAN NOT NULL,
fornavn VARCHAR(25) NOT NULL,
etternavn VARCHAR(50) NOT NULL,
mobil INTEGER NOT NULL,
passord VARCHAR(255) NOT NULL,
CONSTRAINT mobil PRIMARY KEY (mobil)
);