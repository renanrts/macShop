package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Cidade;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Estado;
import br.com.les.util.Resultado;

public class DAOEndereco extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Endereco endereco = (Endereco) entidade;
		
		Resultado resultado = new Resultado();
		
		String sql = "INSERT INTO ENDERECOS (end_cid_id, end_tipo_residencia, end_cep, end_logradouro, end_numero, end_tipo_logradouro, end_bairro, end_obs, end_cli_id, end_status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, endereco.getCidade().getId());
			stmt.setString(2, endereco.getTipoEndereco());
			stmt.setString(3, endereco.getCep());
			stmt.setString(4, endereco.getLogradouro());
			stmt.setString(5, endereco.getNumero());
			stmt.setString(6, endereco.getTipoLogradouro());
			stmt.setString(7, endereco.getBairro());
			stmt.setString(8, endereco.getObservacao());
			stmt.setInt(9, endereco.getCliId());
			stmt.setBoolean(10, true);
			
	
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
