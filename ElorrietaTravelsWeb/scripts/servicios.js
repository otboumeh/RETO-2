document.addEventListener("DOMContentLoaded", function () {
    const tipoServicio = document.getElementById("tipo_servicio");
    const otrosCampo = document.getElementById("otros_servicio");
    const vueloCampos = document.getElementById("vuelo_campos");
    const alojamientoCampos = document.getElementById("alojamiento_campos");
    const secondContainerWrapper = document.getElementById("secondContainerWrapper");

    // Show/hide fields based on service type
    tipoServicio.addEventListener("change", function () {
        const tipo = tipoServicio.value;

        // Hide all fields initially
        otrosCampo.style.display = "none";
        vueloCampos.style.display = "none";
        alojamientoCampos.style.display = "none";
        secondContainerWrapper.style.display = "none";

        // Show relevant fields
        if (tipo === "alojamiento") {
            alojamientoCampos.style.display = "block";
        } else if (tipo === "vuelo") {
            vueloCampos.style.display = "block";
        } else if (tipo === "otros") {
            otrosCampo.style.display = "block";
        }
    });

    // Show/hide second container for "ida y vuelta"
    const tipoViajeRadios = document.querySelectorAll('input[name="tipo_viaje"]');
    tipoViajeRadios.forEach((radio) => {
        radio.addEventListener("change", function () {
            const tipoViaje = document.querySelector('input[name="tipo_viaje"]:checked').value;
            if (tipoViaje === "ida_vuelta") {
                secondContainerWrapper.style.display = "flex";
            } else {
                secondContainerWrapper.style.display = "none";
            }
        });
    });
});