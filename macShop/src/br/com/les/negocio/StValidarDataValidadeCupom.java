package br.com.les.negocio;

import java.time.LocalDate;

import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;

public class StValidarDataValidadeCupom implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Cupom cupom = (Cupom) entidade;
		StringBuilder mensagem = new StringBuilder();
		
		if(cupom.getDataDeValidade().isBefore(LocalDate.now()))
		{
			mensagem.append("A data de validade do cupom deve ser maior que a data atual.");
			return mensagem.toString();
		}
		
		return null;
	}

}
