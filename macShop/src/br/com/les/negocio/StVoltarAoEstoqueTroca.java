package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;

public class StVoltarAoEstoqueTroca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		ItemCarrinho item = (ItemCarrinho) entidade;
		
		item.getProduto();
		return null;
	}

}
