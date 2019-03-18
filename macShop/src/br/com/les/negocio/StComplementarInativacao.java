package br.com.les.negocio;

import java.util.Calendar;

import br.com.les.dao.DAOCategoria;
import br.com.les.dao.DAOInativacao;
import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Inativacao;

public class StComplementarInativacao implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		StringBuilder mensagem = new StringBuilder();

		if (entidade.getTipo().equals("VHELETRONICO"))
		{
			
			Eletronico eletronico = (Eletronico) entidade;
			
			Inativacao inativacao = new Inativacao();
			
			
			inativacao.setMotivo(eletronico.getMotivo());
			inativacao.setProdutoId(eletronico.getId());
			inativacao.setStatus(eletronico.getAtivo());
			
			
			Calendar dataAlteracao = Calendar.getInstance();
			inativacao.setDataAlteracao(dataAlteracao);
			
			if(eletronico.getAtivo().equals("Ativo")){
			
				DAOInativacao dao = new DAOInativacao();
				dao.salvar(inativacao);
			}
			
			return null;
		
		}
		
		else
			
		{
			Acessorio acessorio = (Acessorio) entidade;
			
			Inativacao inativacao = new Inativacao();
			
			
			inativacao.setMotivo(acessorio.getMotivo());
			inativacao.setProdutoId(acessorio.getId());
			inativacao.setStatus(acessorio.getAtivo());
			
			
			Calendar dataAlteracao = Calendar.getInstance();
			inativacao.setDataAlteracao(dataAlteracao);
			
			if(acessorio.getAtivo().equals("Ativo")){
				DAOInativacao dao = new DAOInativacao();
				dao.salvar(inativacao);
			}
			return null;
		}
	}

}
