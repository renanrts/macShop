package br.com.les.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.CartaoCredito;
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
			
			
			for (CartaoCredito cartao : cliente.getListCartoes())
			{
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
	
				
			}
			
			
			
			if(cliente.getNome() == null || cliente.getNome().equals("")){
				mensagem.append("Nome é um campo obrigatório\n");
			}
			
		
			List<Endereco> enderecos = new ArrayList<Endereco>();
			
			if (!enderecos.isEmpty())
			{
				for (Endereco endereco : cliente.getListEnderecosEntrega())
				{
					enderecos.add(endereco);
				}
				
			}
			
			enderecos.add(cliente.getEnderecoCobranca());
			enderecos.add(cliente.getEnderecoResidencial());
			
			
			for (Endereco endereco : enderecos)
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
				if(endereco.getTipoEndereco() == null || endereco.getTipoEndereco().equals("")){
					mensagem.append("Tipo de Endereco " + endereco.getTipo() +  "  é um campo obrigatório\n");
				}	
				if(endereco.getTipoLogradouro() == null || endereco.getTipoLogradouro().equals("")){
					mensagem.append("Tipo de Logradouro " + endereco.getTipo() +  "  é um campo obrigatório\n");
				}	
				
			}

			if(cliente.getSenhas() == null || cliente.getSenhas().equals("")){
				mensagem.append("Senha é um campo obrigatório\n");
			}
			
			if(cliente.getTelefone() == null || cliente.getTelefone().equals("")){
				mensagem.append("Telefone é um campo obrigatório\n");
			}
			
			for (CartaoCredito cartoes : cliente.getListCartoes())
			{
				if(cartoes.getBandeira() == null || cartoes.getBandeira().equals("")){
					mensagem.append("Bandeira é um campo obrigatório\n");
				}
				
				if(cartoes.getCodSeguranca() == null || cartoes.getCodSeguranca().equals("")){
					mensagem.append("Código de Segurança é um campo obrigatório\n");
				}
				
				if(cartoes.getDtVenciamento() == null || cartoes.getDtVenciamento().equals("")){
					mensagem.append("Data de Vencimento é um campo obrigatório\n");
				}
				
				if(cartoes.getNome() == null || cartoes.getNome().equals("")){
					mensagem.append("Nome (Cartão de Crédito) é um campo obrigatório\n");
				}
				
				if(cartoes.getNumero() == null || cartoes.getNumero().equals("")){
					mensagem.append("Número (Cartão de Crédito) é um campo obrigatório\n");
				}
				
			}
			
			if(mensagem.length() == 0){
				return null;
			}
		
		return mensagem.toString();
				
	}

}
