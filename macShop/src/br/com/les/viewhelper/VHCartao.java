package br.com.les.viewhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class VHCartao implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		CartaoCredito cartao = new CartaoCredito();

		cartao.setBandeira(request.getParameter("txtBandeira"));
		cartao.setCodSeguranca(request.getParameter("txtCodSeguranca"));

		if (request.getParameter("txtCartaoID") != null) {
			cartao.setId(Integer.parseInt(request.getParameter("txtCartaoID")));
		}
		cartao.setNome(request.getParameter("txtNomeCartao"));
		cartao.setNumero(request.getParameter("txtNumeroCartao"));
		cartao.setPreferencial(true);

		String strDataVencimento = null != request.getParameter("txtDataVencimento")
				&& !"".equals(request.getParameter("txtDataVencimento")) ? request.getParameter("txtDataVencimento")
						: "1800-01-01";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dataVencimento = LocalDate.parse(strDataVencimento, formatter);
		cartao.setDtVenciamento(dataVencimento);
		
		if(request.getParameter("txtCliID") != null){
			cartao.setCliId(Integer.parseInt(request.getParameter("txtCliID")));
		}	
				
		return cartao;

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
				RequestDispatcher rd = request.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&txtID=10&Direcionamento=PAGAMENTO");
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
				RequestDispatcher rd = request.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&txtID=10&Direcionamento=DADOS");
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
