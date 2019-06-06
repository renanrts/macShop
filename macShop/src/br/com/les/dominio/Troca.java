package br.com.les.dominio;

import java.time.LocalDate;

public class Troca {
	
	private Produto produto;
	private Integer codCliente;
	private Integer codPedido;
	private LocalDate dataSolicitacao;
	private String Status;
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public Integer getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}
	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	

}
