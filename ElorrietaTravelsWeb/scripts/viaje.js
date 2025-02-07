document.addEventListener("DOMContentLoaded", function () {
    console.log("DOM fully loaded");

    const fechaInicio = document.getElementById("fecha_inicio");
    const fechaFin = document.getElementById("fecha_fin");
    const diasInput = document.getElementById("dias");
    const guardarBtn = document.querySelector("button[type='submit']");
    const tipoViaje = document.getElementById("tipo_viaje");
    const otrosServicio = document.getElementById("otros_servicio");

    function mostrarCampoOtros() {
        if (tipoViaje.value === "otros") {
            otrosServicio.style.display = "block";
        } else {
            otrosServicio.style.display = "none";
        }
    }
    mostrarCampoOtros();
    function calcularDias() {
        if (!fechaInicio.value || !fechaFin.value) {
            diasInput.value = "";
            return;
        }

        const inicio = new Date(fechaInicio.value);
        const fin = new Date(fechaFin.value);

        if (fin < inicio) {
            diasInput.value = "";
            return;
        }
        const diferenciaDias = (fin - inicio) / (1000 * 3600 * 24);
        diasInput.value = diferenciaDias;
    }
    function validarFormulario(event) {
        event.preventDefault();

        if (!fechaInicio.value || !fechaFin.value) {
            alert("Por favor, seleccione ambas fechas antes de guardar.");
            return;
        }
        const inicio = new Date(fechaInicio.value);
        const fin = new Date(fechaFin.value);

        if (fin < inicio) {
            alert("Error: La fecha de finalización no puede ser anterior a la fecha de inicio.");
            return;
        }

        alert("Formulario enviado correctamente.");
    }
    fechaInicio.addEventListener("keydown", (e) => e.preventDefault());
    fechaFin.addEventListener("keydown", (e) => e.preventDefault());

    fechaInicio.addEventListener("change", calcularDias);
    fechaFin.addEventListener("change", calcularDias);

    tipoViaje.addEventListener("change", mostrarCampoOtros);

    guardarBtn.addEventListener("click", validarFormulario);
});
