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

$sql_tipoViaje = "SELECT TipoViaje FROM tipoViaje";
$result_tipoViaje = $conn->query($sql_tipoViaje);

$tipoViajeArray = [];

if ($result_tipoViaje->num_rows > 0) {
    while ($row = $result_tipoViaje->fetch_assoc()) {
        $tipoViajeArray[] = $row['TipoViaje'];
    }
} else {
    echo "No country found!";
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
<header>
    <?php include '../includes/header.php'; ?>
    </header>
<main>

<div class="firstContainer">
  <form class="secondContainter" action ="saveViaje.php" method="POST">
    <h2>Registrar Viaje</h2>

    <label for="nombre"
      >Nombre:
      <input
        type="text"
        id="nombre"
        name="nombre"
        placeholder="Ingrese su nombre"
        required
      />
    </label>
  
    <label for="tipo_viaje"
      >Tipo de viaje:
      <select
        id="tipo_viaje"
        name="tipo_viaje"
        onchange="mostrarCampoOtros(this)"
        required
      >
        <option value="">Elige una opción</option>
        <?php
          foreach ($tipoViajeArray as $tipoViaje) {
              echo "<option value=\"$tipoViaje\">$tipoViaje</option>";
          }
        ?> 
      </select>
    </label>
  
    <label for="fecha_inicio"
      >Fecha de inicio:
      <input type="date" id="fecha_inicio" name="fecha_inicio" required />
    </label>
  
    <label for="fecha_fin"
      >Fecha de finalización:
      <input type="date" id="fecha_fin" name="fecha_fin" required />
    </label>
  
    <label for="dias"
      >Días:
      <input type="number" id="dias" name="dias" readonly />
    </label>
  
    <label for="pais"
      >País:
      <select id="pais" name="pais" required>
        <option value="">Seleccionar</option>
         <?php
          foreach ($paisArray as $pais) {
              echo "<option value=\"$pais\">$pais</option>";
          }
          ?> 
      </select>
    </label>
  
    <label for="descripcion"
      >Descripción:
      <textarea
        id="descripcion"
        name="descripcion"
        rows="4"
        placeholder="Escribe una descripción"
        required
      ></textarea>
    </label>
  
    <label for="servicios_no_incluidos"
      >Servicios excluidos:
      <textarea
        id="servicios_no_incluidos"
        name="servicios_no_incluidos"
        rows="4"
        placeholder="Escribe los servicios no incluidos"
        required
      ></textarea>
    </label>
  
    <button type="submit">GUARDAR</button>
  </form>
</div>
</main>


<footer>
  <?php include '../includes/footer.php'; ?>
</footer>

<script src="../scripts/viaje.js" ></script>
</body>
</html>