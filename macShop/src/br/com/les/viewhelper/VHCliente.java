package br.com.les.viewhelper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		telefone.setNumero(request.getParameter("txtNumeroTel"));
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
		endereco.setTipoLogradouro(request.getParameter("txtTiposLogradouro"));
		endereco.setNumero(request.getParameter("txtNumero"));
		endereco.setObservacao(request.getParameter("txtObservacao"));
		endereco.setBairro(request.getParameter("txtBairro"));
		
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
		enderecoEntrega.setTipoLogradouro(request.getParameter("txtTiposLogradouroEntrega"));
		enderecoEntrega.setNumero(request.getParameter("txtNumeroEntrega"));
		enderecoEntrega.setObservacao(request.getParameter("txtObservacaoEntrega"));
		enderecoEntrega.setBairro(request.getParameter("txtBairroEntrega"));

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
		enderecoResidencial.setTipoLogradouro(request.getParameter("txtTiposLogradouroResidencial"));
		enderecoResidencial.setNumero(request.getParameter("txtNumeroResidencial"));
		enderecoResidencial.setObservacao(request.getParameter("txtObservacaoResidencial"));
		enderecoResidencial.setBairro(request.getParameter("txtBairroResidencial"));
		
		enderecos.add(enderecoResidencial);
		enderecos.add(enderecoEntrega);
		enderecos.add(endereco);
		
		cliente.setListEnderecos(enderecos);
		
		List<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
		CartaoCredito cartao = new CartaoCredito();
		
		cartao.setBandeira(request.getParameter("txtBandeira"));
		cartao.setCodSeguranca(request.getParameter("txtCodSeguranca"));
		
		if (request.getParameter("txtCartaoID") != null){
			cartao.setId(Integer.parseInt(request.getParameter("txtCartaoID")));
		}
		cartao.setNome(request.getParameter("txtNomeCartao"));
		cartao.setNumero(request.getParameter("txtNumeroCartao"));
		cartao.setPreferencial(true);
		String stDataVencimento = request.getParameter("txtDataVencimento");
 		
		stDataVencimento = (stDataVencimento == "") ? null : stDataVencimento;
		
		Calendar DataVencimento = null;
		
		if(stDataVencimento != null)
		{
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date data = format.parse(stDataVencimento);
				DataVencimento = Calendar.getInstance();
				DataVencimento.setTime(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		
		cartao.setDtVenciamento(DataVencimento);
		
		cartoes.add(cartao);
		
		cliente.setListCartoes(cartoes);
		
		
		String stDataNascimento = request.getParameter("txtDataNascimento");
 		
 		stDataNascimento = (stDataNascimento == "") ? null : stDataNascimento;
		
		Calendar dataNascimento = null;
		
		if(stDataNascimento != null)
		{
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date data = format.parse(stDataNascimento);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		
		cliente.setDataNascimento(dataNascimento);
		cliente.setGenero(request.getParameter("txtGenero"));
		
		return cliente;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");		
		
		if(resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);
		
		if(operacao.equals("SALVAR")){
			if(resultado.getErro()){

					request.setAttribute("cliente", (Cliente) resultado.getListaResultado().get(0));
			}
			else
			{
				request.setAttribute("resultado", resultado.getCategoria());
			}
		} else if(operacao.equals("CONSULTAR")){
			if(!resultado.getErro()){
				if(resultado.getResultado() != null){
					request.setAttribute("cliente", (Cliente) resultado.getResultado());
				
				}else{
					request.setAttribute("resultado", resultado.getListaResultado());
				}
			}
		}
		else if(operacao.equals("VISUALIZAR")){

		
				request.setAttribute("cliente", (Cliente) resultado.getListaResultado().get(0));
		
			

		}
		else if(operacao.equals("ALTERAR")){

		
				request.setAttribute("cliente", (Cliente) resultado.getListaResultado().get(0));

			


}
		
		try {
			if(operacao.equals("SALVAR")){
				if(resultado.getErro()) {
					RequestDispatcher rd = request.getRequestDispatcher("cad-cliente.jsp");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			
			}
			else if(operacao.equals("CONSULTAR")){			
					RequestDispatcher rd = request.getRequestDispatcher("consulta-cli.jsp");
					rd.forward(request, response);
			}
			else if(operacao.equals("VISUALIZAR")){

					RequestDispatcher rd = request.getRequestDispatcher("area-cli.jsp");
					rd.forward(request, response);

			}
			else if(operacao.equals("INATIVAR")){
								
					RequestDispatcher rd = request.getRequestDispatcher("consulta-cli.jsp");
					rd.forward(request, response);

			}
			else if(operacao.equals("ALTERAR")){
				
				RequestDispatcher rd = request.getRequestDispatcher("area-cli.jsp");
				rd.forward(request, response);

		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
