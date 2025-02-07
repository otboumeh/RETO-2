
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/index_style.css">
    <title>Document</title>
</head>

<body>

<header>
    <?php include './includes/header.php'; ?>
</header>
<main>

<div class="formWrapper">
        <div class="firstCard card">
            <h1 class="cardTitle">Servicio</h1>
            <div class="cardBackground bg1"></div>
            <button class="submitButton card1-btn" name="submit"><a href="./pages/servicios.php">Registrar</a></button>
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