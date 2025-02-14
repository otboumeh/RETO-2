<?php
session_start();
include "../includes/connection.php";
$conn = connection();

$successError = "";

if (isset($_SESSION['success_message'])) {
    $successError = $_SESSION['success_message'];
    unset($_SESSION['success_message']);
}
if (isset($_SESSION['error_message'])) {
    $successError = $_SESSION['error_message'];
    unset($_SESSION['error_message']);
}

if (!isset($_SESSION['username'])) {
    header("Location: login.php");
    exit;
}

$idAgencia = isset($_SESSION['id_agencia']) ? trim($_SESSION['id_agencia']) : "";
if (empty($idAgencia)) {
    die("Error: ID de Agencia no está definido en la sesión.");
}

$viajes = [];
$sql_viaje = "SELECT id_viaje, NomViaje FROM viaje WHERE id_Agencia = ?";
$stmt = $conn->prepare($sql_viaje);
$stmt->bind_param("s", $idAgencia);
$stmt->execute();
$result_viaje = $stmt->get_result();

if ($result_viaje->num_rows > 0) {
    while ($row = $result_viaje->fetch_assoc()) {
        $viajes[] = $row['id_viaje'] . " - " . $row['NomViaje'];
    }
}

$aeropuertoArray = [];
$sql_aeropuerto = "SELECT Id_Aeropuerto, Ciudad FROM aeropuerto";
$result_aeropuerto = $conn->query($sql_aeropuerto);

if ($result_aeropuerto->num_rows > 0) {
    while ($row = $result_aeropuerto->fetch_assoc()) {
        $aeropuertoArray[] = $row['Id_Aeropuerto'] . " - " . $row['Ciudad'];
    }
} else {
    $successError = "No airports found!";
}

$aeroLineaArray = [];
$sql_aeroLinea = "SELECT Cod_AeroLinea, NomAeroLinea FROM AeroLinea";
$result_aeroLinea = $conn->query($sql_aeroLinea);

if ($result_aeroLinea->num_rows > 0) {
    while ($row = $result_aeroLinea->fetch_assoc()) {
        $aeroLineaArray[] = $row['Cod_AeroLinea'] . " - " . $row['NomAeroLinea'];
    }
} else {
    $successError = "No airline found!";
}

$conn->close();
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar servicio</title>
    <link rel="stylesheet" href="../styles/tipoServicios.css" />
    
    <script>
        <?php if (!empty($successError)): ?>
            window.onload = function() {
                alert("<?php echo $successError; ?>");
            };
        <?php endif; ?>
    </script>
</head>
<body>

<header>
    <?php include '../includes/header.php'; ?>
</header>

<main>
    
<div class="typeSelectContainer">
    <h3>Nuevo Servicio</h3>
    <div class="typeSelect">
        <form class="serviceOpcions" action="servicios.php" method="POST">
            <label for="nombre">Nombre:
                <input type="text" id="nombre" name="nombre" required />
            </label>

            <label for="tipo_servicio">Tipo de servicio:
                <select id="tipo_servicio" name="tipo_servicio" required>
                    <option value="">Elige una opción</option>
                    <option value="vuelo">Vuelo</option>
                    <option value="alojamiento">Alojamiento</option>
                    <option value="otros">Otros</option>
                </select>
            </label>

            <label for="viaje">Elige un viaje:
                <select id="viaje" name="viaje" required>
                    <option value="">Elige una opción</option>
                    <?php foreach ($viajes as $viaje): ?>
                        <option value="<?php echo htmlspecialchars($viaje); ?>"><?php echo htmlspecialchars($viaje); ?></option>
                    <?php endforeach; ?>
                </select>
            </label>
            
            <button type="submit" class="typeButton">Siguiente</button>
        </form>
    </div>
</div>
</main>

<footer>

<?php include '../includes/footer.php'; ?>

</footer>

</body>
</html>
