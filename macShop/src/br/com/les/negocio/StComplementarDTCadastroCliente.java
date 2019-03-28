package br.com.les.negocio;

import java.util.Calendar;

import br.com.les.dominio.Cliente;
import br.com.les.dominio.EntidadeDominio;

public class StComplementarDTCadastroCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		
		Calendar dataCadastro = Calendar.getInstance();
		cliente.setDataCadastro(dataCadastro);
		
		return null;
	}

}
