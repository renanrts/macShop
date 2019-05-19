package br.com.les.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;

public class StValidarQuantidadeAIncluirOuExcluirCarrinho implements IStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public String processar(EntidadeDominio entidade) {
		
		 String mensagem = "";
		    Bloqueio produtosBloqueados = (Bloqueio) entidade;
		    Carrinho carrinho = produtosBloqueados.getCarrinho();
		    ArrayList<ItemCarrinho> itensCarrinho = carrinho.getItensCarrinho();
		    Integer indexUltimoProdutoAdicionado = itensCarrinho.size() - 1;
		    Produto produtoASerInserido = itensCarrinho
		        .get(indexUltimoProdutoAdicionado).getProduto();
		    // Armazena a quantidade a ser removida ou inserida
		    Integer quantidade = 1;
		    HttpSession sessaoUsuario = produtosBloqueados.getSessao();
		    
		    Integer quantidadeDeItensBloqueados = 0;
		    HashMap<String, Bloqueio> mapProdutosBloqueados;
		    mapProdutosBloqueados = (HashMap<String, Bloqueio>) sessaoUsuario.getServletContext()
		        .getAttribute("bloqueio");
		    
		    for(Map.Entry<String, Bloqueio> entry : mapProdutosBloqueados.entrySet()) {
		      
		      Bloqueio bloqueioCarrinho = (Bloqueio) entry.getValue();
		       
		      for(int i = 0; i < bloqueioCarrinho.getCarrinho().getItensCarrinho().size(); i++) {
		         ItemCarrinho itemBloqueado = bloqueioCarrinho.getCarrinho().getItensCarrinho().get(i);
		         if(itemBloqueado.getProduto().getId().equals(produtoASerInserido.getId())) {
		           quantidadeDeItensBloqueados += itemBloqueado.getQuantidade();
		         }  
		       }
		    }
		    
		    
		      IStrategy validarQuantidadeDisonivel = new StConsultarQuantidadeEstoque();
		      mensagem = validarQuantidadeDisonivel.processar(entidade);
		      
		      
		      if(!"".equals(mensagem)) {
		        return mensagem;
		      }     

		    
		    if ((quantidadeDeItensBloqueados - quantidade) < 0 ) {
		      mensagem = "A quantidade de ser maior ou igual a zero";
		      
		    }  
		    
		    return mensagem;
		
	}

}
