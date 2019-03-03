package br.com.les.facade;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public interface IFachada {
	
public Resultado salvar(EntidadeDominio e);
	
	public Resultado consultar(EntidadeDominio e);

}
