package br.com.les.dominio;

import java.util.ArrayList;

public class Carrinho extends EntidadeDominio {
	
	private ArrayList<ItemCarrinho> itensCarrinho;
	private Integer quantidadeProdutos;
	private boolean status;

	public void setItensCarrinho(ArrayList<ItemCarrinho> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
		
	}
	
	public void addItem(ItemCarrinho item)
	{
		this.getItensCarrinho().add(item);
	}

	public ArrayList<ItemCarrinho> getItensCarrinho() {
		return itensCarrinho;
	}
	
	public void removeItem(Integer id)
	{
		ArrayList<ItemCarrinho> itens = this.getItensCarrinho();
		for(int i=0; i < itens.size(); i++)
		{
			if (itens.get(i).getProduto().getId() == id)
			{
				itens.remove(i);
			}
			
		}
	}
	
	 public void setQuantidadeProdutos(Integer quantidadeProdutos) {
		    this.quantidadeProdutos = quantidadeProdutos;
		  }

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
