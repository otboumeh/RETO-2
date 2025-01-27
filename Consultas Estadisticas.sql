/* 1. Cantidad de Viajes por Agencia */

SELECT 
    NomAgencia, 
    COUNT(Id_Viaje) AS CantidadViajes
FROM 
    Agencia 
NATURAL JOIN Viaje 
GROUP BY 
    NomAgencia
ORDER BY 
    CantidadViajes DESC;
    
    /* 2. Precio Promedio de Vuelos */
    
    SELECT 
    Aerolinea, 
    AVG(Precio) AS PrecioPromedio
FROM 
    Vuelo
GROUP BY 
    Aerolinea
ORDER BY 
    PrecioPromedio DESC;
    
    /* 3. Ingresos Totales por Actividades */
    
    SELECT 
    E.Nom_Evento, 
    SUM(A.Precio) AS IngresosTotales
FROM 
    Actividad A
JOIN 
    Evento E ON A.Id_Actividad = E.Id_Evento
GROUP BY 
    E.Nom_Evento;
    
    /* 4. País con Mayor Cantidad de Aerolíneas */
    
    SELECT 
    P.NomPais, 
    COUNT(A.Cod_Aerolinea) AS CantidadAerolineas
FROM 
    Pais P
JOIN 
    Aerolinea A ON P.Cod_Pais = A.Cod_Pais
GROUP BY 
    P.NomPais
ORDER BY 
    CantidadAerolineas DESC
    LIMIT 1;

/* 5.Precio Promedio de Alojamientos */

SELECT 
    Ciudad, 
    AVG(Precio) AS PrecioPromedio
FROM 
    Alojamiento
GROUP BY 
   Ciudad
ORDER BY 
    PrecioPromedio DESC;
    
    /* 6.Duración Promedio de Viajes por Tipo */
    
    SELECT 
    T.TipoViaje, 
    AVG(V.NumDias) AS DuracionPromedio
FROM 
    TipoViaje T
JOIN 
    Viaje V ON T.Cod_TipoViaje = V.Cod_TipoViaje
GROUP BY 
    T.TipoViaje;






