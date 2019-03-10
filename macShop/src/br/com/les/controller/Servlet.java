package br.com.les.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.command.CmdConsultar;
import br.com.les.command.CmdSalvar;
import br.com.les.command.ICommand;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;
import br.com.les.viewhelper.IViewHelper;
import br.com.les.viewhelper.VHAcessorio;
import br.com.les.viewhelper.VHCategoria;
import br.com.les.viewhelper.VHEletronico;



@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/Pages/servlet", "/Pages/consultaCategoria", "/Pages/cadastroEletronico", "/Pages/cadastroAcessorio", "/Pages/consultaProdutos" })
public class Servlet extends HttpServlet{
	
	 
		private Map<String, ICommand> mapCommand;
		private Map<String, IViewHelper> mapViewHelper;
		
		
		public Servlet(){
			
			mapCommand = new HashMap<String, ICommand>();
			mapViewHelper = new HashMap<String, IViewHelper>();
	
			mapCommand.put("SALVAR", new CmdSalvar());
			mapCommand.put("CONSULTAR", new CmdConsultar());
			
			mapViewHelper.put("/macShop/Pages/cadastroEletronico", new VHEletronico());
			mapViewHelper.put("/macShop/Pages/consultaProdutos", new VHEletronico());
			mapViewHelper.put("/macShop/Pages/cadastroAcessorio", new VHAcessorio());
			mapViewHelper.put("/macShop/Pages/consultaCategoria", new VHCategoria());

		}
		
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) {
		
			String uri = request.getRequestURI();
			String operacao = request.getParameter("btnOperacao");

			ICommand command = mapCommand.get(operacao);
			
	 		IViewHelper viewHelper = mapViewHelper.get(uri);
	 			 		
			EntidadeDominio entidade = viewHelper.getEntidade(request);

			Resultado resultado = command.executar(entidade);
			
			viewHelper.setView(resultado, request, response);
		}

}
