package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOCartao extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		CartaoCredito cartao = (CartaoCredito) entidade;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Resultado resultado = new Resultado();
		
		String sql = "INSERT INTO CARTOES (cart_bandeira, cart_nome, cart_numero, cart_cod, cart_vencimento, cart_preferencial, cli_id, cart_status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, cartao.getBandeira());
			stmt.setString(2, cartao.getNome());
			stmt.setString(3, cartao.getNumero());
			stmt.setString(4, cartao.getCodSeguranca());
			stmt.setDate(5, Date.valueOf(cartao.getDtVenciamento()));
			

			stmt.setBoolean(6, false);
			stmt.setInt(7, cartao.getCliId());
			stmt.setBoolean(8, true);
	
			stmt.execute();

			stmt.close();

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

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
