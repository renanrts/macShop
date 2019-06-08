package br.com.les.negocio;

import br.com.les.dao.DAOCategoria;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Relatorio;

public class StComplementarVariaveis implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Relatorio rel = (Relatorio) entidade;
		
		DAOCategoria dao = new DAOCategoria();
		
		rel.setVariavel1(dao.consultarCategorias());

		return null;
	}

}
