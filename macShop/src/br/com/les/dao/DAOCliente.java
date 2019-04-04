package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cidade;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Estado;
import br.com.les.dominio.Telefone;
import br.com.les.util.Resultado;

public class DAOCliente extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		
		Resultado resultado = new Resultado();
		

		String sql = "INSERT INTO CLIENTES (cli_nome, cli_cpf, cli_ativo, cli_email, cli_senha, cli_tel_tipo, cli_tel_ddd, cli_tel_numero, cli_genero, cli_dt_nascimento) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, "ATIVO");
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getSenhas().get(0));
			stmt.setString(6, cliente.getTelefone().getTipoTelefone());
			stmt.setString(7, cliente.getTelefone().getDdd());
			stmt.setString(8, cliente.getTelefone().getNumero());
			stmt.setString(9, cliente.getGenero());
			stmt.setDate(10, new Date(cliente.getDataNascimento().getTimeInMillis()));

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				cliente.setId(rs.getInt("cli_id"));
			
			stmt.close();
			
			for(Endereco endereco : cliente.getListEnderecosEntrega())
			{
				IDAO dao = new DAOEndereco();
				endereco.setCliId(rs.getInt("cli_id"));
				dao.salvar(endereco);
			}
			
			IDAO daoEnd = new DAOEndereco();
			cliente.getEnderecoCobranca().setCliId(rs.getInt("cli_id"));
			cliente.getEnderecoResidencial().setCliId(rs.getInt("cli_id"));
			daoEnd.salvar(cliente.getEnderecoCobranca());
			daoEnd.salvar(cliente.getEnderecoCobranca());
			
			for(CartaoCredito cartao : cliente.getListCartoes())
			{
				IDAO dao = new DAOCartao();
				cartao.setCliId(rs.getInt("cli_id"));
				dao.salvar(cartao);
			}
			
			con.close();

			resultado.sucesso("Salvo com sucesso!");
			return resultado;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultado.erro("Erro salvar, por favor, refaça a operação.");
			return resultado;
		}
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();
	
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
			List<Endereco> enderecos = new ArrayList<Endereco>();
			List<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
			PreparedStatement stmt = null;
			Boolean visualizar = false;
			

			stmt = this.con.prepareStatement(
					"SELECT * from ENDERECOS AS C INNER JOIN CLIENTES AS F ON C.end_cli_Id = F.cli_id INNER JOIN CARTOES AS D ON F.cli_id = D.cart_cli_id INNER JOIN cidade AS G ON C.end_cid_id = G.cid_id INNER JOIN estado AS P ON P.est_id = g.cid_est_id WHERE G.cid_id = C.end_cid_id AND P.est_id = g.cid_est_id"
					);
						
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
				if(contagem == 0)		
				{
					cliente.setCpf(rs.getString("cli_cpf"));
					cliente.setEmail(rs.getString("cli_email"));
					cliente.setGenero(rs.getString("cli_genero"));
					cliente.setNome(rs.getString("cli_nome"));
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("cli_dt_nascimento"));
					cliente.setDataNascimento(data);
					
					Telefone telefone = new Telefone();
					telefone.setDdd(rs.getString("cli_tel_ddd"));
					telefone.setNumero(rs.getString("cli_tel_numero"));
					telefone.setTipoTelefone(rs.getString("cli_tel_tipo"));
					
					cliente.setTelefone(telefone);
					
					CartaoCredito cart = new CartaoCredito();
					cart.setBandeira(rs.getString("cart_bandeira"));
					cart.setCodSeguranca(rs.getString("cart_cod"));
					cart.setNome(rs.getString("cart_nome"));
					cart.setNumero(rs.getString("cart_numero"));
					cart.setPreferencial(rs.getBoolean("cart_preferencial"));
					Calendar dtVencimento = Calendar.getInstance();
					dtVencimento.setTime(rs.getDate("cart_vencimento"));
					cart.setDtVenciamento(dtVencimento);
					
					cartoes.add(cart);
					
				}
				
				Endereco end = new Endereco();
					
				Estado est = new Estado();
				est.setId(rs.getInt("est_id"));
				est.setNome(rs.getString("est_nome"));
				
				Cidade cid = new Cidade();
				
				cid.setEstado(est);
				cid.setId(rs.getInt("cid_id"));
				cid.setNome(rs.getString("cid_nome"));
				
				end.setBairro(rs.getString("end_bairro"));
				end.setCep(rs.getString("end_cep"));
				end.setCidade(cid);
				end.setId(rs.getInt("end_id"));
				end.setLogradouro(rs.getString("end_logradouro"));
				end.setNumero(rs.getString("end_numero"));
				end.setObservacao(rs.getString("end_obs"));
				end.setPreferencial(rs.getBoolean("end_preferencial"));
				end.setTipo(rs.getString("end_tipo"));
				end.setTipoEndereco(rs.getString("end_tipo_residencia"));
				end.setTipoLogradouro(rs.getString("end_tipo_logradouro"));
				
				if (end.getTipo().equals("ENDERECO COBRANCA"))
				{
					cliente.setEnderecoCobranca(end);
				}
				else if (end.getTipo().equals("ENDERECO ENTREGA"))
				{
					enderecos.add(end);
				}
				else if (end.getTipo().equals("ENDERECO RESIDENCIAL"))
				{
					cliente.setEnderecoResidencial(end);
				}

				contagem++;
			}
			
			
			cliente.setListCartoes(cartoes);
			cliente.setListEnderecosEntrega(enderecos);
			clientes.add(cliente);
			resultado.setListaResultado(clientes);

		
			if(contagem == 0){
				resultado.sucesso("Nenhum produto encontrado.");
			}
			else{
				resultado.sucesso("");
			}
			
			resultado.setContagem(contagem);
			rs.close();
			stmt.close();
			return resultado;
			
		} catch (SQLException e1) {
			
						e1.printStackTrace();
						resultado.erro("Erro de consulta.");
						return resultado;
		}
		
		
		
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado visualizar(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		Cliente cliente = (Cliente) e;
		Resultado resultado = new Resultado();
		int contagem = 0;

		try {
			
			
			PreparedStatement stmt = null;

			stmt = this.con.prepareStatement("SELECT * FROM CLIENTES WHERE cli_cpf = ?");
			stmt.setString(1, cliente.getCpf());
	
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
				contagem++;
			}
			
			
			if(contagem == 0){
				resultado.sucesso("Nenhum cliente encontrado.");
			}
			else{
				resultado.sucesso("");
			}
			
			resultado.setContagem(contagem);
			rs.close();
			stmt.close();
			return resultado;
			
		} catch (SQLException e1) {
			
						e1.printStackTrace();
						resultado.erro("Erro de consulta.");
						return resultado;
		}

	}
}
