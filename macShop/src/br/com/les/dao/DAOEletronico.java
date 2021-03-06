package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Categoria;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOEletronico extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		Eletronico eletronico = (Eletronico) entidade;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO ELETRONICOS (ele_nome, ele_alimentacao, ele_caminhofoto, cat_id, ele_codigobarras, ele_conteudoembalagem, ele_cor, ele_datafabricaco, ele_descricao, ele_dimensoes, ele_memoria, ele_modelo, ele_processador, ele_ram, ele_resolucaocamera, ele_sistemaoperacional, ele_display, ele_preco, ele_status, ele_dtCadastro, ele_estoque) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, eletronico.getNome());
			stmt.setString(2, eletronico.getAlimentacao());
			stmt.setString(3, eletronico.getCaminhoFoto());
			stmt.setInt(4, eletronico.getCategoria().getId());
			stmt.setString(5, eletronico.getCodigoBarras());
			stmt.setString(6, eletronico.getConteudoEmbalagem());
			stmt.setString(7, eletronico.getCor());
			stmt.setString(8, eletronico.getDataaFabricacao());
			stmt.setString(9, eletronico.getDescricao());
			stmt.setString(10, eletronico.getDimensoes());
			stmt.setString(11, eletronico.getMemoria());
			stmt.setString(12, eletronico.getModelo());
			stmt.setString(13, eletronico.getProcessador());
			stmt.setString(14, eletronico.getRAM());
			stmt.setString(15, eletronico.getResolucaoCamera());
			stmt.setString(16, eletronico.getSistemaOperacional());
			stmt.setString(17, eletronico.getTamanhoDisplay());
			stmt.setDouble(18, eletronico.getPreco());
			stmt.setString(19, "Ativo");
			stmt.setDate(20, new Date(eletronico.getDataCadastro().getTimeInMillis()));
			stmt.setInt(21, 0);

			stmt.execute();

			DAOCategoria dao = new DAOCategoria();
			resultado = dao.consultar(entidade);

			resultado.sucesso("Salvo com sucesso!");
			return resultado;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultado.erro("Erro salvar, por favor, refaça a operação.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Eletronico eletronico = (Eletronico) entidade;
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			List<EntidadeDominio> eletronicos = new ArrayList<EntidadeDominio>();

			Boolean visualizar = false;
			// SQL para retornar um produto específico
			if (eletronico.getCodigoBarras() != null && !eletronico.getCodigoBarras().isEmpty()) {
				String sql = "SELECT * FROM ELETRONICOS WHERE ele_codigobarras = ?";
				stmt = con.prepareStatement(sql);

				stmt.setString(1, eletronico.getCodigoBarras());
				visualizar = true;
				// SQL para retornar somente os produtos ativos e uma categoria específica
			} else if (eletronico.getAtivo() != null && !eletronico.getAtivo().isEmpty()
					&& eletronico.getCategoria().getId() != null) {
				String sql = "SELECT C.ele_nome AS ele_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.ele_alimentacao AS ele_alimentacao, C.ele_caminhofoto AS ele_caminhofoto, C.ele_estoque AS ele_estoque, C.ele_codigobarras AS ele_codigobarras, C.ele_conteudoembalagem AS ele_conteudoembalagem, C.ele_cor AS ele_cor, C.ele_datafabricaco AS ele_datafabricaco, C.ele_descricao AS ele_descricao, C.ele_dimensoes AS ele_dimensoes, C.ele_memoria AS ele_memoria, C.ele_modelo AS ele_modelo, C.ele_preco AS ele_preco, C.ele_processador AS ele_processador, C.ele_ram AS ele_ram, C.ele_resolucaocamera AS ele_resolucaocamera, C.ele_sistemaoperacional AS ele_sistemaoperacional, C.ele_display AS ele_display, C.ele_status AS ele_ativo, C.ele_id AS ele_id FROM ELETRONICOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id where F.cat_id = ? and ele_status = ? order by ele_id";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, eletronico.getCategoria().getId());
				stmt.setString(2, eletronico.getAtivo());
				// SQL para retornar somente os produtos ativos
			} else if (eletronico.getAtivo() != null && !eletronico.getAtivo().isEmpty()) {
				String sql = "SELECT C.ele_nome AS ele_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.ele_alimentacao AS ele_alimentacao, C.ele_caminhofoto AS ele_caminhofoto, C.ele_estoque AS ele_estoque, C.ele_codigobarras AS ele_codigobarras, C.ele_conteudoembalagem AS ele_conteudoembalagem, C.ele_cor AS ele_cor, C.ele_datafabricaco AS ele_datafabricaco, C.ele_descricao AS ele_descricao, C.ele_dimensoes AS ele_dimensoes, C.ele_memoria AS ele_memoria, C.ele_modelo AS ele_modelo, C.ele_preco AS ele_preco, C.ele_processador AS ele_processador, C.ele_ram AS ele_ram, C.ele_resolucaocamera AS ele_resolucaocamera, C.ele_sistemaoperacional AS ele_sistemaoperacional, C.ele_display AS ele_display, C.ele_status AS ele_ativo, C.ele_id AS ele_id FROM ELETRONICOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id where ele_status = ? order by ele_id";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, eletronico.getAtivo());

			}
			// SQL para retornar todos os produtos

			else {
				String sql = "SELECT C.ele_nome AS ele_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.ele_alimentacao AS ele_alimentacao, C.ele_estoque AS ele_estoque, C.ele_caminhofoto AS ele_caminhofoto, C.ele_codigobarras AS ele_codigobarras, C.ele_conteudoembalagem AS ele_conteudoembalagem, C.ele_cor AS ele_cor, C.ele_datafabricaco AS ele_datafabricaco, C.ele_descricao AS ele_descricao, C.ele_dimensoes AS ele_dimensoes, C.ele_memoria AS ele_memoria, C.ele_modelo AS ele_modelo, C.ele_preco AS ele_preco, C.ele_processador AS ele_processador, C.ele_ram AS ele_ram, C.ele_resolucaocamera AS ele_resolucaocamera, C.ele_sistemaoperacional AS ele_sistemaoperacional, C.ele_display AS ele_display, C.ele_status AS ele_ativo, C.ele_id AS ele_id FROM ELETRONICOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id order by ele_id";
				stmt = con.prepareStatement(sql);
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Eletronico a = new Eletronico();
				Categoria cat = new Categoria();

				cat.setDescricao(rs.getString("cat_descricao"));
				cat.setId(rs.getInt("cat_id"));

				a.setNome(rs.getString("ele_nome"));
				a.setAlimentacao(rs.getString("ele_alimentacao"));
				a.setCaminhoFoto(rs.getString("ele_caminhofoto"));
				a.setCategoria(cat);
				a.setCodigoBarras(rs.getString("ele_codigobarras"));
				a.setConteudoEmbalagem(rs.getString("ele_conteudoembalagem"));
				a.setCor(rs.getString("ele_cor"));
				a.setDataaFabricacao(rs.getString("ele_datafabricaco"));
				a.setDescricao(rs.getString("ele_descricao"));
				a.setDimensoes(rs.getString("ele_dimensoes"));
				a.setMemoria(rs.getString("ele_memoria"));
				a.setModelo(rs.getString("ele_modelo"));
				a.setPreco(rs.getDouble("ele_preco"));
				a.setProcessador(rs.getString("ele_processador"));
				a.setRAM(rs.getString("ele_ram"));
				a.setResolucaoCamera(rs.getString("ele_resolucaocamera"));
				a.setSistemaOperacional(rs.getString("ele_sistemaoperacional"));
				a.setTamanhoDisplay(rs.getString("ele_display"));
				a.setAtivo(rs.getString("ele_status"));
				a.setId(rs.getInt("ele_id"));
				a.setTipo("VHELETRONICO");
				a.setEstoque(rs.getInt("ele_estoque"));

				eletronicos.add(a);
				contagem++;
			}

			if (visualizar) {
				resultado.setResultado(eletronicos.get(0));
			} else {
				resultado.setListaResultado(eletronicos);
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhum produto encontrado.");
			} else {
				resultado.sucesso("");
			}

			resultado.setContagem(contagem);
			rs.close();
			stmt.close();
			con.close();
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
	}

	@SuppressWarnings("resource")
	@Override
	public Resultado alterar(EntidadeDominio entidade) {

		Eletronico eletronico = (Eletronico) entidade;
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		try {

			List<EntidadeDominio> eletronicos = new ArrayList<EntidadeDominio>();
			// alterar estoque
			if (eletronico.getEstoque() != 0) {
				String sql = "UPDATE ELETRONICOS SET ele_estoque = ele_estoque + ? WHERE ele_id = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, eletronico.getEstoque());
				stmt.setInt(2, eletronico.getId());
			}
			// alterar informações de cadastro
			else {
				String sql = "UPDATE ELETRONICOS SET ele_nome = ?, ele_alimentacao = ?, ele_caminhofoto = ?, cat_id = ?, ele_codigobarras = ?, ele_conteudoembalagem = ?, ele_cor = ?, ele_datafabricaco = ?, ele_descricao = ?, ele_dimensoes = ?, ele_memoria = ?, ele_modelo = ?, ele_processador = ?, ele_ram = ?, ele_resolucaocamera = ?, ele_sistemaoperacional = ?, ele_display = ?, ele_preco = ?, ele_status = ? WHERE ele_id = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, eletronico.getNome());
				stmt.setString(2, eletronico.getAlimentacao());
				stmt.setString(3, eletronico.getCaminhoFoto());
				stmt.setInt(4, eletronico.getCategoria().getId());
				stmt.setString(5, eletronico.getCodigoBarras());
				stmt.setString(6, eletronico.getConteudoEmbalagem());
				stmt.setString(7, eletronico.getCor());
				stmt.setString(8, eletronico.getDataaFabricacao());
				stmt.setString(9, eletronico.getDescricao());
				stmt.setString(10, eletronico.getDimensoes());
				stmt.setString(11, eletronico.getMemoria());
				stmt.setString(12, eletronico.getModelo());
				stmt.setString(13, eletronico.getProcessador());
				stmt.setString(14, eletronico.getRAM());
				stmt.setString(15, eletronico.getResolucaoCamera());
				stmt.setString(16, eletronico.getSistemaOperacional());
				stmt.setString(17, eletronico.getTamanhoDisplay());
				stmt.setDouble(18, eletronico.getPreco());
				stmt.setString(19, eletronico.getAtivo());
				stmt.setInt(20, eletronico.getId());

			}

			ResultSet rs = stmt.executeQuery();
			// select para exibir informações
			String sql = "SELECT C.ele_nome AS ele_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.ele_estoque AS ele_estoque, C.ele_alimentacao AS ele_alimentacao, C.ele_caminhofoto AS ele_caminhofoto, C.ele_codigobarras AS ele_codigobarras, C.ele_conteudoembalagem AS ele_conteudoembalagem, C.ele_cor AS ele_cor, C.ele_datafabricaco AS ele_datafabricaco, C.ele_descricao AS ele_descricao, C.ele_dimensoes AS ele_dimensoes, C.ele_memoria AS ele_memoria, C.ele_modelo AS ele_modelo, C.ele_preco AS ele_preco, C.ele_processador AS ele_processador, C.ele_ram AS ele_ram, C.ele_resolucaocamera AS ele_resolucaocamera, C.ele_sistemaoperacional AS ele_sistemaoperacional, C.ele_display AS ele_display, C.ele_status AS ele_ativo, C.ele_id AS ele_id FROM ELETRONICOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id where ele_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, eletronico.getId());
			ResultSet rt = stmt.executeQuery();

			while (rt.next()) {
				Eletronico a = new Eletronico();
				Categoria categoria = new Categoria();

				categoria.setDescricao(rt.getString("cat_descricao"));
				categoria.setId(rt.getInt("cat_id"));
				a.setNome(rt.getString("ele_nome"));
				a.setAlimentacao(rt.getString("ele_alimentacao"));
				a.setCaminhoFoto(rt.getString("ele_caminhofoto"));
				a.setCategoria(categoria);
				a.setCodigoBarras(rt.getString("ele_codigobarras"));
				a.setConteudoEmbalagem(rt.getString("ele_conteudoembalagem"));
				a.setCor(rt.getString("ele_cor"));
				a.setDataaFabricacao(rt.getString("ele_datafabricaco"));
				a.setDescricao(rt.getString("ele_descricao"));
				a.setDimensoes(rt.getString("ele_dimensoes"));
				a.setMemoria(rt.getString("ele_memoria"));
				a.setModelo(rt.getString("ele_modelo"));
				a.setPreco(rt.getDouble("ele_preco"));
				a.setProcessador(rt.getString("ele_processador"));
				a.setRAM(rt.getString("ele_ram"));
				a.setResolucaoCamera(rt.getString("ele_resolucaocamera"));
				a.setSistemaOperacional(rt.getString("ele_sistemaoperacional"));
				a.setTamanhoDisplay(rt.getString("ele_display"));
				a.setAtivo(rt.getString("ele_status"));
				a.setId(rt.getInt("ele_id"));
				a.setEstoque(rt.getInt("ele_estoque"));

				eletronicos.add(a);
				contagem++;

				resultado.setListaResultado(eletronicos);
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhum produto encontrado.");
			} else {
				resultado.sucesso("Alterado com sucesso!");
			}

			resultado.setContagem(contagem);
			rs.close();
			rt.close();

			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		Eletronico eletronico = (Eletronico) entidade;

		Resultado resultado = new Resultado();

		String sql = "UPDATE ELETRONICOS SET ele_status = ? WHERE ele_id = ?";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, "Inativo");
			stmt.setInt(2, eletronico.getId());

			stmt.execute();

			stmt.close();

			resultado.sucesso("Inativado com sucesso!");
			return resultado;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultado.erro("Erro salvar, por favor, refaça a operação.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

	public Resultado visualizar(EntidadeDominio entidade) {
		Eletronico eletronico = (Eletronico) entidade;
		Resultado resultado = new Resultado();
		Categoria categoria = new Categoria();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			List<EntidadeDominio> eletronicos = new ArrayList<EntidadeDominio>();

			Boolean visualizar = false;

			String sql = "SELECT C.ele_nome AS ele_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.ele_estoque AS ele_estoque, C.ele_alimentacao AS ele_alimentacao, C.ele_status AS ele_status, C.ele_caminhofoto AS ele_caminhofoto, C.ele_codigobarras AS ele_codigobarras, C.ele_conteudoembalagem AS ele_conteudoembalagem, C.ele_cor AS ele_cor, C.ele_datafabricaco AS ele_datafabricaco, C.ele_descricao AS ele_descricao, C.ele_dimensoes AS ele_dimensoes, C.ele_memoria AS ele_memoria, C.ele_modelo AS ele_modelo, C.ele_preco AS ele_preco, C.ele_processador AS ele_processador, C.ele_ram AS ele_ram, C.ele_resolucaocamera AS ele_resolucaocamera, C.ele_sistemaoperacional AS ele_sistemaoperacional, C.ele_display AS ele_display, C.ele_status AS ele_ativo, C.ele_id AS ele_id FROM ELETRONICOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id WHERE ele_id = ?";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, eletronico.getId());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Eletronico a = new Eletronico();
				Categoria category = new Categoria();
				category.setDescricao(rs.getString("cat_descricao"));
				category.setId(rs.getInt("cat_id"));

				a.setNome(rs.getString("ele_nome"));
				a.setAlimentacao(rs.getString("ele_alimentacao"));
				a.setCaminhoFoto(rs.getString("ele_caminhofoto"));
				a.setCategoria(category);
				a.setCodigoBarras(rs.getString("ele_codigobarras"));
				a.setConteudoEmbalagem(rs.getString("ele_conteudoembalagem"));
				a.setCor(rs.getString("ele_cor"));
				a.setDataaFabricacao(rs.getString("ele_datafabricaco"));
				a.setDescricao(rs.getString("ele_descricao"));
				a.setDimensoes(rs.getString("ele_dimensoes"));
				a.setMemoria(rs.getString("ele_memoria"));
				a.setModelo(rs.getString("ele_modelo"));
				a.setPreco(rs.getDouble("ele_preco"));
				a.setProcessador(rs.getString("ele_processador"));
				a.setRAM(rs.getString("ele_ram"));
				a.setResolucaoCamera(rs.getString("ele_resolucaocamera"));
				a.setSistemaOperacional(rs.getString("ele_sistemaoperacional"));
				a.setTamanhoDisplay(rs.getString("ele_display"));
				a.setAtivo(rs.getString("ele_status"));
				a.setId(rs.getInt("ele_id"));
				categoria.setId(rs.getInt("cat_id"));
				a.setTipo("VHELETRONICO");
				a.setEstoque(rs.getInt("ele_estoque"));
				eletronicos.add(a);
				eletronicos.add(categoria);
				contagem++;
			}

			if (visualizar) {
				resultado.setResultado(eletronicos.get(0));
			} else {
				resultado.setListaResultado(eletronicos);
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhum produto encontrado.");
			} else {
				resultado.sucesso("");
			}

			resultado.setContagem(contagem);
			rs.close();
			con.close();
			stmt.close();
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		Eletronico eletronico = (Eletronico) e;
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			String sql = "SELECT * FROM ELETRONICOS WHERE ele_codigobarras = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, eletronico.getCodigoBarras());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contagem++;
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhum produto encontrado.");
			} else {
				resultado.sucesso("");
			}

			resultado.setContagem(contagem);
			rs.close();
			stmt.close();
			con.close();
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
	}

	//Método implementado para futura inclusão da funcionalidade de diminuir estoque
	public Resultado alterarEstoque(EntidadeDominio e) {
		System.out.println(e.getClass().getSimpleName());
		Eletronico eletronico = (Eletronico) e;
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			String sql = "UPDATE ELETRONICOS SET ele_estoque = ele_estoque - ? WHERE ele_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, eletronico.getEstoque());
			stmt.setInt(2, eletronico.getId());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contagem++;
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhum produto encontrado.");
			} else {
				resultado.sucesso("");
			}

			resultado.setContagem(contagem);
			rs.close();
			stmt.close();
			con.close();
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
	}

	//Metodo para voltar produto ao estoque (quando há troca).
	public Resultado voltarEstoque(EntidadeDominio e) {

		Eletronico eletronico = (Eletronico) e;
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			String sql = "UPDATE ELETRONICOS SET ele_estoque = ele_estoque + ? WHERE ele_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, eletronico.getEstoque());
			stmt.setInt(2, eletronico.getId());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contagem++;
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhum produto encontrado.");
			} else {
				resultado.sucesso("");
			}

			resultado.setContagem(contagem);
			rs.close();
			con.close();
			stmt.close();
			return resultado;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
	}

}
