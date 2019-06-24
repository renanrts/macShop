package br.com.les.negocio;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;

public class StValidarItensCarrinhoComTempoExpirado implements Job {


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

	    ServletContext servletContext = (ServletContext) context.getMergedJobDataMap().get("servletContext");
	    
	    @SuppressWarnings("unchecked")
		Map<String, Bloqueio> produtosBloqueados = 
	        (Map<String, Bloqueio>) servletContext.getAttribute("bloqueio");
	 

	   //For de produtos bloqueados disponíveis no Contexto da Aplicação
	    for(Map.Entry<String, Bloqueio> entry : produtosBloqueados.entrySet()) {
	      Bloqueio bloqueioCarrinho = entry.getValue();
	      LocalDateTime horarioAtual = LocalDateTime.now();
	      LocalDateTime horarioBloqueio = bloqueioCarrinho.getTimeStamp();
	      long diferenca = Duration.between(horarioBloqueio, horarioAtual ).getSeconds();
	      if(diferenca > 300) {        
	        System.out.println("Retirando do carrinho ");
	        
	        // Remove carrinho dos itens bloqueados
	        produtosBloqueados.remove(entry.getKey());
	        
	        Carrinho carrinhoSessao = (Carrinho) entry.getValue().getCarrinho();
	        
	        // Remove carrinho da sessão do usuário
	        entry.getValue().getSessao().removeAttribute("carrinho");
	     
	      }
	      
	    }
		
	}

}
