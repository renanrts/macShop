package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;

public class StCalcularTotalPedido implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
		Pedido pedido = (Pedido) entidade;
		Double valorTotal = 0.0;
		
		 if(pedido.getCarrinho() == null)
		 {
			 mensagem.append("Tempo do produto no carrinho expirado. Por favor, visite o catálogo de produtos. ");
			 return mensagem.toString();
		 }
		
		for (ItemCarrinho produto : pedido.getCarrinho().getItensCarrinho())
		{
			valorTotal += (produto.getProduto().getPreco() * produto.getQuantidade());
		}
		
		valorTotal += pedido.getFrete();
		
		pedido.setValorTotal(valorTotal);
		
		return null;
	}

}
