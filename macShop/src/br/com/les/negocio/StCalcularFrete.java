package br.com.les.negocio;

import java.util.Random;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;

public class StCalcularFrete implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		
		Random gerador = new Random();
		

		Integer qtdeItens = 0;
		
		for(ItemCarrinho produto : pedido.getCarrinho().getItensCarrinho())
		{
			qtdeItens++;
		}
		pedido.setFrete((gerador.nextDouble() % 20) * qtdeItens);
		
		return null;
	}

}

