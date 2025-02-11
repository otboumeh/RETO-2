<?php
include "../includes/connection.php";
$conn = connection();
session_start();

$username;

if (isset($_SESSION['username'])) {
    $username = $_SESSION['username'];  
} else {
    header("Location: login.php");
    exit;
}

$sql_aeropuerto = "SELECT Id_Aeropuerto, Ciudad FROM aeropuerto";
$result_aeropuerto = $conn->query($sql_aeropuerto);

$aeropuertoArray = [];

if ($result_aeropuerto->num_rows > 0) {
    while ($row = $result_aeropuerto->fetch_assoc()) {
        $aeropuertoArray[] = $row['Id_Aeropuerto'] . " - " . $row['Ciudad'];
    }
} else {
    echo "No airports found!";
}

$sql_aeroLinea = "SELECT Cod_AeroLinea, NomAeroLinea FROM AeroLinea";
$result_aeroLinea = $conn->query($sql_aeroLinea);

$aeroLineaArray = [];

if ($result_aeroLinea->num_rows > 0) {
    while ($row = $result_aeroLinea->fetch_assoc()) {
        $aeroLineaArray[] = $row['Cod_AeroLinea'] . " - " . $row['NomAeroLinea'];
    }
} else {
    echo "No airline found!";
}

$sql_pais = "SELECT Cod_Pais, NomPais FROM Pais";
$result_pais = $conn->query($sql_pais);

$paisArray = [];

if ($result_pais->num_rows > 0) {
    while ($row = $result_pais->fetch_assoc()) {
        $paisArray[] = $row['Cod_Pais'] . " - " . $row['NomPais'];
    }
} else {
    echo "No country found!";
}

$conn->close();
?>



<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar viaje</title>
    <link rel="stylesheet" href="../styles/viaje_style.css">
</head>
<body>
<div class="firstContainer">
<h2>Registrar Viaje</h2>

<label for="nombre">Nombre:</label>
<input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre" required>

<label for="tipo_viaje">Tipo de viaje:</label>
<select id="tipo_viaje" name="tipo_viaje" onchange="mostrarCampoOtros(this)" required>
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
<input type="date" id="fecha_inicio" name="fecha_inicio" required>

<label for="fecha_fin">Fecha de finalización:</label>
<input type="date" id="fecha_fin" name="fecha_fin" required>

<label for="dias">Días:</label>
<input type="number" id="dias" name="dias" readonly>

<label for="pais">País:</label>
<select id="pais" name="pais" required>
    <option value="">Seleccionar</option>
    <?php
    foreach ($paisArray as $pais) {
        echo "<option value=\"$pais\">$pais</option>";
    }
    ?>
</select>

<label for="descripcion">Descripción:</label>
<textarea id="descripcion" name="descripcion" rows="4" placeholder="Ingrese una descripción del viaje" required></textarea>

<label for="servicios_excluidos">Servicios excluidos:</label>
<textarea id="servicios_excluidos" name="servicios_excluidos" rows="4" placeholder="Ingrese los servicios que no están incluidos" required></textarea>

<button type="submit">GUARDAR</button>

<script src="../scripts/viaje.js" ></script>
</body>
</html>