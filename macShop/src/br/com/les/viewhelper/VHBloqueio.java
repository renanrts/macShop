package br.com.les.viewhelper;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
			  
			  if (null == carrinho ) {
			    
			    Carrinho carrinho = new Carrinho();
			    ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<>();
			    carrinho.setItensCarrinho(itensCarrinho);
			    this.carrinho = carrinho;
			  }
			  
			  if(request.getAttribute("carrinho") !=  null)
			  {
				  carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
			  } else {
				  request.getSession().setAttribute("carrinho", carrinho);
			  }

		Bloqueio bloqueio = new Bloqueio();
		LocalDate horario = LocalDate.now();
		VHProduto vh = new VHProduto();
		Produto produto = new Produto();
		ItemCarrinho itemCarrinho = new ItemCarrinho();
		bloqueio.setTipo(request.getParameter("Tipo"));
		
	
		if (request.getParameter("Tipo").equals("VHELETRONICO"))
		{

			produto = (Produto) vh.getEntidade(request);
		}
		
		else if (request.getParameter("Tipo").equals("VHACESSORIO"))
		{
			produto = (Produto) vh.getEntidade(request);
		}
		
		itemCarrinho.setProduto(produto);
		
		if (request.getParameter("qtdeComprada") != null)
			{
			itemCarrinho.setQuantidade(Integer.parseInt(request.getParameter("qtdeComprada")));
			}
		
		
		this.carrinho.getItensCarrinho().add(itemCarrinho);

		
		bloqueio.setTimeStamp(horario);
		bloqueio.setCarrinho(carrinho);
		bloqueio.setSessao(request.getSession());
		
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
		
				request.setAttribute("eletronico", (Eletronico) carrinho.getItensCarrinho().get(carrinho.getItensCarrinho().size()-1).getProduto());
			}
			else
			{
				request.setAttribute("eletronico", (Acessorio) carrinho.getItensCarrinho().get(carrinho.getItensCarrinho().size()-1).getProduto());
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
				
				
				RequestDispatcher rd = request.getRequestDispatcher("product-detail.jsp");
				rd.forward(request, response);
				
				

		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}

}
