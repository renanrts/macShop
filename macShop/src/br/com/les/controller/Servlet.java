package br.com.les.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import br.com.les.command.CmdAlterar;
import br.com.les.command.CmdConsultar;
import br.com.les.command.CmdInativar;
import br.com.les.command.CmdSalvar;
import br.com.les.command.CmdVisualizar;
import br.com.les.command.CommandCarrinhoAdicionar;
import br.com.les.command.ICommand;
import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOEletronico;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;
import br.com.les.negocio.StAprovarOuReprovarCompra;
import br.com.les.negocio.StValidarItensCarrinhoComTempoExpirado;
import br.com.les.util.Resultado;
import br.com.les.viewhelper.IViewHelper;
import br.com.les.viewhelper.VHAcessorio;
import br.com.les.viewhelper.VHBloqueio;
import br.com.les.viewhelper.VHCategoria;
import br.com.les.viewhelper.VHCliente;
import br.com.les.viewhelper.VHEletronico;
import br.com.les.viewhelper.VHPedido;
import br.com.les.viewhelper.VHProduto;



@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/Pages/servlet", "/Pages/consultaCategoria", "/Pages/cadastroEletronico", "/Pages/cadastroAcessorio", "/Pages/consultaProdutos" , "/Pages/visualizarProduto", "/Pages/inativarProduto", "/Pages/alterarEletronico", "/Pages/cadastrarAcessorio", "/Pages/cadastroCliente", "/Pages/contact", "/Pages/alteracaoCliente", "/Pages/product", "/Pages/product-detail", "/Pages/carrinho", "/Pages/pedido", "/Pages/orders"})
public class Servlet extends HttpServlet implements ServletContextListener{
	
	 
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
			mapCommand.put("CARRINHOADICIONAR", new CommandCarrinhoAdicionar());
			
			
			mapViewHelper.put("VHELETRONICO", new VHEletronico());
			mapViewHelper.put("VHCATEGORIA", new VHCategoria());
			mapViewHelper.put("VHPRODUTO", new VHProduto());
			mapViewHelper.put("VHACESSORIO", new VHAcessorio());
			mapViewHelper.put("VHCLIENTE", new VHCliente());
			mapViewHelper.put("VHBLOQUEIO", new VHBloqueio());
			mapViewHelper.put("VHPEDIDO", new VHPedido());
			


		}
		

		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
			
			request.setCharacterEncoding("UTF-8");
			
			
			if (request.getParameter("qtdeComprada") != null)
			{
				int quantidade = Integer.parseInt(request.getParameter("qtdeComprada"));
				System.out.println(quantidade);
			}
		    
		   
			if(getServletContext().getAttribute("bloqueio") == null)
			{
				HashMap<String, Carrinho> mapProdutosBloqueados = new HashMap<>();
				getServletContext().setAttribute("bloqueio", mapProdutosBloqueados);
			}
			
			String operacao = request.getParameter("btnOperacao");
			ICommand command = mapCommand.get(operacao);
			
			String formName = request.getParameter("FormName");
	 		IViewHelper viewHelper = mapViewHelper.get(formName);
	 			 		
			EntidadeDominio entidade = viewHelper.getEntidade(request);
			

			Resultado resultado = command.executar(entidade);
			
			viewHelper.setView(resultado, request, response);
		}
		
		@Override
		  public void init() {
		    System.out.println("contextInitialized");

		    HashMap<String, Bloqueio> mapProdutosBloqueados = new HashMap<>();     
		    getServletContext().setAttribute("bloqueio", mapProdutosBloqueados);


		    HashMap<String, Carrinho> mapProdutosDesbloqueados = new HashMap<>();     
		    getServletContext().setAttribute("desbloqueio", mapProdutosDesbloqueados);

		    SchedulerFactory shedFact = new StdSchedulerFactory();
		    try {
		           Scheduler scheduler = shedFact.getScheduler();
		           scheduler.start();
		         JobDataMap jobDataMap = new JobDataMap();
		         jobDataMap.put("servletContext", getServletContext());
		           JobDetail job = JobBuilder.newJob(StValidarItensCarrinhoComTempoExpirado.class)
		                         .withIdentity("validadorJOB", "grupo01")
		                         .usingJobData(jobDataMap)
		                         .build();
		           
		          JobDetail jobAprovarOuReprovarCompra = JobBuilder.newJob(StAprovarOuReprovarCompra.class)
		                                                .withIdentity("validadorOperadora", "grupo01")
		                                                .usingJobData(jobDataMap)
		                                                .build();
		           Trigger trigger = TriggerBuilder.newTrigger()
		                         .withIdentity("validadorTRIGGER","grupo01")
		                         .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
		                         .build();
		           scheduler.scheduleJob(job, trigger);
		           
		  } catch (SchedulerException e) {
		      e.printStackTrace();
		  }
		      
		      
		    
		  }
		
		
}
