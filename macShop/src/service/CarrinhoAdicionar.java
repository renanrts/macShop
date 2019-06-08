package service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class CarrinhoAdicionar implements IServico {

	@Override
	public Resultado executarServico(EntidadeDominio e) {
		Resultado resultado = new Resultado(); 
	    Bloqueio produtoBloqueado = (Bloqueio) e;  
	    
	    // Apenas um item é adicionado por vez (index sempre será 0)
	    ItemCarrinho itemBloqueado = produtoBloqueado.getCarrinho().getItensCarrinho().get(0);
	    Produto produto = itemBloqueado.getProduto();
	    Integer idProduto = produto.getId();    
	    HttpSession sessaoUsuario = produtoBloqueado.getSessao();
	    Carrinho carrinhoSessao = (Carrinho) sessaoUsuario.getAttribute("carrinho");
	    ArrayList<ItemCarrinho> itensCarrinhoSessao = carrinhoSessao.getItensCarrinho();
	    Integer quantidadeReservados = 0;

	    for (int i= 0; i < carrinhoSessao.getItensCarrinho().size();i++) {
	      Produto produtoSessao = carrinhoSessao
	          .getItensCarrinho()
	          .get(i).getProduto();
	      // Armazenar a quantidade atual de um determinado produto
	      if(produtoSessao.getId().equals(produto.getId())) {
	        quantidadeReservados = carrinhoSessao
	            .getItensCarrinho()
	            .get(i).getQuantidade();
	      }      
	    }
	    Integer totalDeProdutosAInserir = quantidadeReservados + itemBloqueado.getQuantidade();
	    
	  boolean contemProduto = false; 
	  
	    for ( int i = 0; i < itensCarrinhoSessao.size(); i++) {
	      Produto prod = itensCarrinhoSessao.get(i).getProduto();
	      if(prod.getId().equals(idProduto)) {
	        
	        itensCarrinhoSessao.get(i).setQuantidade(totalDeProdutosAInserir);
	    
	        contemProduto = true;
	        break;
	      }    
	    }
	  
	    if (!contemProduto) {
	      ItemCarrinho item = new ItemCarrinho();
	      
	      item.setProduto(produto);
	      item.setQuantidade(totalDeProdutosAInserir);
	          
	      carrinhoSessao.addItem(item);     
	    }

	    
	    Integer quantidadeDeItensBloqueados = 0;
	    
	    // Conta total de produtos no carrinho
	    for(int i = 0; i < itensCarrinhoSessao.size(); i++) {
	       ItemCarrinho item = itensCarrinhoSessao.get(i);
	       quantidadeDeItensBloqueados += item.getQuantidade();  
	    }
	    
	    carrinhoSessao.setQuantidadeProdutos(quantidadeDeItensBloqueados);
	    
	    sessaoUsuario.setAttribute("carrinho", carrinhoSessao);
	    
	    HashMap<String, Bloqueio> mapProdutosBloqueados;
	    mapProdutosBloqueados = (HashMap<String, Bloqueio>) sessaoUsuario.getServletContext()
	        .getAttribute("bloqueio");
	    
	    produtoBloqueado.setCarrinho(carrinhoSessao);
	    
	    // Atualiza de lista de produtos bloqueados ( todos os usuários )
	    mapProdutosBloqueados.put(sessaoUsuario.getId(), produtoBloqueado);

	    
	    resultado.setResultado(produto);
	    resultado.sucesso("Produto inserido com sucesso");
	    
	    return resultado;
	}

}
