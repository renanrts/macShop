package br.com.les.negocio;

import java.util.ArrayList;

import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;

//Validar se existe o carrinho na sessao
public class StValidarExistenciaCarrinhoSessao implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Bloqueio bloqueio = (Bloqueio) entidade;
	    
	    if (bloqueio.getSessao().getAttribute("carrinho") == null) {
	      Carrinho novoCarrinho = new Carrinho();
	      ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<>();
	      novoCarrinho.setItensCarrinho(itensCarrinho);
	      novoCarrinho.setStatus(true);      
	      bloqueio.getSessao().setAttribute("carrinho", novoCarrinho); 
	    }
	    
	    return null;
	    
	}

}
