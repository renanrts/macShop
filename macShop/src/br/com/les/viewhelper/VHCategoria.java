package br.com.les.viewhelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Categoria;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class VHCategoria implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Categoria categoria = new Categoria();
		categoria.setDescricao(request.getParameter("txtCategoria"));
		
		return categoria;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");		
		
		if(resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);
		
	if(operacao.equals("CONSULTAR")){
			if(!resultado.getErro()){
				if(resultado.getResultado() != null){
					request.setAttribute("categoria", (Categoria) resultado.getResultado());
				}else{
					request.setAttribute("resultado", resultado.getListaResultado());
				}
			}
		}
		try {
			if(operacao.equals("CONSULTAR")){
				if(resultado.getResultado() != null){					
					RequestDispatcher rd = request.getRequestDispatcher("cad-produto.jsp");
					rd.forward(request, response);
				} else if(resultado.getListaResultado() != null){
					RequestDispatcher rd = request.getRequestDispatcher("cad-produto.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("cad-produto.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
