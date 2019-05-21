package br.com.les.negocio;

import br.com.les.dao.DAOEndereco;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;

public class StComplementarEnderecoEntrega implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco en = (Endereco) entidade;
		DAOEndereco dao = new DAOEndereco();
		
		en = dao.complementarEndereco(en);

		return null;
	}

}

