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

    <!-- <h1>welcome back ?php echo $username; ?> !</h1>
    <a href="logout.php">logout</a> -->
    <div class="formWrapper">
    <div class="firstContainer">
        <h1 class="loginTitle">Registrar servicio</h1>
        <div class="backgroundDiv"></div>
        <button class="submitButton1" name="submit"><a href="./servicios.php">Registrar</a></button>
    </div>

    <div class="secondContainer">
        <h1 class="loginTitle">Registrar viaje</h1>
        <div class="backgroundDiv1"></div>
        <button class="submitButton2" name="submit"><a href="./viaje.php">Registrar</a></button>
    </div>
</div>


    </div>
</body>
</html>