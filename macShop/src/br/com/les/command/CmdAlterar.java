package br.com.les.command;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class CmdAlterar extends AbstractCommand{

	@Override
	public Resultado executar(EntidadeDominio e) {
		return fachada.alterar(e);
	}

}
