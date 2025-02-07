<?php
session_start();
$username;

if (isset($_SESSION['username'])) {
    $username = $_SESSION['username'];
    $color = $_SESSION['colorAgencia'];
} else {
    header("Location: ./pages/login.php");
    exit;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./styles/headerStyle.css">

    <script
      src="https://kit.fontawesome.com/38b1724369.js"
      crossorigin="anonymous"
    ></script>
</head>
<body>
    
<header class="menucontainer" id="top">
    <nav class="navbarContainer">
      <ul class="navbar">
        <li class="level1 home" ><a href="./index.php" style="color: <?php echo $color; ?>;"><?php echo "Welcome back " . $username . "!"?></a>
        </li>
        <li class="level1 logout">
          <a class="l1" href="./pages/logout.php"><i class="fas fa-power-off"></i>
          </a>
        </li>
      </ul>
    </nav>
  </header>
</body>
</html>