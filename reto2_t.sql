CREATE DATABASE Reto2_t
COLLATE utf8mb4_spanish_ci;

USE Reto2_t;
-- ///////////////// tipo agencia ////////////////////

CREATE TABLE TipoAgencia(
Cod_Tipo CHAR(2) PRIMARY KEY,
Tipo VARCHAR(30)
);

INSERT INTO TipoAgencia (Cod_Tipo, Tipo) VALUES 
('A1', 'Mayorista'),
('A2', 'Minorista'),
('A3', 'Mayorista-minorista');

-- ///////////////// descripcion de empleados //////////////////

CREATE TABLE DescEmpleados(
	Cod_descEmp CHAR(2) PRIMARY KEY,
	DescripcionEmp VARCHAR(50) NOT NULL
);

INSERT INTO DescEmpleados (Cod_DescEmp, DescripcionEmp) VALUES 
('L1', '5 empleados maximo de 1 a 5'),
('L2', '10 empleados maximo de 1 a 10'),
('L3', '20 empleados maximo de 1 a 20');

-- ///////////////// agencia ////////////////////////

CREATE TABLE Agencia(
	Id_Agencia VARCHAR(5) PRIMARY KEY NOT NULL,
	NomAgencia TEXT NOT NULL,
	TipoAgencia TEXT NOT NULL,
	ColorAgencia VARCHAR(7) NOT NULL ,
	Cod_DescEmp CHAR(2) NOT NULL ,
	Logo TEXT NOT NULL,
	Pass VARCHAR(40) NOT NULL,
    CONSTRAINT FK_Cod_DescEmp FOREIGN KEY (Cod_DescEmp) REFERENCES DescEmpleados(Cod_DescEmp)
);

INSERT INTO Agencia (Id_Agencia, NomAgencia, TipoAgencia, ColorAgencia, Cod_DescEmp, Logo, Pass)
VALUES 
('AG001', 'Agencia Viajar', 'Agencias de viajes física', '#FF5733', 'L1', 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@123'),
('AG002', 'Turismo Total', 'Agencias de viajes en línea', '#33FF57', 'L2', 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@456'),
('AG003', 'ExploraMundo', 'Agencias de viajes especializadas', '#3357FF', 'L3', 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@789');

-- //////////////////////// tipo viaje /////////////////////////
CREATE TABLE TipoViaje (
Cod_TipoViaje CHAR(2) PRIMARY KEY, 
TipoViaje VARCHAR(70) NOT NULL

);

INSERT INTO TipoViaje (Cod_TipoViaje, TipoViaje) VALUES 
('B1', 'Parejas'),
('B2', 'Mayores'),
('B3', 'Grupos'),
('B4', 'Grandes viajes (destinos exóticos + vuelo + alojamiento)'),
('B5', 'Escapada');

-- /////////////////////////////// viaje /////////////////////

CREATE TABLE Viaje(
	Id_Viaje VARCHAR(5) PRIMARY KEY NOT NULL,
	NomViaje TEXT NOT NULL,
	Cod_TipoViaje CHAR(2) NOT NULL,
	FechInicio DATE NOT NULL ,
	FechFin DATE NOT NULL ,
	NumDias INT NOT NULL,
	PaisDestino VARCHAR(40) NOT NULL,
	Descripcion TEXT NOT NULL,
	ServiciosnoIncl TEXT NOT NULL,
	Id_Agencia  VARCHAR(5) NOT NULL,
	CONSTRAINT FK_Id_Agencia FOREIGN KEY(Id_Agencia) REFERENCES Agencia(Id_Agencia),
	CONSTRAINT FK_Cod_TipoViaje FOREIGN KEY(Cod_TipoViaje) REFERENCES TipoViaje(Cod_TipoViaje)

);

INSERT INTO Viaje (Id_Viaje, NomViaje, Cod_TipoViaje, FechInicio, FechFin, NumDias, PaisDestino, Descripcion, ServiciosnoIncl, Id_Agencia)
VALUES 
('VI001', 'Aventura en Costa Rica', 'B4', '2025-03-01', '2025-03-10', 10, 'Costa Rica', 'Una experiencia llena de naturaleza y deportes extremos.', 'Comidas no incluidas', 'AG001'),
('VI002', 'Tour por Europa', 'B5', '2025-04-01', '2025-04-20', 20, 'Francia, Italia, España', 'Visita a los lugares más emblemáticos de Europa.', 'Transporte interno no incluido', 'AG002'),
('VI003', 'Relax en el Caribe', 'B1', '2025-06-01', '2025-06-10', 10, 'República Dominicana', 'Vacaciones de descanso en las mejores playas del Caribe.', 'Excursiones no incluidas', 'AG003');

--  ////////////////// evento //////////////////////////// 

CREATE TABLE Evento (
	Id_Evento CHAR(5) PRIMARY KEY,
    Nom_Evento VARCHAR(30) NOT NULL,
    TipoEvento ENUM("Vuelo","Alojamiento","Actividad") NOT NULL,
    Id_Viaje CHAR(5) NOT NULL,
    CONSTRAINT FK_Id_Viaje FOREIGN KEY (Id_Viaje) REFERENCES Viaje(Id_Viaje)
);

INSERT INTO Evento (Id_Evento, Nom_Evento, TipoEvento, Id_Viaje)
VALUES 
('EV001', 'Vuelo a Costa Rica', 'Vuelo', 'VI001'),
('EV002', 'Alojamiento en París', 'Alojamiento', 'VI002'),
('EV003', 'Actividad en Punta Cana', 'Actividad', 'VI003'),
('EV004', 'Plan Ida', 'Vuelo', 'VI001'),
('EV005', 'Plan Ida y Vuelta', 'Vuelo', 'VI002'),
('EV006', 'Hotel Sol', 'Alojamiento', 'VI001'),
('EV007', 'Resort Caribe', 'Alojamiento', 'VI002'),
('EV008', 'Villa Toscana', 'Alojamiento', 'VI003'),
('EV009', 'Senderismo en Costa Rica', 'Actividad', 'VI001'),
('EV010', 'Tour por el Coliseo Romano', 'Actividad', 'VI002');

-- ///////////////////////////////pais//////////////////

CREATE TABLE Pais(
	Cod_Pais CHAR(2) NOT NULL PRIMARY KEY,
	NomPais VARCHAR(30) NOT NULL
);

INSERT INTO Pais (Cod_Pais, NomPais) VALUES 
('AR', 'ARGENTINA'),
('AT', 'AUSTRIA'),
('BE', 'BÉLGICA'),
('BR', 'BRASIL'),
('CA', 'CANADA'),
('CH', 'SUIZA'),
('CN', 'CHINA'),
('CU', 'CUBA'),
('CY', 'CHIPRE'),
('CZ', 'REPUBLICA CHECA'),
('DE', 'ALEMANIA'),
('DK', 'DINAMARCA'),
('EE', 'ESTONIA'),
('EG', 'EGIPTO'),
('ES', 'ESPAÑA'),
('FI', 'FINLANDIA'),
('FR', 'FRANCIA'),
('GB', 'REINO UNIDO'),
('GR', 'GRECIA'),
('GT', 'GUATEMALA'),
('HK', 'HONG-KONG'),
('HR', 'CROACIA'),
('HU', 'HUNGRIA'),
('ID', 'INDONESIA'),
('IE', 'IRLANDA'),
('IL', 'ISRAEL'),
('IN', 'INDIA'),
('IS', 'ISLANDIA'),
('IT', 'ITALIA'),
('JM', 'JAMAICA'),
('JP', 'JAPÓN'),
('KE', 'KENIA'),
('LU', 'LUXEMBURGO'),
('MA', 'MARRUECOS'),
('MC', 'MÓNACO'),
('MT', 'MALTA'),
('MV', 'MALDIVAS'),
('MX', 'MÉXICO'),
('NL', 'PAÍSES BAJOS'),
('NO', 'NORUEGA'),
('PA', 'PANAMÁ'),
('PE', 'PERÚ'),
('PL', 'POLONIA'),
('PR', 'PUERTO RICO'),
('PT', 'PORTUGAL'),
('QA', 'QATAR'),
('RO', 'RUMANIA'),
('RU', 'RUSIA'),
('SC', 'SEYCHELLES'),
('SE', 'SUECIA'),
('SG', 'SINGAPUR'),
('TH', 'TAILANDIA'),
('TN', 'TÚNEZ'),
('TR', 'TURQUÍA'),
('TZ', 'TANZANIA (INCLUYE ZANZIBAR)'),
('US', 'ESTADOS UNIDOS'),
('VE', 'VENEZUELA'),
('VN', 'VIETNAM'),
('ZA', 'SUDÁFRICA'),
('CO', 'COLOMBIA'),
('EC', 'ECUADOR');

-- /////////////// aeropuerto /////////////////////////

CREATE TABLE Aeropuerto(
	Id_Aeropuerto CHAR(3) PRIMARY KEY,
	Ciudad VARCHAR(50) NOT NULL
);

INSERT INTO Aeropuerto (Id_Aeropuerto, Ciudad) VALUES 
('ACA', 'MÉXICO (ACAPULCO)'),
('ACE', 'Lanzarote'),
('AGP', 'MÁLAGA'),
('ALC', 'Alicante'),
('AMM', 'JO (Ammán)'),
('AMS', 'HOLANDA (Amsterdam)'),
('ATH', 'GRECIA (Atenas)'),
('BCN', 'Barcelona'),
('BER', 'ALEMANIA (Berlín)'),
('BIO', 'Bilbao'),
('BJZ', 'Badajoz'),
('BKK', 'TAILANDIA (Bangkok)'),
('BOG', 'COLOMBIA (Bogotá)'),
('BOS', 'Boston'),
('BRU', 'BÉLGICA (Bruselas)'),
('BSB', 'BRASIL (Brasilia)'),
('BUE', 'ARGENTINA (Buenos Aires)'),
('CAI', 'EGIPTO (El Cairo)'),
('CAS', 'MARRUECOS (Casablanca)'),
('CDG', 'FRANCIA (París, Charles de Gaulle)'),
('CPH', 'DINAMARCA (Copenhague)'),
('DUB', 'IRLANDA (Dublín)'),
('DUS', 'ALEMANIA (Düsseldorf)'),
('EAS', 'San Sebastián'),
('FRA', 'ALEMANIA (Frankfurt)'),
('GVA', 'SUIZA (Ginebra)'),
('HAM', 'ALEMANIA (Hamburgo)'),
('HEL', 'FINLANDIA (Helsinki)'),
('HOU', 'Houston'),
('IST', 'TURQUÍA (Estambul)'),
('JFK', 'Nueva York (JFK)'),
('LAX', 'Los Ángeles'),
('LHR', 'Reino Unido (Heathrow)'),
('LIM', 'PERÚ (Lima)'),
('MAD', 'Madrid'),
('MEX', 'MÉXICO (Ciudad de México)'),
('MUC', 'ALEMANIA (Múnich)'),
('NBO', 'KENIA (Nairobi)'),
('ORY', 'FRANCIA (París, Orly)'),
('OSL', 'NORUEGA (Oslo)'),
('PMI', 'Palma de Mallorca'),
('PRG', 'REPUBLICA CHECA (Praga)'),
('RAK', 'MARRUECOS (Marrakech)'),
('SFO', 'San Francisco'),
('SYD', 'AUSTRALIA (Sídney)'),
('TFN', 'Tenerife Norte'),
('TFS', 'Tenerife Sur'),
('ZRH', 'SUIZA (Zúrich)');

-- ///////////// aerolinea ////////////////////////

CREATE TABLE Aerolinea (
	Cod_Aerolinea VARCHAR(5) NOT NULL PRIMARY KEY,
	NomAerolinea VARCHAR(50) NOT NULL,
    Cod_Pais CHAR(2) NOT NULL,
    CONSTRAINT FK_Cod_Pais FOREIGN KEY (Cod_Pais) REFERENCES Pais(Cod_Pais)
);

INSERT INTO Aerolinea (Cod_Aerolinea, NomAerolinea, Cod_Pais) VALUES 
('2K', 'AVIANCA-Ecuador dba AVIANCA', 'EC'),
('3P', 'World 2 Fly PT, S.A.', 'PT'),
('6B', 'TUIfly Nordic AB', 'CN'),
('AC', 'Air France', 'FR'),
('A0', 'BA Euroflyer Limited dba British Airways', 'GB'),
('AM', 'AeroMéxico', 'MX'),
('AV', 'Avianca', 'CO'),
('BA', 'British Airways', 'GB'),
('LH', 'Lufthansa', 'DE'),
('QR', 'Qatar Airways', 'QA'),
('TK', 'Turkish Airlines', 'TR'),
('UA', 'United Airlines', 'US');

-- ///////////////// vuelo //////////////

CREATE TABLE Vuelo (
	Id_Vuelo CHAR(5) PRIMARY KEY,
    FechVuelo DATE NOT NULL,
    Aerolinea VARCHAR(50) NOT NULL,
    HorarioSalida TIME NOT NULL,
    Duracion INT NOT NULL,
    Id_AeroOrig CHAR(3) NOT NULL,  
    Id_AeroDest CHAR(3) NOT NULL,
	Precio INT NOT NULL,
	CONSTRAINT FK_Id_AeroOrig FOREIGN KEY (Id_AeroOrig) REFERENCES Aeropuerto(Id_Aeropuerto),
	CONSTRAINT FK_Id_AeroDest FOREIGN KEY (Id_AeroDest) REFERENCES Aeropuerto(Id_Aeropuerto)
);

INSERT INTO Vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio)
VALUES
('V001', '2025-03-01', 'AeroMéxico', '08:00:00', 180, 'ACA', 'MEX', 250),
('V002', '2025-04-10', 'Avianca', '10:00:00', 240, 'BOG', 'LIM', 300),
('V003', '2025-06-05', 'Lufthansa', '14:00:00', 360, 'FRA', 'MAD', 400);

-- ////////////////// planViaje //////////////////

CREATE TABLE Plan_Viaje (
	Id_Plan CHAR(5) PRIMARY KEY,
    Trayecto ENUM("Ida","Ida_Vuelta") NOT NULL,
    Id_VueloIda CHAR(5) NOT NULL,
    Id_VueloVuelta CHAR(5),
	CONSTRAINT FK_Id_Plan FOREIGN KEY (Id_Plan) REFERENCES Evento(Id_Evento),
    CONSTRAINT FK_Id_VueloIda FOREIGN KEY (Id_VueloIda) REFERENCES Vuelo(Id_Vuelo),
	CONSTRAINT FK_Id_VueloVuelta FOREIGN KEY (Id_VueloVuelta) REFERENCES Vuelo(Id_Vuelo)
);

INSERT INTO Plan_Viaje (Id_Plan, Trayecto, Id_VueloIda, Id_VueloVuelta)
VALUES
('EV004', 'Ida', 'V001', NULL),
('EV005', 'Ida_Vuelta', 'V002', 'V003');

 
 -- /////////////// tipo alojamiento ///////////////

CREATE TABLE TipoDormitorio (
	Cod_TipoHab VARCHAR(3) PRIMARY KEY, 
    TipoHab VARCHAR(30) NOT NULL
    );

INSERT INTO TipoDormitorio (Cod_TipoHab, TipoHab) VALUES 
('DB', 'Doble'),
('DUI', 'Doble, uso individual'),
('SIN', 'Individual'),
('TPL', 'Triple');


-- ////////////////// alojamiento //////////////

CREATE TABLE Alojamiento (
	Id_Alojamiento CHAR(5) PRIMARY KEY,
    nomHotel VARCHAR(30) NOT NULL,
    Cod_TipoHab VARCHAR(3)  NOT NULL,
    Ciudad VARCHAR(30) NOT NULL,
    Precio INT NOT NULL,
    fechaEnt DATE NOT NULL,
    FechaSal DATE NOT NULL,
    CONSTRAINT FK_Id_Alojamiento FOREIGN KEY (Id_Alojamiento) REFERENCES Evento(Id_Evento),
    CONSTRAINT FK_Cod_TipoHab FOREIGN KEY (Cod_TipoHab) REFERENCES TipoDormitorio (Cod_TipoHab)
);

INSERT INTO Alojamiento (Id_Alojamiento, nomHotel, Cod_TipoHab, Ciudad, Precio, fechaEnt, FechaSal)
VALUES
('EV006', 'Hotel Sol', 'DB', 'Madrid', 120, '2025-03-01', '2025-03-05'),
('EV007', 'Resort Caribe', 'TPL', 'Cancún', 200, '2025-04-10', '2025-04-15'),
('EV008', 'Villa Toscana', 'SIN', 'Florencia', 150, '2025-06-05', '2025-06-10');

-- //////////////// actividad //////////////////////

CREATE TABLE Actividad (
	Id_Actividad CHAR(5) PRIMARY KEY, 
    Descripcion TEXT NOT NULL, 
    fecha DATE NOT NULL,
    Precio INT NOT NULL,
	CONSTRAINT FK_Id_Actividad FOREIGN KEY (Id_Actividad) REFERENCES Evento(Id_Evento)
);

INSERT INTO Actividad (Id_Actividad, Descripcion, fecha, Precio)
VALUES
('EV009', 'Senderismo en Costa Rica', '2025-03-02', 50),
('EV010', 'Tour por el Coliseo Romano', '2025-04-12', 75);







