package br.com.les.negocio;


import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOEletronico;
import br.com.les.dao.IDAO;
import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class StValidarExistencia implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		
		if (entidade.getTipo().equals("VHELETRONICO"))
		{
			Eletronico eletronico = (Eletronico) entidade;
			
			IDAO dao = new DAOEletronico(); 
			
			resultado = dao.consultarExistencia(eletronico);
		}
		else
		{
			Acessorio acessorio = (Acessorio) entidade;
			
			IDAO dao = new DAOAcessorio(); 
			
			resultado = dao.consultarExistencia(acessorio);
		}
		
		if(resultado.getContagem() == 0){
			return null;
		}else{
			return "O produto informado já está cadastrado na base de dados!\n";
		}
	}
	
	

}
