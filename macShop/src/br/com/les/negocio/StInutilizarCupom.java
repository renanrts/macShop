package br.com.les.negocio;

import br.com.les.dao.DAOCupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.FormaPagamento;
import br.com.les.dominio.Pedido;

public class StInutilizarCupom implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		
		DAOCupom dao = new DAOCupom();
		
		Double valorTotalCartoes = 0.0;

		
		for(FormaPagamento pagto: pedido.getFormapagto())
		{
			valorTotalCartoes += pagto.getValor();
		}
		
		if (pedido.getValorTotal() > valorTotalCartoes)
		{
			return null;
		}
		
		else
		{
			if(pedido.getFormapagto().get(0).getCupom().getValor() > pedido.getValorTotal())
			{
				dao.salvar(pedido);
			}
			dao.excluir(pedido.getFormapagto().get(0).getCupom());
		}
		
		
		return null;
	}

}
