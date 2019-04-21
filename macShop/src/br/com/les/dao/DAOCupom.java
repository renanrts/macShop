package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.les.dominio.Cupom;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class DAOCupom extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
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


