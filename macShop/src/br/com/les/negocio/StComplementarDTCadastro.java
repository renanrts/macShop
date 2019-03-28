package br.com.les.negocio;

import java.util.Calendar;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;

public class StComplementarDTCadastro implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
			
		if (entidade.getTipo().equals("VHELETRONICO"))
		{
			Eletronico eletronico = (Eletronico) entidade;
		
			Calendar dataCadastro = Calendar.getInstance();
			eletronico.setDataCadastro(dataCadastro);
	
		}
		
		else if (entidade.getTipo().equals("VHACESSORIO"))
		{
			Acessorio acessorio = (Acessorio) entidade;
			
			Calendar dataCadastro = Calendar.getInstance();
			acessorio.setDataCadastro(dataCadastro);
			
		}
		return null;
		

	
	}
}
