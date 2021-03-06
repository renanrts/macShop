package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Categoria;
import br.com.les.dominio.Cidade;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Estado;
import br.com.les.dominio.Telefone;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOCliente extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		Cliente cliente = (Cliente) entidade;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO CLIENTES (cli_nome, cli_cpf, cli_ativo, cli_email, cli_senha, cli_tel_tipo, cli_tel_ddd, cli_tel_numero, cli_genero, cli_dt_nascimento) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

			for (Endereco endereco : cliente.getListEnderecosEntrega()) {
				IDAO dao = new DAOEndereco();
				endereco.setCliId(rs.getInt("cli_id"));
				dao.salvar(endereco);
			}

			IDAO daoEnd = new DAOEndereco();
			cliente.getEnderecoCobranca().setCliId(rs.getInt("cli_id"));
			cliente.getEnderecoResidencial().setCliId(rs.getInt("cli_id"));
			daoEnd.salvar(cliente.getEnderecoCobranca());
			daoEnd.salvar(cliente.getEnderecoCobranca());

			for (CartaoCredito cartao : cliente.getListCartoes()) {
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
		}finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
	}

	@SuppressWarnings("resource")
	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();

		int contagem = 0;

		try {

			List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
			List<Endereco> enderecos = new ArrayList<Endereco>();
			List<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
			
			
			String sql = "Select * from Clientes where cli_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()) {
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
				
				clientes.add(cliente);	
				contagem++;
			}
			
			rs.close();
			
			
			String sqlEnderecos = "Select * from Enderecos as C INNER JOIN cidade AS G ON C.end_cid_id = G.cid_id INNER JOIN estado AS P ON P.est_id = g.cid_est_id WHERE G.cid_id = C.end_cid_id AND P.est_id = g.cid_est_id AND c.end_status = 1 and cli_id = ?";
			stmt = con.prepareStatement(sqlEnderecos);
			stmt.setInt(1, cliente.getId());
			ResultSet rsEndereco = stmt.executeQuery();
			
			while (rsEndereco.next()) {
				Endereco end = new Endereco();

				Estado est = new Estado();
				est.setId(rsEndereco.getInt("est_id"));
				est.setNome(rsEndereco.getString("est_nome"));

				Cidade cid = new Cidade();

				cid.setEstado(est);
				cid.setId(rsEndereco.getInt("cid_id"));
				cid.setNome(rsEndereco.getString("cid_nome"));

				end.setBairro(rsEndereco.getString("end_bairro"));
				end.setCep(rsEndereco.getString("end_cep"));
				end.setCidade(cid);
				end.setId(rsEndereco.getInt("end_id"));
				end.setLogradouro(rsEndereco.getString("end_logradouro"));
				end.setNumero(rsEndereco.getString("end_numero"));
				end.setObservacao(rsEndereco.getString("end_obs"));
				end.setPreferencial(rsEndereco.getBoolean("end_preferencial"));
				end.setTipo(rsEndereco.getString("end_tipo"));
				end.setTipoEndereco(rsEndereco.getString("end_tipo_residencia"));
				end.setTipoLogradouro(rsEndereco.getString("end_tipo_logradouro"));

				if (end.getTipo().equals("ENDERECO COBRANCA")) {
					cliente.setEnderecoCobranca(end);
				} else if (end.getTipo().equals("ENDERECO ENTREGA")) {
					enderecos.add(end);
				} else if (end.getTipo().equals("ENDERECO RESIDENCIAL")) {
					cliente.setEnderecoResidencial(end);
				}
				
			}
			
			rsEndereco.close();
			
			
			String sqlCartoes = "Select * from Cartoes where cli_id = ?";
			stmt = con.prepareStatement(sqlCartoes);
			stmt.setInt(1, cliente.getId());
			ResultSet rsCartoes = stmt.executeQuery();
			
			while (rsCartoes.next()) {
				CartaoCredito cart = new CartaoCredito();
				cart.setBandeira(rsCartoes.getString("cart_bandeira"));
				cart.setCodSeguranca(rsCartoes.getString("cart_cod"));
				cart.setNome(rsCartoes.getString("cart_nome"));
				cart.setNumero(rsCartoes.getString("cart_numero"));
				cart.setPreferencial(rsCartoes.getBoolean("cart_preferencial"));
				cart.setId(rsCartoes.getInt("cart_id"));
				cart.setDtVenciamento(LocalDate.parse(rsCartoes.getDate("cart_vencimento").toString()));
				cartoes.add(cart);
			}
			
			rsCartoes.close();
			

			String sqlCuPOM = "SELECT * from CUPONS AS C INNER JOIN CLIENTES AS F ON C.cli_id = f.cli_id where f.cli_id = ? and CUP_STATUS = ?";
			stmt = con.prepareStatement(sqlCuPOM);
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, "ATIVO");
			ResultSet rsTCupom = stmt.executeQuery();

			List<Cupom> cupons = new ArrayList<Cupom>();

			while (rsTCupom.next()) {
				Cupom cup = new Cupom();

				cup.setId(Integer.parseInt(rsTCupom.getString("CUP_ID")));
				cup.setStatus(rsTCupom.getString("CUP_STATUS"));
				cup.setValor(Double.parseDouble(rsTCupom.getString("CUP_VALOR")));
				cupons.add(cup);

			}
			
			rsTCupom.close();
			
			
			String sqlCupomPromo = "SELECT * from CUPONS where cli_id = 0 and CUP_Validade > ?";
			stmt = con.prepareStatement(sqlCupomPromo);
			stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now().toString()));

			ResultSet rstPromo = stmt.executeQuery();

			List<Cupom> cuponsPromo = new ArrayList<Cupom>();

			while (rstPromo.next()) {
				Cupom cup = new Cupom();

				cup.setId(Integer.parseInt(rstPromo.getString("CUP_ID")));
				cup.setStatus(rstPromo.getString("CUP_STATUS"));
				cup.setValor(Double.parseDouble(rstPromo.getString("CUP_VALOR")));
				if (cup.getStatus().equals("ATIVO")) {
					cuponsPromo.add(cup);
				}

			}
			
			rstPromo.close();
			

			cliente.setCupons(cupons);
			cliente.setCuponsPromocionais(cuponsPromo);
			cliente.setListCartoes(cartoes);
			cliente.setListEnderecosEntrega(enderecos);
			clientes.add(cliente);
			resultado.setListaResultado(clientes);

			if (contagem == 0) {
				resultado.sucesso("Nenhum cliente encontrado.");
			} else {
				resultado.sucesso("");
			}

			resultado.setContagem(contagem);
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		}finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

	@SuppressWarnings("resource")
	@Override
	
	//Metodo para futura funcionalidade de alteração do cliente
	public Resultado alterar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	//Metodo para futura funcionalidade de inativação do cliente
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado visualizar(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	//método para verificar se o cliente já não está cadastrado na base de dados através do CPF
	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		Cliente cliente = (Cliente) e;
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			String sql = "SELECT * FROM CLIENTES WHERE cli_cpf = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getCpf());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contagem++;
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhum cliente encontrado.");
			} else {
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
		}finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

	//Método para validar o Login do cliente, verificando existência e infos de login
	public Boolean validarLogin(Cliente cli) {
		
		Cliente cliBase = new Cliente();
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			String sql = "SELECT * FROM CLIENTES WHERE cli_email = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cli.getEmail());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cliBase.setEmail(rs.getString("cli_email"));
				List<String> senhas = new ArrayList<String>();
				
				senhas.add(rs.getString("cli_senha"));

				cliBase.setSenhas(senhas);
				cliBase.setId(Integer.parseInt(rs.getString("cli_id")));
				contagem++;
			}
			
			if(cliBase.getEmail().equals(cli.getEmail()) && cliBase.getSenhas().get(0).equals(cli.getSenhas().get(0)))
			{
				return true;
			}
			
			else
			{
				return false;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");

		}finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
		
		
		return null;
	}

	
	//Método para retornar o ID do cliente
	public String consultarID(Cliente cli) {
		Resultado resultado = new Resultado();
	
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			String sql = "SELECT * FROM CLIENTES WHERE cli_email = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cli.getEmail());
			String id = "";

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
			
				id = rs.getString("cli_id");
			
			}
			
			return id;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");

		}finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
		
		
		return null;
	}
}
