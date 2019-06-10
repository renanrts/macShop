package br.com.les.negocio;

import java.util.Random;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOEletronico;
import br.com.les.dao.DAOPedido;
import br.com.les.dao.DAOProdxPed;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class StAprovarOuReprovarCompra implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		 System.out.println("StAprovarOuReprovarCompra ");
//		 Random random = new Random();
//		 Integer analisarPedido = random.nextInt(3);
		 
		 Integer analisarPedido = 2;
		    DAOPedido daoPedido = new DAOPedido();
		    if(analisarPedido % 2 == 0) {
		      
		      daoPedido.aprovarCompra(); 
		      System.out.println("Aprovar");
		    } else {
		      
		      DAOProdxPed daoItens = new DAOProdxPed();
		      DAOAcessorio daoAcs = new DAOAcessorio();
		      DAOEletronico daoEle = new DAOEletronico();
		      
		      Resultado resultado = daoItens.consultarPedidosEmProcessamento();
		      
		      // Devolve os itens reprovados ao estoque
		      for(EntidadeDominio it : resultado.getListaResultado()) {
		        Produto item = (Produto) it;
		        if(item.getTipo().equals("VHELETRONICO"))
		        {
		        	daoEle.voltarEstoque(item);
		        }
		        else {
		        	daoAcs.voltarEstoque(item);     	
		      }
		      
		      daoPedido.reprovarCompra();
		      
		      System.out.println("Reprovar");
		    }
		    
		    
		  }

	}

}
