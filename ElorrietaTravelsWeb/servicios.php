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
    <form id="form_servicio">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre">

        <label for="tipo_servicio">¿Qué servicio necesita registrar?</label>
        <select id="tipo_servicio" name="tipo_servicio" onchange="mostrarCampoOtros(this)">
            <option value="">Elige una opción</option>
            <option value="vuelo">Vuelo</option>
            <option value="alojamiento">Alojamiento</option>
            <option value="otros">Otros</option>
        </select>

        <div id="otros_servicio" style="display: none;">
            <label for="descripcion_otros">Por favor, especifique:</label>
            <input type="text" id="descripcion_otros" name="descripcion_otros">
        </div>

        <button type="submit">GUARDAR SERVICIO</button>
    </form>
</div>

<div id="popup" style="display: none;">
    <div class="popup-content">
        <span id="popup-close" onclick="cerrarPopup()">&times;</span>
        <p id="popup-message"></p>
    </div>
</div>

<script>
function mostrarCampoOtros(selectElement) {
    var otrosCampo = document.getElementById('otros_servicio');
    if (selectElement.value === 'otros') {
        otrosCampo.style.display = 'block';
    } else {
        otrosCampo.style.display = 'none';
    }
}

function validarFormulario(event) {
    event.preventDefault();

    var nombre = document.getElementById('nombre').value;
    var tipo_servicio = document.getElementById('tipo_servicio').value;
    var descripcion_otros = document.getElementById('descripcion_otros').value;

    if (nombre === "" || tipo_servicio === "") {
        alert("Por favor, complete todos los campos obligatorios.");
        return;
    }

    if (tipo_servicio === "otros" && descripcion_otros === "") {
        alert("Por favor, especifique el servicio en 'Otros'.");
        return;
    }

    alert("Formulario enviado correctamente.");
}

document.getElementById('form_servicio').addEventListener('submit', validarFormulario);
</script>

</body>
</html>
