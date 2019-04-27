package br.com.les.dominio;

public enum StatusPedido {
	
	EMPROCESSAMENTO("Em Processamento"), APROVADO("Aprovado"), REPROVADO("Reprovado"), EMTRANSPORTE("Em transporte"), ENTREGUE("Entregue"),
	EMTROCA("Em Troca"), TROCADO("Trocado"), TROCAAUTORIZADA("Troca Autorizada")
	;
	
	private String descricao;
	
	StatusPedido(String descricao){
		this.descricao = descricao;
	}
	public String getDescription() 
	{
		return descricao;
	}
}
