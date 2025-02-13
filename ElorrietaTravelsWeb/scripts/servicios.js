

function handleSelection() {
    let nombre = document.getElementById("nombre").value;
    let tipoServicio = document.getElementById("tipo_servicio").value;

    if (nombre.trim() === "" || tipoServicio === "") {
        alert("Por favor, complete todos los campos.");
        return;
    }
    hideAll()

    if (tipoServicio === "vuelo") {
        document.getElementById("vueloDiv").style.display = "flex";
    } else if (tipoServicio === "alojamiento") {
        document.getElementById("alojamientoDiv").style.display = "flex";
    } else if (tipoServicio === "otros") {
        document.getElementById("otrosDiv").style.display = "flex";
    }
}

document.addEventListener("DOMContentLoaded", function () {
    const idaRadio = document.getElementById("ida");
    const idaVueltaRadio = document.getElementById("ida_vuelta");
    const vueltaFields = document.querySelectorAll(".vuelta");

    function toggleVueltaFields() {
        if (idaVueltaRadio.checked) {
            vueltaFields.forEach(field => {
                field.style.display = "inline-block"; 
                field.setAttribute("required", "required");
            });
        } else {
            vueltaFields.forEach(field => {
                field.style.display = "none"; 
                field.removeAttribute("required");
            });
        }
    }

    idaRadio.addEventListener("change", toggleVueltaFields);
    idaVueltaRadio.addEventListener("change", toggleVueltaFields);

    toggleVueltaFields();
});



function hideAll(){
    document.querySelector(".typeSelectContainer").style.display = "none";
    document.getElementById("vueloDiv").style.display = "none";
    document.getElementById("alojamientoDiv").style.display = "none";
    document.getElementById("otrosDiv").style.display = "none";
}

document.addEventListener("DOMContentLoaded", function () {
    const vueloForm = document.getElementById("vuelo_servicio");

    vueloForm.addEventListener("submit", function (e) {
        const fechaSalida = document.getElementById("fecha_salida").value;
        const fechaVuelta = document.getElementById("fecha_vuelta").value;

        if (fechaVuelta && new Date(fechaSalida) > new Date(fechaVuelta)) {
            alert("La fecha de ida no puede ser posterior a la fecha de vuelta.");
            e.preventDefault();
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const vueloForm = document.getElementById("vuelo_servicio");

    vueloForm.addEventListener("submit", function (e) {
        const codigoVuelo = document.getElementById("codigo_vuelo").value;

        if (codigoVuelo.length !== 5) {
            alert("El código de vuelo debe tener exactamente 5 caracteres.");
            e.preventDefault();
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const vueloForm = document.getElementById("vuelo_servicio");

    vueloForm.addEventListener("submit", function (e) {
        const codigoVuelo = document.getElementById("codigo_vuelo").value;
        const codigoVueloVuelta = document.getElementById("codigo_vuelo_vuelta").value;

        if (codigoVuelo.length !== 5) {
            alert("El código de vuelo (ida) debe tener exactamente 5 caracteres.");
            e.preventDefault();
            return;
        }
        if (codigoVueloVuelta && codigoVueloVuelta.length !== 5) {
            alert("El código de vuelo (vuelta) debe tener exactamente 5 caracteres.");
            e.preventDefault();
        }
    });
});


document.addEventListener("DOMContentLoaded", function () {
    function preventTyping(input) {
        if (input) {
            input.addEventListener("keydown", function (e) {
                e.preventDefault();
            });
        }
    }

    const fechaSalida = document.getElementById("fecha_salida");
    const fechaVuelta = document.getElementById("fecha_vuelta");
    const horaSalida = document.getElementById("hora_salida");
    const horaVuelta = document.getElementById("hora_vuelta");

    [fechaSalida, fechaVuelta, horaSalida, horaVuelta].forEach(preventTyping);

    const idaRadio = document.getElementById("ida");
    const idaVueltaRadio = document.getElementById("ida_vuelta");
    const vueltaFields = document.querySelectorAll(".vuelta");

    function toggleVueltaFields() {
        if (idaVueltaRadio.checked) {
            vueltaFields.forEach(field => {
                field.style.display = "inline-block";
                field.setAttribute("required", "required");
            });
        } else {
            vueltaFields.forEach(field => {
                field.style.display = "none";
                field.removeAttribute("required");
            });
        }
    }

    idaRadio.addEventListener("change", toggleVueltaFields);
    idaVueltaRadio.addEventListener("change", toggleVueltaFields);
});


document.getElementById('alojamiento_servicio').onsubmit = function(event) {
    var fechaEntrada = document.getElementById('fecha_entrada_hotel').value;
    var fechaSalida = document.getElementById('fecha_salida_hotel').value;

    if (fechaEntrada && fechaSalida) {
        if (new Date(fechaEntrada) >= new Date(fechaSalida)) {
            alert("La fecha de entrada debe ser anterior a la fecha de salida.");
            event.preventDefault();
            return false;
        }
    } else {
        alert("Por favor, complete ambas fechas.");
        event.preventDefault();
        return false;
    }
};

function calculateDuracion() {
    var fechaEntrada = document.getElementById('fecha_entrada_hotel').value;
    var fechaSalida = document.getElementById('fecha_salida_hotel').value;

    if (fechaEntrada && fechaSalida) {
        if (new Date(fechaEntrada) >= new Date(fechaSalida)) {
            alert("La fecha de entrada debe ser anterior a la fecha de salida.");
            document.getElementById('duracion').value = ''; 
            return;
        }

        var entradaDate = new Date(fechaEntrada);
        var salidaDate = new Date(fechaSalida);
        var timeDiff = salidaDate - entradaDate;
        var dias = timeDiff / (1000 * 3600 * 24);

        document.getElementById('duracion').value = dias;
    }
}

document.getElementById('fecha_entrada_hotel').addEventListener('change', calculateDuracion);
document.getElementById('fecha_salida_hotel').addEventListener('change', calculateDuracion);

document.getElementById('duracion').readOnly = true;

