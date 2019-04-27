package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.FormaPagamento;
import br.com.les.dominio.Pedido;

public class StValidarDadosObrigatoriosPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		
		StringBuilder mensagem = new StringBuilder();

		if(pedido.getEntrega_id() == null || pedido.getEntrega_id().equals("")){
			mensagem.append("Endereço de entrega é um campo obrigatório\n");
		}

		for (FormaPagamento pagto : pedido.getFormapagto())
		{
			pagto.getParcela();
			pagto.getValor();
		}
		
		pedido.getFrete();
		pedido.getCarrinho();
		
		
		return null;
	}

}
