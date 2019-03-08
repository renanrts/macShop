package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class DAOEletronico extends AbstractDAO{

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
Eletronico eletronico = (Eletronico) entidade;
		
		Resultado resultado = new Resultado();
		
		String sql = "INSERT INTO eletronico (nome, alimentacao, caminhofoto, categoria, codigobarras, conteudoembalagem, cor, datafabricaco, descricao, dimensoes, memoria, modelo, processador, ram, resolucaocamera, sistemaoperacional, display, preco) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, eletronico.getNome());
			stmt.setString(2, eletronico.getAlimentacao());
			stmt.setString(3, eletronico.getCaminhoFoto());
			stmt.setString(4, eletronico.getCategoria());
			stmt.setString(5, eletronico.getCodigoBarras());
			stmt.setString(6, eletronico.getConteudoEmbalagem());
			stmt.setString(7, eletronico.getCor());
			stmt.setString(8, eletronico.getDataaFabricacao());
			stmt.setString(9, eletronico.getDescricao());
			stmt.setString(10, eletronico.getDimensoes());
			stmt.setString(11, eletronico.getMemoria());
			stmt.setString(12, eletronico.getModelo());
			stmt.setString(13, eletronico.getProcessador());
			stmt.setString(14, eletronico.getRAM());
			stmt.setString(15, eletronico.getResolucaoCamera());
			stmt.setString(16, eletronico.getSistemaOperacional());
			stmt.setString(17, eletronico.getTamanhoDisplay());
			stmt.setDouble(18, eletronico.getPreco());

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

}
