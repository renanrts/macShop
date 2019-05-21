package br.com.les.negocio;

import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.EntidadeDominio;

public class StValidarDadosObrigatoriosCartao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		StringBuilder mensagem = new StringBuilder();
		CartaoCredito cartao = (CartaoCredito) entidade;
		
				if(cartao.getBandeira() == null || cartao.getBandeira().equals("")){
					mensagem.append("Bandeira do cartão de Crédito é um campo obrigatório\n");
				}
				
				if(cartao.getCodSeguranca() == null || cartao.getCodSeguranca().equals("")){
					mensagem.append("Código de Segurança do cartão de Crédito é um campo obrigatório\n");
				}
				
				if(cartao.getDtVenciamento() == null || cartao.getDtVenciamento().equals("")){
					mensagem.append("Data de Vencimento do cartão de Crédito é um campo obrigatório\n");
				}
				
				if(cartao.getNome() == null || cartao.getNome().equals("")){
					mensagem.append("Nome do cartão de Crédito é um campo obrigatório\n");
				}
				
				if(cartao.getNumero() == null || cartao.getNumero().equals("")){
					mensagem.append("Número do cartão de Crédito é um campo obrigatório\n");
				}
	

			if(mensagem.length() == 0){
				return null;
			}
		
		return mensagem.toString();
	}

}
