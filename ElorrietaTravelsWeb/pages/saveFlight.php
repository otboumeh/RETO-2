<?php
include "../includes/connection.php";
$conn = connection();
session_start(); 

// Get session data
$eventName = isset($_SESSION['nombre']) ? $_SESSION['nombre'] : '';
$eventType = isset($_SESSION['tipo_servicio']) ? $_SESSION['tipo_servicio'] : '';
$viaje = isset($_SESSION['viaje']) ? $_SESSION['viaje'] : '';

// Get POST data for the flight
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

    $precio = $precio/2;

    $stmt = $conn->prepare("INSERT INTO vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("sssssssd", $codigo_vuelo_vuelta, $fecha_vuelta, $cod_aerolinea_vuelta, $hora_salida_vuelta, $duracion_vuelo, $iata_destino, $iata_origen, $precio);
    if (!$stmt->execute()) {
        $success = false;
        $error_messages[] = "Error inserting return flight: " . $stmt->error;
    }

    $stmt = $conn->prepare("INSERT INTO vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("sssssssd", $codigo_vuelo, $fecha_salida, $cod_aerolinea, $hora_salida, $duracion_vuelo, $iata_origen, $iata_destino, $precio);
    if (!$stmt->execute()) {
        $success = false;
        $error_messages[] = "Error inserting outbound flight: " . $stmt->error;
    }

    $stmt_plan_viaje = $conn->prepare("INSERT INTO Plan_Viaje (Id_Evento, Nom_Evento, TipoEvento, Trayecto, Id_VueloIda, Id_VueloVuelta, Id_Viaje) VALUES (?, ?, ?, ?, ?, ?, ?)");
    $stmt_plan_viaje->bind_param("sssssss", $codEvento,  $eventName, $eventType, $tipo_viaje, $codigo_vuelo, $codigo_vuelo_vuelta, $codViaje);
    
    echo "<pre>";
    echo "codEvento: " . htmlspecialchars($codEvento) . "<br>";
    echo "eventName: " . htmlspecialchars($eventName) . "<br>";
    echo "eventType: " . htmlspecialchars($eventType) . "<br>";
    echo "tipo_viaje: " . htmlspecialchars($tipo_viaje) . "<br>";
    echo "codigo_vuelo: " . htmlspecialchars($codigo_vuelo) . "<br>";
    echo "codigo_vuelo_vuelta: " . htmlspecialchars($codigo_vuelo_vuelta) . "<br>";
    echo "codViaje (Id_Viaje): " . htmlspecialchars($codViaje) . "<br>";
    echo "</pre>";
    exit; // Stop execution to inspect values


    if (!$stmt_plan_viaje->execute()) {
        $success = false;
        $error_messages[] = "Error inserting travel plan: " . $stmt_plan_viaje->error;
    }

} else { 
    $stmt = $conn->prepare("INSERT INTO vuelo (Id_Vuelo, FechVuelo, Aerolinea, HorarioSalida, Duracion, Id_AeroOrig, Id_AeroDest, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("sssssssd", $codigo_vuelo, $fecha_salida, $cod_aerolinea, $hora_salida, $duracion_vuelo, $iata_origen, $iata_destino, $precio);
    if (!$stmt->execute()) {
        $success = false;
        $error_messages[] = "Error inserting flight: " . $stmt->error;
    }

    $stmt_plan_viaje = $conn->prepare("INSERT INTO Plan_Viaje (Id_Evento, Nom_Evento, TipoEvento, Trayecto, Id_VueloIda, Id_Viaje) VALUES (?, ?, ?, ?, ?, ?)");
    $stmt_plan_viaje->bind_param("ssssss", $codEvento, $eventName, $eventType, $tipo_viaje, $codigo_vuelo, $codViaje);
    
    if (!$stmt_plan_viaje->execute()) {
        $success = false;
        $error_messages[] = "Error inserting travel plan: " . $stmt_plan_viaje->error;
    }
}

// Store messages in session
if ($success) {
    $_SESSION['success_message'] = "Los datos del vuelo han sido registrado corectamente";
} else {
    $_SESSION['error_message'] = implode("<br>", $error_messages);
}

// Close statements
$stmt->close();
if (isset($stmt_plan_viaje)) {
    $stmt_plan_viaje->close();
}
$conn->close();

header("Location: tipoServicios.php");
exit();
?>
