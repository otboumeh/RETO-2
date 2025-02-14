<?php
include "../includes/connection.php";
$conn = connection();
session_start();

if (!isset($_SESSION['username'])) {
    header("Location: login.php");
    exit;
}

$idAgencia = isset($_SESSION['id_agencia']) ? trim($_SESSION['id_agencia']) : "";
if (empty($idAgencia)) {
    die("Error: ID de Agencia no está definido en la sesión.");
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nomViaje = isset($_POST['nombre']) ? trim($_POST['nombre']) : "";
    $tipoViaje = isset($_POST['tipo_viaje']) ? trim($_POST['tipo_viaje']) : "";

    $fechaInicio = isset($_POST['fecha_inicio']) ? $_POST['fecha_inicio'] : "";
    $fechaFin = isset($_POST['fecha_fin']) ? $_POST['fecha_fin'] : "";
    $numDias = isset($_POST['dias']) ? intval($_POST['dias']) : 0;
    $paisDestino = isset($_POST['pais']) ? trim($_POST['pais']) : "";
    $descripcion = isset($_POST['descripcion']) ? trim($_POST['descripcion']) : "";
    $serviciosExcluidos = isset($_POST['servicios_no_incluidos']) ? trim($_POST['servicios_no_incluidos']) : "";

    $idViaje = "VI" . strtoupper(substr(uniqid(), -3));
    
    $sql = "SELECT Cod_TipoViaje FROM TipoViaje WHERE TipoViaje = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $tipoViaje);
    $stmt->execute();
    $stmt->bind_result($codTipoViaje);
    $stmt->fetch();
    $stmt->close();

    $sql = "INSERT INTO Viaje (Id_Viaje, NomViaje, Cod_TipoViaje, FechInicio, FechFin, NumDias, PaisDestino, Descripcion, ServiciosnoIncl, Id_Agencia) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ssssssssss", $idViaje, $nomViaje, $codTipoViaje, $fechaInicio, $fechaFin, $numDias, $paisDestino, $descripcion, $serviciosExcluidos, $idAgencia);

    if ($stmt->execute()) {
        $_SESSION['success_message'] = "Viaje registrado correctamente.";
    } else {
        $_SESSION['error_message'] = "Error: no se ha registrado el viaje";
    }

    $stmt->close();
    $conn->close();

    header("Location: /ElorrietaTravelsWeb/index.php");
    exit;
}
?>