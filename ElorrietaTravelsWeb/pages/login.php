<?php
include "../includes/connection.php";
$conn = connection();

$username = '';
$password = '';
$errorWrongData = '';
function validate($data)
{
    $data = htmlspecialchars(trim($data));
    return $data;
}
;

if (isset($_POST['submit'])) {
    $username = $_POST['username'];
    $password = $_POST['pass'];

    if (empty($username) || empty($password)) {
        $errorWrongData = "Rellene los campos por favor";
    } else {

        $sql = "SELECT id_agencia, NomAgencia, Pass, ColorAgencia FROM Agencia WHERE NomAgencia = ?";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("s", $username);
        $stmt->execute();
        $result = $stmt->get_result();

        if ($row = $result->fetch_assoc()) {
            if ($password === $row["Pass"]) {

                session_start();
                $_SESSION['username'] = $username;
                $_SESSION['id_agencia'] = $row['id_agencia'];
                $_SESSION['colorAgencia'] = $row['ColorAgencia'];


                header("Location: ../index.php");
                exit;
            } else {
                $errorWrongData = "Contraseña incorrecta";
            }
        } else {
            $errorWrongData = "Usuario no encontrado";
        }
        $stmt->close();
    }
};

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="../styles/login_style.css">
</head>

<body>

    <div class="formContainer">
        <h1 class="loginTitle">LOGIN</h1>

        <form class="loginForm" action="" method='POST'>
            <div class="input">
                <input class="username" type="text" placeholder='nombre' name='username' value="<?= $username; ?>"><br>
                <input class="password" type="password" placeholder='contraseña' name='pass' value="<?= $password; ?>">
            </div>

            <button class="submitButton" name="submit">Login</button>


        </form>
        <span class="errorPanel" style="color: red"><?= $errorWrongData; ?></span>

    </div>

</body>

</html>