<?php
include "../includes/connection.php";
$conn = connection();
session_start();

$eventName = isset($_SESSION['nombre']) ? $_SESSION['nombre'] : '';
$eventType = isset($_SESSION['tipo_servicio']) ? $_SESSION['tipo_servicio'] : '';
$viaje = isset($_SESSION['viaje']) ? $_SESSION['viaje'] : '';

$nombre_hotel = $_POST['nombre_hotel'];
$tipo_hab = $_POST['tipo_hab'];
$cod_tipo_hab = trim(strtoupper(substr($tipo_hab, 0, 3)));

$ciudad = $_POST['Ciudad'];
$precio_hotel = $_POST['precio_hotel'];
$fecha_entrada = $_POST['fecha_entrada_hotel'];
$fecha_salida = $_POST['fecha_salida_hotel'];

$codViaje = strtoupper(substr($viaje, 0, 5));
$codEvento = "EV" . substr(str_shuffle("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"), 0, 3);

$success = true;
$error_messages = [];

$stmt = $conn->prepare("INSERT INTO Alojamiento (Id_Evento, Nom_Evento, TipoEvento, nomHotel, Cod_TipoHab, Ciudad, Precio, fechaEnt, FechaSal, Id_Viaje) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
$stmt->bind_param("ssssssdsss", $codEvento, $eventName, $eventType, $nombre_hotel, $cod_tipo_hab, $ciudad, $precio_hotel, $fecha_entrada, $fecha_salida, $codViaje);

if (!$stmt->execute()) {
    $success = false;
    $error_messages[] = "Error: " . $stmt->error;
}

if ($success) {
    $_SESSION['success_message'] = "Los datos del alojamiento han sido registrados correctamente";
} else {
    $_SESSION['error_message'] = implode("<br>", $error_messages);
}

$stmt->close();
$conn->close();

header("Location: tipoServicios.php");
exit();
?>
