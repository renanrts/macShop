package br.com.les.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.command.CmdAlterar;
import br.com.les.command.CmdConsultar;
import br.com.les.command.CmdInativar;
import br.com.les.command.CmdSalvar;
import br.com.les.command.CmdVisualizar;
import br.com.les.command.ICommand;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;
import br.com.les.viewhelper.IViewHelper;
import br.com.les.viewhelper.VHAcessorio;
import br.com.les.viewhelper.VHCategoria;
import br.com.les.viewhelper.VHCliente;
import br.com.les.viewhelper.VHEletronico;
import br.com.les.viewhelper.VHProduto;



@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/Pages/servlet", "/Pages/consultaCategoria", "/Pages/cadastroEletronico", "/Pages/cadastroAcessorio", "/Pages/consultaProdutos" , "/Pages/visualizarProduto", "/Pages/inativarProduto", "/Pages/alterarEletronico", "/Pages/cadastrarAcessorio", "/Pages/cadastroCliente"})
public class Servlet extends HttpServlet{
	
	 
		private Map<String, ICommand> mapCommand;
		private Map<String, IViewHelper> mapViewHelper;
		
		
		public Servlet(){
			
			mapCommand = new HashMap<String, ICommand>();
			mapViewHelper = new HashMap<String, IViewHelper>();
	
			mapCommand.put("SALVAR", new CmdSalvar());
			mapCommand.put("CONSULTAR", new CmdConsultar());
			mapCommand.put("VISUALIZAR", new CmdVisualizar());
			mapCommand.put("INATIVAR", new CmdInativar());
			mapCommand.put("ALTERAR", new CmdAlterar());
			
			mapViewHelper.put("VHELETRONICO", new VHEletronico());
			mapViewHelper.put("VHCATEGORIA", new VHCategoria());
			mapViewHelper.put("VHPRODUTO", new VHProduto());
			mapViewHelper.put("VHACESSORIO", new VHAcessorio());
			mapViewHelper.put("VHCLIENTE", new VHCliente());
			

		}
		
		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) {
			
			String operacao = request.getParameter("btnOperacao");
			ICommand command = mapCommand.get(operacao);
			
			String formName = request.getParameter("FormName");
	 		IViewHelper viewHelper = mapViewHelper.get(formName);
	 			 		
			EntidadeDominio entidade = viewHelper.getEntidade(request);
			
			String nmClasse = entidade.getClass().getSimpleName().toUpperCase();
			System.out.println(nmClasse);

			Resultado resultado = command.executar(entidade);
			
			viewHelper.setView(resultado, request, response);
		}

}
