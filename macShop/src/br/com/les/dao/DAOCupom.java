package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;
import br.com.les.util.Resultado;

public class DAOCupom extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
	
		Resultado resultado = new Resultado();


		Pedido pedido = (Pedido) entidade;
		
		Cupom cupom = new Cupom();
		
		cupom.setValor(pedido.getFormapagto().get(0).getValor() - pedido.getValorTotal());
		
		Random gerador = new Random();
		
		StringBuilder codigo = new StringBuilder();
		
		for(int i=0; i < 5; i++)
		{
			codigo.append(String.valueOf(gerador.nextInt()));
		}
		

		try {
			

			String sql = "INSERT INTO CUPONS (CUP_CODIGO, CUP_VALOR, CLI_ID, CUP_STATUS) "
					+ "VALUES (?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, codigo.toString());
			
			stmt.setDouble(2, cupom.getValor());
			stmt.setInt(3, pedido.getCli_id());
			stmt.setString(4, "ATIVO");

			stmt.executeQuery();
			stmt.close();
			
			resultado.sucesso("Cupom criado com sucesso!");
			return resultado;
			
		} catch (SQLException e1) {
			
						e1.printStackTrace();
						resultado.erro("Erro de consulta.");
						return resultado;
		}
	
		
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
	
		return null;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();


		Cupom cupom = (Cupom) entidade;

		try {
			
			
			PreparedStatement stmt = null;
				
			stmt = this.con.prepareStatement("UPDATE CUPONS SET cup_status = ? WHERE CUP_CODIGO = ?");
			stmt.setString(1, "INATIVO");
			stmt.setString(2, cupom.getCodigo());

			ResultSet rs = stmt.executeQuery();
				
			resultado.sucesso("Cupom invalidado com sucesso");
			
			rs.close();
			stmt.close();
		
			return null;
			
		} catch (SQLException e1) {
			
						e1.printStackTrace();
						resultado.erro("Erro de consulta.");
						return null;
		}
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
	
	public Cupom consultarValidade(EntidadeDominio e) {
		
		Resultado resultado = new Resultado();


			Cupom cupom = (Cupom) e;

			try {
				
				
				PreparedStatement stmt = null;
					
				stmt = this.con.prepareStatement("SELECT * FROM CUPONS WHERE CUP_CODIGO = ?");
				stmt.setString(1, cupom.getCodigo());
	
				ResultSet rs = stmt.executeQuery();
							
				while (rs.next()) {
									
					cupom.setId(Integer.parseInt(rs.getString("cup_id")));
					cupom.setStatus(rs.getString("cup_status"));
					cupom.setValor(Double.parseDouble(rs.getString("cup_valor")));
					
					
				}
				
				
				rs.close();
				stmt.close();
			
				return cupom;
				
			} catch (SQLException e1) {
				
							e1.printStackTrace();
							resultado.erro("Erro de consulta.");
							return cupom;
			}
		
		}
	
	
	}


