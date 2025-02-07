
<?php

include "../includes/connection.php";
error_reporting(E_ALL);
ini_set('display_errors', 1);

$conn = connection();

session_start();

$origen = '';
$destino = '';
$fecha = '';
$errorWrongData = '';

function validate($data)
{
    return htmlspecialchars(trim($data));
}

if (isset($_POST['submit'])) {  
    $origen = validate($_POST['origen']);
    $destino = validate($_POST['destino']);
    $fecha = validate($_POST['fecha']);

    if (empty($origen) || empty($destino) || empty($fecha)) {
        $errorWrongData = "Todos los campos son obligatorios";
    } else {
        $sql = "INSERT INTO Viajes (Origen, Destino, Fecha) VALUES (?, ?, ?)";
        $stmt = $conn->prepare($sql);
        
        if (!$stmt) {
            die("Error en la consulta SQL: " . $conn->error);
        }

        $stmt->bind_param("sss", $origen, $destino, $fecha);
        
        if ($stmt->execute()) {
            header("Location: ../viajes_list.php");
            exit;
        } else {
            $errorWrongData = "Error al registrar el viaje";
        }

        $stmt->close();
    }
}


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
    <option value="">--Seleccionar--</option>
    <option value="espana">España</option>
    <option value="francia">Francia</option>
</select>

<label for="descripcion">Descripción:</label>
<textarea id="descripcion" name="descripcion" rows="4" placeholder="Ingrese una descripción del viaje" required></textarea>

<label for="servicios_excluidos">Servicios excluidos:</label>
<textarea id="servicios_excluidos" name="servicios_excluidos" rows="4" placeholder="Ingrese los servicios que no están incluidos" required></textarea>

<button type="submit">GUARDAR</button>

<script src="../scripts/viaje.js" ></script>
</body>
</html>