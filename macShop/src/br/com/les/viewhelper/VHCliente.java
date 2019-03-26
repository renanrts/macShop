package br.com.les.viewhelper;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Bandeira;
import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Telefone;
import br.com.les.util.Resultado;

public class VHCliente implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		LocalDateTime lala;
		
		Bandeira bandeira = Bandeira.VISA;
		//Bandeira.valueOf(enumType, name)
		//cliente.setAtivo(ativo);
		cliente.setCpf(request.getParameter("txtCpf"));
		//cliente.setDataNascimento(lala);
		cliente.setEmail(request.getParameter("txtEmail"));
		
		if(request.getParameter("txtId") != null) {
			cliente.setId(Integer.parseInt(request.getParameter("txtId")));
		}
		
		cliente.setNome(request.getParameter("txtNome"));
		cliente.setTipo(request.getParameter("txtTipo"));
		
		List<CartaoCredito> cartoes;
		CartaoCredito cartao = new CartaoCredito();
		//cartoes.add(cartao);
		//cliente.setListCartoes(cartoes);
		
		List<Endereco> enderecos;
		Endereco endereco = new Endereco();
		//enderecos.add(endereco);
		//cliente.setListEnderecos(enderecos);
		
		List<String> senhas;
		String senha1 = request.getParameter("txtSenha1");
		//senhas.add(senha1);
		//cliente.setSenhas(senhas);
		
		Telefone telefone = new Telefone();
		cliente.setTelefone(telefone);
		
		
		return cliente;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
