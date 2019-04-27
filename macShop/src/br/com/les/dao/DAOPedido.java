package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;
import br.com.les.util.Resultado;

public class DAOPedido extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Pedido pedido = (Pedido) entidade;
		
		Resultado resultado = new Resultado();
		

		String sql = "INSERT INTO PEDIDOS (cli_id, end_id, ped_total, ped_status, ped_frete, cupom_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

							
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, pedido.getCli_id());
			stmt.setInt(2, pedido.getEntrega_id());
			stmt.setDouble(3, pedido.getValorTotal());
			stmt.setString(4, pedido.getStatus());
			stmt.setDouble(5, pedido.getFrete());
			stmt.setString(6, pedido.getFormapagto().get(0).getCupom().getCodigo());

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				pedido.setId(rs.getInt("ped_id"));
			
			stmt.close();

			
			for(ItemCarrinho item : pedido.getCarrinho().getItensCarrinho())
			{
					String sql2 = "INSERT INTO ProdxPed (ped_id, prod_id, prodxped_qtde, prodxped_status) "
							+ "VALUES (?, ?, ?, ?,)";
					
	
					PreparedStatement stmt2 = con.prepareStatement(sql2);
					stmt2.setInt(1, pedido.getId());
					stmt2.setInt(2, item.getProduto().getId());
					stmt2.setInt(3, item.getQuantidade());
					stmt2.setString(4, "ATIVO");

					stmt2.execute();
			
					stmt2.close();
				
			}

			
			for(int i = 0; i < pedido.getFormapagto().size(); i++)
			{
				String sql3 = "INSERT INTO Form_pagto (cart_id, Form_pagto_psrcelas, Form_pagto_valor) "
						+ "VALUES (?, ?, ?)";
				

				PreparedStatement stmt3 = con.prepareStatement(sql3);
				stmt3.setInt(1, pedido.getFormapagto().get(i).getId());
				stmt3.setInt(2, pedido.getFormapagto().get(i).getParcela());
				stmt3.setDouble(3, pedido.getFormapagto().get(0).getValor());

				stmt3.execute();
		
				stmt3.close();
			}
			
			con.close();

			resultado.sucesso("Pedido efetuado com sucesso!");
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
