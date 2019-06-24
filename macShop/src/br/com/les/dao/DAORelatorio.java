package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

		Integer quantidadeTotalIphone = 0;
		Integer quantidadeTotalIpad = 0;
		Integer quantidadeTotalMacbook = 0;
		Integer quantidadeItenTrocados = 0;
		Integer quantidadeTotaisItens = 0;
		Integer quantidadeTotaisReprovados = 0;
		Integer quantidadeTotaisEmtroca = 0;

		List<Integer> quantidades = new ArrayList<Integer>();
		List<Integer> quantidadesiPhoneMasculino = new ArrayList<Integer>();
		List<Integer> quantidadesiPadMasculino = new ArrayList<Integer>();
		List<Integer> quantidadesMacbookMasculino = new ArrayList<Integer>();
		List<Integer> quantidadesiPhoneFeminino = new ArrayList<Integer>();
		List<Integer> quantidadesiPadFeminino = new ArrayList<Integer>();
		List<Integer> quantidadesMacbookFeminino = new ArrayList<Integer>();

		for (int i = 1; i <= 12; i++) {
			quantidadesiPhoneMasculino.add(0);
			quantidadesiPadMasculino.add(0);
			quantidadesMacbookMasculino.add(0);
			quantidadesiPhoneFeminino.add(0);
			quantidadesiPadFeminino.add(0);
			quantidadesMacbookFeminino.add(0);
		}

		try {

			// Select * from ProdxPed AS PP INNER JOIN ACESSORIOS AS a on a.acs_id=
			// PP.ele_id INNER JOIN CATEGORIAS AS C ON C.cat_id = a.cat_id INNER JOIN
			// PEDIDOS as p on p.ped_id = pp.ped_id WHERE P.ped_data between ? and ?
			String sql = "Select * from ProdxPed2 AS PP INNER JOIN ELETRONICOS AS E ON E.ele_id = PP.ele_id INNER JOIN CATEGORIAS AS C ON C.cat_id = E.cat_id INNER JOIN PEDIDOS as p on p.ped_id = pp.ped_id  INNER join CLIENTES as cli on cli.cli_id = p.cli_id WHERE P.ped_data between ? and ?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(rel.getDataInicio()));
			stmt.setDate(2, Date.valueOf(rel.getDataFim()));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String cat = rs.getString("cat_descricao");
				String genero = rs.getString("cli_genero");
				String troca = rs.getString("prodxped_status");

				if (troca.equals("Trocado")) {
					quantidadeItenTrocados++;
				}

				if (troca.equals("Em Troca")) {
					quantidadeTotaisEmtroca++;
				}

				if (troca.equals("Reprovado")) {
					quantidadeTotaisReprovados++;
				}

				if (cat.equals("iPhone")) {
					quantidadeTotalIphone++;
				}

				if (cat.equals("iPad")) {
					quantidadeTotalIpad++;
				}

				if (cat.equals("Macbook")) {
					quantidadeTotalMacbook++;
				}
				contagem++;
				quantidadeTotaisItens++;

			}

			// for de meses
			// uma lista para cada mes

			String sql2 = "SELECT COUNT(PP.ped_id) 'QUANTIDADE', c.cat_descricao 'CATEGORIA', EXTRACT(month FROM P.ped_data)'MES', cli.cli_genero 'GENERO' from ProdxPed2 AS PP INNER JOIN ELETRONICOS AS E ON E.ele_id = PP.ele_id INNER JOIN CATEGORIAS AS C ON C.cat_id = E.cat_id INNER JOIN PEDIDOS as p on p.ped_id = pp.ped_id INNER join CLIENTES as cli on cli.cli_id = p.cli_id WHERE P.ped_data between ? and ? GROUP by c.cat_id, EXTRACT(month FROM P.ped_data), cli.cli_genero";
			stmt = con.prepareStatement(sql2);
			stmt.setDate(1, Date.valueOf(rel.getDataInicio()));
			stmt.setDate(2, Date.valueOf(rel.getDataFim()));

			ResultSet rst = stmt.executeQuery();

			while (rst.next()) {

				String genero = rst.getString("genero");
				String cat = rst.getString("categoria");
				Integer mes = Integer.parseInt(rst.getString("MES"));
				Integer quantidade = rst.getInt("quantidade");

				if (cat.equals("iPhone")) {
					if (genero.equals("MASCULINO")) {
						for (int i = 1; i <= 12; i++) {
							if (mes.equals(i)) {
								quantidadesiPhoneMasculino.set(i - 1,
										quantidadesiPhoneMasculino.get(i - 1) + quantidade);
							}
						}

					} else {
						for (int i = 1; i <= 12; i++) {
							if (mes.equals(i)) {
								quantidadesiPhoneFeminino.set(i - 1,
										quantidadesiPhoneFeminino.get(i - 1) + quantidade);
							}
						}
					}
				}

				
				if (cat.equals("iPad")) {
					if (genero.equals("MASCULINO")) {
						for (int i = 1; i <= 12; i++) {
							if (mes.equals(i)) {
								quantidadesiPadMasculino.set(i - 1,
										quantidadesiPadMasculino.get(i - 1) + quantidade);
							}
						}

					} else {
						for (int i = 1; i <= 12; i++) {
							if (mes.equals(i)) {
								quantidadesiPadFeminino.set(i - 1,
										quantidadesiPadFeminino.get(i - 1) + quantidade);
							}
						}
					}
				}
		
				if (cat.equals("Macbook")) {
					if (genero.equals("MASCULINO")) {
						for (int i = 1; i <= 12; i++) {
							if (mes.equals(i)) {
								quantidadesMacbookMasculino.set(i - 1,
										quantidadesMacbookMasculino.get(i - 1) + quantidade);
							}
						}

					} else {
						for (int i = 1; i <= 12; i++) {
							if (mes.equals(i)) {
								quantidadesMacbookFeminino.set(i - 1,
										quantidadesMacbookFeminino.get(i - 1) + quantidade);
							}
						}
					}
				}

				contagem++;
				quantidadeTotaisItens++;

			}
			
				quantidades.addAll(quantidadesiPhoneMasculino);
				quantidades.addAll(quantidadesiPadMasculino);
				quantidades.addAll(quantidadesMacbookMasculino);
				quantidades.addAll(quantidadesiPhoneFeminino);
				quantidades.addAll(quantidadesiPadFeminino);
				quantidades.addAll(quantidadesMacbookFeminino);
				quantidades.add(quantidadeTotaisItens);
				quantidades.add(quantidadeTotaisEmtroca);
				quantidades.add(quantidadeItenTrocados);
				quantidades.add(quantidadeTotaisReprovados);
				quantidades.add(quantidadeTotalIphone);
				quantidades.add(quantidadeTotalIpad);
				quantidades.add(quantidadeTotalMacbook);
				
				
				

			resultado.setQtdeRelatorio(quantidades);

			if (contagem == 0) {
				resultado.sucesso("Nenhuma categoria encontrado.");
			} else {
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
		} finally {
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
