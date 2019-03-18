package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Categoria;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class DAOAcessorio extends AbstractDAO{

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		Acessorio acessorio = (Acessorio) entidade;
		
		Resultado resultado = new Resultado();
		
		String sql = "INSERT INTO ACESSORIOS (acs_nome, acs_preco, cat_id, acs_datafabricacao, acs_cor, acs_dimensoes, acs_codigobarras, acs_caminhofoto, acs_descricao, acs_status, acs_modelocompativel, acs_mfi, acs_dtCadastro) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, acessorio.getNome());
			stmt.setDouble(2, acessorio.getPreco());
			stmt.setString(3, String.valueOf(acessorio.getCategoria().getId()));
			stmt.setString(4, acessorio.getDataaFabricacao());
			stmt.setString(5, acessorio.getCor());
			stmt.setString(6, acessorio.getDimensoes());
			stmt.setString(7, acessorio.getCodigoBarras());
			stmt.setString(8, acessorio.getCaminhoFoto());
			stmt.setString(9, acessorio.getDescricao());
			stmt.setString(10, "Ativo");
			stmt.setString(11, acessorio.getModeloCompativel());;
			stmt.setBoolean(12, acessorio.isSeloMfi());		
			stmt.setDate(13, new Date(acessorio.getDataCadastro().getTimeInMillis()));
			
			stmt.execute();

			stmt.close();
			
			DAOCategoria dao = new DAOCategoria();
			resultado = dao.consultar(entidade);

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
		Acessorio acessorio = (Acessorio) entidade;
		Resultado resultado = new Resultado();
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> acessorios = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
			Boolean visualizar = false;
			
			if (acessorio.getId() != 0)
			{
				stmt = this.con.prepareStatement("SELECT * FROM ELETRONICOS WHERE id = ?");
				stmt.setInt(1, acessorio.getId());
			}
			else
			{
				stmt = this.con.prepareStatement(
						" SELECT C.acs_nome AS ele_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.acs_caminhofoto AS acs_caminhofoto, C.acs_codigobarras AS acs_codigobarras, C.acs_cor AS acs_cor, C.acs_datafabricacao AS acs_datafabricacao, C.acs_descricao AS acs_descricao, C.acs_dimensoes AS acs_dimensoes, C.acs_modelocompativel AS acs_modelocompativel, C.acs_preco AS acs_preco, C.acs_mfi AS acs_mfi, C.acs_status AS acs_ativo, C.acs_id AS acs_id FROM ACESSORIOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id order by acs_id"
				);
			}
			
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
								
				Acessorio a = new Acessorio();
				Categoria cat = new Categoria ();
				
				cat.setDescricao(rs.getString("cat_descricao"));
				cat.setId(rs.getInt("cat_id"));

						
				a.setNome(rs.getString("acs_nome"));
				a.setCaminhoFoto(rs.getString("acs_caminhofoto"));
				a.setCategoria(cat);
				a.setCodigoBarras(rs.getString("acs_codigobarras"));
				a.setCor(rs.getString("acs_cor"));
				a.setDataaFabricacao(rs.getString("acs_datafabricacao"));
				a.setDescricao(rs.getString("acs_descricao"));
				a.setDimensoes(rs.getString("acs_dimensoes"));
				a.setModeloCompativel(rs.getString("acs_modelocompativel"));
				a.setPreco(rs.getDouble("acs_preco"));
				a.setAtivo(rs.getString("acs_status"));
				a.setId(rs.getInt("acs_id"));
				a.setSeloMfi(rs.getBoolean("acs_mfi"));
				a.setTipo("VHACESSORIO");
				

				
				acessorios.add(a);
				contagem++;
			}
			
			if(visualizar){
				resultado.setResultado(acessorios.get(0));
			} else{
				resultado.setListaResultado(acessorios);
			}
			
			
			if(contagem == 0){
				resultado.sucesso("Nenhum produto encontrado.");
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
		Acessorio acessorio = (Acessorio) entidade;
		Resultado resultado = new Resultado();
		Categoria cat = new Categoria();
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> acessorios = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
			
			
		
				stmt = this.con.prepareStatement("UPDATE ACESSORIOS SET acs_nome = ?, acs_preco = ?, cat_id = ?, acs_datafabricacao = ?, acs_cor = ?, acs_dimensoes = ?, acs_codigobarras = ?, acs_caminhofoto = ?, acs_descricao = ?, acs_status = ?, acs_modelocompativel = ?, acs_mfi = ? WHERE acs_id = ?");	
				
				stmt.setString(1, acessorio.getNome());
				stmt.setDouble(2, acessorio.getPreco());
				stmt.setString(3, String.valueOf(acessorio.getCategoria().getId()));
				stmt.setString(4, acessorio.getDataaFabricacao());
				stmt.setString(5, acessorio.getCor());
				stmt.setString(6, acessorio.getDimensoes());
				stmt.setString(7, acessorio.getCodigoBarras());
				stmt.setString(8, acessorio.getCaminhoFoto());
				stmt.setString(9, acessorio.getDescricao());
				stmt.setString(10, acessorio.getAtivo());
				stmt.setString(11, acessorio.getModeloCompativel());;
				stmt.setBoolean(12, acessorio.isSeloMfi());	
				stmt.setInt(13, acessorio.getId());
				
				
			
			
			ResultSet rs = stmt.executeQuery();
						
			stmt = this.con.prepareStatement("SELECT C.acs_nome AS acs_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.acs_caminhofoto AS acs_caminhofoto, C.acs_codigobarras AS acs_codigobarras, C.acs_cor AS acs_cor, C.acs_datafabricacao AS acs_datafabricacao, C.acs_descricao AS acs_descricao, C.acs_dimensoes AS acs_dimensoes, C.acs_modelocompativel AS acs_modelocompativel, C.acs_preco AS acs_preco, C.acs_mfi AS acs_mfi, C.acs_status AS acs_ativo, C.acs_id AS acs_id FROM ACESSORIOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id WHERE acs_id = ?");

			stmt.setInt(1, acessorio.getId());
			ResultSet rt = stmt.executeQuery();
			
			while (rt.next()) {
				Acessorio a = new Acessorio();
				Categoria category = new Categoria();
				category.setDescricao(rt.getString("cat_descricao"));
				category.setId(rt.getInt("cat_id"));
						
				a.setNome(rt.getString("acs_nome"));
				a.setCaminhoFoto(rt.getString("acs_caminhofoto"));
				a.setCategoria(category);
				a.setCodigoBarras(rt.getString("acs_codigobarras"));
				a.setCor(rt.getString("acs_cor"));
				a.setDataaFabricacao(rt.getString("acs_datafabricacao"));
				a.setDescricao(rt.getString("acs_descricao"));
				a.setDimensoes(rt.getString("acs_dimensoes"));
				a.setModeloCompativel(rt.getString("acs_modelocompativel"));
				a.setPreco(rt.getDouble("acs_preco"));
				a.setAtivo(rt.getString("acs_status"));
				a.setId(rt.getInt("acs_id"));
				a.setSeloMfi(rt.getBoolean("acs_mfi"));
				a.setTipo("VHACESSORIO");
				
				
				acessorios.add(a);
				
				contagem++;
				
			
				resultado.setListaResultado(acessorios);
			}
			
			
			if(contagem == 0){
				resultado.sucesso("Nenhum produto encontrado.");
			}
			else{
				resultado.sucesso("Alterado com sucesso!");
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
	public Resultado excluir(EntidadeDominio entidade) {
		Acessorio acessorio = (Acessorio) entidade;
		
		Resultado resultado = new Resultado();
		
		String sql = "UPDATE ACESSORIOS SET acs_status = ? WHERE acs_id = ?";


		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Inativo");
			stmt.setInt(2, acessorio.getId());

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
	public Resultado visualizar(EntidadeDominio e) {
		Acessorio acessorio = (Acessorio) e;
		Resultado resultado = new Resultado();
		Categoria categoria = new Categoria();
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> acessorios = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
			Boolean visualizar = false;
			

			stmt = this.con.prepareStatement("SELECT C.acs_nome AS ele_nome, F.cat_descricao AS cat_descricao, F.cat_id AS cat_id, C.acs_caminhofoto AS acs_caminhofoto, C.acs_codigobarras AS acs_codigobarras, C.acs_cor AS acs_cor, C.acs_datafabricacao AS acs_datafabricacao, C.acs_descricao AS acs_descricao, C.acs_dimensoes AS acs_dimensoes, C.acs_modelocompativel AS acs_modelocompativel, C.acs_preco AS acs_preco, C.acs_mfi AS acs_mfi, C.acs_status AS acs_ativo, C.acs_id AS acs_id FROM ACESSORIOS AS C INNER JOIN CATEGORIAS AS F ON C.cat_id = F.cat_id WHERE acs_id = ?");
			stmt.setInt(1, acessorio.getId());

			
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
								
				Acessorio a = new Acessorio();
				Categoria category = new Categoria();
				category.setDescricao(rs.getString("cat_descricao"));
				category.setId(rs.getInt("cat_id"));
						
				a.setNome(rs.getString("acs_nome"));
				a.setCaminhoFoto(rs.getString("acs_caminhofoto"));
				a.setCategoria(category);
				a.setCodigoBarras(rs.getString("acs_codigobarras"));
				a.setCor(rs.getString("acs_cor"));
				a.setDataaFabricacao(rs.getString("acs_datafabricacao"));
				a.setDescricao(rs.getString("acs_descricao"));
				a.setDimensoes(rs.getString("acs_dimensoes"));
				a.setModeloCompativel(rs.getString("acs_modelocompativel"));
				a.setPreco(rs.getDouble("acs_preco"));
				a.setAtivo(rs.getString("acs_status"));
				a.setId(rs.getInt("acs_id"));
				a.setSeloMfi(rs.getBoolean("acs_mfi"));
				a.setTipo("VHACESSORIO");
				
				
				acessorios.add(a);
				acessorios.add(categoria);
				contagem++;
			}
			
			if(visualizar){
				resultado.setResultado(acessorios.get(0));
			} else{
				resultado.setListaResultado(acessorios);
			}
			
		
			if(contagem == 0){
				resultado.sucesso("Nenhum produto encontrado.");
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

}