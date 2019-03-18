package br.com.les.negocio;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Inativacao;

public class StValidarAtivacaoInativacao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		StringBuilder mensagem = new StringBuilder();
		
		if (entidade.getTipo().equals("VHELETRONICO"))
		{
			
			Eletronico eletronico = (Eletronico) entidade;
			if(eletronico.getMotivo() == null || eletronico.getMotivo().equals("")){
				mensagem.append("O motivo é um campo obrigatório\n");
			}
			
			if(eletronico.getAtivo().equals("Inativo")){
				mensagem.append("O produto já está inativo\n");
			}
			
			if(mensagem.length() == 0){
				return null;
			}
			else {
				return mensagem.toString();
			}
		}
		
		else
			
		{
			Acessorio acessorio = (Acessorio) entidade;
			if(acessorio.getMotivo() == null || acessorio.getMotivo().equals("")){
				mensagem.append("O motivo é um campo obrigatório\n");
			}
			if(acessorio.getAtivo().equals("Inativo")){
				mensagem.append("O produto já está inativo\n");
			}
			
			if(mensagem.length() == 0){
				return null;
			}
			else {
				return mensagem.toString();
			}
		}
	}

}
