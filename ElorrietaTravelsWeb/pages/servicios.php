<?php
session_start();
$username;

if (isset($_SESSION['username'])) {
    $username = $_SESSION['username'];  
} else {
    header("Location: login.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar servicio</title>
    <link rel="stylesheet" href="../styles/servicios_style.css" />
</head>
<body>
    <div class="firstContainer">
        <form id="form_servicio">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre">

            <label for="tipo_servicio">¿Qué servicio necesita registrar?</label>
            <select id="tipo_servicio" name="tipo_servicio">
                <option value="">Elige una opción</option>
                <option value="vuelo">Vuelo</option>
                <option value="alojamiento">Alojamiento</option>
                <option value="otros">Otros</option>
            </select>

            <div id="otros_servicio" style="display: none;">
                <label for="descripcion_otros">Por favor, especifique:</label>
                <input type="text" id="descripcion_otros" name="descripcion_otros">
            </div>

            <div id="vuelo_campos" style="display: none;">
                <label>Tipo de viaje:</label>
                <input type="radio" id="ida" name="tipo_viaje" value="ida" checked>
                <label for="ida">Ida</label>

                <input type="radio" id="ida_vuelta" name="tipo_viaje" value="ida_vuelta">
                <label for="ida_vuelta">Ida y vuelta</label>

                <label for="aeropuerto_origen">Aeropuerto de origen:</label>
                <input type="text" id="aeropuerto_origen" name="aeropuerto_origen">

                <label for="aeropuerto_destino">Aeropuerto de destino:</label>
                <input type="text" id="aeropuerto_destino" name="aeropuerto_destino">

                <label for="codigo_vuelo">Código de vuelo:</label>
                <input type="text" id="codigo_vuelo" name="codigo_vuelo">

                <label for="aerolinea">Aerolínea:</label>
                <input type="text" id="aerolinea" name="aerolinea">

                <label for="precio">Precio (€):</label>
                <input type="number" id="precio" name="precio">

                <label for="fecha_salida">Fecha de salida:</label>
                <input type="date" id="fecha_salida" name="fecha_salida">

                <label for="hora_salida">Hora de salida:</label>
                <input type="time" id="hora_salida" name="hora_salida">

                <label for="duracion_vuelo">Duración del vuelo (horas):</label>
                <input type="number" id="duracion_vuelo" name="duracion_vuelo">
            </div>

            <div id="alojamiento_campos" style="display: none;">
                <label for="nombre_hotel">Nombre del hotel:</label>
                <input type="text" id="nombre_hotel" name="nombre_hotel">

                <label for="Ciudad">Ciudad:</label>
                <input type="text" id="Ciudad" name="Ciudad">

                <label for="precio_hotel">Precio (€):</label>
                <input type="number" id="precio_hotel" name="precio_hotel">

                <label for="fecha_entrada_hotel">Fecha de entrada:</label>
                <input type="date" id="fecha_entrada_hotel" name="fecha_entrada_hotel">

                <label for="fecha_salida_hotel">Fecha de salida:</label>
                <input type="date" id="fecha_salida_hotel" name="fecha_salida_hotel">

                <label for="duracion">Duración del viaje (horas):</label>
                <input type="number" id="duracion" name="duracion">
            </div>

            <button type="submit">GUARDAR SERVICIO</button>
        </form>
    </div>

    <!-- Second Container for "ida y vuelta" -->
    <div id="secondContainerWrapper" class="SecondContainer" style="display: none;">
        <h3>Detalles de Vuelta</h3>
        <div id="vuelo_vuelta_campos_second">
            <label for="fecha_vuelta_second">Fecha de vuelta:</label>
            <input type="date" id="fecha_vuelta_second" name="fecha_vuelta_second">

            <label for="hora_vuelta_second">Hora de vuelta:</label>
            <input type="time" id="hora_vuelta_second" name="hora_vuelta_second">

            <label for="codigo_vuelo_vuelta_second">Código de vuelo de vuelta:</label>
            <input type="text" id="codigo_vuelo_vuelta_second" name="codigo_vuelo_vuelta_second">

            <label for="aerolinea_vuelta_second">Aerolínea de vuelta:</label>
            <input type="text" id="aerolinea_vuelta_second" name="aerolinea_vuelta_second">
        </div>
    </div>

    <script src="../scripts/servicios.js"></script>
</body>
</html>