<?php
include "../includes/connection.php";
$conn = connection();
session_start();

$eventName = isset($_SESSION['nombre']) ? $_SESSION['nombre'] : '';
$eventType = isset($_SESSION['tipo_servicio']) ? $_SESSION['tipo_servicio'] : '';
$viaje = isset($_SESSION['viaje']) ? $_SESSION['viaje'] : '';

$descripcion = $_POST['descripcion_otros'];
$fecha = $_POST['fecha_salida'];
$precio = $_POST['precio'];

$codViaje = strtoupper(substr($viaje, 0, 5));
$codEvento = "EV" . substr(str_shuffle("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"), 0, 3);

$success = true;
$error_messages = [];

$stmt = $conn->prepare("INSERT INTO Actividad (Id_Evento, Nom_Evento, TipoEvento, Descripcion, fecha, Precio, Id_Viaje) VALUES (?, ?, ?, ?, ?, ?, ?)");
$stmt->bind_param("sssssss", $codEvento, $eventName, $eventType, $descripcion, $fecha, $precio, $codViaje);

if (!$stmt->execute()) {
    $success = false;
    $error_messages[] = "Error: " . $stmt->error;
}

if ($success) {
    $_SESSION['success_message'] = "Los datos del servicio han sido registrados correctamente";
} else {
    $_SESSION['error_message'] = implode("<br>", $error_messages);
}

$stmt->close();
$conn->close();

header("Location: tipoServicios.php");
exit();
?>