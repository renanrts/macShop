package br.com.les.negocio;

import java.util.ArrayList;
import java.util.List;

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
		
		Integer idCupom = pedido.getCupom_id().getId();
		cupom.setId(idCupom);
		if(cupom.getId() !=null)
		{
			cupom = dao.consultarValidade(cupom);
		}
		
		else
		{
			cupom.setId(0);
			cupom.setValor(0.0);
		}
		
		pedido.setCupom_id((cupom));
		
		
		List<Cupom> cuponsTroca = new ArrayList<Cupom>();
		for(Cupom cupomTroca : pedido.getCuponsTroca())
		{
			Integer idCupomTroca = cupomTroca.getId();
			cupomTroca.setId(idCupomTroca);
			if(cupomTroca.getId() !=null)
			{
				cupomTroca = dao.consultarValidade(cupomTroca);
			}
			
			else
			{
				cupomTroca.setId(0);
				cupomTroca.setValor(0.0);
			}
			cuponsTroca.add(cupomTroca);
		}
		
		pedido.setCuponsTroca(cuponsTroca);
		
		return null;
	}

}
