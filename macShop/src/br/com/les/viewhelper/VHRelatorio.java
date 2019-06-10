package br.com.les.viewhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Relatorio;
import br.com.les.util.Resultado;

public class VHRelatorio implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		Relatorio rel = new Relatorio();
		
		 String strDataInicio = null != request.getParameter("txtDataInicio") && 
			        !"".equals(request.getParameter("txtDataInicio")) 
			        ? request.getParameter("txtDataInicio") : "1800-01-01";

	
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dataInicio = LocalDate.parse(strDataInicio,formatter);
			rel.setDataInicio(dataInicio);
		
			 String strDataFim = null != request.getParameter("txtDataFim") && 
				        !"".equals(request.getParameter("txtDataFim")) 
				        ? request.getParameter("txtDataFim") : "1800-01-01";

		
			    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate dataFim = LocalDate.parse(strDataFim,format);
				rel.setDataFim(dataFim);
				
		return rel;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		if (resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);

		if (operacao.equals("CONSULTAR")) {
			request.setAttribute("quantidade", resultado.getQtdeRelatorio());
			RequestDispatcher rd = request.getRequestDispatcher("relatorio.jsp");
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
