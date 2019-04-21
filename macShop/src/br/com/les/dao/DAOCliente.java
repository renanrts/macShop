package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
					"SELECT * from ENDERECOS AS C INNER JOIN CLIENTES AS F ON C.end_cli_Id = F.cli_id INNER JOIN CARTOES AS D ON F.cli_id = D.cart_cli_id INNER JOIN cidade AS G ON C.end_cid_id = G.cid_id INNER JOIN estado AS P ON P.est_id = g.cid_est_id WHERE G.cid_id = C.end_cid_id AND P.est_id = g.cid_est_id AND c.end_status = 1 AND d.cart_status = 1 AND f.cli_id = ?"	
					);
			stmt.setInt(1, cliente.getId());
			
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
					cart.setId(rs.getInt("cart_id"));
					cart.setDtVenciamento(LocalDate.parse(rs.getDate("cart_vencimento").toString()));
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
			
			stmt = this.con.prepareStatement(
					"SELECT * from CUPONS AS C INNER JOIN CLIENTES AS F ON C.CLI_ID = f.cli_id where f.cli_id = ?"	
					);
			stmt.setInt(1, cliente.getId());
			
			ResultSet rsT = stmt.executeQuery();
						
			List<Cupom> cupons = new ArrayList<Cupom>();
			
			while (rsT.next()) {
				Cupom cup = new Cupom();
				
				cup.setId(Integer.parseInt(rsT.getString("CUP_ID")));
				cup.setStatus(rsT.getString("CUP_STATUS"));
				cup.setValor(Double.parseDouble(rsT.getString("CUP_VALOR")));
				if (cup.getStatus().equals("ATIVO"))
				{
					cupons.add(cup);
				}
				
			}
			
			
			cliente.setCupons(cupons);
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
			rsT.close();
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
		Acessorio acessorio = (Acessorio) entidade;
		Resultado resultado = new Resultado();
		Categoria cat = new Categoria();
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> acessorios = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
			
			
		
				stmt = this.con.prepareStatement("UPDATE ACESSORIOS SET acs_nome = ?, acs_preco = ?, cat_id = ?, acs_datafabricacao = ?, acs_cor = ?, acs_dimensoes = ?, acs_codigobarras = ?, acs_caminhofoto = ?, acs_descricao = ?, acs_status = ?, acs_modelocompativel = ?, acs_mfi = ? WHERE acs_id = ?");	
				
				stmt.setString(1, acessorio.getNome());
				stmt.setDouble(2, acessorio.getPreco());
				stmt.setString(3, String.valueOf(acessorio.getCategoria().getId()));
				stmt.setString(4, acessorio.getDataaFabricacao());
				stmt.setString(5, acessorio.getCor());
				stmt.setString(6, acessorio.getDimensoes());
				stmt.setString(7, acessorio.getCodigoBarras());
				stmt.setString(8, acessorio.getCaminhoFoto());
				stmt.setString(9, acessorio.getDescricao());
				stmt.setString(10, acessorio.getAtivo());
				stmt.setString(11, acessorio.getModeloCompativel());;
				stmt.setBoolean(12, acessorio.isSeloMfi());	
				stmt.setInt(13, acessorio.getId());
				
				
			
			
			ResultSet rs = stmt.executeQuery();
						
			stmt = this.con.prepareStatement("SELECT C.acs_nome AS acs_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.acs_caminhofoto AS acs_caminhofoto, C.acs_codigobarras AS acs_codigobarras, C.acs_cor AS acs_cor, C.acs_datafabricacao AS acs_datafabricacao, C.acs_descricao AS acs_descricao, C.acs_dimensoes AS acs_dimensoes, C.acs_modelocompativel AS acs_modelocompativel, C.acs_preco AS acs_preco, C.acs_mfi AS acs_mfi, C.acs_status AS acs_ativo, C.acs_id AS acs_id FROM ACESSORIOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id WHERE acs_id = ?");

			stmt.setInt(1, acessorio.getId());
			ResultSet rt = stmt.executeQuery();
			
			while (rt.next()) {
				Acessorio a = new Acessorio();
				Categoria category = new Categoria();
				category.setDescricao(rt.getString("cat_descricao"));
				category.setId(rt.getInt("cat_id"));
						
				a.setNome(rt.getString("acs_nome"));
				a.setCaminhoFoto(rt.getString("acs_caminhofoto"));
				a.setCategoria(category);
				a.setCodigoBarras(rt.getString("acs_codigobarras"));
				a.setCor(rt.getString("acs_cor"));
				a.setDataaFabricacao(rt.getString("acs_datafabricacao"));
				a.setDescricao(rt.getString("acs_descricao"));
				a.setDimensoes(rt.getString("acs_dimensoes"));
				a.setModeloCompativel(rt.getString("acs_modelocompativel"));
				a.setPreco(rt.getDouble("acs_preco"));
				a.setAtivo(rt.getString("acs_status"));
				a.setId(rt.getInt("acs_id"));
				a.setSeloMfi(rt.getBoolean("acs_mfi"));
				a.setTipo("VHACESSORIO");
				
				
				acessorios.add(a);
				
				contagem++;
				
			
				resultado.setListaResultado(acessorios);
			}
			
			
			if(contagem == 0){
				resultado.sucesso("Nenhum produto encontrado.");
			}
			else{
				resultado.sucesso("Alterado com sucesso!");
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
