package br.com.les.negocio;

import br.com.les.dao.DAOCupom;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;

public class StInutilizarCupom implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		String mensagem = "";
		
	    Pedido pedido = (Pedido) entidade;
	    
	    DAOCupom daoCupom = new DAOCupom();
	    
	    if(pedido.getCupom_id().getId().equals(0)) {
	      daoCupom.excluir(pedido.getCupom_id());
	    }
	    
	    for (int i = 0; i < pedido.getCuponsTroca().size(); i++) {
	      Cupom cupomAdesativar = pedido.getCuponsTroca().get(i);
	      daoCupom.excluir(cupomAdesativar);  
	    }
	       
	    return mensagem;
	  }
	}
