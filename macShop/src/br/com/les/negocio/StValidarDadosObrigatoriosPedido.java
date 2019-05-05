package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.FormaPagamento;
import br.com.les.dominio.Pedido;

public class StValidarDadosObrigatoriosPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		
		StringBuilder mensagem = new StringBuilder();

		if(pedido.getEndEntrega().getId() == null || pedido.getEndEntrega().getId().equals("")){
			mensagem.append("Endereço de entrega é um campo obrigatório.\n");
		}

		for (FormaPagamento pagto : pedido.getFormapagto())
		{
			pagto.getParcela();
			pagto.getValor();
		}
		
		if(pedido.getFrete() == null || pedido.getFrete().equals(""))
		{
			mensagem.append("O frete é um campo obrigatório, por favor digite um CEP para calculá-lo.\n");
		}
		
		if(pedido.getCarrinho() == null || pedido.getCarrinho().equals(""))
		{
			mensagem.append("Por favor, para realizar a compra, coloque o item desejado no carrinho\n");
		}
		
		
		
		
		return null;
	}

}
