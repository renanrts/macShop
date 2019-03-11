package br.com.les.command;


import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class CmdVisualizar extends AbstractCommand{
	
	@Override
	public Resultado executar(EntidadeDominio e) {
		
		return fachada.visualizar(e);
	}


}
