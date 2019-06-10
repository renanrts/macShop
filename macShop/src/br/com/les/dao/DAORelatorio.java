package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Categoria;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Relatorio;
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
		Relatorio rel = (Relatorio) entidade;
		Resultado resultado = new Resultado();
		int contagem = 0;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Integer quantidadeIphoneMasculino = 0;
		Integer quantidadeIphoneFeminino = 0;
		Integer quantidadeIpadMasculino = 0;
		Integer quantidadeIpadFeminino = 0;
		Integer quantidadeMacbookMasculino = 0;
		Integer quantidadeMacbookFeminino = 0;
		Integer quantidadeTotalIphone = 0;
		Integer quantidadeTotalIpad = 0;
		Integer quantidadeTotalMacbook = 0;
		Integer quantidadeItenTrocados = 0;
		Integer quantidadeTotaisItens = 0;
		Integer quantidadeTotaisReprovados = 0;
		Integer quantidadeTotaisEmtroca = 0;
		
		List<Integer> quantidades = new ArrayList<Integer>();
		
		try {

			//Select * from ProdxPed AS PP INNER JOIN ACESSORIOS AS a on a.acs_id= PP.ele_id INNER JOIN CATEGORIAS AS C ON C.cat_id = a.cat_id INNER JOIN PEDIDOS as p on p.ped_id = pp.ped_id WHERE P.ped_data between ? and ?
			String sql = "Select * from ProdxPed AS PP INNER JOIN ELETRONICOS AS E ON E.ele_id = PP.ele_id INNER JOIN CATEGORIAS AS C ON C.cat_id = E.cat_id INNER JOIN PEDIDOS as p on p.ped_id = pp.ped_id  INNER join CLIENTES as cli on cli.cli_id = p.cli_id WHERE P.ped_data between ? and ?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(rel.getDataInicio()));
			stmt.setDate(2, Date.valueOf(rel.getDataFim()));

			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
				String cat = rs.getString("cat_descricao");
				String genero = rs.getString("cli_genero");
				String troca = rs.getString("prodxped_status");
				
				if(troca.equals("Trocado"))
				{
					quantidadeItenTrocados++;
				}
				
				if(troca.equals("Em Troca"))
				{
					quantidadeTotaisEmtroca++;
				}
				
				if(troca.equals("Reprovado"))
				{
					quantidadeTotaisReprovados++;
				}
				
				if(cat.equals("iPhone"))
				{
					quantidadeTotalIphone++;
					if(genero.equals("MASCULINO"))
					{
						quantidadeIphoneMasculino++;
					}
					else {
						quantidadeIphoneFeminino++;
					}
				}
				
				if(cat.equals("iPad"))
				{
					quantidadeTotalIpad++;
					if(genero.equals("MASCULINO"))
					{
						quantidadeIpadMasculino++;
					}
					else {
						quantidadeIpadFeminino++;
					}
				}
				
				if(cat.equals("Macbook"))
				{
					quantidadeTotalMacbook++;
					if(genero.equals("MASCULINO"))
					{
						quantidadeMacbookMasculino++;
					}
					else {
						quantidadeMacbookFeminino++;
					}
				}
				
				contagem++;
				quantidadeTotaisItens++;
	
			}
			quantidades.add(quantidadeIphoneMasculino);
			quantidades.add(quantidadeIphoneFeminino);
			quantidades.add(quantidadeIpadMasculino);
			quantidades.add(quantidadeIpadFeminino);
			quantidades.add(quantidadeMacbookMasculino);
			quantidades.add(quantidadeMacbookFeminino);
			quantidades.add(quantidadeTotalIphone);
			quantidades.add(quantidadeTotalIpad);
			quantidades.add(quantidadeTotalMacbook);
			quantidades.add(quantidadeItenTrocados);
			quantidades.add(quantidadeTotaisItens);
			quantidades.add(quantidadeTotaisEmtroca);
			quantidades.add(quantidadeTotaisReprovados);

		
			resultado.setQtdeRelatorio(quantidades);
			

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
