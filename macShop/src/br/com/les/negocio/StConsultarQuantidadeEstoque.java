package br.com.les.negocio;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOEletronico;
import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class StConsultarQuantidadeEstoque implements IStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public String processar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		String mensagem = "";
	    Bloqueio produtoBloqueado = (Bloqueio) entidade;
	    Carrinho carrinho = produtoBloqueado.getCarrinho();
	    
	    // Index do último produto adicionado
	    ItemCarrinho itemCarrinho = carrinho.getItensCarrinho().get(0);
	    HttpSession sessaoUsuario = produtoBloqueado.getSessao();
	    
	    Produto produto = itemCarrinho.getProduto();
	    
	    Integer quantidadeAInserir = 1; 
	    
	    if (produtoBloqueado.getCarrinho().getItensCarrinho().get(0).getProduto().getTipo().equals("VHELETRONICO"))
		{
		    DAOEletronico daoEletronico = new DAOEletronico();
		    resultado = daoEletronico.visualizar(produto);
		    
		}
	    
	    else
	  		{
	  		    DAOAcessorio daoAcessorio = new DAOAcessorio();
	  		    resultado = daoAcessorio.visualizar(produto);
	  		    
	  		}
	    

	    Integer quantidadeDeItensBloqueados = 0;
	    HashMap<String, Bloqueio> mapProdutosBloqueados;
	    mapProdutosBloqueados = (HashMap<String, Bloqueio>) sessaoUsuario.getServletContext()
	        .getAttribute("bloqueio");
	    
	    // Conta a quantidade de itens bloqueados com o id do produto adicionado
	    for(Map.Entry<String, Bloqueio> entry : mapProdutosBloqueados.entrySet()) {
	      
	      Bloqueio bloqueioCarrinho = (Bloqueio) entry.getValue();
	       
	      for(int i = 0; i < bloqueioCarrinho.getCarrinho().getItensCarrinho().size(); i++) {
	         ItemCarrinho itemBloqueado = bloqueioCarrinho.getCarrinho().getItensCarrinho().get(i);
	         if(itemBloqueado.getProduto().getId().equals(produto.getId())) {
	           quantidadeDeItensBloqueados += itemBloqueado.getQuantidade();
	         }  
	       }
	    }
	    
	    Integer quantidadeEmEstoque  = 0 ;
	    if (produtoBloqueado.getCarrinho().getItensCarrinho().get(0).getProduto().getTipo().equals("VHELETRONICO"))
		{
	    	Eletronico estoque = (Eletronico) resultado.getListaResultado().get(0);
	    	quantidadeEmEstoque = estoque.getEstoque();
		}
	    
	    else
	    {
	    	Acessorio estoque = (Acessorio) resultado.getListaResultado().get(0);
	    	quantidadeEmEstoque = estoque.getEstoque();
	    }
	 

	    Integer quantidadeDisponivel = quantidadeEmEstoque - quantidadeDeItensBloqueados ;
	   
	    if(quantidadeAInserir > quantidadeDisponivel) {
	      Integer idProduto = itemCarrinho.getProduto().getId();
	      mensagem = "Não há itens suficiente em estoque."
	          + "Você solicitou " +  quantidadeAInserir +
	          ", mas nós só temos " + quantidadeDisponivel + " :(";
	      carrinho.removeItem(idProduto); 
	      resultado.erro(mensagem); 
	      return mensagem;
	    }
	    
	    resultado.setResultado(carrinho);
	   return null;
	    
	}

}
