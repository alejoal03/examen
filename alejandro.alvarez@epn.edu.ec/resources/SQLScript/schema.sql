.version
.database
.show

.tables

DROP TABLE USUARIOS
DROP TABLE COORDENADAS
DROP TABLE COORDENADAS_PERSONALES

CREATE TABLE USUARIOS
(
    Id   INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          VARCHAR(20) NOT NULL,
    Apellido        VARCHAR(20) NOT NULL,
    Usuario         VARCHAR(30) NOT NULL,
    Contrasena      VARCHAR(20) NOT NULL,
    Fecha_creacion  TEXT DEFAULT (date('now'))
);

CREATE TABLE COORDENADAS
(
    Capacidad       INTEGER PRIMARY KEY,
    Geolocalizacion VARCHAR(4) NOT NULL,
    TIpoArsenal     VARCHAR(15) NOT NULL,
    Fecha_ingreso  TEXT DEFAULT (date('now'))
);

INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (0, "GPS0", "ab");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (1, "GPS1", "bc");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (2, "GPS2", "ac");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (3, "GPS3", "bcd");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (4, "GPS4", "acd");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (5, "GPS5", "bct");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (6, "GPS6", "act");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (7, "GPS7", "aaabbct");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (8, "GPS8", "abbccdt");
INSERT INTO COORDENADAS(Capacidad, Geolocalizacion, TipoArsenal) VALUES (9, "GPS9", "aaabbcd");

CREATE TABLE COORDENADAS_PERSONALES
(
    Id              INTEGER NOT NULL,
    Capacidad       INTEGER NOT NULL,
    Geolocalizacion VARCHAR(4) NOT NULL,
    TIpoArsenal     VARCHAR(15) NOT NULL,
    FOREIGN KEY(Id) REFERENCES USUARIOS(Id) 
);




SELECT * from USUARIOS
SELECT * from COORDENADAS
SELECT * from COORDENADAS_PERSONALES