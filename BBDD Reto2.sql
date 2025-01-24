CREATE DATABASE Reto2_t
COLLATE utf8mb4_spanish_ci;

use Reto2_t;


CREATE TABLE TipoEmpleados (
    Codigo CHAR(2) PRIMARY KEY NOT NULL,
    MaxEmpleados INT NOT NULL
);

INSERT INTO TipoEmpleados (Codigo, MaxEmpleados)
VALUES
('L1', 5), -- 5 empleados máximo
('L2', 10), -- 10 empleados máximo
('L3', 20); -- 20 empleados máximo


CREATE TABLE TipoAgencia (
    Codigo CHAR(2) PRIMARY KEY NOT NULL,
    Descripcion TEXT NOT NULL
);

INSERT INTO TipoAgencia (Codigo, Descripcion)
VALUES 
('A1', 'Mayorista'),
('A2', 'Minorista'),
('A3', 'Mayorista-minorista');

CREATE TABLE Agencia(
    Id_Agencia VARCHAR(5) PRIMARY KEY NOT NULL,
    NomAgencia TEXT NOT NULL,
    TipoAgencia CHAR(2) NOT NULL,
    ColorAgencia VARCHAR(7) NOT NULL,
    NumEmp INT NOT NULL,
    Logo TEXT NOT NULL,
    Pass VARCHAR(40) NOT NULL,
    CodigoTipoEmpleado CHAR(2),
    CONSTRAINT FK_TipoEmpleado FOREIGN KEY (CodigoTipoEmpleado) REFERENCES TipoEmpleados(Codigo),
	CONSTRAINT FK_TipoAgencia FOREIGN KEY (TipoAgencia) REFERENCES TipoAgencia(Codigo)
);

INSERT INTO Agencia (Id_Agencia, NomAgencia, TipoAgencia, ColorAgencia, NumEmp, Logo, Pass, CodigoTipoEmpleado)
VALUES 
('AG001', 'Agencia Viajar', 'A3', '#FF5733', 50, 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@123', 'L1'),
('AG002', 'Turismo Total', 'A2', '#33FF57', 30, 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@456', 'L2'),
('AG003', 'ExploraMundo', 'A1', '#3357FF', 20, 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@789', 'L3');


CREATE TABLE Viaje (
    Id_Viaje VARCHAR(5) PRIMARY KEY NOT NULL,
    NomViaje TEXT NOT NULL,
    FechInicio DATE NOT NULL,
    FechFin DATE NOT NULL,
    NumDias INT NOT NULL,
    PaisDestino VARCHAR(40) NOT NULL,
    Descripcion TEXT NOT NULL,
    ServiciosnoIncl TEXT NOT NULL,
    Id_Agencia VARCHAR(5) NOT NULL,
    CodigoTipoViaje CHAR(2),
    CONSTRAINT FK_Id_Agencia FOREIGN KEY(Id_Agencia) REFERENCES Agencia(Id_Agencia),
    CONSTRAINT FK_TipoViaje FOREIGN KEY (CodigoTipoViaje) REFERENCES TipoViaje(Codigo)
);

INSERT INTO Viaje (Id_Viaje, NomViaje, FechInicio, FechFin, NumDias, PaisDestino, Descripcion, ServiciosnoIncl, Id_Agencia, CodigoTipoViaje)
VALUES 
('VI001', 'Aventura en Costa Rica', '2025-03-01', '2025-03-10', 10, 'Costa Rica', 'Una experiencia llena de naturaleza y deportes extremos.', 'Comidas no incluidas', 'AG001', 'B1'),
('VI002', 'Tour por Europa', '2025-04-01', '2025-04-20', 20, 'Francia, Italia, España', 'Visita a los lugares más emblemáticos de Europa.', 'Transporte interno no incluido', 'AG002', 'B2'),
('VI003', 'Relax en el Caribe', '2025-06-01', '2025-06-10', 10, 'República Dominicana', 'Vacaciones de descanso en las mejores playas del Caribe.', 'Excursiones no incluidas', 'AG003', 'B6');

CREATE TABLE TipoViaje (
    Codigo CHAR(2) PRIMARY KEY NOT NULL,
    Descripcion TEXT NOT NULL
);

INSERT INTO TipoViaje (Codigo, Descripcion)
VALUES 
('B1', 'Los novios'),
('B2', 'Senior'),
('B3', 'Grupos'),
('B4', 'Grandes viajes (destinos exóticos + vuelo + alojamiento)'),
('B5', 'Escapada'),
('B6', 'Familias (con niños pequeños)');

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
('EV003', 'Actividad en Punta Cana', 'Actividad', 'VI003');


CREATE TABLE Pais(
	Id_Pais CHAR(2) NOT NULL PRIMARY KEY,
	NomPais VARCHAR(30) NOT NULL
);
INSERT INTO Pais (Id_Pais, NomPais)
VALUES
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
('HK', 'Hong Kong'),
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
('TZ', 'Tanzania (Incluye Zanzibar)'),
('US', 'Estados Unidos'),
('VE', 'Venezuela'),
('VN', 'Vietnam'),
('ZA', 'Sudáfrica'),
('JO', 'Jordania'),
('CO', 'Colombia'),
('DO', 'República Dominicana');



CREATE TABLE Aeropuerto(
	Id_Aeropuerto CHAR(3) NOT NULL PRIMARY KEY,
	NomAero VARCHAR(400) NOT NULL,
	Ciudad VARCHAR(30) NOT NULL,
	Id_Pais CHAR(2) NOT NULL,
	CONSTRAINT FK_Id_Pais FOREIGN KEY (Id_Pais) REFERENCES Pais(Id_Pais)
);

INSERT INTO Aeropuerto (Id_Aeropuerto, NomAero, Ciudad, Id_Pais)
VALUES 
('ACA', 'General Juan N. Álvarez International Airport', 'Acapulco', 'MX'),
('ACE', 'Lanzarote Airport', 'Lanzarote', 'ES'),
('AGP', 'Malaga Airport', 'Málaga', 'ES'),
('ALC', 'Alicante-Elche Airport', 'Alicante', 'ES'),
('AMM', 'Queen Alia International Airport', 'Ammán', 'JO'),
('AMS', 'Amsterdam Airport Schiphol', 'Ámsterdam', 'NL'),
('ATH', 'Athens International Airport', 'Atenas', 'GR'),
('BCN', 'Barcelona El Prat Airport', 'Barcelona', 'ES'),
('BER', 'Berlin Brandenburg Airport', 'Berlín', 'DE'),
('BIO', 'Bilbao Airport', 'Bilbao', 'ES'),
('BJZ', 'Badajoz Airport', 'Badajoz', 'ES'),
('BKK', 'Suvarnabhumi Airport', 'Bangkok', 'TH'),
('BOG', 'El Dorado International Airport', 'Bogotá', 'CO'),
('BOS', 'Logan International Airport', 'Boston', 'US'),
('BRU', 'Brussels Airport', 'Bruselas', 'BE'),
('BSB', 'Brasilia International Airport', 'Brasilia', 'BR'),
('BUE', 'Ezeiza International Airport', 'Buenos Aires', 'AR'),
('CAI', 'Cairo International Airport', 'El Cairo', 'EG'),
('CAS', 'Mohammed V International Airport', 'Casablanca', 'MA'),
('CCS', 'Simón Bolívar International Airport', 'Caracas', 'VE'),
('CDG', 'Charles de Gaulle Airport', 'París', 'FR'),
('CPH', 'Copenhagen Airport', 'Copenhague', 'DK'),
('DTT', 'Detroit Metropolitan Airport', 'Detroit', 'US'),
('DUB', 'Dublin Airport', 'Dublín', 'IE'),
('DUS', 'Düsseldorf Airport', 'Düsseldorf', 'DE'),
('EAS', 'San Sebastián Airport', 'San Sebastián', 'ES'),
('FRA', 'Frankfurt Airport', 'Frankfurt', 'DE'),
('FUE', 'Fuerteventura Airport', 'Fuerteventura', 'ES'),
('GMZ', 'La Gomera Airport', 'La Gomera', 'ES'),
('GRO', 'Girona-Costa Brava Airport', 'Gerona', 'ES'),
('GRX', 'Federico García Lorca Granada-Jaén Airport', 'Granada', 'ES'),
('GVA', 'Geneva Airport', 'Ginebra', 'CH'),
('HAM', 'Hamburg Airport', 'Hamburgo', 'DE'),
('HEL', 'Helsinki Airport', 'Helsinki', 'FI'),
('HOU', 'George Bush Intercontinental Airport', 'Houston', 'US'),
('IBZ', 'Ibiza Airport', 'Ibiza', 'ES'),
('IST', 'Istanbul Airport', 'Estambul', 'TR'),
('JFK', 'John F. Kennedy International Airport', 'Nueva York', 'US'),
('KIN', 'Norman Manley International Airport', 'Kingston', 'JM'),
('LAX', 'Los Angeles International Airport', 'Los Ángeles', 'US'),
('LBG', 'Le Bourget Airport', 'Le Bourget', 'FR'),
('LCG', 'A Coruña Airport', 'La Coruña', 'ES'),
('LGH', 'London Gatwick Airport', 'Londres', 'GB'),
('LHR', 'London Heathrow Airport', 'Londres', 'GB'),
('LIM', 'Jorge Chávez International Airport', 'Lima', 'PE'),
('LIS', 'Lisbon Airport', 'Lisboa', 'PT'),
('LPA', 'Gran Canaria Airport', 'Gran Canaria', 'ES'),
('LYS', 'Lyon–Saint-Exupéry Airport', 'Lyon', 'FR'),
('MAD', 'Adolfo Suárez Madrid–Barajas Airport', 'Madrid', 'ES'),
('MAH', 'Menorca Airport', 'Mahon', 'ES'),
('MEL', 'Melbourne Airport', 'Melbourne', 'AU'),
('MEX', 'Mexico City International Airport', 'México D.F.', 'MX'),
('MIA', 'Miami International Airport', 'Miami', 'US'),
('MIL', 'Milan Malpensa Airport', 'Milán', 'IT'),
('MJV', 'Murcia–San Javier Airport', 'Murcia', 'ES'),
('MOW', 'Sheremetyevo International Airport', 'Moscú', 'RU'),
('MRS', 'Marseille Provence Airport', 'Marsella', 'FR'),
('MUC', 'Munich Airport', 'Múnich', 'DE'),
('NBO', 'Jomo Kenyatta International Airport', 'Nairobi', 'KE'),
('ODB', 'Córdoba Airport', 'Córdoba', 'ES'),
('ORY', 'Orly Airport', 'París', 'FR'),
('OSL', 'Oslo Gardermoen Airport', 'Oslo', 'NO'),
('OVD', 'Asturias Airport', 'Asturias', 'ES'),
('PHL', 'Philadelphia International Airport', 'Filadelfia', 'US'),
('PMI', 'Palma de Mallorca Airport', 'Palma de Mallorca', 'ES'),
('PNA', 'Pamplona Airport', 'Pamplona', 'ES'),
('PRG', 'Václav Havel Airport Prague', 'Praga', 'CZ'),
('RAK', 'Marrakech Menara Airport', 'Marrakech', 'MA'),
('REU', 'Reus Airport', 'Reus', 'ES'),
('RIO', 'Galeão International Airport', 'Rio de Janeiro', 'BR'),
('SAO', 'São Paulo-Guarulhos International Airport', 'São Paulo', 'BR'),
('SCQ', 'Santiago de Compostela Airport', 'Santiago de Compostela', 'ES'),
('SDQ', 'Las Américas International Airport', 'Santo Domingo', 'DO'),
('SDR', 'Santander Airport', 'Santander', 'ES'),
('SEA', 'Seattle–Tacoma International Airport', 'Seattle', 'US'),
('SFO', 'San Francisco International Airport', 'San Francisco', 'US'),
('SLM', 'Salamanca Airport', 'Salamanca', 'ES'),
('SPC', 'Santa Cruz de la Palma Airport', 'Santa Cruz de la Palma', 'ES'),
('STN', 'London Stansted Airport', 'Londres', 'GB'),
('STO', 'Stockholm Arlanda Airport', 'Estocolmo', 'SE'),
('STR', 'Stuttgart Airport', 'Stuttgart', 'DE'),
('SYD', 'Sydney Airport', 'Sídney', 'AU'),
('TFN', 'Tenerife North Airport', 'Tenerife Norte', 'ES'),
('TFS', 'Tenerife South Airport', 'Tenerife Sur', 'ES'),
('TUN', 'Tunis–Carthage International Airport', 'Túnez', 'TN'),
('VDE', 'El Hierro Airport', 'El Hierro', 'ES'),
('VGO', 'Vigo Airport', 'Vigo', 'ES'),
('VIE', 'Vienna International Airport', 'Viena', 'AT'),
('VIT', 'Vitoria Airport', 'Vitoria', 'ES'),
('VLC', 'Valencia Airport', 'Valencia', 'ES'),
('WAS', 'Washington Dulles International Airport', 'Washington', 'US'),
('WAW', 'Warsaw Chopin Airport', 'Varsovia', 'PL'),
('XRY', 'Jerez Airport', 'Jerez de la Frontera', 'ES'),
('YMQ', 'Montréal–Trudeau International Airport', 'Montreal', 'CA'),
('YOW', 'Ottawa Macdonald–Cartier International Airport', 'Ottawa', 'CA'),
('YTO', 'Toronto Pearson International Airport', 'Toronto', 'CA'),
('YVR', 'Vancouver International Airport', 'Vancouver', 'CA'),
('ZAZ', 'Zaragoza Airport', 'Zaragoza', 'ES'),
('ZRH', 'Zurich Airport', 'Zürich', 'CH');



CREATE TABLE Aerolinea (
    Id_Aerolinea CHAR(5) PRIMARY KEY NOT NULL,
    Nombre VARCHAR(255) NOT NULL,
    Pais CHAR(2) NOT NULL,
    CONSTRAINT FK_Pais FOREIGN KEY (Pais) REFERENCES Pais(Id_Pais)
);

INSERT INTO Aerolinea (Codigo, Nombre, Pais)
VALUES
('2K', 'AVIANCA-Ecuador dba AVIANCA', 'EC'),
('3P', 'World 2 Fly PT, S.A.', 'PT'),
('6B*', 'TUIfly Nordic AB', 'CN'),
('A.C.', 'Air France', 'FR'),
('A0', 'BA Euroflyer Limited dba British Airways', 'GB'),
('AA', 'American Airlines', 'USA'),
('AM', 'Aerovias de Mexico SA de CV dba AeroMexico', 'MX'),
('AR', 'Aerolineas Argentinas S.A.', 'AR'),
('AV', 'Aerovias del Continente Americano S.A. AVIANCA', 'CO'),
('AY', 'Finnair', 'FI'),
('AZ', 'Alitalia', 'IT'),
('BA', 'British Airways PLC', 'GB'),
('CL', 'Lufthansa CityLine GmbH', 'DE'),
('DE', 'Condor Flugdienst GmbH', 'DE'),
('DL', 'Delta Air Lines Inc', 'USA'),
('DS', 'Easyjet CH S.A', 'CH'),
('GL', 'Air GRL', 'GRL'),
('JJ', 'Tam Linhas Aereas SA dba Latam Airlines Brasil', 'BR'),
('KL', 'KLM', 'NL'),
('KN', 'CN United Airlines', 'CN'),
('LH', 'Lufthansa', 'DE'),
('LX', 'SWISS Internation Air Lines Ltd', 'CH'),
('M3', 'BSA - Aerolinhas Brasileiras S.A dba LATAM Cargo Br', 'BR'),
('MS', 'Egyptair', 'EG'),
('MT', 'MT Air Travel Ltd dba MT MedAir', 'MT'),
('N0', 'Norse Atlantic Airways AS', 'NO'),
('OU', 'HR Airlines d.d.', 'HR'),
('PC', 'Pegasus Airlines', 'TR'),
('QR', 'QA Airways Group Q.C.S.C dba QA Airways', 'QA'),
('RJ', 'Alia - The Royal JOn Airlines dba Royal JOn', 'JO'),
('RK', 'RYNAIR', 'GB'),
('S4', 'SATA Internacional - Azores Airlines, S.A.', 'PT'),
('SN', 'Brussels Airlines', 'BE'),
('SP', 'SATA (Air Acores)', 'PT'),
('TK', 'Turkish Airlines Inc', 'TR'),
('TP', 'TAP PT', 'PT'),
('TS', 'Air Transat', 'CA'),
('U2', 'EASYJET UK LIMITED', 'GB'),
('UA', 'United Airlines Inc', 'USA'),
('UX', 'Air Europa Lineas Aereas, S.A.', 'ES'),
('VOY', 'Aerolínea Vueling SA', 'ES'),
('VS', 'Virgin Atlantic Airways Ltd', 'GB'),
('WA', 'KLM Cityhopper', 'NL'),
('WFL', 'World2Fly', 'ES'),
('WK', 'Edelweiss Air AG', 'CH'),
('X3*', 'TUIfly Gmbh', 'DE'),
('X7', 'Challenge Airlines (BE) S.A.', 'BE'),
('YW', 'Air Nostrum, Lineas aereas del Mediterra neo SA', 'ES');



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
	CONSTRAINT FK_Id_AeroDest FOREIGN KEY (Id_AeroDest) REFERENCES Aeropuerto(Id_Aeropuerto),
    CONSTRAINT FK_Aerolinea FOREIGN KEY (Aerolinea) REFERENCES Aerolinea(Id_Aerolinea)
);

INSERT INTO Vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio)
VALUES
('VU001', '2025-02-01', 'Aeroméxico', '14:00:00', 180, 'ACA', 'MEX', 500),
('VU002', '2025-02-05', 'Iberia', '10:30:00', 150, 'MAD', 'BCN', 350),
('VU003', '2025-03-01', 'LATAM', '18:15:00', 210, 'SFO', 'RIO', 600);


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
('EV001', 'Ida', 'VU001', NULL),
('EV002', 'Ida_Vuelta', 'VU002', 'VU003'),
('EV003', 'Ida', 'VU003', NULL);


CREATE TABLE Alojamiento (
    Id_Alojamiento CHAR(5) PRIMARY KEY,
    NomHotel VARCHAR(30) NOT NULL,
    TipoDormitorio CHAR(3) NOT NULL,
    Ciudad VARCHAR(30) NOT NULL,
    Precio INT NOT NULL,
    FechaEnt DATE NOT NULL,
    FechaSal DATE NOT NULL,
    CONSTRAINT FK_TipoDormitorio FOREIGN KEY (TipoDormitorio) REFERENCES TipoDormitorio(Codigo)
);

INSERT INTO Alojamiento (Id_Alojamiento, NomHotel, TipoDormitorio, Ciudad, Precio, FechaEnt, FechaSal)
VALUES
('EV001', 'Hotel Fiesta Americana', 'DB', 'Acapulco', 150, '2025-02-01', '2025-02-07'),
('EV002', 'Hotel Melia Barcelona', 'SIN', 'Barcelona', 120, '2025-02-05', '2025-02-10'),
('EV003', 'Copacabana Palace', 'TPL', 'Rio de Janeiro', 300, '2025-03-01', '2025-03-07');


CREATE TABLE TipoDormitorio (
    Codigo CHAR(3) PRIMARY KEY NOT NULL,
    Descripcion TEXT NOT NULL
);

INSERT INTO TipoDormitorio (Codigo, Descripcion)
VALUES 
('DB', 'Doble'),
('DUI', 'Uso doble e individual'),
('SIN', 'Individual'),
('TPL', 'Triple');

CREATE TABLE Actividad (
	Id_Actividad CHAR(5) PRIMARY KEY, 
    Descripcion TEXT NOT NULL, 
    fecha DATE NOT NULL,
    Precio INT NOT NULL,
	CONSTRAINT FK_Id_Actividad FOREIGN KEY (Id_Actividad) REFERENCES Evento(Id_Evento)
);

INSERT INTO Actividad (Id_Actividad, Descripcion, fecha, Precio)
VALUES
('EV001', 'Excursión en el Zócalo de la Ciudad de México', '2025-02-02', 50),
('EV002', 'Tour por el Parc Güell en Barcelona', '2025-02-06', 40),
('EV003', 'Paseo por la playa de Copacabana', '2025-03-02', 60);
