package br.com.les.viewhelper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Bandeira;
import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cidade;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Estado;
import br.com.les.dominio.Telefone;
import br.com.les.util.Resultado;

public class VHCliente implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		if(request.getParameter("txtStatus") != null)
		{
			cliente.setAtivo(request.getParameter("txtStatus"));
		}
		
		if(request.getParameter("txtID") != null)
		{
			cliente.setId(Integer.parseInt(request.getParameter("txtID")));
		}
		
		cliente.setTipo("VHCliente");
		
		cliente.setCpf(request.getParameter("txtCPF"));
	
		cliente.setEmail(request.getParameter("txtEmail"));
		
		cliente.setNome(request.getParameter("txtNome"));
		
		cliente.setTipo(request.getParameter("txtTipo"));
		
		List<String> senhas = new ArrayList<String>();
		
		senhas.add(request.getParameter("txtSenha1"));
		senhas.add(request.getParameter("txtSenha2"));
		
 		cliente.setSenhas(senhas);
 		
 		
 	
 		
		Telefone telefone = new Telefone();
		telefone.setDdd(request.getParameter("txtDDD"));
		telefone.setNumero(request.getParameter("txtNumero"));
		telefone.setTipoTelefone(request.getParameter("txtTipoTelefone"));
		cliente.setTelefone(telefone);
		
		List<Endereco> enderecos = new ArrayList<Endereco>();
		Endereco endereco = new Endereco();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		
		estado.setId(Integer.parseInt(request.getParameter("txtEstado")));
	
		cidade.setId(Integer.parseInt(request.getParameter("txtCidade")));
		cidade.setEstado(estado);
		
		endereco.setCidade(cidade);
		endereco.setTipoEndereco(request.getParameter("txtTipoEndereco"));
		endereco.setTipo("ENDERECO");
		endereco.setCep(request.getParameter("txtCEP"));
		endereco.setLogradouro(request.getParameter("txtLogradouro"));
		endereco.setTipoLogradouro(request.getParameter("txtTipoLogradouro"));
		endereco.setNumero(request.getParameter("txtNumero"));
		endereco.setObservacao(request.getParameter("txtObservacao"));
		
		Endereco enderecoEntrega = new Endereco();
		Cidade cidadeEntrega  = new Cidade();
		Estado estadoEntrega  = new Estado();
		
		estadoEntrega.setId(Integer.parseInt(request.getParameter("txtEstadoEntrega")));
	
		cidadeEntrega.setId(Integer.parseInt(request.getParameter("txtCidadeEntrega")));
		cidadeEntrega.setEstado(estadoEntrega);
		
		enderecoEntrega.setCidade(cidadeEntrega);
		enderecoEntrega.setTipoEndereco(request.getParameter("txtTipoEnderecoEntrega"));
		enderecoEntrega.setTipo("ENDERECOENTREGA");
		enderecoEntrega.setCep(request.getParameter("txtCEPEntrega"));
		enderecoEntrega.setLogradouro(request.getParameter("txtLogradouroEntrega"));
		enderecoEntrega.setTipoLogradouro(request.getParameter("txtTipoLogradouroEntrega"));
		enderecoEntrega.setNumero(request.getParameter("txtNumeroEntrega"));
		enderecoEntrega.setObservacao(request.getParameter("txtObservacaoEntrega"));
		
		Endereco enderecoResidencial = new Endereco();
		Cidade cidadeEntregaResidencial = new Cidade();
		Estado estadoEntregaResidencial  = new Estado();
		
		estadoEntregaResidencial.setId(Integer.parseInt(request.getParameter("txtEstadoResidencial")));
	
		cidadeEntregaResidencial.setId(Integer.parseInt(request.getParameter("txtCidadeResidencial")));
		cidadeEntregaResidencial.setEstado(estadoEntregaResidencial);
		
		enderecoResidencial.setCidade(cidadeEntregaResidencial);
		enderecoResidencial.setTipoEndereco(request.getParameter("txtTipoEnderecoResidencial"));
		enderecoResidencial.setTipo("ENDERECORESIDENCIAL");
		enderecoResidencial.setCep(request.getParameter("txtCEPResidencial"));
		enderecoResidencial.setLogradouro(request.getParameter("txtLogradouroResidencial"));
		enderecoResidencial.setTipoLogradouro(request.getParameter("txtTipoLogradouroResidencial"));
		enderecoResidencial.setNumero(request.getParameter("txtNumeroResidencial"));
		enderecoResidencial.setObservacao(request.getParameter("txtObservacaoResidencial"));
		
		enderecos.add(enderecoResidencial);
		enderecos.add(enderecoEntrega);
		enderecos.add(endereco);
		
		cliente.setListEnderecos(enderecos);
		
		List<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
		CartaoCredito cartao = new CartaoCredito();
		
		cartao.setBandeira(request.getParameter("txtBandeira"));
		cartao.setCodSeguranca(request.getParameter("txtCodSeguranca"));
		//cartao.setDtVenciamento(request.getParameter("txtDataVencimento"));
		
		if (request.getParameter("txtCartaoID") != null){
			cartao.setId(Integer.parseInt(request.getParameter("txtCartaoID")));
		}
		cartao.setNome(request.getParameter("txtNomeCartao"));
		cartao.setNumero(request.getParameter("txtNumeroCartao"));
		cartao.setPreferencial(true);
		
		cartoes.add(cartao);
		
		cliente.setListCartoes(cartoes);
		
		
		return cliente;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
