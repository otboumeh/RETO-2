document.addEventListener("DOMContentLoaded", function () {
    console.log("DOM fully loaded");

    const form = document.querySelector("form.secondContainter");
    const fechaInicio = document.getElementById("fecha_inicio");
    const fechaFin = document.getElementById("fecha_fin");
    const diasInput = document.getElementById("dias");
    const tipoViaje = document.getElementById("tipo_viaje");
    const nombre = document.getElementById("nombre");
    const pais = document.getElementById("pais");
    const descripcion = document.getElementById("descripcion");
    const serviciosNoIncluidos = document.getElementById("servicios_no_incluidos");

    if (!form || !fechaInicio || !fechaFin || !diasInput) {
        console.error("Missing elements in the DOM");
        return;
    }

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
        if (!nombre.value || !tipoViaje.value || !fechaInicio.value || !fechaFin.value || !pais.value || !descripcion.value || !serviciosNoIncluidos.value) {
            alert("Por favor, complete todos los campos antes de guardar.");
            event.preventDefault();
            return;
        }

        const inicio = new Date(fechaInicio.value);
        const fin = new Date(fechaFin.value);

        if (fin < inicio) {
            alert("Error: La fecha de finalización no puede ser anterior a la fecha de inicio.");
            event.preventDefault();
            return;
        }
    }

    fechaInicio.addEventListener("keydown", (e) => e.preventDefault());
    fechaFin.addEventListener("keydown", (e) => e.preventDefault());

    fechaInicio.addEventListener("change", calcularDias);
    fechaFin.addEventListener("change", calcularDias);

    form.addEventListener("submit", validarFormulario);
});
