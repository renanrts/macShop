package br.com.les.negocio;

import java.time.LocalDate;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;

public class StComplementarDataPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Pedido pedido = (Pedido) entidade;
		
		LocalDate dataCadastro = LocalDate.now();
		pedido.setDataPedido(dataCadastro);
		return null;
	}

}
