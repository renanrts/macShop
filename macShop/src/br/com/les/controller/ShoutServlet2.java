package br.com.les.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.viewhelper.VHBaseCadastro;



@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/Pages/contact.jsp"})
public class ShoutServlet2 extends HttpServlet{
		
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			VHBaseCadastro viewHelper = new VHBaseCadastro();
			
			EntidadeDominio baseCadastro = viewHelper.getEntidade(request);
	
			request.setAttribute("baseCadastro", baseCadastro);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Pages/cad-cliente.jsp");
			
		    rd.forward(request, response);
		
		}

}
