package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class DAOCartao extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		CartaoCredito cartao = (CartaoCredito) entidade;
		
		Resultado resultado = new Resultado();
		
		String sql = "INSERT INTO CARTOES (cart_bandeira, cart_nome, cart_numero, cart_cod, cart_vencimento, cart_preferencial, cart_cli_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cartao.getBandeira());
			stmt.setString(2, cartao.getNome());
			stmt.setString(3, cartao.getNumero());
			stmt.setString(4, cartao.getCodSeguranca());
			stmt.setDate(5, new Date (cartao.getDtVenciamento().getTimeInMillis()));
			stmt.setBoolean(6, true);
			//stmt.setInt(7, eletronico.getCor());
	
			stmt.execute();

			stmt.close();

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
