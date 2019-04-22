package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;

public class StCalcularTotalPedido implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		Double valorTotal = 0.0;
		
		for (ItemCarrinho produto : pedido.getCarrinho().getItensCarrinho())
		{
			valorTotal += (produto.getProduto().getPreco() * produto.getQuantidade());
		}
		
		pedido.setValorTotal(valorTotal);
		
		return null;
	}

}
