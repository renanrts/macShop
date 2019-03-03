package br.com.les.command;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public interface ICommand {
	
	public Resultado executar(EntidadeDominio e);

}
