package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Categoria;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class DAOCategoria extends AbstractDAO{

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
			Boolean visualizar = false;
			
			stmt = this.con.prepareStatement("SELECT * FROM CATEGORIAS");
			
			
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

}