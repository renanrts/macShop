package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.StatusPedido;

public class StReprovarTroca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
		
		ItemCarrinho item = (ItemCarrinho) entidade;
	
		
		if (item.getProduto().getAtivo().equals(StatusPedido.EMTROCA.getDescription()))
		{
			item.getProduto().setAtivo(StatusPedido.REPROVADO.getDescription());
		}
		
		
		if(mensagem.length() == 0){
			return null;
		}
	    
	    return mensagem.toString();
	}

}
