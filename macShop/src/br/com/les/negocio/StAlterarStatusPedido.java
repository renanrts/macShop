package br.com.les.negocio;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.StatusPedido;

public class StAlterarStatusPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
		
		Pedido pedido = (Pedido) entidade;
		
		if (pedido.getStatus().equals(StatusPedido.APROVADO.getDescription()))
		{
			pedido.setStatus(StatusPedido.EMTRANSPORTE.getDescription());
		}
		
		else if (pedido.getStatus().equals(StatusPedido.EMTRANSPORTE.getDescription()))
		{
			pedido.setStatus(StatusPedido.ENTREGUE.getDescription());
		}
		
		else if (pedido.getStatus().equals(StatusPedido.ENTREGUE.getDescription()))
		{
			pedido.setStatus(StatusPedido.EMTROCA.getDescription());
		}
		
		else if (pedido.getStatus().equals(StatusPedido.EMTROCA.getDescription()))
		{
			pedido.setStatus(StatusPedido.TROCAAUTORIZADA.getDescription());
		}
		
		else if (pedido.getStatus().equals(StatusPedido.TROCAAUTORIZADA.getClass()))
		{
			pedido.setStatus(StatusPedido.TROCADO.getDescription());
		}
		if(mensagem.length() == 0){
			return null;
		}
	    
	    return mensagem.toString();
	}

}
