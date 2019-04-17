package br.com.les.negocio;

import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOEletronico;
import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class StValidarBloqueio implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		StringBuilder mensagem = new StringBuilder();
		Bloqueio bloq = (Bloqueio) entidade;
		
		Produto produto = bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getProduto();
		produto.setId(bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getProduto().getId());
		
		
		if (bloq.getTipo().equals("VHELETRONICO"))
		{
			DAOEletronico dao = new DAOEletronico();
			Resultado resultado = dao.visualizar(produto);
			Eletronico eletronico = (Eletronico) resultado.getListaResultado().get(0);
			Integer qtdeSolicitada = bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getQuantidade();
			
			if (eletronico.getEstoque() < qtdeSolicitada)
			{
				bloq.getCarrinho().getItensCarrinho().remove(bloq.getCarrinho().getItensCarrinho().size()-1);
				mensagem.append("Não há estoque suficiente para a compra.\n");
				return mensagem.toString();

			}
			else
			{
				eletronico.setEstoque(eletronico.getEstoque() - qtdeSolicitada);
				bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).setProduto(eletronico);
			}

		}
		
		else if (bloq.getTipo().equals("VHACESSORIO"))
		{
			DAOAcessorio dao = new DAOAcessorio();
			Resultado resultado = dao.visualizar(produto);
			Acessorio acessorio = (Acessorio) resultado.getListaResultado().get(0);
			Integer qtdeSolicitada = bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).getQuantidade();
			if (acessorio.getEstoque() < qtdeSolicitada)
			{
				bloq.getCarrinho().getItensCarrinho().remove(bloq.getCarrinho().getItensCarrinho().size()-1);
				mensagem.append("Não há estoque suficiente para a compra.\n");
				return mensagem.toString();
			}
			else
			{
				acessorio.setEstoque(acessorio.getEstoque() - qtdeSolicitada);
				bloq.getCarrinho().getItensCarrinho().get(bloq.getCarrinho().getItensCarrinho().size()-1).setProduto(acessorio);
			}

		}
		
		return null;
	}

}
