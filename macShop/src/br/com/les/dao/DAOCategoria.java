package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Categoria;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOCategoria extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();

			Boolean visualizar = false;

			String sql = "SELECT * FROM CATEGORIAS";
			stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Categoria a = new Categoria();

				a.setId(rs.getInt("cat_id"));
				a.setDescricao(rs.getString("cat_descricao"));

				categorias.add(a);
				contagem++;
			}

			if (visualizar) {
				resultado.setResultado(categorias.get(0));
			} else {
				resultado.setListaResultado(categorias);
				resultado.setCategoria(categorias);
			}

			if (contagem == 0) {
				resultado.sucesso("Nenhuma categoria encontrado.");
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
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
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
		return null;

	}
	
	//metodo para identificar a categoria de um produto em questão (StComplementarCategoria)
	public Resultado consultarCategoria(EntidadeDominio e) {

		Resultado resultado = new Resultado();
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		if (e.getTipo().equals("VHELETRONICO")) {
			Eletronico eletronico = (Eletronico) e;
			int idCategoria = eletronico.getCategoria().getId();
			try {
				String sql = "SELECT * FROM CATEGORIAS WHERE CAT_ID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, idCategoria);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {

					eletronico.getCategoria().setDescricao(rs.getString("cat_descricao"));

				}

				rs.close();
				stmt.close();
				return null;

			} catch (SQLException e1) {

				e1.printStackTrace();
				resultado.erro("Erro de consulta.");
				return resultado;
			} finally {
				ConnectionFactory.closeConnection(stmt, con);
			}

		}

		else {
			Acessorio acessorio = (Acessorio) e;
			int idCategoria = acessorio.getCategoria().getId();
			try {

				String sql = "SELECT * FROM CATEGORIAS WHERE CAT_ID = ?";
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, idCategoria);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {

					acessorio.getCategoria().setDescricao(rs.getString("cat_descricao"));

				}

				rs.close();
				stmt.close();
				return null;

			} catch (SQLException e1) {

				e1.printStackTrace();
				resultado.erro("Erro de consulta.");
				return resultado;
			} finally {
				ConnectionFactory.closeConnection(stmt, con);
			}
		}

	}

	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	//metodo para consultar todas as categorias cadastradas para montar o relatório
	public List<EntidadeDominio> consultarCategorias() {
		List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
		Resultado resultado = new Resultado();
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM CATEGORIAS";
			stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Categoria cat = new Categoria();
				cat.setDescricao(rs.getString("cat_descricao"));
				categorias.add(cat);

			}

			rs.close();
			stmt.close();
			return categorias;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return null;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}
}
