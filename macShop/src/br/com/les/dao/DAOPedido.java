package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class DAOPedido extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Pedido pedido = (Pedido) entidade;
		
		Resultado resultado = new Resultado();
		

		String sql = "INSERT INTO PEDIDOS (cli_id, end_id, ped_total, ped_status, ped_frete, cupom_id, ped_data) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

							
		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, pedido.getCli_id());
			stmt.setInt(2, pedido.getEntrega_id());
			stmt.setDouble(3, pedido.getValorTotal());
			stmt.setString(4, pedido.getStatus());
			stmt.setDouble(5, pedido.getFrete());
			stmt.setInt(6, pedido.getFormapagto().get(0).getCupom().getId());
			stmt.setDate(7, java.sql.Date.valueOf(pedido.getDataPedido().toString()));

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				pedido.setId(rs.getInt("ped_id"));
			
			stmt.close();

			
			for(ItemCarrinho item : pedido.getCarrinho().getItensCarrinho())
			{
					String sql2 = "INSERT INTO ProdxPed (ped_id, prod_id, prodxped_qtde, prodxped_status)"
							+ "VALUES (?, ?, ?, ?)";
					
	
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
				stmt3.setInt(1, pedido.getFormapagto().get(i).getCartao().getId());
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
		
		Pedido pedido = (Pedido) entidade;
		
		Resultado resultado = new Resultado();
		
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> pedidos = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
	
			

			stmt = this.con.prepareStatement(
					"SELECT * from PEDIDOS WHERE cli_id = ?"	
					);
			stmt.setInt(1, pedido.getCli_id());
			
			ResultSet rs = stmt.executeQuery();

						
			while (rs.next()) {
				
				Pedido ped = new Pedido();

					ped.setId(Integer.parseInt(rs.getString("ped_id")));
					ped.setDataPedido(rs.getDate("ped_data").toLocalDate());
					ped.setValorTotal(rs.getDouble("ped_total"));
					ped.setCli_id(rs.getInt("cli_id"));
					ped.setStatus(rs.getString("ped_status"));	
					
					pedidos.add(ped);
			}
			
			for (int i=0; i<pedidos.size(); i++)
			{
				Pedido prod = (Pedido) pedidos.get(i);
				stmt = this.con.prepareStatement(
						"SELECT * from ProdxPed WHERE ped_id = ?"	
						);
				stmt.setInt(1, prod.getId());
				
				ResultSet rsm = stmt.executeQuery();
				
				Carrinho carrinho = new Carrinho();
							
				while (rsm.next()) {
					
					ItemCarrinho item = new ItemCarrinho();
					Produto prods = new Produto();
					prods.setId(rs.getInt("prod_id"));
					prods.setAtivo(rs.getString("prodxped_status"));
					item.setProduto(prods);
					item.setQuantidade(rs.getInt("prodxped_qtde"));
					carrinho.addItem(item);
				}
				prod.setCarrinho(carrinho);	
				rsm.close();
			}

			for (EntidadeDominio ent : pedidos)
			{
				Pedido pe = (Pedido) ent;
				
				for(ItemCarrinho item : pe.getCarrinho().getItensCarrinho())
				{
					Produto prod = item.getProduto();
					
					if(prod.getTipo().equals("VHELETRONICO"))
					{
						
						Eletronico a = (Eletronico) prod;
						stmt = this.con.prepareStatement(
								"SELECT * from ELETRONICOS where ele_id = ?"	
								);
					
						stmt.setInt(1, prod.getId());

						ResultSet rsT = stmt.executeQuery();
						
						while (rsT.next()) {
							a.setNome(rs.getString("ele_nome"));
							a.setAlimentacao(rs.getString("ele_alimentacao"));
							a.setCaminhoFoto(rs.getString("ele_caminhofoto"));
							a.setCodigoBarras(rs.getString("ele_codigobarras"));
							a.setConteudoEmbalagem(rs.getString("ele_conteudoembalagem"));
							a.setCor(rs.getString("ele_cor"));
							a.setDataaFabricacao(rs.getString("ele_datafabricaco"));
							a.setDescricao(rs.getString("ele_descricao"));
							a.setDimensoes(rs.getString("ele_dimensoes"));
							a.setMemoria(rs.getString("ele_memoria"));
							a.setModelo(rs.getString("ele_modelo"));
							a.setPreco(rs.getDouble("ele_preco"));
							a.setProcessador(rs.getString("ele_processador"));
							a.setRAM(rs.getString("ele_ram"));
							a.setResolucaoCamera(rs.getString("ele_resolucaocamera"));
							a.setSistemaOperacional(rs.getString("ele_sistemaoperacional"));
							a.setTamanhoDisplay(rs.getString("ele_display"));
							a.setAtivo(rs.getString("ele_status"));
							a.setId(rs.getInt("ele_id"));
							a.setTipo("VHELETRONICO");
							a.setEstoque(rs.getInt("ele_estoque"));
							
						}
						rsT.close();
					}
					
					else {
						Acessorio a = (Acessorio) prod;
						stmt = this.con.prepareStatement(
								"SELECT * from ELETRONICOS where ele_id = ?"	
								);
					
						stmt.setInt(1, prod.getId());

						ResultSet rsT = stmt.executeQuery();
						
						while (rsT.next()) {
							a.setNome(rs.getString("acs_nome"));
							a.setCaminhoFoto(rs.getString("acs_caminhofoto"));
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
							a.setEstoque(rs.getInt("acs_estoque"));
							
						}
						rsT.close();
						
					}
					
				}
				
			}

			resultado.setListaResultado(pedidos);

		
			if(contagem == 0){
				resultado.sucesso("Pedidos encontrados");
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
