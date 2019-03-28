package br.com.les.negocio;

import br.com.les.dominio.Cliente;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;

public class StValidarDadosObrigatoriosCliente implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {

		StringBuilder mensagem = new StringBuilder();
		Cliente cliente = (Cliente) entidade;
		
			if(cliente.getCpf() == null || cliente.getCpf().equals("")){
				mensagem.append("CPF é um campo obrigatório\n");
			}
					
			if(cliente.getDataNascimento() == null || cliente.getDataNascimento().equals("")){
				mensagem.append("Data de Nascimento é um campo obrigatório\n");
			}

			if(cliente.getEmail() == null || cliente.getEmail().equals("")){
				mensagem.append("E-mail é um campo obrigatório\n");
			}
			
			if(cliente.getListCartoes() == null || cliente.getListCartoes().equals("")){
				mensagem.append("Cartão de Crédito é um campo obrigatório\n");
			}
			
			if(cliente.getNome() == null || cliente.getNome().equals("")){
				mensagem.append("Nome é um campo obrigatório\n");
			}
			
			for (Endereco endereco : cliente.getListEnderecos())
			{
				
				if(endereco.getBairro() == null || endereco.getBairro().equals("")){
					mensagem.append("Bairro " + endereco.getTipo() +  " é um campo obrigatório\n");
				}
				if(endereco.getCep() == null || endereco.getCep().equals("")){
					mensagem.append("Cep " + endereco.getTipo() +  " é um campo obrigatório\n");
				}
				if(endereco.getCidade() == null || endereco.getCidade().equals("")){
					mensagem.append("Cidade " + endereco.getTipo() +  "  é um campo obrigatório\n");
				}
				if(endereco.getCidade().getEstado() == null || endereco.getCidade().getEstado().equals("")){
					mensagem.append("Estado " + endereco.getTipo() +  "  é um campo obrigatório\n");
				}
				if(endereco.getLogradouro() == null || endereco.getLogradouro().equals("")){
					mensagem.append("Logradouro " + endereco.getTipo() +  "  é um campo obrigatório\n");
				}	
				if(endereco.getNumero() == null || endereco.getNumero().equals("")){
					mensagem.append("Numero " + endereco.getTipo() +  "  é um campo obrigatório\n");
				}		
			}
			
			
			if(cliente.getSenhas() == null || cliente.getSenhas().equals("")){
				mensagem.append("Senha é um campo obrigatório\n");
			}
			
			if(cliente.getTelefone() == null || cliente.getTelefone().equals("")){
				mensagem.append("Telefone é um campo obrigatório\n");
			}
			
			if(mensagem.length() == 0){
				return null;
			}
		
		return mensagem.toString();
				
	}

}
