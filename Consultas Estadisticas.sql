-- 1. Número de viajes organizados por cada agencia

SELECT a.NomAgencia, COUNT(v.Id_Viaje) AS Total_Viajes
FROM Agencia a
LEFT JOIN Viaje v ON a.Id_Agencia = v.Id_Agencia
GROUP BY a.NomAgencia
ORDER BY Total_Viajes DESC;

-- 2. Duración promedio de los viajes por tipo de viaje

SELECT tv.TipoViaje, AVG(v.NumDias) AS Duracion_Promedio
FROM Viaje v
JOIN TipoViaje tv ON v.Cod_TipoViaje = tv.Cod_TipoViaje
GROUP BY tv.TipoViaje
ORDER BY Duracion_Promedio DESC;

-- 3. Cantidad de vuelos por tipo de trayecto

SELECT Trayecto, COUNT(*) AS Total_Vuelos
FROM Plan_Viaje
WHERE TipoEvento = 'Vuelo'
GROUP BY Trayecto
ORDER BY Total_Vuelos DESC;

-- 4. Costo total de vuelos por trayecto

SELECT pv.Trayecto, SUM(v.Precio) AS Costo_Total
FROM Plan_Viaje pv
JOIN Vuelo v ON pv.Id_VueloIda = v.Id_Vuelo
LEFT JOIN Vuelo v2 ON pv.Id_VueloVuelta = v2.Id_Vuelo
GROUP BY pv.Trayecto;

-- 5. Ciudad con mayor cantidad de alojamientos registrados

SELECT Ciudad, COUNT(Id_Evento) AS Total_Alojamientos
FROM Alojamiento
GROUP BY Ciudad
ORDER BY Total_Alojamientos DESC
LIMIT 1;

-- 6. Costo total de todas las actividades organizadas

SELECT SUM(Precio) AS Costo_Total_Actividades
FROM Actividad;

-- 7. Top 3 de los países más visitados en los viajes

SELECT PaisDestino, COUNT(Id_Viaje) AS Total_Visitas
FROM Viaje
GROUP BY PaisDestino
ORDER BY Total_Visitas DESC
LIMIT 3;

-- 8. Precio medio de los alojamientos por tipo de habitación

SELECT td.TipoHab, AVG(a.Precio) AS Precio_Medio
FROM Alojamiento a
JOIN TipoHabitacion td ON a.Cod_TipoHab = td.Cod_TipoHab
GROUP BY td.TipoHab
ORDER BY Precio_Medio DESC;

-- 9. Número total de vuelos por aerolínea

SELECT Aerolinea, COUNT(Id_Vuelo) AS Total_Vuelos
FROM Vuelo
GROUP BY Aerolinea
ORDER BY Total_Vuelos DESC;

-- 10. Fecha con más eventos organizados

SELECT fecha, COUNT(Id_Evento) AS Total_Eventos
FROM Actividad
GROUP BY fecha
ORDER BY Total_Eventos DESC
LIMIT 1;