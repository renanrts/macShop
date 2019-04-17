package br.com.les.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class DAOBloqueio extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		Bloqueio bloq = (Bloqueio) entidade;
		
		
		Produto produto = bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getProduto();

		produto.setEstoque(bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getQuantidade());
		if (bloq.getTipo().equals("VHELETRONICO"))
		{
			DAOEletronico dao = new DAOEletronico();
			dao.alterarEstoque(produto);
			
			List<EntidadeDominio> eletronicos = new ArrayList<EntidadeDominio>();
			Eletronico a = (Eletronico) produto;
			eletronicos.add(a);
			resultado.setListaResultado(eletronicos);
		}
		else
		{
			DAOAcessorio dao = new DAOAcessorio();
			dao.alterarEstoque(produto);
			
			List<EntidadeDominio> acessorios = new ArrayList<EntidadeDominio>();
			Acessorio a = (Acessorio) produto;
			acessorios.add(a);
			resultado.setListaResultado(acessorios);
		}
		
		bloq.getSessao().setAttribute("carrinho", bloq.getCarrinho());
		
		
		
		HashMap<String, Carrinho> mapProdutosBloqueados;
		mapProdutosBloqueados = (HashMap<String,Carrinho>) bloq.getSessao().getServletContext().getAttribute("bloqueio");
		
		if(mapProdutosBloqueados.containsValue(bloq.getSessao().getId()))
		{
			mapProdutosBloqueados.get(bloq.getSessao().getId()).addItem(bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1));
		}
		else {
			mapProdutosBloqueados.put(bloq.getSessao().getId(), bloq.getCarrinho());
		}
		
		resultado.sucesso("Salvo com sucesso!");
		
		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado visualizar(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

}
