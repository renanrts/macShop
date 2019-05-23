package br.com.les.negocio;

import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;

public class StValidarCarrinhoExpirado implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
	    mensagem.append("");
	    Pedido pedido = (Pedido) entidade;
	    Carrinho carrinho = pedido.getCarrinho();
	    if(null == carrinho) {
	      mensagem.append("Pedido expirado por tempo excedido, coloque os itens no carrinho novamente.");
	           
	    } else if(!carrinho.isStatus()) {
	      if(null !=  carrinho.getItensCarrinho()) {
	        mensagem.append("Pedido expirado por tempo excedido,");
	        mensagem.append("os seguintes itens foram retirados do carrinho: ;");
	        
	        for(int i = 0; i < carrinho.getItensCarrinho().size(); i++) {
	          Produto produto = (Produto) carrinho.getItensCarrinho().get(i).getProduto();
	          mensagem.append("- ");
	          mensagem.append(produto.getNome());
	          mensagem.append("\n");
	        }
	      } 
	    }
	    
	    return mensagem.toString();
	}

}
