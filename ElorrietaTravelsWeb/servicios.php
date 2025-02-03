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
    <link rel="stylesheet" href="./servicios_style.css" />
</head>
<body>
<div class="firstContainer">
<form>
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre">

    <label for="tipo_servicio">¿Qué servicio necesita registrar?</label>
    <select id="tipo_servicio" name="tipo_servicio" onchange="mostrarCampoOtros(this)">
        <option value="">Elige una opción</option>
        <option value="vuelo">Vuelo</option>
        <option value="alojamiento">Alojamiento</option>
        <option value="otros">Otros</option>
    </select>

    <div id="otros_servicio">
        <label for="descripcion_otros">Por favor, especifique:</label>
        <input type="text" id="descripcion_otros" name="descripcion_otros">
    </div>

    <button type="submit">GUARDAR SERVICIO</button>
</form>
</div>
<script src="servicios.js" defer></script>

</body>

</html>

