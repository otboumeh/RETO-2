    <?php
    session_start();
    include "../includes/connection.php";
    $conn = connection();

    if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['nombre']) && isset($_POST['tipo_servicio']) && isset($_POST['viaje']) ) {
        $_SESSION['nombre'] = $_POST['nombre'];
        $_SESSION['tipo_servicio'] = $_POST['tipo_servicio'];
        $_SESSION['viaje'] = $_POST['viaje'];
    }

    $username;

    if (isset($_SESSION['username'])) {
        $username = $_SESSION['username'];  
    } else {
        header("Location: login.php");
        exit;
    }

    $idAgencia = (isset($_SESSION['id_agencia'])) ? trim($_SESSION['id_agencia']) : "" ;
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
    } else {
        echo "No airports found!";
    }

    $sql_aeropuerto = "SELECT Id_Aeropuerto, Ciudad FROM aeropuerto";
    $result_aeropuerto = $conn->query($sql_aeropuerto);

    $aeropuertoArray = [];

    if ($result_aeropuerto->num_rows > 0) {
        while ($row = $result_aeropuerto->fetch_assoc()) {
            $aeropuertoArray[] = $row['Id_Aeropuerto'] . " - " . $row['Ciudad'];
        }
    } else {
        echo "No airports found!";
    }

    $sql_aeroLinea = "SELECT Cod_AeroLinea, NomAeroLinea FROM AeroLinea";
    $result_aeroLinea = $conn->query($sql_aeroLinea);

    $aeroLineaArray = [];

    if ($result_aeroLinea->num_rows > 0) {
        while ($row = $result_aeroLinea->fetch_assoc()) {
            $aeroLineaArray[] = $row['Cod_AeroLinea'] . " - " . $row['NomAeroLinea'];
        }
    } else {
        echo "No airline found!";
    }

    $sql_tipoHab = "SELECT Cod_TipoHab, TipoHab FROM TipoHabitacion";
    $result_TipoHab = $conn->query($sql_tipoHab);

    $tipoHabArray = [];

    if ($result_TipoHab->num_rows > 0) {
        while ($row = $result_TipoHab->fetch_assoc()) {
            $tipoHabArray[] = $row['Cod_TipoHab'] . " - " . $row['TipoHab'];
        }
    } else {
        echo "tipoHab no encontrado!";
    }


    $conn->close();
    ?>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar servicio</title>
        <link rel="stylesheet" href="../styles/servicios_style.css" />
        <script>
    window.onload = function() {
        var tipoServicio = "<?php echo isset($_SESSION['tipo_servicio']) ? $_SESSION['tipo_servicio'] : ''; ?>";
        console.log(tipoServicio);
        

        document.getElementById('vueloDiv').style.display = "none";
        document.getElementById('alojamientoDiv').style.display = "none";
        document.getElementById('otrosDiv').style.display = "none";

        if (tipoServicio === "vuelo") {
            document.getElementById('vueloDiv').style.display = "flex";
        } else if (tipoServicio === "alojamiento") {
            document.getElementById('alojamientoDiv').style.display = "flex";
        } else if (tipoServicio === "otros") {
            document.getElementById('otrosDiv').style.display = "flex";
        }
    };
</script>
    </head>
    <body>

    <header>
    <?php include '../includes/header.php'; ?>
    </header>

    <main>

    <div id="vueloDiv" class="hidden">
        <h3>Detalles de Vuelo</h3>
        <form id="vuelo_servicio" action="saveFlight.php" method = "POST">
            <div id="vuelo_campos">

                <label class="tipoviaje">
                    Tipo de viaje:
                    <label for="ida" class="ida">
                        <input type="radio" id="ida" name="tipo_viaje" value="ida" checked  /> Ida
                    </label>
                    <label for="ida_vuelta" class="ida_vuelta">
                        <input type="radio" id="ida_vuelta" name="tipo_viaje" value="ida_vuelta" /> Ida y vuelta
                    </label>
                </label>

                <label for="aeropuerto_origen">
                    Aeropuerto de origen:
                    <select id="aeropuerto_origen" name="aeropuerto_origen" required>
                        <option value="">Seleccionar</option>
                        <?php
                            foreach ($aeropuertoArray as $aeropuerto) {
                                echo "<option value=\"$aeropuerto\">$aeropuerto</option>";
                            }
                        ?>
                    </select>
                </label>

                <label for="aeropuerto_destino">
                    Aeropuerto de destino:
                    <select id="aeropuerto_destino" name="aeropuerto_destino" required>
                        <option value="">Seleccionar</option>
                        <?php
                            foreach ($aeropuertoArray as $aeropuerto) {
                                echo "<option value=\"$aeropuerto\">$aeropuerto</option>";
                            }
                        ?>
                    </select>
                </label>

                <label for="codigo_vuelo">
                    Código de vuelo:
                    <div class="double_input">                
                        <input type="text" id="codigo_vuelo" name="codigo_vuelo" placeholder = "Código Vuelo ida" required />
                        <input type="text" id="codigo_vuelo_vuelta" name="codigo_vuelo_vuelta" placeholder = "Código Vuelo vuelta" class="vuelta" />
                    </div>
                </label>

                <label for="aerolinea">
                    Aerolínea:
                    <div class="double_input">                
                        <select id="aerolinea" name="aerolinea" required>
                            <option value="">Aerolinea Ida</option>
                            <?php
                                foreach ($aeroLineaArray as $aeroLinea) {
                                    echo "<option value=\"$aeroLinea\">$aeroLinea</option>";
                                }
                            ?>  
                        </select>
                        <select id="aerolinea_vuelta" name="aerolinea_vuelta" class="vuelta" >
                            <option value="">Aerolinea vuelta</option>
                            <?php
                                foreach ($aeroLineaArray as $aeroLinea) {
                                    echo "<option value=\"$aeroLinea\">$aeroLinea</option>";
                                }
                            ?>  
                        </select>
                    </div>
                </label>

                <label for="precio">
                    Precio (€):
                    <input type="number" id="precio" name="precio" min="0" required />
                </label>

                <label for="fecha_salida">
                    Fecha de salida:
                    <div class="double_input">                
                        <input type="date" id="fecha_salida" name="fecha_salida" required />
                        <input type="date" id="fecha_vuelta" name="fecha_vuelta"  class="vuelta" />
                    </div>
                </label>

                <label for="hora_salida">
                    Hora de salida:
                    <div class="double_input">                
                        <input type="time" id="hora_salida" name="hora_salida" required/>
                        <input type="time" id="hora_salida_vuelta" name="hora_salida_vuelta"  class="vuelta" />
                    </div>
                </label>

                <label for="duracion_vuelo">
                    Duración del vuelo (horas):
                    <div class="double_input">                
                    <input type="number" id="duracion_vuelo" name="duracion_vuelo" min="0" required />
                    <input type="number" id="duracion_vueloVuelta" name="duracion_vueloVuelta" min="0" class="vuelta" />
                    </div>
                </label>
            </div>

            <button type="submit" id="guardar_servicio">GUARDAR SERVICIO</button>
        </form>
    </div>

    <div id="alojamientoDiv" class="hidden">
        <h3>Detalles de Alojamiento</h3>
        <form id="alojamiento_servicio" action="saveHotel.php" method="POST">
            <div id="alojamiento_campos">

                <label for="nombre_hotel">
                    Nombre del hotel:
                    <input type="text" id="nombre_hotel" name="nombre_hotel" required />
                </label>

                <label for="tipo_hab">
                    Tipo de dormitorio:
                    <select id="tipo_hab" name="tipo_hab"  >
                        <option value="">Elige un opción</option>
                        <?php
                            foreach ($tipoHabArray as $tipoHab) {
                                echo "<option value=\"$tipoHab\">$tipoHab</option>";
                            }
                        ?>  
                    </select>               
                </label>

                <label for="Ciudad">
                    Ciudad:
                    <input type="text" id="Ciudad" name="Ciudad" required />
                </label>

                <label for="precio_hotel">
                    Precio (€):
                    <input type="number" id="precio_hotel" name="precio_hotel" min="0" required />
                </label>

                <label for="fecha_entrada_hotel">
                    Fecha de entrada:
                        <input type="date" id="fecha_entrada_hotel" name="fecha_entrada_hotel" required />
                </label>

                <label for="fecha_salida_hotel">
                    Fecha de entrada:
                        <input type="date" id="fecha_salida_hotel" name="fecha_salida_hotel" required />
                </label>

                <label for="duracion">
                    Duración (días):
                    <input type="number" id="duracion" name="duracion" min="0" required />
                </label>

            </div>

            <button type="submit" id="guardar_alojamiento">GUARDAR SERVICIO</button>
        </form>
    </div>


    <div id="otrosDiv" class="hidden">
        <h3>Otros Servicios</h3>
        <form id="otros_servicio" action="saveOtros.php" method="POST">
            <div id="otros_campos">

                <label for="descripcion_otros">
                    Descripción:
                    <textarea id="descripcion_otros" name="descripcion_otros" rows="2" placeholder="Escribe la descripcion" required ></textarea>
                </label>

                <label for="fecha_salida">
                    Fecha:
                    <input type="date" id="fecha_salida" name="fecha_salida" required />
                </label>

                <label for="precio">
                    Precio (€):
                    <input type="number" id="precio" name="precio" min="0" required />
                </label>

            </div>

            <button type="submit" id="guardar_otros">GUARDAR SERVICIO</button>
        </form>
    </div>

    </main>


    <footer>

        <?php include '../includes/footer.php'; ?>

    </footer>

        <script src="../scripts/servicios.js"></script>
    </body>
    </html>