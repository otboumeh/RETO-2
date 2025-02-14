<?php
include "./includes/connection.php";
$conn = connection();
session_start();

$successMessage = isset($_SESSION['success_message']) ? $_SESSION['success_message'] : "";
$errorMessage = isset($_SESSION['error_message']) ? $_SESSION['error_message'] : "";

unset($_SESSION['success_message']);
unset($_SESSION['error_message']);

$conn->close();
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/index_style.css">
    <title>Document</title>
    <script>
    window.onload = function() {
        <?php if (!empty($successMessage)): ?>
            alert("<?php echo htmlspecialchars($successMessage); ?>");
        <?php endif; ?>

        <?php if (!empty($errorMessage)): ?>
            alert("<?php echo htmlspecialchars($errorMessage); ?>");
        <?php endif; ?>
    };
    </script>
</head>

<body>

<header>
    <?php include './includes/header.php'; ?>
</header>
<main>

<div class="cardWrapper">
        <div class="firstCard card">
            <h1 class="cardTitle">Servicio</h1>
            <div class="cardBackground bg1"></div>
            <button class="submitButton card1-btn" name="submit"><a href="./pages/tipoServicios.php">Registrar</a></button>
        </div>

        <div class="secondCard card">
            <h1 class="cardTitle">Viaje</h1>
            <div class="cardBackground bg2"></div>
            <button class="submitButton card2-btn" name="submit"><a href="./pages/viaje.php">Registrar</a></button>
        </div>
    </div>
</main>
<footer>

<?php include './includes/footer.php'; ?>

</footer>
    </div>
</body>

</html>