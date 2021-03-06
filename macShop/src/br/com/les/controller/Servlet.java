package br.com.les.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

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
import br.com.les.command.CommandCarrinhoAlterar;
import br.com.les.command.CmdConsultar;
import br.com.les.command.CmdInativar;
import br.com.les.command.CmdSalvar;
import br.com.les.command.CmdVisualizar;
import br.com.les.command.CommandCarrinhoAdicionar;
import br.com.les.command.CommandCarrinhoExcluir;
import br.com.les.command.ICommand;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.negocio.StValidarItensCarrinhoComTempoExpirado;
import br.com.les.util.Resultado;
import br.com.les.viewhelper.IViewHelper;
import br.com.les.viewhelper.VHAcessorio;
import br.com.les.viewhelper.VHBloqueio;
import br.com.les.viewhelper.VHCartao;
import br.com.les.viewhelper.VHCategoria;
import br.com.les.viewhelper.VHCliente;
import br.com.les.viewhelper.VHCupom;
import br.com.les.viewhelper.VHEletronico;
import br.com.les.viewhelper.VHEndereco;
import br.com.les.viewhelper.VHItemProduto;
import br.com.les.viewhelper.VHPedido;
import br.com.les.viewhelper.VHProduto;
import br.com.les.viewhelper.VHRelatorio;
import service.JobAprovarCompra;


//Controller principal do sistema
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/Pages/servlet", "/Pages/consultaCategoria", "/Pages/cadastroEletronico", "/Pages/cadastroAcessorio", "/Pages/consultaProdutos" , "/Pages/visualizarProduto", "/Pages/inativarProduto", "/Pages/alterarEletronico", "/Pages/cadastrarAcessorio", "/Pages/cadastroCliente", "/Pages/contact", "/Pages/alteracaoCliente", "/Pages/product", "/Pages/product-detail", "/Pages/carrinho", "/Pages/pedido", "/Pages/orders", "/Pages/cupom", "/Pages/endereco", "/Pages/cartao", "/Pages/relatorio3variaveis"})
public class Servlet extends HttpServlet implements ServletContextListener{
	
	 
		private Map<String, ICommand> mapCommand;
		private Map<String, IViewHelper> mapViewHelper;
		
		
		public Servlet(){
			
			mapCommand = new HashMap<String, ICommand>();
			mapViewHelper = new HashMap<String, IViewHelper>();
			
			//Mapa de commands
			mapCommand.put("SALVAR", new CmdSalvar());
			mapCommand.put("CONSULTAR", new CmdConsultar());
			mapCommand.put("VISUALIZAR", new CmdVisualizar());
			mapCommand.put("INATIVAR", new CmdInativar());
			mapCommand.put("ALTERAR", new CmdAlterar());
			mapCommand.put("CARRINHOADICIONAR", new CommandCarrinhoAdicionar());
			mapCommand.put("CARRINHOEXCLUIR", new CommandCarrinhoExcluir());
			mapCommand.put("CARRINHOALTERAR", new CommandCarrinhoAlterar());
			mapCommand.put("TROCAR", new CmdSalvar());
			mapCommand.put("APROVAR", new CmdSalvar());
			mapCommand.put("REPROVAR", new CmdInativar());
			mapCommand.put("VOLTAR AO ESTOQUE", new CmdAlterar());
			mapCommand.put("RECEBIDO", new CmdSalvar());
			
			//Mapa de VH
			
			mapViewHelper.put("VHELETRONICO", new VHEletronico());
			mapViewHelper.put("VHCATEGORIA", new VHCategoria());
			mapViewHelper.put("VHPRODUTO", new VHProduto());
			mapViewHelper.put("VHACESSORIO", new VHAcessorio());
			mapViewHelper.put("VHCLIENTE", new VHCliente());
			mapViewHelper.put("VHBLOQUEIO", new VHBloqueio());
			mapViewHelper.put("VHPEDIDO", new VHPedido());
			mapViewHelper.put("VHCUPOM", new VHCupom());
			mapViewHelper.put("VHENDERECO", new VHEndereco());
			mapViewHelper.put("VHCARTAO", new VHCartao());
			mapViewHelper.put("VHITEMPRODUTO", new VHItemProduto());
			mapViewHelper.put("VHRELATORIO", new VHRelatorio());


		}
		

		@Override
		public void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
			
			request.setCharacterEncoding("UTF-8");
			
			String operacao = request.getParameter("btnOperacao");
			
			ICommand command = mapCommand.get(operacao);
			
			String formName = request.getParameter("FormName");
	 		
			IViewHelper viewHelper = mapViewHelper.get(formName);
	 			 		
			EntidadeDominio entidade = viewHelper.getEntidade(request);
			
			Resultado resultado = command.executar(entidade);
			
			viewHelper.setView(resultado, request, response);
		}
		
		
		//para inicializar os serviços de Bloqueio/Desbloqueio do Produto e Aprovação/Reprovação de Pedidos
		@Override
		  public void init() {
			System.out.println("contexto inicializado");
		    HashMap<String, Bloqueio> mapProdutosBloqueados = new HashMap<>();     
		    getServletContext().setAttribute("bloqueio", mapProdutosBloqueados);

		    SchedulerFactory shedFact = new StdSchedulerFactory();
		    
		    try {
		           Scheduler schedulerBloqueio = shedFact.getScheduler();
		           Scheduler schedulerAprovacaoPedido = shedFact.getScheduler();
		           schedulerBloqueio.start();
		           schedulerAprovacaoPedido.start();
		           
		          //utiliza o contexto da aplicação
		         JobDataMap jobDataMap = new JobDataMap();
		         jobDataMap.put("servletContext", getServletContext());
		         
		         //Job1 de StValidarItensCarrinhoComTempoExpirado - bloqueio de produtos no carrinho
		           JobDetail job = JobBuilder.newJob(StValidarItensCarrinhoComTempoExpirado.class)
		                         .withIdentity("validadorJOB", "grupo01")
		                         .usingJobData(jobDataMap)
		                         .build();
		         //Job2 de Aprovação ou Reprovação do pedido
		          JobDetail jobAprovarOuReprovarCompra = JobBuilder.newJob(JobAprovarCompra.class)
		                                                .withIdentity("validadorOperadora", "grupo02")
		                                                .build();
		         
		         
		          //Trigger do Job1 de 1 minuto
		           Trigger trigger = TriggerBuilder.newTrigger()
		                         .withIdentity("validadorTRIGGER","grupo01")
		                         .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
		                         .build();
		           
		           //Trigger do Job2 de 60 segundos
		           Trigger trigger2 = TriggerBuilder.newTrigger()
		               .withIdentity("validadorTRIGGER2","grupo02")
		             .withSchedule(CronScheduleBuilder.cronSchedule("0/60 * * * * ?"))
		               .build();
		           
		           schedulerBloqueio.scheduleJob(job, trigger);
		           schedulerAprovacaoPedido.scheduleJob(jobAprovarOuReprovarCompra, trigger2);
		           
		  } catch (SchedulerException e) {
		      e.printStackTrace();
		  }
			  
		      
		      
		    
		  }
		
		
}
