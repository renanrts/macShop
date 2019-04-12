package br.com.les.viewhelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Categoria;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class VHAcessorio implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Acessorio acessorio = new Acessorio();
		Categoria categoria = new Categoria();
		
		if(request.getParameter("txtCategoria") != null)
		{
			try {
				categoria.setId(Integer.parseInt(request.getParameter("txtCategoria")));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("txtStatus") != null)
		{
		
			acessorio.setAtivo(request.getParameter("txtStatus"));
		}
		
	
		acessorio.setCaminhoFoto(request.getParameter("txtFoto"));
		acessorio.setCategoria(categoria);
		acessorio.setCodigoBarras(request.getParameter("txtCodBarras"));
		acessorio.setCor(request.getParameter("txtCor"));
		acessorio.setDimensoes(request.getParameter("txtDimensoes"));		
		acessorio.setDataaFabricacao(request.getParameter("txtAnoFabricacao"));	
		acessorio.setModeloCompativel(request.getParameter("txtModeloCompativel"));
		acessorio.setDescricao(String.valueOf(request.getParameter("txtDescricao")));
		
		if(request.getParameter("txtMFI") != null)
		{
			if (request.getParameter("txtMFI").equals("Ativo"))
			{
				acessorio.setSeloMfi(true);
			}
		}
		
		if(request.getParameter("txtPreco") != null)
		{
			try {
				acessorio.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		acessorio.setNome(request.getParameter("txtNome"));
		acessorio.setTipo("VHACESSORIO");
		return acessorio;
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
			if(resultado.getErro()){
				request.setAttribute("acessorio", (Acessorio) resultado.getListaResultado().get(0));
			}
			else
			{
				request.setAttribute("resultado", resultado.getCategoria());
			}
		} else if(operacao.equals("CONSULTAR")){
			if(!resultado.getErro()){
				if(resultado.getResultado() != null){
					request.setAttribute("eletronico", (Acessorio) resultado.getResultado());
					request.setAttribute("categoria", (Categoria) resultado.getResultado());
				}else{
					request.setAttribute("resultado", resultado.getListaResultado());
				}
			}
		}
		else if(operacao.equals("VISUALIZAR")){
			if(!resultado.getErro()){
				if(resultado.getResultado() != null){
					request.setAttribute("acessorio", (Acessorio) resultado.getResultado());
		
				}else{
					request.setAttribute("resultado", resultado.getListaResultado());
				}
			}
		}
		
		try {
			if(operacao.equals("SALVAR")){
			RequestDispatcher rd = request.getRequestDispatcher("cad-produto.jsp");
			rd.forward(request, response);
			}
			else if(operacao.equals("CONSULTAR")){
				
				if (request.getParameter("direcionamento").equals("CATALOGO"))
				{
					if(resultado.getResultado() != null){					
						RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
						rd.forward(request, response);
					} else if(resultado.getListaResultado() != null){
						RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
						rd.forward(request, response);
					}
				}
				else {
					if(resultado.getResultado() != null){					
						RequestDispatcher rd = request.getRequestDispatcher("visualizar-prod.jsp");
						rd.forward(request, response);
					} else if(resultado.getListaResultado() != null){
						RequestDispatcher rd = request.getRequestDispatcher("consulta-prod.jsp");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("consulta-prod.jsp");
						rd.forward(request, response);
					}
				}
			
			}
			else if(operacao.equals("VISUALIZAR")){
				if(resultado.getResultado() != null){					
					RequestDispatcher rd = request.getRequestDispatcher("visualizar-prod.jsp");
					rd.forward(request, response);
				} else if(resultado.getListaResultado() != null){
					RequestDispatcher rd = request.getRequestDispatcher("visualizar-prod.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("visualizar-prod.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
