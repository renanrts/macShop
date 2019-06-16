package br.com.les.viewhelper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Cidade;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Estado;
import br.com.les.util.Resultado;

public class VHEndereco implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		Endereco enderecoEntrega = new Endereco();
		Cidade cidadeEntrega  = new Cidade();
		Estado estadoEntrega  = new Estado();
		
		if(request.getParameter("txtEstadoEntrega") != null)
		{
			estadoEntrega.setId(Integer.parseInt(request.getParameter("txtEstadoEntrega")));
		}
		if(request.getParameter("txtCidadeEntrega") != null)
		{
			cidadeEntrega.setId(Integer.parseInt(request.getParameter("txtCidadeEntrega")));
		}
		cidadeEntrega.setEstado(estadoEntrega);
		
		enderecoEntrega.setCidade(cidadeEntrega);
		enderecoEntrega.setTipoEndereco(request.getParameter("txtTipoEnderecoEntrega"));
		enderecoEntrega.setTipo("ENDERECO ENTREGA");
		enderecoEntrega.setCep(request.getParameter("txtCEPEntrega"));
		enderecoEntrega.setLogradouro(request.getParameter("txtLogradouroEntrega"));
		enderecoEntrega.setTipoLogradouro(request.getParameter("txtTiposLogradouroEntrega"));
		enderecoEntrega.setNumero(request.getParameter("txtNumeroEntrega"));
		enderecoEntrega.setObservacao(request.getParameter("txtObservacaoEntrega"));
		enderecoEntrega.setBairro(request.getParameter("txtBairroEntrega"));
		
		if (request.getSession().getAttribute("idUsuario") != null)
		{
			int userid = Integer.parseInt(String.valueOf(request.getSession().getAttribute("idUsuario")));
			enderecoEntrega.setCliId(userid);
		}

		return enderecoEntrega;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");		
		
		if(resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);
		
		if(operacao.equals("SALVAR")){	
			if(request.getParameter("Direcionamento").equals("COMPRA"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=PAGAMENTO");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				
			{
				RequestDispatcher rd = request.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=DADOS");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
