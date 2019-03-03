package br.com.les.command;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class CmdSalvar extends AbstractCommand{
	
	@Override
	public Resultado executar(EntidadeDominio e) {
		
		return fachada.salvar(e);
		
	}

}
