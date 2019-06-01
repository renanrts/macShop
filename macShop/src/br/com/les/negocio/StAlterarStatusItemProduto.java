package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.StatusPedido;

public class StAlterarStatusItemProduto implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
		
		ItemCarrinho item = (ItemCarrinho) entidade;
		
		if (item.getProduto().getAtivo().equals(StatusPedido.APROVADO.getDescription()))
		{
			item.getProduto().setAtivo(StatusPedido.EMTROCA.getDescription());
		}
		
		else if (item.getProduto().getAtivo().equals(StatusPedido.EMTROCA.getDescription()))
		{
			item.getProduto().setAtivo(StatusPedido.TROCAAUTORIZADA.getDescription());
		}
		
		else if (item.getProduto().getAtivo().equals(StatusPedido.TROCAAUTORIZADA.getDescription()))
		{
			item.getProduto().setAtivo(StatusPedido.TROCADO.getDescription());
		}
		
		
		if(mensagem.length() == 0){
			return null;
		}
	    
	    return mensagem.toString();
	}

}
