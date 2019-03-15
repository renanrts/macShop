package br.com.les.negocio;



import br.com.les.dao.DAOCategoria;
import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;


public class StComplementarCategoria implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		
		
		
		if (entidade.getTipo().equals("VHELETRONICO"))
		{
			Eletronico eletronico = (Eletronico) entidade;
			DAOCategoria dao = new DAOCategoria();
			dao.consultarCategoria(eletronico);
		}
		else
		{
			Acessorio acessorio = (Acessorio) entidade;
			DAOCategoria dao = new DAOCategoria();
			dao.consultarCategoria(acessorio);
		}
		
	
		return null;
			
	}

}
