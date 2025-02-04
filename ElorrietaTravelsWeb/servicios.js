function mostrarCampoOtros(selectElement) {
    var otrosCampo = document.getElementById('otros_servicio');
    if (selectElement.value === 'otros') {
        otrosCampo.style.display = 'block';
    } else {
        otrosCampo.style.display = 'none';
    }
}

function validarFormulario(event) {
    event.preventDefault();

    var nombre = document.getElementById('nombre').value;
    var tipo_servicio = document.getElementById('tipo_servicio').value;
    var descripcion_otros = document.getElementById('descripcion_otros').value;

    if (nombre === "" || tipo_servicio === "") {
        alert("Por favor, complete todos los campos obligatorios.");
        return;
    }

    if (tipo_servicio === "otros" && descripcion_otros === "") {
        alert("Por favor, especifique el servicio en 'Otros'.");
        return;
    }

    alert("Formulario enviado correctamente.");
}

document.getElementById('form_servicio').addEventListener('submit', validarFormulario);
