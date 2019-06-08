package br.com.les.viewhelper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		// TODO Auto-generated method stub

	}

}
