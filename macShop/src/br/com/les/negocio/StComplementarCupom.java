package br.com.les.negocio;

import br.com.les.dao.DAOCupom;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;

public class StComplementarCupom implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		DAOCupom dao = new DAOCupom();
		Cupom cupom = new Cupom();
		Integer idCupom = pedido.getFormapagto().get(0).getCupom().getId();
		cupom.setId(idCupom);
		if(cupom.getId() !=null)
		{
			cupom = dao.consultarValidade(cupom);
		}
		
		else
		{
			cupom.setId(0);
		}
		
		pedido.getFormapagto().get(0).setCupom(cupom);
		
		return null;
	}

}
