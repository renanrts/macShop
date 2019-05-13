package br.com.les.viewhelper;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.Categoria;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class VHBloqueio implements IViewHelper {

	private Carrinho carrinho;
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
			  
	    Bloqueio bloqueio = new Bloqueio();
	    
	    LocalDateTime horarioBloqueio = LocalDateTime.now();
	    
	    Produto produto = new Produto();
	    
	    VHProduto vh = new VHProduto();
	    
		if (request.getParameter("Tipo").equals("VHELETRONICO"))
		{

			produto = (Produto) vh.getEntidade(request);
			produto.setTipo("VHELETRONICO");
		}
		
		else if (request.getParameter("Tipo").equals("VHACESSORIO"))
		{
			produto = (Produto) vh.getEntidade(request);
			produto.setTipo("VHACESSORIO");
		}
		
	    int quantidade = Integer.parseInt(request.getParameter("quantidade"));
	    
	    double preco = Integer.parseInt(request.getParameter("preco"));
	    
	    produto.setPreco(preco);    

	    Carrinho carrinho = new Carrinho();
	    ItemCarrinho item = new ItemCarrinho();
	    ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<>();
	    
	    item.setProduto(produto);
	    item.setQuantidade(quantidade);
	    carrinho.setItensCarrinho(itensCarrinho);
	    carrinho.addItem(item);
	    
	    HttpSession sessaoUsuario = request.getSession();
	    bloqueio.setCarrinho(carrinho);
	    bloqueio.setTimeStamp(horarioBloqueio);
	    bloqueio.setSessao(sessaoUsuario);

		
		return bloqueio;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");		
		
		if(resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);
		
		if(operacao.equals("SALVAR")){
			carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
			
			if (request.getParameter("Tipo").equals("VHELETRONICO"))
			{
		
				request.setAttribute("eletronico", (Eletronico) carrinho.getItensCarrinho().get(carrinho.getItensCarrinho().size()-1).getProduto());
			}
			else
			{
				request.setAttribute("eletronico", (Acessorio) carrinho.getItensCarrinho().get(carrinho.getItensCarrinho().size()-1).getProduto());
			}
			request.setAttribute("categoria", (Categoria) resultado.getResultado());
		} else if(operacao.equals("CONSULTAR")){
			if(!resultado.getErro()){
				if(resultado.getResultado() != null){
					request.setAttribute("eletronico", (Eletronico) resultado.getResultado());
					request.setAttribute("categoria", (Categoria) resultado.getResultado());
				}else{
					request.setAttribute("resultado", resultado.getListaResultado());
				}
			}
		}
		else if(operacao.equals("VISUALIZAR")){

			if (request.getParameter("Tipo").equals("VHELETRONICO"))
			{
				request.setAttribute("eletronico", (Eletronico) resultado.getListaResultado().get(0));
			}
			else
			{
				request.setAttribute("eletronico", (Acessorio) resultado.getListaResultado().get(0));
			}
			
			request.setAttribute("categoria", (Categoria) resultado.getResultado());
			

		}
		else if(operacao.equals("ALTERAR")){
			
			carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
			
			if (request.getParameter("Tipo").equals("VHELETRONICO"))
			{
		
				request.setAttribute("teste", (Eletronico) carrinho.getItensCarrinho().get(carrinho.getItensCarrinho().size()-1).getProduto());
			}
			else
			{
				request.setAttribute("teste", (Acessorio) carrinho.getItensCarrinho().get(carrinho.getItensCarrinho().size()-1).getProduto());
			}
			request.setAttribute("categoria", (Categoria) resultado.getResultado());
			


}
		
		try {
			if(operacao.equals("SALVAR")){
			RequestDispatcher rd = request.getRequestDispatcher("product-detail.jsp");
			rd.forward(request, response);
			}
			else if(operacao.equals("CONSULTAR")){			
					RequestDispatcher rd = request.getRequestDispatcher("product-detail.jsp");
					rd.forward(request, response);
			}
			else if(operacao.equals("VISUALIZAR")){
				if (request.getParameter("direcionamento").equals("CATALOGO"))
				{
					
						RequestDispatcher rd = request.getRequestDispatcher("product-detail.jsp");
						rd.forward(request, response);

				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("product-detail.jsp");
					rd.forward(request, response);
				}
				

			}
			else if(operacao.equals("INATIVAR")){
								
					RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
					rd.forward(request, response);

			}
			else if(operacao.equals("ALTERAR")){
				

					RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
					rd.forward(request, response);

				

		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}

}
