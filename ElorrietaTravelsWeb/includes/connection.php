<?php
function connection(){
    $host = 'localhost:3307';
    $user = 'root';
    $pass = '';
    $db = 'reto2_t';

    $conn = new mysqli($host, $user, $pass, $db);

    if ($conn->connect_error) {
        die("❌ Connection failed: " . $conn->connect_error);
    }

    return $conn;

};

?>