-- // Consultas listas //

-- Crea una consulta para listar todas las agencias, indicando su nombre, tipo y la descripción de empleados que tienen asignada. //
Select NomAgencia , tipo, Cod_DescEmp
From agencia JOIN tipoagencia USING(cod_tipo)
order by NomAgencia asc;

-- Diseña una consulta que muestre todos los viajes disponibles junto con el nombre de la agencia que los ofrece. Incluye el nombre del viaje, país de destino y duración. //
Select NomViaje, PaisDestino, DATEDIFF(FechFin, FechInicio) AS DuracionViaje , NomAgencia
from viaje natural join agencia ;

-- Escribe una consulta para obtener una lista de eventos, incluyendo su ID, nombre y tipo, y el viaje al que están asociados. //
SELECT ID_Evento, Nom_Evento, TipoEvento, NomViaje 
FROM Plan_Viaje 
NATURAL JOIN Viaje
UNION ALL
SELECT ID_Evento, Nom_Evento , TipoEvento, NomViaje
FROM Alojamiento 
NATURAL JOIN Viaje
UNION ALL
SELECT ID_Evento, Nom_Evento, TipoEvento, NomViaje
FROM Actividad 
NATURAL JOIN Viaje
ORDER BY NomViaje;

-- Realiza una consulta que liste los alojamientos disponibles, indicando el nombre del hotel, el tipo de habitación, la ciudad y su precio. //
Select nomHotel,TipoHab,Ciudad,Precio from alojamiento natural join tipohabitacion;

-- Crea una consulta que muestre todas las aerolíneas junto con el país al que pertenecen. //
select NomAerolinea, NomPais from aerolinea natural join pais;