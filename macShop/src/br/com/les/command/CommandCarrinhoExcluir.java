package br.com.les.command;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class CommandCarrinhoExcluir extends AbstractCommand {

	@Override
	public Resultado executar(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return fachada.excluirDoCarrinho(e);
	}

}
