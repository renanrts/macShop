package br.com.les.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.les.dao.DAOEndereco;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;

public class StComplementarEnderecoCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		DAOEndereco dao = new DAOEndereco();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		for(Endereco en : cliente.getListEnderecos())
		{
			//en = dao.complementarEndereco(cliente);
			enderecos.add(en);
		}
		cliente.setListEnderecos(enderecos);
		
		return null;
	}

}
