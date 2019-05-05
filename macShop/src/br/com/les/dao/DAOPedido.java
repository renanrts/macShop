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
					String sql2 = "INSERT INTO ProdxPed (ped_id, prodxped_qtde, prodxped_status, ele_id, acs_id)"
							+ "VALUES (?, ?, ?, ?, ?)";
					
	
					PreparedStatement stmt2 = con.prepareStatement(sql2);
					stmt2.setInt(1, pedido.getId());
					stmt2.setInt(2, item.getQuantidade());
					stmt2.setString(3, "ATIVO");
					if(item.getProduto().getTipo().equals("VHELETRONICO"))
					{
						stmt2.setInt(4, item.getProduto().getId());
						stmt2.setInt(5, 0);
					}
					else {
						stmt2.setInt(4, 0);
						stmt2.setInt(5, item.getProduto().getId());
					}
					
					
					stmt2.execute();
			
					stmt2.close();
				
			}

			
			for(int i = 0; i < pedido.getFormapagto().size(); i++)
			{
				String sql3 = "INSERT INTO Form_pagto (cart_id, Form_pagto_psrcelas, Form_pagto_valor, ped_id) "
						+ "VALUES (?, ?, ?, ?)";
				

				PreparedStatement stmt3 = con.prepareStatement(sql3);
				stmt3.setInt(1, pedido.getFormapagto().get(i).getCartao().getId());
				stmt3.setInt(2, pedido.getFormapagto().get(i).getParcela());
				stmt3.setDouble(3, pedido.getFormapagto().get(0).getValor());
				stmt3.setInt(4, pedido.getId());
				
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
					System.out.println(rs.getDate("ped_data"));
					System.out.println(rs.getString("ped_data"));
					ped.setDataPedido(rs.getDate("ped_data").toLocalDate());
					ped.setValorTotal(rs.getDouble("ped_total"));
					ped.setCli_id(rs.getInt("cli_id"));
					ped.setStatus(rs.getString("ped_status"));	
					
					pedidos.add(ped);
			}
			ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<ItemCarrinho>();
			
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
					Integer eletronico = rsm.getInt("ele_id");
					if(eletronico.equals(0))
					{
						prods.setId(rsm.getInt("acs_id"));
						prods.setTipo("VHACESSORIO");
					}
					else {
						prods.setId(eletronico);
						prods.setTipo("VHELETRONICO");
					}
					
					prods.setAtivo(rsm.getString("prodxped_status"));
					item.setProduto(prods);
					item.setQuantidade(rsm.getInt("prodxped_qtde"));
					itensCarrinho.add(item);
					
					
				}
				carrinho.setItensCarrinho(itensCarrinho);
				prod.setCarrinho(carrinho);	
				rsm.close();
			}

			for (EntidadeDominio ent : pedidos)
			{
				Pedido pe = (Pedido) ent;
				
				for(ItemCarrinho item : pe.getCarrinho().getItensCarrinho())
				{
					Produto prod2 = item.getProduto();
					System.out.println(prod2.getTipo());
					if(prod2.getTipo().equals("VHELETRONICO"))
					{
						
						Eletronico a = new Eletronico();
						stmt = this.con.prepareStatement(
								"SELECT * from ELETRONICOS where ele_id = ?"	
								);
					
						stmt.setInt(1, prod2.getId());

						ResultSet rsT = stmt.executeQuery();
						
						while (rsT.next()) {
							a.setNome(rsT.getString("ele_nome"));
							a.setAlimentacao(rsT.getString("ele_alimentacao"));
							a.setCaminhoFoto(rsT.getString("ele_caminhofoto"));
							a.setCodigoBarras(rsT.getString("ele_codigobarras"));
							a.setConteudoEmbalagem(rsT.getString("ele_conteudoembalagem"));
							a.setCor(rsT.getString("ele_cor"));
							a.setDataaFabricacao(rsT.getString("ele_datafabricaco"));
							a.setDescricao(rsT.getString("ele_descricao"));
							a.setDimensoes(rsT.getString("ele_dimensoes"));
							a.setMemoria(rsT.getString("ele_memoria"));
							a.setModelo(rsT.getString("ele_modelo"));
							a.setPreco(rsT.getDouble("ele_preco"));
							a.setProcessador(rsT.getString("ele_processador"));
							a.setRAM(rsT.getString("ele_ram"));
							a.setResolucaoCamera(rsT.getString("ele_resolucaocamera"));
							a.setSistemaOperacional(rsT.getString("ele_sistemaoperacional"));
							a.setTamanhoDisplay(rsT.getString("ele_display"));
							a.setAtivo(rsT.getString("ele_status"));
							a.setId(rsT.getInt("ele_id"));
							a.setTipo("VHELETRONICO");
							a.setEstoque(rsT.getInt("ele_estoque"));
							prod2 = (Produto) a;
						}
						rsT.close();
					}
					
					else {
						Acessorio a = new Acessorio();
						stmt = this.con.prepareStatement(
								"SELECT * from ACESSORIOS where acs_id = ?"	
								);
					
						stmt.setInt(1, prod2.getId());

						ResultSet rsT = stmt.executeQuery();
						
						while (rsT.next()) {
							a.setNome(rsT.getString("acs_nome"));
							a.setCaminhoFoto(rsT.getString("acs_caminhofoto"));
							a.setCodigoBarras(rsT.getString("acs_codigobarras"));
							a.setCor(rsT.getString("acs_cor"));
							a.setDataaFabricacao(rsT.getString("acs_datafabricacao"));
							a.setDescricao(rsT.getString("acs_descricao"));
							a.setDimensoes(rsT.getString("acs_dimensoes"));
							a.setModeloCompativel(rsT.getString("acs_modelocompativel"));
							a.setPreco(rsT.getDouble("acs_preco"));
							a.setAtivo(rsT.getString("acs_status"));
							a.setId(rsT.getInt("acs_id"));
							a.setSeloMfi(rsT.getBoolean("acs_mfi"));
							a.setTipo("VHACESSORIO");
							a.setEstoque(rsT.getInt("acs_estoque"));
							prod2 = (Produto) a;
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
		
		Pedido pedido = (Pedido) e;
		
		Resultado resultado = new Resultado();
		
		int contagem = 0;
		


		try {
			
			List<EntidadeDominio> pedidos = new ArrayList<EntidadeDominio>();
			PreparedStatement stmt = null;
	
			

			stmt = this.con.prepareStatement(
					"SELECT * from PEDIDOS WHERE ped_id = ?"	
					);
			stmt.setInt(1, pedido.getId());
			
			ResultSet rs = stmt.executeQuery();

						
			while (rs.next()) {
				
				Pedido ped = new Pedido();

					ped.setId(Integer.parseInt(rs.getString("ped_id")));
					System.out.println(rs.getDate("ped_data"));
					System.out.println(rs.getString("ped_data"));
					ped.setDataPedido(rs.getDate("ped_data").toLocalDate());
					ped.setValorTotal(rs.getDouble("ped_total"));
					ped.setCli_id(rs.getInt("cli_id"));
					ped.setStatus(rs.getString("ped_status"));	
					
					pedidos.add(ped);
			}
			ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<ItemCarrinho>();
			
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
					Integer eletronico = rsm.getInt("ele_id");
					if(eletronico.equals(0))
					{
						prods.setId(rsm.getInt("acs_id"));
						prods.setTipo("VHACESSORIO");
					}
					else {
						prods.setId(eletronico);
						prods.setTipo("VHELETRONICO");
					}
					
					prods.setAtivo(rsm.getString("prodxped_status"));
					item.setProduto(prods);
					item.setQuantidade(rsm.getInt("prodxped_qtde"));
					itensCarrinho.add(item);
					
					
				}
				carrinho.setItensCarrinho(itensCarrinho);
				prod.setCarrinho(carrinho);	
				rsm.close();
			}

			for (EntidadeDominio ent : pedidos)
			{
				Pedido pe = (Pedido) ent;
				
				for(ItemCarrinho item : pe.getCarrinho().getItensCarrinho())
				{
					Produto prod2 = item.getProduto();
					System.out.println(prod2.getTipo());
					if(prod2.getTipo().equals("VHELETRONICO"))
					{
						
						Eletronico a = new Eletronico();
						stmt = this.con.prepareStatement(
								"SELECT * from ELETRONICOS where ele_id = ?"	
								);
					
						stmt.setInt(1, prod2.getId());

						ResultSet rsT = stmt.executeQuery();
						
						while (rsT.next()) {
							a.setNome(rsT.getString("ele_nome"));
							a.setAlimentacao(rsT.getString("ele_alimentacao"));
							a.setCaminhoFoto(rsT.getString("ele_caminhofoto"));
							a.setCodigoBarras(rsT.getString("ele_codigobarras"));
							a.setConteudoEmbalagem(rsT.getString("ele_conteudoembalagem"));
							a.setCor(rsT.getString("ele_cor"));
							a.setDataaFabricacao(rsT.getString("ele_datafabricaco"));
							a.setDescricao(rsT.getString("ele_descricao"));
							a.setDimensoes(rsT.getString("ele_dimensoes"));
							a.setMemoria(rsT.getString("ele_memoria"));
							a.setModelo(rsT.getString("ele_modelo"));
							a.setPreco(rsT.getDouble("ele_preco"));
							a.setProcessador(rsT.getString("ele_processador"));
							a.setRAM(rsT.getString("ele_ram"));
							a.setResolucaoCamera(rsT.getString("ele_resolucaocamera"));
							a.setSistemaOperacional(rsT.getString("ele_sistemaoperacional"));
							a.setTamanhoDisplay(rsT.getString("ele_display"));
							a.setId(rsT.getInt("ele_id"));
							a.setTipo("VHELETRONICO");
							a.setEstoque(rsT.getInt("ele_estoque"));
							prod2 = (Produto) a;
							item.setProduto(a);
						}
						rsT.close();
					}
					
					else {
						Acessorio a = new Acessorio();
						stmt = this.con.prepareStatement(
								"SELECT * from ACESSORIOS where acs_id = ?"	
								);
					
						stmt.setInt(1, prod2.getId());

						ResultSet rsT = stmt.executeQuery();
						
						while (rsT.next()) {
							a.setNome(rsT.getString("acs_nome"));
							a.setCaminhoFoto(rsT.getString("acs_caminhofoto"));
							a.setCodigoBarras(rsT.getString("acs_codigobarras"));
							a.setCor(rsT.getString("acs_cor"));
							a.setDataaFabricacao(rsT.getString("acs_datafabricacao"));
							a.setDescricao(rsT.getString("acs_descricao"));
							a.setDimensoes(rsT.getString("acs_dimensoes"));
							a.setModeloCompativel(rsT.getString("acs_modelocompativel"));
							a.setPreco(rsT.getDouble("acs_preco"));
							a.setId(rsT.getInt("acs_id"));
							a.setSeloMfi(rsT.getBoolean("acs_mfi"));
							a.setTipo("VHACESSORIO");
							a.setEstoque(rsT.getInt("acs_estoque"));
							prod2 = (Produto) a;
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
	public Resultado consultarExistencia(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

}
