document.addEventListener("DOMContentLoaded", function() {
    const tipoServicio = document.getElementById("tipo_servicio");
    const otrosCampo = document.getElementById("otros_servicio");
    const vueloCampos = document.getElementById("vuelo_campos");
    const alojamientoCampos = document.getElementById("alojamiento_campos");
    const formServicio = document.getElementById("form_servicio");
    const popup = document.getElementById("popup");
    const popupMessage = document.getElementById("popup-message");
    const popupClose = document.getElementById("popup-close");

    // Manejo de cambio en el tipo de servicio
    tipoServicio.addEventListener("change", function() {
        const tipo = tipoServicio.value;

        // Ocultar todos los formularios
        alojamientoCampos.style.display = "none";
        vueloCampos.style.display = "none";
        otrosCampo.style.display = "none";

        // Mostrar el formulario correspondiente
        if (tipo === "alojamiento") {
            alojamientoCampos.style.display = "block";
        } else if (tipo === "vuelo") {
            vueloCampos.style.display = "block";
        } else if (tipo === "otros") {
            otrosCampo.style.display = "block";
        }
    });

    // Manejo de cambio en el tipo de viaje para vuelos
    const tipoViajeRadios = document.getElementsByName("tipo_viaje");
    tipoViajeRadios.forEach(radio => {
        radio.addEventListener("change", function() {
            const tipoViaje = document.querySelector('input[name="tipo_viaje"]:checked').value;
            // Si se selecciona "ida y vuelta", muestra los campos de retorno
            if (tipoViaje === "ida_vuelta") {
                // Puedes agregar aquí más campos de ida y vuelta si es necesario
                document.getElementById("vuelo_campos").style.display = "block";
            } else {
                // Si se selecciona "ida", ocultamos los campos adicionales de ida y vuelta
                document.getElementById("vuelo_campos").style.display = "block";
            }
        });
    });

    // Envío del formulario
    formServicio.addEventListener("submit", function(event) {
        event.preventDefault();

        let nombre = document.getElementById("nombre").value.trim();
        let tipo = tipoServicio.value;
        let descripcionOtros = document.getElementById("descripcion_otros") ? document.getElementById("descripcion_otros").value.trim() : "";

        if (nombre === "" || tipo === "") {
            mostrarPopup("Por favor, complete todos los campos obligatorios.");
            return;
        }

        if (tipo === "otros" && descripcionOtros === "") {
            mostrarPopup("Por favor, especifique el servicio en 'Otros'.");
            return;
        }

        if (tipo === "vuelo") {
            let aeropuertoOrigen = document.getElementById("aeropuerto_origen").value.trim();
            let aeropuertoDestino = document.getElementById("aeropuerto_destino").value.trim();
            let codigoVuelo = document.getElementById("codigo_vuelo").value.trim();
            let aerolinea = document.getElementById("aerolinea").value.trim();
            let precio = document.getElementById("precio").value.trim();
            let fechaSalida = document.getElementById("fecha_salida").value.trim();
            let horaSalida = document.getElementById("hora_salida").value.trim();
            let duracion = document.getElementById("duracion_vuelo").value.trim();

            if (aeropuertoOrigen === "" || aeropuertoDestino === "" || codigoVuelo === "" ||
                aerolinea === "" || precio === "" || fechaSalida === "" || horaSalida === "" || duracion === "") {
                mostrarPopup("Por favor, complete todos los campos del vuelo.");
                return;
            }
        }

        mostrarPopup("Formulario enviado correctamente.");
    });

    function mostrarPopup(mensaje) {
        popupMessage.textContent = mensaje;
        popup.style.display = "block";
    }

    popupClose.addEventListener("click", function() {
        popup.style.display = "none";
    });
});
