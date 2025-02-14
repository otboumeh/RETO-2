<?php
include "../includes/connection.php";
$conn = connection();
session_start(); 

$eventName = isset($_SESSION['nombre']) ? $_SESSION['nombre'] : '';
$eventType = isset($_SESSION['tipo_servicio']) ? $_SESSION['tipo_servicio'] : '';
$viaje = isset($_SESSION['viaje']) ? $_SESSION['viaje'] : '';

$codViaje = strtoupper(substr($viaje, 0, 5));
$tipo_viaje = $_POST['tipo_viaje'];
$aeropuerto_origen = $_POST['aeropuerto_origen'];
$iata_origen = strtoupper(substr($aeropuerto_origen, 0, 3));
$aeropuerto_destino = $_POST['aeropuerto_destino'];
$iata_destino = strtoupper(substr($aeropuerto_destino, 0, 3));
$codigo_vuelo = $_POST['codigo_vuelo'];
$aerolinea = $_POST['aerolinea'];
$cod_aerolinea = strtoupper(substr($aerolinea, 0, 2));
$precio = $_POST['precio'];
$fecha_salida = $_POST['fecha_salida'];
$hora_salida = $_POST['hora_salida'];
$duracion_vuelo = $_POST['duracion_vuelo'];

$codEvento = "EV" . substr(str_shuffle("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"), 0, 3);

$success = true;  
$error_messages = [];

if ($tipo_viaje === "ida_vuelta") {
    $codigo_vuelo_vuelta = $_POST['codigo_vuelo_vuelta'];
    $aerolinea_vuelta = $_POST['aerolinea_vuelta'];
    $cod_aerolinea_vuelta = strtoupper(substr($aerolinea_vuelta, 0, 2));
    $fecha_vuelta = $_POST['fecha_vuelta'];
    $hora_salida_vuelta = $_POST['hora_salida_vuelta'];
    $duracion_vuelo_vuelta = $_POST['duracion_vueloVuelta'];

    $precio = $precio/2;

    $stmt = $conn->prepare("INSERT INTO vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("sssssssd", $codigo_vuelo_vuelta, $fecha_vuelta, $cod_aerolinea_vuelta, $hora_salida_vuelta, $duracion_vuelo_vuelta, $iata_destino, $iata_origen, $precio);
    if (!$stmt->execute()) {
        $success = false;
        $error_messages[] = "Error: vuelo no registrado";
    }

    $stmt = $conn->prepare("INSERT INTO vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("sssssssd", $codigo_vuelo, $fecha_salida, $cod_aerolinea, $hora_salida, $duracion_vuelo, $iata_origen, $iata_destino, $precio);
    if (!$stmt->execute()) {
        $success = false;
        $error_messages[] = "Error: vuelo no registrado";
    }

    $stmt_plan_viaje = $conn->prepare("INSERT INTO Plan_Viaje (Id_Evento, Nom_Evento, TipoEvento, Trayecto, Id_VueloIda, Id_VueloVuelta, Id_Viaje) VALUES (?, ?, ?, ?, ?, ?, ?)");
    $stmt_plan_viaje->bind_param("sssssss", $codEvento,  $eventName, $eventType, $tipo_viaje, $codigo_vuelo, $codigo_vuelo_vuelta, $codViaje);

    if (!$stmt_plan_viaje->execute()) {
        $success = false;
        $error_messages[] = "Error: vuelo no registrado";
    }

} else { 
    $stmt = $conn->prepare("INSERT INTO vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("sssssssd", $codigo_vuelo, $fecha_salida, $cod_aerolinea, $hora_salida, $duracion_vuelo, $iata_origen, $iata_destino, $precio);
    if (!$stmt->execute()) {
        $success = false;
        $error_messages[] = "Error: vuelo no registrado";
    }

    $stmt_plan_viaje = $conn->prepare("INSERT INTO Plan_Viaje (Id_Evento, Nom_Evento, TipoEvento, Trayecto, Id_VueloIda, Id_Viaje) VALUES (?, ?, ?, ?, ?, ?)");
    $stmt_plan_viaje->bind_param("ssssss", $codEvento, $eventName, $eventType, $tipo_viaje, $codigo_vuelo, $codViaje);
    
    if (!$stmt_plan_viaje->execute()) {
        $success = false;
        $error_messages[] = "Error: vuelo no registrado";
    }
}

if ($success) {
    $_SESSION['success_message'] = "Los datos del vuelo han sido registrado corectamente";
} else {
    $_SESSION['error_message'] = implode("<br>", $error_messages);
}

$stmt->close();
if (isset($stmt_plan_viaje)) {
    $stmt_plan_viaje->close();
}
$conn->close();

header("Location: tipoServicios.php");
exit();
?>
