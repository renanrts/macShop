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
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class DAOBloqueio extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
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
			a.setTipo("VHELETRONICO");
			eletronicos.add(a);
			resultado.setListaResultado(eletronicos);
		}
		else
		{
			DAOAcessorio dao = new DAOAcessorio();
			dao.alterarEstoque(produto);
			
			List<EntidadeDominio> acessorios = new ArrayList<EntidadeDominio>();
			Acessorio a = (Acessorio) produto;
			a.setTipo("VHACESSORIO");
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
	public Resultado consultar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		Bloqueio bloq = (Bloqueio) entidade;
		
		if (bloq.getOperation().equals("add"))
		{

			Produto produto = bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getProduto();
			Integer qtde = 0;
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
			
			ArrayList<ItemCarrinho> itensCarrinho = bloq.getCarrinho().getItensCarrinho();
			
			
			bloq.getCarrinho().getItensCarrinho().remove(bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1));
			for (int i = 0; i < itensCarrinho.size(); i++)
			{
				ItemCarrinho item = itensCarrinho.get(i);
				
				if (item.getProduto().getId().equals(produto.getId()))
				{
					qtde = item.getProduto().getEstoque() + 1;
					item.getProduto().setEstoque(qtde);
					itensCarrinho.set(i, item);
					bloq.getCarrinho().getItensCarrinho().get(i).setQuantidade(qtde);
				}
					
			}
			bloq.getCarrinho().setItensCarrinho(itensCarrinho);
			
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
	
		else {
			
			Produto produto = bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getProduto();
			ArrayList<ItemCarrinho> itensCarrinho = bloq.getCarrinho().getItensCarrinho();
			
			Integer qtde = 0;
			bloq.getCarrinho().getItensCarrinho().remove(bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1));
			for (int i = 0; i < itensCarrinho.size(); i++)
			{
				ItemCarrinho item = itensCarrinho.get(i);
				if (item.getProduto().getId().equals(produto.getId()))
				{
					qtde = item.getProduto().getEstoque() - 1;
					item.getProduto().setEstoque(qtde);
					itensCarrinho.set(i, item);
					bloq.getCarrinho().getItensCarrinho().get(i).setQuantidade(qtde);
				}
					
			}
			bloq.getCarrinho().setItensCarrinho(itensCarrinho);
			produto.setEstoque(1);

			if (bloq.getTipo().equals("VHELETRONICO"))
			{
				DAOEletronico dao = new DAOEletronico();
				dao.voltarEstoque(produto);
			}
			else
			{
				DAOAcessorio dao = new DAOAcessorio();
				dao.voltarEstoque(produto);
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
			
			resultado.sucesso("Removido com sucesso!");
			
			return resultado;
		}

	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		Bloqueio bloq = (Bloqueio) entidade;
		Integer qtdeItensdevolucao = 0;
		Produto produto = bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getProduto();
		ArrayList<ItemCarrinho> itensCarrinho = bloq.getCarrinho().getItensCarrinho();
		
		
		bloq.getCarrinho().getItensCarrinho().remove(bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1));
		for (int i = 0; i < itensCarrinho.size(); i++)
		{
			ItemCarrinho item = itensCarrinho.get(i);
			if (item.getProduto().getId().equals(produto.getId()))
			{
				qtdeItensdevolucao+= item.getProduto().getEstoque();
				itensCarrinho.remove(i);
			}
				
		}
		
		produto.setEstoque(qtdeItensdevolucao);

		
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
		
		resultado.sucesso("Removido com sucesso!");
		
		return resultado;
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
