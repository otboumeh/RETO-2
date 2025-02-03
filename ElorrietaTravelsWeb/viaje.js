function mostrarCampoOtros(selectElement) {
    var otrosCampo = document.getElementById('otros_servicio');
    if (selectElement.value === 'otros') {
        otrosCampo.style.display = 'block';
    } else {
        otrosCampo.style.display = 'none';
    }
}
