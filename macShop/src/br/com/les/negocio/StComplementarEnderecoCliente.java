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
		
		
		if(cliente.getEnderecoCobranca() == null || cliente.getEnderecoResidencial() == null || cliente.getListEnderecosEntrega() == null)
		{
			return null;
		}
		
		cliente.setEnderecoCobranca(dao.complementarEndereco(cliente.getEnderecoCobranca()));
		cliente.setEnderecoResidencial(dao.complementarEndereco(cliente.getEnderecoResidencial()));
				
		List<Endereco> enderecosEntrega = new ArrayList<Endereco>();
		
		for(Endereco en : cliente.getListEnderecosEntrega())
		{
			en = dao.complementarEndereco(en);
			enderecosEntrega.add(en);
		}
		cliente.setListEnderecosEntrega(enderecosEntrega);
		
		return null;
	}

}
