DROP DATABASE IF EXISTS Reto2_t;
CREATE DATABASE Reto2_t COLLATE utf8mb4_spanish_ci;
USE Reto2_t;

-- ///////////////// Tipo Agencia ////////////////////
CREATE TABLE TipoAgencia(
    Cod_Tipo CHAR(2) PRIMARY KEY,
    Tipo VARCHAR(30) NOT NULL
);

INSERT INTO TipoAgencia (Cod_Tipo, Tipo) VALUES 
('A1', 'Mayorista'),
('A2', 'Minorista'),
('A3', 'Mayorista-minorista');

-- ///////////////// Descripción de Empleados //////////////////
CREATE TABLE DescEmpleados(
    Cod_DescEmp CHAR(2) PRIMARY KEY,
    DescripcionEmp VARCHAR(50) NOT NULL
);

INSERT INTO DescEmpleados (Cod_DescEmp, DescripcionEmp) VALUES 
('L1', '5 empleados máximo de 1 a 5'),
('L2', '10 empleados máximo de 1 a 10'),
('L3', '20 empleados máximo de 1 a 20');

-- ///////////////// Agencia ////////////////////////
CREATE TABLE Agencia(
    Id_Agencia VARCHAR(5) PRIMARY KEY NOT NULL,
    NomAgencia VARCHAR(50) NOT NULL,
    Cod_Tipo CHAR(2) NOT NULL,
    ColorAgencia VARCHAR(7) NOT NULL,
    Cod_DescEmp CHAR(2) NOT NULL,
    Logo TEXT NOT NULL,
    Pass VARCHAR(40) NOT NULL,
    CONSTRAINT FK_Cod_DescEmp FOREIGN KEY (Cod_DescEmp) REFERENCES DescEmpleados(Cod_DescEmp)  ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Cod_Tipo FOREIGN KEY (Cod_Tipo) REFERENCES TipoAgencia(Cod_Tipo)  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Agencia (Id_Agencia, NomAgencia, Cod_Tipo, ColorAgencia, Cod_DescEmp, Logo, Pass)
VALUES 
('AG001', 'Agencia Viajar', 'A1', '#6A0DAD', 'L1', 'https://img.freepik.com/vector-gratis/tipografia-viaje-o-vector-logo_53876-43334.jpg?t=st=1738506941~exp=1738510541~hmac=70a3e587d7101d06aed0108db224a404dab81e95288ec281370364072a81f59f&w=740', 'pass@123'),
('AG002', 'Turismo Total', 'A2', '#3E2723', 'L2', 'https://img.freepik.com/vector-gratis/fondo-plano-viaje-vintage_23-2148189177.jpg?t=st=1738506896~exp=1738510496~hmac=d155f787cc6de9464587258e0cc71196611e9cc2b7c83c630bb6b248d0554485&w=740', 'pass@456'),
('AG003', 'ExploraMundo', 'A3', '#8B2500', 'L3', 'https://img.freepik.com/vector-gratis/logotipo-viaje-detallado_23-2148619622.jpg?t=st=1738506970~exp=1738510570~hmac=f8516def09f612eafeaad5f63433868aa4fff54626f640f7c3309ae41aeede6d&w=740', 'pass@789');

-- //////////////////////// Tipo Viaje /////////////////////////
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

-- /////////////////////////////// Viaje /////////////////////
CREATE TABLE Viaje(
    Id_Viaje VARCHAR(5) PRIMARY KEY NOT NULL,
    NomViaje VARCHAR(100) NOT NULL,
    Cod_TipoViaje CHAR(2) NOT NULL,
    FechInicio DATE NOT NULL,
    FechFin DATE NOT NULL,
    NumDias INT NOT NULL,
    PaisDestino VARCHAR(40) NOT NULL,
    Descripcion TEXT NOT NULL,
    ServiciosnoIncl TEXT NOT NULL,
    Id_Agencia VARCHAR(5) NOT NULL,
    CONSTRAINT FK_Id_Agencia FOREIGN KEY(Id_Agencia) REFERENCES Agencia(Id_Agencia)  ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Cod_TipoViaje FOREIGN KEY(Cod_TipoViaje) REFERENCES TipoViaje(Cod_TipoViaje)  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Viaje (Id_Viaje, NomViaje, Cod_TipoViaje, FechInicio, FechFin, NumDias, PaisDestino, Descripcion, ServiciosnoIncl, Id_Agencia)
VALUES 
('VI001', 'Aventura en Costa Rica', 'B5', '2025-03-01', '2025-03-10', 10, 'Costa Rica', 'Naturaleza y deportes extremos.', 'Comidas no incluidas', 'AG001'),
('VI002', 'Tour por Europa', 'B3', '2025-04-01', '2025-04-20', 20, 'Francia, Italia, España', 'Visitas culturales', 'Transporte interno no incluido', 'AG002'),
('VI003', 'Relax en el Caribe', 'B2', '2025-06-01', '2025-06-10', 10, 'República Dominicana', 'Playas paradisíacas.', 'Excursiones no incluidas', 'AG003');

-- ////////////////pais///////
CREATE TABLE Pais(
    Cod_Pais CHAR(2) PRIMARY KEY,
    NomPais VARCHAR(30) NOT NULL
);

INSERT INTO Pais (Cod_Pais, NomPais) VALUES 
('AR', 'Argentina'),
('AT', 'Austria'),
('BE', 'Bélgica'),
('BR', 'Brasil'),
('CA', 'Canadá'),
('CH', 'Suiza'),
('CN', 'China'),
('CU', 'Cuba'),
('CY', 'Chipre'),
('CZ', 'República Checa'),
('DE', 'Alemania'),
('DK', 'Dinamarca'),
('EE', 'Estonia'),
('EG', 'Egipto'),
('ES', 'España'),
('FI', 'Finlandia'),
('FR', 'Francia'),
('GB', 'Reino Unido'),
('GR', 'Grecia'),
('GT', 'Guatemala'),
('HK', 'Hong-Kong'),
('HR', 'Croacia'),
('HU', 'Hungría'),
('ID', 'Indonesia'),
('IE', 'Irlanda'),
('IL', 'Israel'),
('IN', 'India'),
('IS', 'Islandia'),
('IT', 'Italia'),
('JM', 'Jamaica'),
('JP', 'Japón'),
('KE', 'Kenia'),
('LU', 'Luxemburgo'),
('MA', 'Marruecos'),
('MC', 'Mónaco'),
('MT', 'Malta'),
('MV', 'Maldivas'),
('MX', 'México'),
('NL', 'Países Bajos'),
('NO', 'Noruega'),
('PA', 'Panamá'),
('PE', 'Perú'),
('PL', 'Polonia'),
('PR', 'Puerto Rico'),
('PT', 'Portugal'),
('QA', 'Qatar'),
('RO', 'Rumania'),
('RU', 'Rusia'),
('SC', 'Seychelles'),
('SE', 'Suecia'),
('SG', 'Singapur'),
('TH', 'Tailandia'),
('TN', 'Túnez'),
('TR', 'Turquía'),
('TZ', 'Tanzania (Incluye Zanzíbar)'),
('US', 'Estados Unidos'),
('VE', 'Venezuela'),
('VN', 'Vietnam'),
('ZA', 'Sudáfrica'),
('CO', 'Colombia'),
('EC', 'Ecuador');

-- //////////// aeropuerto /////////////////
CREATE TABLE Aeropuerto(
    Id_Aeropuerto CHAR(3) PRIMARY KEY,
    Ciudad VARCHAR(50) NOT NULL
);

INSERT INTO Aeropuerto (Id_Aeropuerto, Ciudad) VALUES 
('ACA', 'México (Acapulco)'),
('ACE', 'Lanzarote'),
('AGP', 'Málaga'),
('ALC', 'Alicante'),
('AMM', 'Jordania (Ammán)'),
('AMS', 'Holanda (Ámsterdam)'),
('ATH', 'Grecia (Atenas)'),
('BCN', 'Barcelona'),
('BER', 'Alemania (Berlín)'),
('BIO', 'Bilbao'),
('BJZ', 'Badajoz'),
('BKK', 'Tailandia (Bangkok)'),
('BOG', 'Colombia (Bogotá)'),
('BOS', 'Boston'),
('BRU', 'Bélgica (Bruselas)'),
('BSB', 'Brasil (Brasilia)'),
('BUE', 'Argentina (Buenos Aires)'),
('CAI', 'Egipto (El Cairo)'),
('CAS', 'Marruecos (Casablanca)'),
('CDG', 'Francia (París, Charles de Gaulle)'),
('CPH', 'Dinamarca (Copenhague)'),
('DUB', 'Irlanda (Dublín)'),
('DUS', 'Alemania (Düsseldorf)'),
('EAS', 'San Sebastián'),
('FRA', 'Alemania (Fráncfort)'),
('GVA', 'Suiza (Ginebra)'),
('HAM', 'Alemania (Hamburgo)'),
('HEL', 'Finlandia (Helsinki)'),
('HOU', 'Houston'),
('IST', 'Turquía (Estambul)'),
('JFK', 'Nueva York (JFK)'),
('LAX', 'Los Ángeles'),
('LHR', 'Reino Unido (Heathrow)'),
('LIM', 'Perú (Lima)'),
('MAD', 'Madrid'),
('MEX', 'México (Ciudad de México)'),
('MUC', 'Alemania (Múnich)'),
('NBO', 'Kenia (Nairobi)'),
('ORY', 'Francia (París, Orly)'),
('OSL', 'Noruega (Oslo)'),
('PMI', 'Palma de Mallorca'),
('PRG', 'República Checa (Praga)'),
('RAK', 'Marruecos (Marrakech)'),
('SFO', 'San Francisco'),
('SYD', 'Australia (Sídney)'),
('TFN', 'Tenerife Norte'),
('TFS', 'Tenerife Sur'),
('ZRH', 'Suiza (Zúrich)');

-- /////////////////// aerolinea ////////
CREATE TABLE Aerolinea (
    Cod_Aerolinea VARCHAR(5) PRIMARY KEY,
    NomAerolinea VARCHAR(50) NOT NULL,
    Cod_Pais CHAR(2) NOT NULL,
    CONSTRAINT FK_Cod_Pais FOREIGN KEY (Cod_Pais) REFERENCES Pais(Cod_Pais)  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Aerolinea (Cod_Aerolinea, NomAerolinea, Cod_Pais) VALUES 
('2K', 'AVIANCA-Ecuador dba AVIANCA', 'EC'),
('3P', 'World 2 Fly PT, S.A.', 'PT'),
('6B', 'TUIfly Nordic AB', 'CN'),
('AC', 'Air Canada', 'CA'),
('A0', 'BA Euroflyer Limited dba British Airways', 'GB'),
('AM', 'AeroMéxico', 'MX'),
('AV', 'Avianca', 'CO'),
('BA', 'British Airways', 'GB'),
('LH', 'Lufthansa', 'DE'),
('QR', 'Qatar Airways', 'QA'),
('TK', 'Turkish Airlines', 'TR'),
('UA', 'United Airlines', 'US');

-- //////////////////// vuelo ///////////////
CREATE TABLE Vuelo (
    Id_Vuelo CHAR(5) PRIMARY KEY,
    FechVuelo DATE NOT NULL,
    Aerolinea VARCHAR(5) NOT NULL,
    HorarioSalida TIME NOT NULL,
    Duracion TIME NOT NULL,
    Id_AeroOrig CHAR(3) NOT NULL,  
    Id_AeroDest CHAR(3) NOT NULL,
    Precio INT NOT NULL,
    CONSTRAINT FK_Aerolinea FOREIGN KEY (Aerolinea) REFERENCES Aerolinea(Cod_Aerolinea)  ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Id_AeroOrig FOREIGN KEY (Id_AeroOrig) REFERENCES Aeropuerto(Id_Aeropuerto)  ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Id_AeroDest FOREIGN KEY (Id_AeroDest) REFERENCES Aeropuerto(Id_Aeropuerto)  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio)
VALUES
('V001', '2025-03-01', 'AM', '08:00:00', '02:00:00', 'MEX', 'JFK', 500),
('V002', '2025-04-10', 'AV', '10:00:00', '05:00:00', 'BOG', 'LIM', 450),
('V003', '2025-06-05', 'LH', '14:00:00', '04:00:00', 'FRA', 'MAD', 700);

-- ////////////////////////// tipo habitacion //////////////
CREATE TABLE TipoHabitacion (
    Cod_TipoHab VARCHAR(3) PRIMARY KEY, 
    TipoHab VARCHAR(30) NOT NULL
);

INSERT INTO TipoHabitacion (Cod_TipoHab, TipoHab) VALUES 
('DB', 'Doble'),
('DUI', 'Doble uso individual'),
('SIN', 'Individual'),
('TPL', 'Triple');

-- ////////////////// Plan Viaje //////////////////
CREATE TABLE Plan_Viaje (
    Id_Evento CHAR(5) PRIMARY KEY,
    Nom_Evento VARCHAR(50) NOT NULL,
    TipoEvento VARCHAR(50) NOT NULL,
    Trayecto ENUM("Ida","Ida-Vuelta") NOT NULL,
    Id_VueloIda CHAR(5) NOT NULL,
    Id_VueloVuelta CHAR(5),
    Id_Viaje CHAR(5) NOT NULL,
    CONSTRAINT FK_Plan_Viaje_VueloIda FOREIGN KEY (Id_VueloIda) REFERENCES Vuelo(Id_Vuelo)  ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Plan_Viaje_VueloVuelta FOREIGN KEY (Id_VueloVuelta) REFERENCES Vuelo(Id_Vuelo)  ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Id_Viaje_Plan_Viaje FOREIGN KEY (Id_Viaje) REFERENCES Viaje(Id_Viaje)  ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO Plan_Viaje (Id_Evento, Nom_Evento, TipoEvento, Trayecto, Id_VueloIda, Id_VueloVuelta, Id_Viaje)
VALUES
('EV001', 'Vuelo a Nueva York', 'Vuelo', 'Ida', 'V001', NULL, 'VI001'),
('EV002', 'Vuelo ida y vuelta a Lima', 'Vuelo', 'Ida-Vuelta', 'V002', 'V003', 'VI002'),
('EV003', 'Vuelo a Madrid', 'Vuelo', 'Ida', 'V003', NULL, 'VI003');



-- ////////////////// Actividad //////////////////
CREATE TABLE Actividad (
    Id_Evento CHAR(5) PRIMARY KEY,
    Nom_Evento VARCHAR(30) NOT NULL,
	TipoEvento VARCHAR(50) NOT NULL,
    Descripcion TEXT NOT NULL, 
    fecha DATE NOT NULL,
    Precio INT NOT NULL,
    Id_Viaje CHAR(5) NOT NULL,
    CONSTRAINT FK_Id_Viaje_Actividad FOREIGN KEY (Id_Viaje) REFERENCES Viaje(Id_Viaje)  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Actividad (Id_Evento, Nom_Evento, TipoEvento, Descripcion, fecha, Precio, Id_Viaje)
VALUES
('EV004', 'Tesoros de la ciudad', 'Actividad', 'Excursión en el Zócalo de la Ciudad de México', '2025-02-02', 50, 'VI001'),
('EV005', 'Arte & Tradición', 'Actividad', 'Tour por el Parc Güell en Barcelona', '2025-02-06', 40, 'VI002'),
('EV006', 'Sabores pacíficos', 'Actividad', 'Paseo por la playa de Copacabana', '2025-03-02', 60, 'VI003');


-- ////////////////// Alojamiento //////////////////
CREATE TABLE Alojamiento (
    Id_Evento CHAR(5) PRIMARY KEY,
    Nom_Evento VARCHAR(30) NOT NULL,
	TipoEvento VARCHAR(50) NOT NULL,
    nomHotel VARCHAR(30) NOT NULL,
    Cod_TipoHab VARCHAR(3) NOT NULL,
    Ciudad VARCHAR(30) NOT NULL,
    Precio INT NOT NULL,
    fechaEnt DATE NOT NULL,
    FechaSal DATE NOT NULL,
    Id_Viaje CHAR(5) NOT NULL,
    CONSTRAINT FK_Cod_TipoHab FOREIGN KEY (Cod_TipoHab) REFERENCES TipoHabitacion(Cod_TipoHab)  ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_Id_Viaje_alojamiento FOREIGN KEY (Id_Viaje) REFERENCES Viaje(Id_Viaje)  ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Alojamiento (Id_Evento, Nom_Evento, TipoEvento, nomHotel, Cod_TipoHab, Ciudad, Precio, fechaEnt, FechaSal, Id_Viaje)
VALUES
('EV007', 'Hogar de desierto', 'Alojamiento', 'Hotel Fiesta Americana', 'DB', 'Acapulco', 150, '2025-02-01', '2025-02-07', 'VI001'),
('EV008', 'Metropolis stay', 'Alojamiento', 'Hotel Melia Barcelona', 'SIN', 'Barcelona', 120, '2025-02-05', '2025-02-10', 'VI002'),
('EV009', 'Paraiso costero', 'Alojamiento', 'Copacabana Palace', 'TPL', 'Rio de Janeiro', 300, '2025-03-01', '2025-03-07', 'VI003');
