package br.com.les.negocio;

import br.com.les.dao.DAOCliente;
import br.com.les.dao.IDAO;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class StValidarExistenciaCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
	
			Cliente cliente = (Cliente) entidade;
			
			IDAO dao = new DAOCliente(); 
			
			resultado = dao.consultarExistencia(cliente);

		if(resultado.getContagem() == 0){
			return null;
		}else{
			return "O produto informado já está cadastrado na base de dados!\n";
		}
	}

}
