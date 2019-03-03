package br.com.les.dao;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public interface IDAO {
	
	
	public Resultado salvar(EntidadeDominio entidade);
	public Resultado consultar (EntidadeDominio entidade);
	public Resultado alterar (EntidadeDominio entidade);
	public Resultado excluir (EntidadeDominio entidade);

}
