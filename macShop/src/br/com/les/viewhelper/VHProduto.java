package br.com.les.viewhelper;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Categoria;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class VHProduto implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		Eletronico eletronico = new Eletronico();

		
		eletronico.setAlimentacao(request.getParameter("txtAlimentacao"));
		eletronico.setCaminhoFoto(request.getParameter("txtFoto"));
		eletronico.setCategoria(request.getParameter("txtCategoria"));
		eletronico.setCodigoBarras(request.getParameter("txtCodBarras"));
		eletronico.setConteudoEmbalagem(request.getParameter("txtConteudoEmbalagem"));
		eletronico.setCor(request.getParameter("txtCor"));
		eletronico.setDimensoes(request.getParameter("txtDimensoes"));		
		eletronico.setDataaFabricacao(request.getParameter("txtAnoFabricacao"));	
		eletronico.setConteudoEmbalagem(request.getParameter("txtConteudoEmbalagem"));
		eletronico.setDescricao(String.valueOf(request.getParameter("txtDescricao")));
		eletronico.setMemoria(request.getParameter("txtMemoria"));
		eletronico.setModelo(request.getParameter("txtModelo"));
		eletronico.setId(Integer.parseInt(request.getParameter("txtID")));
		
		
		if(request.getParameter("txtPreco") != null)
		{
			try {
				eletronico.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		eletronico.setProcessador(request.getParameter("txtProcessador"));
		eletronico.setRAM(request.getParameter("txtRAM"));
		eletronico.setResolucaoCamera(request.getParameter("txtResolucaoCamera"));
		eletronico.setSistemaOperacional(request.getParameter("txtSO"));
		eletronico.setTamanhoDisplay(request.getParameter("txtTamanhoDisplay"));
		eletronico.setNome(request.getParameter("txtNome"));

		return eletronico;
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
				request.setAttribute("eletronico", (Eletronico) resultado.getListaResultado().get(0));
				request.setAttribute("categoria", (Categoria) resultado.getResultado());
			}
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

					request.setAttribute("resultado", resultado.getListaResultado());
					request.setAttribute("eletronico", (Eletronico) resultado.getListaResultado().get(0));


		}
		
		try {
			if(operacao.equals("SALVAR")){
			RequestDispatcher rd = request.getRequestDispatcher("cad-produto.jsp");
			rd.forward(request, response);
			}
			else if(operacao.equals("CONSULTAR")){			
					RequestDispatcher rd = request.getRequestDispatcher("consulta-prod.jsp");
					rd.forward(request, response);
			}
			else if(operacao.equals("VISUALIZAR")){

					RequestDispatcher rd = request.getRequestDispatcher("visualizar-prod.jsp");
					rd.forward(request, response);

			}
			else if(operacao.equals("INATIVAR")){
								
					RequestDispatcher rd = request.getRequestDispatcher("consulta-prod.jsp");
					rd.forward(request, response);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
