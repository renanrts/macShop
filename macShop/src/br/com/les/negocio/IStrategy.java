package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;

public interface IStrategy {
	

	public String processar(EntidadeDominio entidade);

}
