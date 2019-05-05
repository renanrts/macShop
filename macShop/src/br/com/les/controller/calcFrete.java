package br.com.les.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/Pages/calcFrete"})

public class calcFrete extends HttpServlet{
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cep = request.getParameter("cep");
		Double numero = 0.0;
		cep.trim().replace("-", "");
		for(char c: cep.toCharArray())
		{
			numero += Character.getNumericValue(c);
		}

		request.getSession().setAttribute("frete", numero);
		request.getSession().setAttribute("cep", cep);
		
	}

}
