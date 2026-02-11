function validarFormulario() {
    const dataInicial = document.getElementById('dataInicial').value;
    const dataFinal = document.getElementById('dataFinal').value;
    
    if (!dataInicial || !dataFinal) {
        alert('Por favor, preencha todas as datas.');
        return false;
    }
    
    const dtInicial = new Date(dataInicial);
    const dtFinal = new Date(dataFinal);
    
    if (dtFinal < dtInicial) {
        alert('A data final não pode ser anterior à data inicial!');
        return false;
    }
    
    return true;
}