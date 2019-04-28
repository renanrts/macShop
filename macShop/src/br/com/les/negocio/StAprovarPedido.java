package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.FormaPagamento;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.StatusPedido;
import br.com.les.util.Resultado;

public class StAprovarPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		
		StringBuilder mensagem = new StringBuilder();


		Pedido pedido = (Pedido) entidade;
		
		Double valorTotalCartoes = 0.0;

		
		for(FormaPagamento pagto: pedido.getFormapagto())
		{
			valorTotalCartoes += pagto.getValor();
		}
		
		if (pedido.getValorTotal() > (valorTotalCartoes + pedido.getFormapagto().get(0).getCupom().getValor()))
		{
			mensagem.append("Por favor, refaça a compra: Valor insuficiente ");
		}
		else
		{
			pedido.setStatus(StatusPedido.APROVADO.getDescription());
			
		}
		
		if(mensagem.length() == 0){
			return null;
		}
	
	return mensagem.toString();
	}

}
