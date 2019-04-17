package br.com.les.viewhelper;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Categoria;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class VHProduto implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		if (request.getParameter("Tipo").equals("VHELETRONICO"))
		{
				Eletronico eletronico = new Eletronico();
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
				
				if(request.getParameter("txtEstoque") != null)
				{
					eletronico.setEstoque(Integer.parseInt(request.getParameter("txtEstoque")));
				}
				
				eletronico.setAlimentacao(request.getParameter("txtAlimentacao"));
				eletronico.setCaminhoFoto(request.getParameter("txtFoto"));
				eletronico.setCategoria(categoria);
				eletronico.setCodigoBarras(request.getParameter("txtCodBarras"));
				eletronico.setConteudoEmbalagem(request.getParameter("txtConteudoEmbalagem"));
				eletronico.setCor(request.getParameter("txtCor"));
				eletronico.setDimensoes(request.getParameter("txtDimensoes"));		
				eletronico.setDataaFabricacao(request.getParameter("txtAnoFabricacao"));	
				eletronico.setConteudoEmbalagem(request.getParameter("txtConteudoEmbalagem"));
				eletronico.setDescricao(String.valueOf(request.getParameter("txtDescricao")));
				eletronico.setMemoria(request.getParameter("txtMemoria"));
				eletronico.setModelo(request.getParameter("txtModelo"));
				
				if(request.getParameter("txtID") != null)
				{
					eletronico.setId(Integer.parseInt(request.getParameter("txtID")));
				}
				
				if(request.getParameter("txtStatus") != null)
				{
				
					eletronico.setAtivo(request.getParameter("txtStatus"));
				}
				
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
				eletronico.setTipo("VHELETRONICO");
				eletronico.setMotivo(request.getParameter("txtMotivo"));
				
				return eletronico;
		}
		else
		{
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
			
			if(request.getParameter("txtEstoque") != null)
			{
				acessorio.setEstoque(Integer.parseInt(request.getParameter("txtEstoque")));
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
			
			if(request.getParameter("txtID") != null)
			{
				acessorio.setId(Integer.parseInt(request.getParameter("txtID")));
			}
			
			if(request.getParameter("txtStatus") != null)
			{
			
				acessorio.setAtivo(request.getParameter("txtStatus"));
			}
					
			acessorio.setNome(request.getParameter("txtNome"));
			acessorio.setTipo("VHACESSORIO");
			acessorio.setMotivo(request.getParameter("txtMotivo"));
			return acessorio;
		}
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
				
				if (request.getParameter("Tipo").equals("VHELETRONICO"))
				{
					request.setAttribute("eletronico", (Eletronico) resultado.getListaResultado().get(0));
				}
				else
				{
					request.setAttribute("acessorio", (Acessorio) resultado.getListaResultado().get(0));
				}
				
				request.setAttribute("categoria", (Categoria) resultado.getResultado());
			}
			else
			{
				request.setAttribute("resultado", resultado.getCategoria());
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

			if (request.getParameter("Tipo").equals("VHELETRONICO"))
			{
				request.setAttribute("eletronico", (Eletronico) resultado.getListaResultado().get(0));
			}
			else
			{
				if (request.getParameter("direcionamento").equals("CATALOGO"))
				{
					request.setAttribute("eletronico", (Acessorio) resultado.getListaResultado().get(0));
				}
				else
					{
					request.setAttribute("acessorio", (Acessorio) resultado.getListaResultado().get(0));
					}
				
			}
			
			request.setAttribute("categoria", (Categoria) resultado.getResultado());
			

		}
		else if(operacao.equals("ALTERAR")){

			if (request.getParameter("Tipo").equals("VHELETRONICO"))
			{
				request.setAttribute("eletronico", (Eletronico) resultado.getListaResultado().get(0));
			}
			else
			{
				request.setAttribute("acessorio", (Acessorio) resultado.getListaResultado().get(0));
			}
			request.setAttribute("categoria", (Categoria) resultado.getResultado());
			


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
				if (request.getParameter("direcionamento").equals("CATALOGO"))
				{
					
						RequestDispatcher rd = request.getRequestDispatcher("product-detail.jsp");
						rd.forward(request, response);

				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("visualizar-prod.jsp");
					rd.forward(request, response);
				}
				

			}
			else if(operacao.equals("INATIVAR")){
								
					RequestDispatcher rd = request.getRequestDispatcher("consulta-prod.jsp");
					rd.forward(request, response);

			}
			else if(operacao.equals("ALTERAR")){
				
				
				if (request.getParameter("direcionamento").equals("Estoque"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("consulta-prod.jsp");
					rd.forward(request, response);
				}
				
				else {
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
