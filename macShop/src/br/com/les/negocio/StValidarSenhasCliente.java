package br.com.les.negocio;

import br.com.les.dominio.Cliente;
import br.com.les.dominio.EntidadeDominio;

public class StValidarSenhasCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
		Cliente cliente = (Cliente) entidade;
		
		
		if(!cliente.getSenhas().get(0).equals(cliente.getSenhas().get(1))){
			mensagem.append("As senhas não batem\n");
		}
		
		if(mensagem.length() == 0){
			return null;
		}
		else {
			return mensagem.toString();
		}
	}

}
