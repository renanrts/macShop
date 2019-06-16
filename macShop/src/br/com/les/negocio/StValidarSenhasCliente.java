package br.com.les.negocio;

import br.com.les.dominio.Cliente;
import br.com.les.dominio.EntidadeDominio;

public class StValidarSenhasCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
		Cliente cliente = (Cliente) entidade;
		boolean achouNumero = false;
		boolean achouMaiuscula = false;
		boolean achouMinuscula = false;
		boolean achouSimbolo = false;

		if (cliente.getSenhas().get(0).length() < 6) {
			mensagem.append("A senha precisa conter pelo menos 6 caracteres\n");
		}

		for (char c : cliente.getSenhas().get(0).toCharArray()) {
			if (c >= '0' && c <= '9') {
				achouNumero = true;
			} else if (c >= 'A' && c <= 'Z') {
				achouMaiuscula = true;
			} else if (c >= 'a' && c <= 'z') {
				achouMinuscula = true;
			} else {
				achouSimbolo = true;
			}
		}
		
		if (achouNumero == false)
		{
			mensagem.append("A senha precisa conter pelo menos 1 número\n");
		}
		
		if (achouMaiuscula == false)
		{
			mensagem.append("A senha precisa conter pelo menos 1 letra maiúscula\n");
		}
		
		if (achouMinuscula == false)
		{
			mensagem.append("A senha precisa conter pelo menos 1 letra minúscula\n");
		}
		
		if (achouSimbolo == false)
		{
			mensagem.append("A senha precisa conter pelo menos 1 caracter especial\n");
		}

		if (!cliente.getSenhas().get(0).equals(cliente.getSenhas().get(1))) {
			mensagem.append("As senhas não batem\n");
		}

		if (mensagem.length() == 0) {
			return null;
		} else {
			return mensagem.toString();
		}
	}

}
