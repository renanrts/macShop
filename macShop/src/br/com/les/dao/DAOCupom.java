package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOCupom extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		Cupom cupom = (Cupom) entidade;


		try {
			
			String sql = "INSERT INTO CUPONS (CUP_CODIGO, CUP_VALOR, CLI_ID, CUP_STATUS, CUP_TIPO, CUP_VALIDADE) " + "VALUES (?, ?, ?, ?, ?, ?)";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, cupom.getCodigo());
			stmt.setDouble(2, cupom.getValor());
			if (cupom.getCliId() != 0)
			{
				stmt.setInt(3, cupom.getCliId());
			}
			else
			{
				stmt.setInt(3, 0);
			}
			stmt.setString(4, "ATIVO");
			stmt.setString(5, cupom.getTipoCupom().toString());
			stmt.setDate(6, java.sql.Date.valueOf(cupom.getDataDeValidade().toString()));
			

			stmt.executeQuery();
			stmt.close();

			resultado.sucesso("Cupom criado com sucesso!");
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
	public Resultado consultar(EntidadeDominio entidade) {

		return null;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();

		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Cupom cupom = (Cupom) entidade;

		try {

			String sql = "UPDATE CUPONS SET cup_status = ? WHERE CUP_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "INATIVO");
			stmt.setInt(2, cupom.getId());

			ResultSet rs = stmt.executeQuery();

			resultado.sucesso("Cupom invalidado com sucesso");

			rs.close();
			stmt.close();

			return null;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return null;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
	}

	@Override
	public Resultado visualizar(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cupom consultarValidade(EntidadeDominio e) {

		Resultado resultado = new Resultado();

		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Cupom cupom = (Cupom) e;

		if (cupom.getId() == null) {
			return null;
		}

		try {

			String sql = "SELECT * FROM CUPONS WHERE CUP_ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cupom.getId());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				cupom.setId(Integer.parseInt(rs.getString("cup_id")));
				cupom.setStatus(rs.getString("cup_status"));
				cupom.setValor(Double.parseDouble(rs.getString("cup_valor")));
				cupom.setDataDeValidade(rs.getDate("CUP_validade").toLocalDate());
			}

			rs.close();
			stmt.close();

			return cupom;

		} catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return cupom;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

}
