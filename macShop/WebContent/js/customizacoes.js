/*$(".endereco").click(() =>{
	alert($(this).val())
})*/

let enderecoSelecionado = document.getElementById('endereco-selecionado');
let idenderecoSelecionado = document.getElementById('idendereco-selecionado');
let spanEndId = document.querySelector('.endereco');
let radio = document.querySelector('.end_sel_id');

radio.addEventListener( 'click' , () => {
	enderecoSelecionado.value = spanEndId.value;
	idenderecoSelecionado.value = radio.value;
})