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
    <title>Registrar viaje</title>
    <link rel="stylesheet" href="viaje_style.css">
</head>
<body>
<div class="firstContainer">
<h2>Registrar Viaje</h2>

<label for="nombre">Nombre:</label>
<input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre">

<label for="tipo_viaje">Tipo de viaje:</label>
<select id="tipo_viaje" name="tipo_viaje" onchange="mostrarCampoOtros(this)">
    <option value="">Elige una opción</option>
    <option value="turismo">Turismo</option>
    <option value="negocios">Negocios</option>
    <option value="otros">Otros</option>
</select>

<div id="otros_servicio">
    <label for="descripcion_otros">Por favor, especifique:</label>
    <input type="text" id="descripcion_otros" name="descripcion_otros" placeholder="Describa el servicio">
</div>

<label for="fecha_inicio">Fecha de inicio:</label>
<input type="date" id="fecha_inicio" name="fecha_inicio">

<label for="fecha_fin">Fecha de finalización:</label>
<input type="date" id="fecha_fin" name="fecha_fin">

<label for="dias">Días:</label>
<input type="number" id="dias" name="dias">

<label for="pais">País:</label>
<select id="pais" name="pais">
    <option value="">--Seleccionar--</option>
    <option value="espana">España</option>
    <option value="francia">Francia</option>
</select>

<label for="descripcion">Descripción:</label>
<textarea id="descripcion" name="descripcion" rows="4" placeholder="Ingrese una descripción del viaje"></textarea>

<label for="servicios_excluidos">Servicios excluidos:</label>
<textarea id="servicios_excluidos" name="servicios_excluidos" rows="4" placeholder="Ingrese los servicios que no están incluidos"></textarea>

<button type="submit">GUARDAR</button>

</body>
<script src="viaje.js" defer></script>

</html>

