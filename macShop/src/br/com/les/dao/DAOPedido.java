package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Carrinho;
import br.com.les.dominio.Cidade;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Estado;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;
import br.com.les.dominio.StatusPedido;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOPedido extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

		Pedido pedido = (Pedido) entidade;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO PEDIDOS (cli_id, end_id, ped_total, ped_status, ped_frete, cupom_id, ped_data) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, pedido.getCli_id());
			stmt.setInt(2, pedido.getEndEntrega().getId());
			stmt.setDouble(3, pedido.getValorTotal());
			stmt.setString(4, StatusPedido.EMPROCESSAMENTO.getDescription());
			stmt.setDouble(5, pedido.getFrete());
			stmt.setInt(6, pedido.getCupom_id().getId());
			stmt.setDate(7, java.sql.Date.valueOf(pedido.getDataPedido().toString()));

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				pedido.setId(rs.getInt("ped_id"));

			stmt.close();

			for (ItemCarrinho item : pedido.getCarrinho().getItensCarrinho()) {
				String sql2 = "INSERT INTO ProdxPed (ped_id, prodxped_qtde, prodxped_status, ele_id, acs_id)"
						+ "VALUES (?, ?, ?, ?, ?)";

				PreparedStatement stmt2 = con.prepareStatement(sql2);
				stmt2.setInt(1, pedido.getId());
				stmt2.setInt(2, item.getQuantidade());
				stmt2.setString(3, "ATIVO");
				if (item.getProduto().getTipo().equals("VHELETRONICO")) {
					stmt2.setInt(4, item.getProduto().getId());
					stmt2.setInt(5, 0);
				} else {
					stmt2.setInt(4, 0);
					stmt2.setInt(5, item.getProduto().getId());
				}

				stmt2.execute();

				stmt2.close();

			}

			for (int i = 0; i < pedido.getFormapagto().size(); i++) {
				String sql3 = "INSERT INTO Form_pagto (cart_id, Form_pagto_psrcelas, Form_pagto_valor, ped_id) "
						+ "VALUES (?, ?, ?, ?)";
				if(pedido.getFormapagto().get(i).getValor() != 0)
				{
					PreparedStatement stmt3 = con.prepareStatement(sql3);
					stmt3.setInt(1, pedido.getFormapagto().get(i).getCartao().getId());
					stmt3.setInt(2, pedido.getFormapagto().get(i).getParcela());
					stmt3.setDouble(3, pedido.getFormapagto().get(i).getValor());
					stmt3.setInt(4, pedido.getId());

					stmt3.execute();

					stmt3.close();
				}
			
			}

			for (ItemCarrinho item : pedido.getCarrinho().getItensCarrinho()) {
				Produto prod = item.getProduto();

				prod.setEstoque(item.getQuantidade());

				if (item.getProduto().getTipo().equals("VHELETRONICO")) {
					DAOEletronico dao = new DAOEletronico();
					dao.alterarEstoque(prod);

				}

				else {
					DAOAcessorio dao = new DAOAcessorio();
					dao.alterarEstoque(prod);
				}

			}

			con.close();

			resultado.sucesso("Pedido efetuado com sucesso!");
			return resultado;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultado.erro("Erro salvar, por favor, refaça a operação.");
			return resultado;
		} finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Pedido pedido = (Pedido) entidade;

		Resultado resultado = new Resultado();

		int contagem = 0;

		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		if(pedido.getTipo().equals("CLIENTE"))
		{
			try {

				List<EntidadeDominio> pedidos = new ArrayList<EntidadeDominio>();

				String sql = "SELECT * from PEDIDOS WHERE cli_id = ?";
				stmt = con.prepareStatement(sql);
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

				for (int i = 0; i < pedidos.size(); i++) {
					Pedido prod = (Pedido) pedidos.get(i);
					String sql2 = "SELECT * from ProdxPed WHERE ped_id = ?";
					stmt = con.prepareStatement(sql2);
					stmt.setInt(1, prod.getId());

					ResultSet rsm = stmt.executeQuery();

					Carrinho carrinho = new Carrinho();

					while (rsm.next()) {

						ItemCarrinho item = new ItemCarrinho();

						Produto prods = new Produto();
						Integer eletronico = rsm.getInt("ele_id");
						if (eletronico.equals(0)) {
							prods.setId(rsm.getInt("acs_id"));
							prods.setTipo("VHACESSORIO");
						} else {
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

				for (EntidadeDominio ent : pedidos) {
					Pedido pe = (Pedido) ent;

					for (ItemCarrinho item : pe.getCarrinho().getItensCarrinho()) {
						Produto prod2 = item.getProduto();
						System.out.println(prod2.getTipo());
						if (prod2.getTipo().equals("VHELETRONICO")) {

							Eletronico a = new Eletronico();
							String sql3 = "SELECT * from ELETRONICOS where ele_id = ?";
							stmt = con.prepareStatement(sql3);
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
							String sql4 = "SELECT * from ACESSORIOS where acs_id = ?";
							stmt = con.prepareStatement(sql4);
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

				if (contagem == 0) {
					resultado.sucesso("Pedidos encontrados");
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
		
		else
		{
			try {

				List<EntidadeDominio> pedidos = new ArrayList<EntidadeDominio>();

				String sql = "SELECT * from PEDIDOS";
				stmt = con.prepareStatement(sql);


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

				for (int i = 0; i < pedidos.size(); i++) {
					Pedido prod = (Pedido) pedidos.get(i);
					String sql2 = "SELECT * from ProdxPed WHERE ped_id = ?";
					stmt = con.prepareStatement(sql2);
					stmt.setInt(1, prod.getId());

					ResultSet rsm = stmt.executeQuery();

					Carrinho carrinho = new Carrinho();

					while (rsm.next()) {

						ItemCarrinho item = new ItemCarrinho();

						Produto prods = new Produto();
						Integer eletronico = rsm.getInt("ele_id");
						if (eletronico.equals(0)) {
							prods.setId(rsm.getInt("acs_id"));
							prods.setTipo("VHACESSORIO");
						} else {
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

				for (EntidadeDominio ent : pedidos) {
					Pedido pe = (Pedido) ent;

					for (ItemCarrinho item : pe.getCarrinho().getItensCarrinho()) {
						Produto prod2 = item.getProduto();
						System.out.println(prod2.getTipo());
						if (prod2.getTipo().equals("VHELETRONICO")) {

							Eletronico a = new Eletronico();
							String sql3 = "SELECT * from ELETRONICOS where ele_id = ?";
							stmt = con.prepareStatement(sql3);
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
							String sql4 = "SELECT * from ACESSORIOS where acs_id = ?";
							stmt = con.prepareStatement(sql4);
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

				if (contagem == 0) {
					resultado.sucesso("Pedidos encontrados");
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

		
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		Pedido pedido = (Pedido) entidade;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Resultado resultado = new Resultado();
		
		try {


			String sql = "UPDATE PEDIDOS SET ped_status = ? WHERE ped_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, pedido.getStatus());
			stmt.setInt(2, pedido.getId());
			stmt.executeQuery();
		}catch (SQLException e1) {

			e1.printStackTrace();
			resultado.erro("Erro de consulta.");
			return resultado;
		}finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	
		resultado.sucesso("Pedido alterado com sucesso!");

		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public Resultado visualizar(EntidadeDominio e) {

		Pedido pedido = (Pedido) e;
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Resultado resultado = new Resultado();

		int contagem = 0;

		try {

			List<EntidadeDominio> pedidos = new ArrayList<EntidadeDominio>();

			String sql = "SELECT * from PEDIDOS WHERE ped_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pedido.getId());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Pedido ped = new Pedido();
				Endereco end = new Endereco();
				ped.setId(Integer.parseInt(rs.getString("ped_id")));
				System.out.println(rs.getDate("ped_data"));
				System.out.println(rs.getString("ped_data"));
				ped.setDataPedido(rs.getDate("ped_data").toLocalDate());
				ped.setValorTotal(rs.getDouble("ped_total"));
				ped.setCli_id(rs.getInt("cli_id"));
				ped.setStatus(rs.getString("ped_status"));
				ped.setFrete(rs.getDouble("ped_frete"));
				end.setId(rs.getInt("end_id"));
				ped.setEndEntrega(end);
				pedidos.add(ped);
			}
			ArrayList<ItemCarrinho> itensCarrinho = new ArrayList<ItemCarrinho>();

			for (int i = 0; i < pedidos.size(); i++) {
				Pedido prod = (Pedido) pedidos.get(i);
				String sql2 = "SELECT * from ProdxPed WHERE ped_id = ?";
				stmt = con.prepareStatement(sql2);
				stmt.setInt(1, prod.getId());

				ResultSet rsm = stmt.executeQuery();

				Carrinho carrinho = new Carrinho();

				while (rsm.next()) {

					ItemCarrinho item = new ItemCarrinho();

					Produto prods = new Produto();
					Integer eletronico = rsm.getInt("ele_id");
					if (eletronico.equals(0)) {
						prods.setId(rsm.getInt("acs_id"));
						prods.setTipo("VHACESSORIO");
					} else {
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

			for (EntidadeDominio ent : pedidos) {
				Pedido pe = (Pedido) ent;

				for (ItemCarrinho item : pe.getCarrinho().getItensCarrinho()) {
					Produto prod2 = item.getProduto();
					System.out.println(prod2.getTipo());
					if (prod2.getTipo().equals("VHELETRONICO")) {

						Eletronico a = new Eletronico();
						String sql3 = "SELECT * from ELETRONICOS where ele_id = ?";
						stmt = con.prepareStatement(sql3);
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
						String sql4 = "SELECT * from ACESSORIOS where acs_id = ?";
						stmt = con.prepareStatement(sql4);
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

			String sql5 = "SELECT * from ENDERECOS AS C INNER JOIN cidade AS G ON C.end_cid_id = G.cid_id INNER JOIN estado AS P ON P.est_id = g.cid_est_id WHERE C.end_id = ?";

			Pedido peds = (Pedido) pedidos.get(0);
			stmt = con.prepareStatement(sql5);
			stmt.setInt(1, peds.getEndEntrega().getId());

			ResultSet rsT = stmt.executeQuery();

			while (rsT.next()) {
				Cidade cid = new Cidade();
				Estado est = new Estado();

				cid.setNome(rsT.getString("cid_nome"));
				est.setNome(rsT.getString("est_nome"));
				cid.setEstado(est);
				peds.getEndEntrega().setBairro(rsT.getString("end_bairro"));
				peds.getEndEntrega().setCep(rsT.getString("end_cep"));
				peds.getEndEntrega().setLogradouro(rsT.getString("end_logradouro"));
				peds.getEndEntrega().setNumero(rsT.getString("end_numero"));
				peds.getEndEntrega().setCidade(cid);
			}
			rsT.close();

			resultado.setListaResultado(pedidos);

			if (contagem == 0) {
				resultado.sucesso("Pedidos encontrados");
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
	public Resultado consultarExistencia(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	public void aprovarCompra() {
		String sql = "UPDATE PEDIDOS set ped_status = ? WHERE ped_status = ? ";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
	    try {
	      stmt = con.prepareStatement(sql);
	      stmt.setString(1, StatusPedido.APROVADO.getDescription());
	      stmt.setString(2, StatusPedido.EMPROCESSAMENTO.getDescription());
	      
	      stmt.executeUpdate();
	      
	      DAOProdxPed daoItens = new DAOProdxPed();
	      
	      daoItens.aprovar();
	      

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
		
	}

	public void reprovarCompra() {
		String sql = "UPDATE PEDIDOS set ped_status = ? WHERE ped_status = ? ";
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		Pedido pedido = new Pedido();
	    try {
	     stmt = con.prepareStatement(sql);
	      stmt.setString(1, StatusPedido.REPROVADO.getDescription());
	      stmt.setString(2, StatusPedido.EMPROCESSAMENTO.getDescription());
	      
	      stmt.executeUpdate();
	    

	      
	      DAOProdxPed daoItens = new DAOProdxPed();
	      daoItens.reprovar();

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    finally {
			ConnectionFactory.closeConnection(stmt, con);
		}
		
	}

}
