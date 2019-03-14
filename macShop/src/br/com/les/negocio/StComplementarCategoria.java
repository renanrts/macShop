package br.com.les.negocio;



import br.com.les.dao.DAOCategoria;

import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;


public class StComplementarCategoria implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Eletronico eletronico = (Eletronico) entidade;
		DAOCategoria dao = new DAOCategoria();
		dao.consultarCategoria(eletronico);
	
		return null;
			
	}

}
