package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Inativacao;
import br.com.les.util.Resultado;

public class DAOInativacao extends AbstractDAO{

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Inativacao inativacao = (Inativacao) entidade;
		
		Resultado resultado = new Resultado();
		
		String sql = "INSERT INTO INATIVACOES (sts_prod_id, sts_motivo, sts_status, sts_dataAlteracao) "
				+ "VALUES (?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, inativacao.getProdutoId());
			stmt.setString(2, inativacao.getMotivo());
			stmt.setString(3, "INATIVO");
			stmt.setDate(4, new Date(inativacao.getDataAlteracao().getTimeInMillis()));
	
			stmt.execute();

			stmt.close();
			
			resultado.sucesso("Inativado com sucesso!");
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
