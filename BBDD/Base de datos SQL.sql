CREATE DATABASE Reto2_t
COLLATE utf8mb4_spanish_ci;

use Reto2_t;

CREATE TABLE Agencia(
	Id_Agencia VARCHAR(5) PRIMARY KEY NOT NULL,
	NomAgencia TEXT NOT NULL,
	TipoAgencia TEXT NOT NULL,
	ColorAgencia VARCHAR(7) NOT NULL ,
	NumEmp INT NOT NULL ,
	Logo TEXT NOT NULL,
	Pass VARCHAR(40) NOT NULL
);

INSERT INTO Agencia (Id_Agencia, NomAgencia, TipoAgencia, ColorAgencia, NumEmp, Logo, Pass)
VALUES 
('AG001', 'Agencia Viajar', 'Agencias de viajes física', '#FF5733', 50, 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@123'),
('AG002', 'Turismo Total', 'Agencias de viajes en línea', '#33FF57', 30, 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@456'),
('AG003', 'ExploraMundo', 'Agencias de viajes espezializadas', '#3357FF', 20, 'https://images.app.goo.gl/Lc42zBdTBWT6jCjX6', 'pass@789');

CREATE TABLE Viaje(
	Id_Viaje VARCHAR(5) PRIMARY KEY NOT NULL,
	NomViaje TEXT NOT NULL,
	TipoViaje TEXT NOT NULL,
	FechInicio DATE NOT NULL ,
	FechFin DATE NOT NULL ,
	NumDias INT NOT NULL,
	PaisDestino VARCHAR(40) NOT NULL,
	Descripcion TEXT NOT NULL,
	ServiciosnoIncl TEXT NOT NULL,
	Id_Agencia  VARCHAR(5) NOT NULL,
	CONSTRAINT FK_Id_Agencia FOREIGN KEY(Id_Agencia) REFERENCES Agencia(Id_Agencia)
);

INSERT INTO Viaje (Id_Viaje, NomViaje, TipoViaje, FechInicio, FechFin, NumDias, PaisDestino, Descripcion, ServiciosnoIncl, Id_Agencia)
VALUES 
('VI001', 'Aventura en Costa Rica', 'Aventura', '2025-03-01', '2025-03-10', 10, 'Costa Rica', 'Una experiencia llena de naturaleza y deportes extremos.', 'Comidas no incluidas', 'AG001'),
('VI002', 'Tour por Europa', 'Cultural', '2025-04-01', '2025-04-20', 20, 'Francia, Italia, España', 'Visita a los lugares más emblemáticos de Europa.', 'Transporte interno no incluido', 'AG002'),
('VI003', 'Relax en el Caribe', 'Playa', '2025-06-01', '2025-06-10', 10, 'República Dominicana', 'Vacaciones de descanso en las mejores playas del Caribe.', 'Excursiones no incluidas', 'AG003');

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
	Id_Pais CHAR(3) NOT NULL PRIMARY KEY,
	NomPais VARCHAR(30) NOT NULL
);

INSERT INTO Pais (Id_Pais, NomPais)
VALUES
('MEX', 'México'),
('ESP', 'España'),
('JOR', 'Jordania'),
('NLD', 'Países Bajos'),
('GRC', 'Grecia'),
('DEU', 'Alemania'),
('COL', 'Colombia'),
('BEL', 'Bélgica'),
('BRA', 'Brasil'),
('ARG', 'Argentina'),
('EGY', 'Egipto'),
('MAR', 'Marruecos'),
('VEN', 'Venezuela'),
('FRA', 'Francia'),
('DNK', 'Dinamarca'),
('USA', 'Estados Unidos'),
('IRL', 'Irlanda'),
('CHE', 'Suiza'),
('FIN', 'Finlandia'),
('KEN', 'Kenia'),
('ITA', 'Italia'),
('RUS', 'Rusia'),
('CZE', 'República Checa'),
('DOM', 'República Dominicana'),
('CAN', 'Canadá'),
('POL', 'Polonia'),
('TUR', 'Turquía'),
('AUS', 'Australia'),
('PER', 'Perú'),
('PRT', 'Portugal'),
('SWE', 'Suecia'),
('AUT', 'Austria'),
('GBR', 'Reino Unido'),
('TUN', 'Túnez'),
('THA', 'Tailandia'),
('JAM', 'Jamaica'),
('NOR', 'Noruega');



CREATE TABLE Aeropuerto(
	Id_Aeropuerto CHAR(3) NOT NULL PRIMARY KEY,
	NomAero VARCHAR(400) NOT NULL,
	Ciudad VARCHAR(30) NOT NULL,
	Id_Pais CHAR(5) NOT NULL,
	CONSTRAINT FK_Id_Pais FOREIGN KEY (Id_Pais) REFERENCES Pais(Id_Pais)
);

INSERT INTO Aeropuerto (Id_Aeropuerto, NomAero, Ciudad, Id_Pais)
VALUES 
('ACA', 'General Juan N. Álvarez International Airport', 'Acapulco', 'MEX'),
('ACE', 'Lanzarote Airport', 'Lanzarote', 'ESP'),
('AGP', 'Malaga Airport', 'Málaga', 'ESP'),
('ALC', 'Alicante-Elche Airport', 'Alicante', 'ESP'),
('AMM', 'Queen Alia International Airport', 'Ammán', 'JOR'),
('AMS', 'Amsterdam Airport Schiphol', 'Ámsterdam', 'NLD'),
('ATH', 'Athens International Airport', 'Atenas', 'GRC'),
('BCN', 'Barcelona El Prat Airport', 'Barcelona', 'ESP'),
('BER', 'Berlin Brandenburg Airport', 'Berlín', 'DEU'),
('BIO', 'Bilbao Airport', 'Bilbao', 'ESP'),
('BJZ', 'Badajoz Airport', 'Badajoz', 'ESP'),
('BKK', 'Suvarnabhumi Airport', 'Bangkok', 'THA'),
('BOG', 'El Dorado International Airport', 'Bogotá', 'COL'),
('BOS', 'Logan International Airport', 'Boston', 'USA'),
('BRU', 'Brussels Airport', 'Bruselas', 'BEL'),
('BSB', 'Brasilia International Airport', 'Brasilia', 'BRA'),
('BUE', 'Ezeiza International Airport', 'Buenos Aires', 'ARG'),
('CAI', 'Cairo International Airport', 'El Cairo', 'EGY'),
('CAS', 'Mohammed V International Airport', 'Casablanca', 'MAR'),
('CCS', 'Simón Bolívar International Airport', 'Caracas', 'VEN'),
('CDG', 'Charles de Gaulle Airport', 'París', 'FRA'),
('CPH', 'Copenhagen Airport', 'Copenhague', 'DNK'),
('DTT', 'Detroit Metropolitan Airport', 'Detroit', 'USA'),
('DUB', 'Dublin Airport', 'Dublín', 'IRL'),
('DUS', 'Düsseldorf Airport', 'Düsseldorf', 'DEU'),
('EAS', 'San Sebastián Airport', 'San Sebastián', 'ESP'),
('FRA', 'Frankfurt Airport', 'Frankfurt', 'DEU'),
('FUE', 'Fuerteventura Airport', 'Fuerteventura', 'ESP'),
('GMZ', 'La Gomera Airport', 'La Gomera', 'ESP'),
('GRO', 'Girona-Costa Brava Airport', 'Gerona', 'ESP'),
('GRX', 'Federico García Lorca Granada-Jaén Airport', 'Granada', 'ESP'),
('GVA', 'Geneva Airport', 'Ginebra', 'CHE'),
('HAM', 'Hamburg Airport', 'Hamburgo', 'DEU'),
('HEL', 'Helsinki Airport', 'Helsinki', 'FIN'),
('HOU', 'George Bush Intercontinental Airport', 'Houston', 'USA'),
('IBZ', 'Ibiza Airport', 'Ibiza', 'ESP'),
('IST', 'Istanbul Airport', 'Estambul', 'TUR'),
('JFK', 'John F. Kennedy International Airport', 'Nueva York', 'USA'),
('KIN', 'Norman Manley International Airport', 'Kingston', 'JAM'),
('LAX', 'Los Angeles International Airport', 'Los Ángeles', 'USA'),
('LBG', 'Le Bourget Airport', 'Le Bourget', 'FRA'),
('LCG', 'A Coruña Airport', 'La Coruña', 'ESP'),
('LGH', 'London Gatwick Airport', 'Londres', 'GBR'),
('LHR', 'London Heathrow Airport', 'Londres', 'GBR'),
('LIM', 'Jorge Chávez International Airport', 'Lima', 'PER'),
('LIS', 'Lisbon Airport', 'Lisboa', 'PRT'),
('LPA', 'Gran Canaria Airport', 'Gran Canaria', 'ESP'),
('LYS', 'Lyon–Saint-Exupéry Airport', 'Lyon', 'FRA'),
('MAD', 'Adolfo Suárez Madrid–Barajas Airport', 'Madrid', 'ESP'),
('MAH', 'Menorca Airport', 'Mahon', 'ESP'),
('MEL', 'Melbourne Airport', 'Melbourne', 'AUS'),
('MEX', 'Mexico City International Airport', 'México D.F.', 'MEX'),
('MIA', 'Miami International Airport', 'Miami', 'USA'),
('MIL', 'Milan Malpensa Airport', 'Milán', 'ITA'),
('MJV', 'Murcia–San Javier Airport', 'Murcia', 'ESP'),
('MOW', 'Sheremetyevo International Airport', 'Moscú', 'RUS'),
('MRS', 'Marseille Provence Airport', 'Marsella', 'FRA'),
('MUC', 'Munich Airport', 'Múnich', 'DEU'),
('NBO', 'Jomo Kenyatta International Airport', 'Nairobi', 'KEN'),
('ODB', 'Córdoba Airport', 'Córdoba', 'ESP'),
('ORY', 'Orly Airport', 'París', 'FRA'),
('OSL', 'Oslo Gardermoen Airport', 'Oslo', 'NOR'),
('OVD', 'Asturias Airport', 'Asturias', 'ESP'),
('PHL', 'Philadelphia International Airport', 'Filadelfia', 'USA'),
('PMI', 'Palma de Mallorca Airport', 'Palma de Mallorca', 'ESP'),
('PNA', 'Pamplona Airport', 'Pamplona', 'ESP'),
('PRG', 'Václav Havel Airport Prague', 'Praga', 'CZE'),
('RAK', 'Marrakech Menara Airport', 'Marrakech', 'MAR'),
('REU', 'Reus Airport', 'Reus', 'ESP'),
('RIO', 'Galeão International Airport', 'Rio de Janeiro', 'BRA'),
('SAO', 'São Paulo-Guarulhos International Airport', 'São Paulo', 'BRA'),
('SCQ', 'Santiago de Compostela Airport', 'Santiago de Compostela', 'ESP'),
('SDQ', 'Las Américas International Airport', 'Santo Domingo', 'DOM'),
('SDR', 'Santander Airport', 'Santander', 'ESP'),
('SEA', 'Seattle–Tacoma International Airport', 'Seattle', 'USA'),
('SFO', 'San Francisco International Airport', 'San Francisco', 'USA'),
('SLM', 'Salamanca Airport', 'Salamanca', 'ESP'),
('SPC', 'Santa Cruz de la Palma Airport', 'Santa Cruz de la Palma', 'ESP'),
('STN', 'London Stansted Airport', 'Londres', 'GBR'),
('STO', 'Stockholm Arlanda Airport', 'Estocolmo', 'SWE'),
('STR', 'Stuttgart Airport', 'Stuttgart', 'DEU'),
('SYD', 'Sydney Airport', 'Sídney', 'AUS'),
('TFN', 'Tenerife North Airport', 'Tenerife Norte', 'ESP'),
('TFS', 'Tenerife South Airport', 'Tenerife Sur', 'ESP'),
('TUN', 'Tunis–Carthage International Airport', 'Túnez', 'TUN'),
('VDE', 'El Hierro Airport', 'El Hierro', 'ESP'),
('VGO', 'Vigo Airport', 'Vigo', 'ESP'),
('VIE', 'Vienna International Airport', 'Viena', 'AUT'),
('VIT', 'Vitoria Airport', 'Vitoria', 'ESP'),
('VLC', 'Valencia Airport', 'Valencia', 'ESP'),
('WAS', 'Washington Dulles International Airport', 'Washington', 'USA'),
('WAW', 'Warsaw Chopin Airport', 'Varsovia', 'POL'),
('XRY', 'Jerez Airport', 'Jerez de la Frontera', 'ESP'),
('YMQ', 'Montréal–Trudeau International Airport', 'Montreal', 'CAN'),
('YOW', 'Ottawa Macdonald–Cartier International Airport', 'Ottawa', 'CAN'),
('YTO', 'Toronto Pearson International Airport', 'Toronto', 'CAN'),
('YVR', 'Vancouver International Airport', 'Vancouver', 'CAN'),
('ZAZ', 'Zaragoza Airport', 'Zaragoza', 'ESP'),
('ZRH', 'Zurich Airport', 'Zürich', 'CHE');


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
    nomHotel VARCHAR(30) NOT NULL,
    TipoHab ENUM("Individual", "Doble", "Triple") DEFAULT "Individual"  NOT NULL,
    Ciudad VARCHAR(30) NOT NULL,
    Precio INT NOT NULL,
    fechaEnt DATE NOT NULL,
    FechaSal DATE NOT NULL,
    CONSTRAINT FK_Id_Alojamiento FOREIGN KEY (Id_Alojamiento) REFERENCES Evento(Id_Evento)
);

INSERT INTO Alojamiento (Id_Alojamiento, nomHotel, TipoHab, Ciudad, Precio, fechaEnt, FechaSal)
VALUES
('EV001', 'Hotel Fiesta Americana', 'Doble', 'Acapulco', 150, '2025-02-01', '2025-02-07'),
('EV002', 'Hotel Melia Barcelona', 'Individual', 'Barcelona', 120, '2025-02-05', '2025-02-10'),
('EV003', 'Copacabana Palace', 'Triple', 'Rio de Janeiro', 300, '2025-03-01', '2025-03-07');


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







