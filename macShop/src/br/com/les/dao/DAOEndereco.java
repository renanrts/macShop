package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.les.dominio.Categoria;
import br.com.les.dominio.Cidade;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Estado;
import br.com.les.dominio.Genero;
import br.com.les.util.Resultado;

public class DAOEndereco extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
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
	
	public List<Cidade> completarCidades(EntidadeDominio e) {
		List<Cidade> listaCidade = new ArrayList<Cidade>();
		
		try {
			
			
			PreparedStatement stmt = null;
			
			stmt = this.con.prepareStatement("SELECT * FROM cidade");
			
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
								
				Cidade cid = new Cidade();
				
				cid.setId(rs.getInt("cid_id"));
				cid.setNome(rs.getString("cid_nome"));
				
				listaCidade.add(cid);

			} 
			rs.close();
			stmt.close();
			
		}catch (SQLException e1) {
				
				e1.printStackTrace();
				
			return null;
		}

		return listaCidade;
	}
	
	public List<Estado> completarEstados(EntidadeDominio e) {
		List<Estado> listaEstado = new ArrayList<Estado>();
		
		try {
			
			
			PreparedStatement stmt = null;
			
			stmt = this.con.prepareStatement("SELECT * FROM estado");
			
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
								
				Estado est = new Estado();
				
				est.setId(rs.getInt("est_id"));
				est.setNome(rs.getString("est_nome"));
				
				listaEstado.add(est);

			} 
			rs.close();
			stmt.close();
			
		}catch (SQLException e1) {
				
				e1.printStackTrace();
				
			return null;
		}

		return listaEstado;
	}

}
