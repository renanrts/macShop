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
	    
	    @SuppressWarnings("unchecked")
		Map<String, Carrinho> produtosDesbloqueados = 
	        (Map<String, Carrinho>) servletContext.getAttribute("desbloqueio"); 

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
	        
	        // Monta um novo carrinho para colocar na lista de carrinhos desbloqueados
	        Carrinho carrinhoDesbloqueado = new Carrinho();
	        ArrayList<ItemCarrinho> itensDesbloqueados = new ArrayList<>();
	        
	        // Monta lista de carrinhos
	        for( ItemCarrinho item : carrinhoSessao.getItensCarrinho()) {
	          ItemCarrinho itemCarrinho = new ItemCarrinho();
	          Produto produtoSessao  = (Produto) item.getProduto();
	          
	          Produto prod = new Produto();
	          prod.setId(item.getProduto().getId().intValue());
	          prod.setNome(produtoSessao.getNome());
	          prod.setAtivo("Inativo");
	          
	       
	          itemCarrinho.setProduto(prod);
	          itemCarrinho.setQuantidade(item.getQuantidade());
	          
	          itensDesbloqueados.add(itemCarrinho);
	        }
	        
	        carrinhoDesbloqueado.setItensCarrinho(itensDesbloqueados);
	        
	        // Coloca o carrinho na lista de carrinhos desbloqueados
	        produtosDesbloqueados.put(entry.getValue().getSessao().getId(),carrinhoDesbloqueado);
	        
	        // Remove carrinho da sessão do usuário
	        entry.getValue().getSessao().removeAttribute("carrinho");
	     
	      }
	      
	    }
		
	}

}
