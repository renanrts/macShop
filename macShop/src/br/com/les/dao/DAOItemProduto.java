package br.com.les.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;
import br.com.les.dominio.Telefone;
import br.com.les.util.ConnectionFactory;
import br.com.les.util.Resultado;

public class DAOItemProduto extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		
		ItemCarrinho item = (ItemCarrinho) entidade;
		
		List<EntidadeDominio> pedidos = new ArrayList<EntidadeDominio>();
		
	    String sql = "UPDATE ProdxPed SET prodxped_status = ? WHERE prodxped_id = ? ";
	    
	    con = ConnectionFactory.getConnection();
	    
		PreparedStatement pst = null;
	    
	    try {
	      pst = con.prepareStatement(sql);
	      pst.setString(1, item.getProduto().getAtivo());   
	      pst.setInt(2, item.getId());
	      
	      pst.executeQuery();
	      
//	      Pedido ped = new Pedido();
//	      Carrinho car = new Carrinho();
//	      
//	      car.setItensCarrinho(itensCarrinho);
//	      ped.setCarrinho(car);
//	      pedidos.add(ped);
//	      
//	      resultado.setListaResultado(pedidos);
	      
	    } catch (Exception e) {
	      resultado.erro("Erro ao consultar itens em processamento");
	      e.printStackTrace();
	    }finally {
			ConnectionFactory.closeConnection(pst, con);
		}

	    resultado.sucesso("Salvo com sucesso!");
	    
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		this.salvar(entidade);
		
Resultado resultado = new Resultado();
		
		ItemCarrinho item = (ItemCarrinho) entidade;
		Produto prod = new Produto();
		
	    String sql = "Select * from ProdxPed WHERE prodxped_id = ? ";
	    
	    con = ConnectionFactory.getConnection();
	    
		PreparedStatement pst = null;
	    
	    try {
	      pst = con.prepareStatement(sql); 
	      pst.setInt(1, item.getId());
	     	      
	      ResultSet rs = pst.executeQuery();
		
		
		while (rs.next()) {
			
			prod.setEstoque(rs.getInt("prodxped_qtde"));
			prod.setId(rs.getInt("acs_id"));
			if(prod.getId().equals(0))
			{
				prod.setId(rs.getInt("ele_id"));
				prod.setTipo("VHELETRONICO");
			}
			else {
				prod.setTipo("VHACESSORIO");
			}
		}

	
		DAOEletronico daoEle = new DAOEletronico();
		DAOAcessorio daoAcs = new DAOAcessorio();
		
		if (prod.getTipo().equals("VHACESSORIO"))
		{
			daoAcs.voltarEstoque(prod);
		}
		else {
			daoEle.voltarEstoque(prod);
		}
	      
	    } catch (Exception e) {
	      resultado.erro("Erro ao consultar itens em processamento");
	      e.printStackTrace();
	    }finally {
			ConnectionFactory.closeConnection(pst, con);
		}

	    resultado.sucesso("Salvo com sucesso!");
	    
		return resultado;
		
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
	
	public String verificarTipoProduto(EntidadeDominio e)
	{
		
		return null;
	}

}
