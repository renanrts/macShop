package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Categoria;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAORelatorio extends AbstractDAO implements IDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;


		try {
			
			List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
	
			Boolean visualizar = false;
			//Select * from ProdxPed AS PP INNER JOIN ACESSORIOS AS a on a.acs_id= PP.ele_id INNER JOIN CATEGORIAS AS C ON C.cat_id = a.cat_id INNER JOIN PEDIDOS as p on p.ped_id = pp.ped_id WHERE P.ped_data between ? and ?
			String sql = "Select * from ProdxPed AS PP INNER JOIN ELETRONICOS AS E ON E.ele_id = PP.ele_id INNER JOIN CATEGORIAS AS C ON C.cat_id = E.cat_id INNER JOIN PEDIDOS as p on p.ped_id = pp.ped_id WHERE P.ped_data between ? and ?";
			stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
								
				Categoria a = new Categoria();
				
				a.setId(rs.getInt("cat_id"));
				a.setDescricao(rs.getString("cat_descricao"));
						
				categorias.add(a);
				contagem++;
			}
			
			if(visualizar){
				resultado.setResultado(categorias.get(0));
			} else{
				resultado.setListaResultado(categorias);
				resultado.setCategoria(categorias);
			}
			
			
			if(contagem == 0){
				resultado.sucesso("Nenhuma categoria encontrado.");
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
		}finally {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

}
