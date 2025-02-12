/* 1- Lista de los viajes gestionados por cada Agencia */
SELECT A.NomAgencia, V.NomViaje
FROM Agencia A
JOIN Viaje V ON A.Id_Agencia = V.Id_Agencia;

/* 2- Lista de viajes junto con sus servicios */
SELECT 
    v.NomViaje,
    pv.Nom_Evento AS Plan_Viaje,
    a.Nom_Evento AS Alojamiento,
    ac.Nom_Evento AS Actividad
FROM 
    Viaje v
LEFT JOIN 
    Plan_Viaje pv ON v.Id_Viaje = pv.Id_Viaje
LEFT JOIN 
    Alojamiento a ON v.Id_Viaje = a.Id_Viaje
LEFT JOIN 
    Actividad ac ON v.Id_Viaje = ac.Id_Viaje
ORDER BY 
    v.Id_Viaje;








/* 3- Los viajes por el Territorio */
SELECT V.NomViaje, V.PaisDestino
FROM Viaje V
ORDER BY V.PaisDestino;

/* 4- Servicios de actividades clasificados por precio */
SELECT 'Actividad' AS TipoServicio, A.Nom_Evento, A.Precio
FROM Actividad A
UNION
SELECT 'Alojamiento' AS TipoServicio, Ac.Nom_Evento, Ac.Precio
FROM Alojamiento Ac
ORDER BY Precio DESC;



