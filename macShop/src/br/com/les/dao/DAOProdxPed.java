package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOProdxPed extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		
	    String sql = "UPDATE ProdxPed SET prodxped_status = ? WHERE prodxped_status = ? ";
	    
	    con = ConnectionFactory.getConnection();
	    
		PreparedStatement pst = null;
	    
	    try {
	      pst = con.prepareStatement(sql);
	      pst.setString(1, "APROVADO");   
	      pst.setString(2, "ATIVO");
	      
	      pst.executeQuery();
	      
	    } catch (Exception e) {
	      resultado.erro("Erro ao consultar itens em processamento");
	      e.printStackTrace();
	    }finally {
			ConnectionFactory.closeConnection(pst, con);
		}
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

	public Resultado consultarPedidosEmProcessamento() {
		Resultado resultado = new Resultado();
	    String sql = "SELECT * FROM  ProdxPed WHERE prodxped_status = ? ";
	    con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
	    ArrayList<EntidadeDominio> itens = new ArrayList<>();
	    
	    try {
	      PreparedStatement pst = con.prepareStatement(sql);
	      pst.setString(1, "ATIVO");     
	      
	      ResultSet rs = pst.executeQuery();
	      
	      while(rs.next()) {       
	        Produto produto = new Produto();
	        Integer eletronico = rs.getInt("ele_id");
			if (eletronico.equals(0)) {
				produto.setId(rs.getInt("acs_id"));
				produto.setTipo("VHACESSORIO");
			} else {
				produto.setId(eletronico);
				produto.setTipo("VHELETRONICO");
			}
			produto.setEstoque(rs.getInt("prodxped_qtde"));

			itens.add(produto);

	      }
	      
	      pst.close();
	      resultado.setListaResultado(itens);
	      resultado.sucesso("Consulta realizada com sucesso");
	    } catch (Exception e) {
	      resultado.erro("Erro ao consultar itens em processamento");
	      e.printStackTrace();
	    }finally {
			ConnectionFactory.closeConnection(stmt, con);
		}

	    
	    
	    
	    
	    return resultado;
	}

	public void reprovar() {
		Resultado resultado = new Resultado();
		
	    String sql = "UPDATE ProdxPed SET prodxped_status = ? WHERE prodxped_status = ? ";
	    
	    con = ConnectionFactory.getConnection();
	    
		PreparedStatement pst = null;
	    
	    try {
	      pst = con.prepareStatement(sql);
	      pst.setString(1, "REPROVADO");   
	      pst.setString(2, "ATIVO");
	      
	      pst.executeQuery();
	      
	    } catch (Exception e) {
	      resultado.erro("Erro ao consultar itens em processamento");
	      e.printStackTrace();
	    }finally {
			ConnectionFactory.closeConnection(pst, con);
		}

		
	}

	public Resultado aprovar() {
	Resultado resultado = new Resultado();
		
	    String sql = "UPDATE ProdxPed SET prodxped_status = ? WHERE prodxped_status = ? ";
	    
	    con = ConnectionFactory.getConnection();
	    
		PreparedStatement pst = null;
	    
	    try {
	      pst = con.prepareStatement(sql);
	      pst.setString(1, "APROVADO");   
	      pst.setString(2, "ATIVO");
	      
	      pst.executeQuery();
	      
	    } catch (Exception e) {
	      resultado.erro("Erro ao consultar itens em processamento");
	      e.printStackTrace();
	    }finally {
			ConnectionFactory.closeConnection(pst, con);
		}
		return null;
		
	}

}
