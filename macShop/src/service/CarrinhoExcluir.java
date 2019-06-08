package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class CarrinhoExcluir implements IServico {

	@Override
	public Resultado executarServico(EntidadeDominio e) {
		 Resultado resultado = new Resultado();
		    Bloqueio produtosBloqueados = (Bloqueio) e;
		    
		    ArrayList<ItemCarrinho> itensCarrinho = produtosBloqueados.getCarrinho().getItensCarrinho();
		    // Para guardar quantidade de itens a serem devolvidos para o estoque
		    HttpSession sessaoUsuario = produtosBloqueados.getSessao();
		    Carrinho carrinhoSessao = (Carrinho) sessaoUsuario.getAttribute("carrinho");
		    ArrayList<ItemCarrinho> itensCarrinhoSessao = carrinhoSessao.getItensCarrinho();
		    Integer idProduto = itensCarrinho.get(0).getProduto().getId();
		    Produto produto = itensCarrinho.get(0).getProduto();

		    
		    for (int i = 0; i< itensCarrinhoSessao.size(); i++) {
		       ItemCarrinho item = itensCarrinho.get(i);
		      
		       if(item.getProduto().getId().equals(idProduto)) {
		        itensCarrinhoSessao.remove(i);        
		      }      
		    }
		    
		    HashMap<String, Bloqueio> mapProdutosBloqueados;
		    mapProdutosBloqueados = (HashMap<String, Bloqueio>) sessaoUsuario.getServletContext()
		        .getAttribute("bloqueio");
		    
		    sessaoUsuario.setAttribute("carrinho", carrinhoSessao);
		    produtosBloqueados.setTimeStamp(LocalDateTime.now());    
		    produtosBloqueados.setCarrinho(carrinhoSessao);
		    mapProdutosBloqueados.put(sessaoUsuario.getId(), produtosBloqueados);
		    System.out.println("Carrinho excluir");
		    resultado.setResultado(produto);
		    resultado.sucesso("Excluído com sucesso");
		    return resultado;
	}

}
