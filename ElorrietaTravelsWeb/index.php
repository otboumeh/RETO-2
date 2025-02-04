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
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./index_style.css">
    <title>Document</title>
</head>

<body>
<header><?php include 'header.html'; ?>
</header>
<main>

<div class="formWrapper">
        <div class="firstCard card">
            <h1 class="cardTitle">Registrar servicio</h1>
            <div class="cardBackground bg1"></div>
            <button class="submitButton card1-btn" name="submit"><a href="./servicios.php">Registrar</a></button>
        </div>

        <div class="secondCard card">
            <h1 class="cardTitle">Registrar viaje</h1>
            <div class="cardBackground bg2"></div>
            <button class="submitButton card2-btn" name="submit"><a href="./viaje.php">Registrar</a></button>
        </div>
    </div>
</main>
    <!-- <h1>welcome back ?php echo $username; ?> !</h1>
    <a href="logout.php">logout</a> -->


    </div>
</body>

</html>