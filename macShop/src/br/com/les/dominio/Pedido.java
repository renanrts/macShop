package br.com.les.dominio;

import java.time.LocalDate;
import java.util.List;

public class Pedido extends EntidadeDominio {

	private Integer cli_id;
	private Integer entrega_id;
	private Double valorTotal;
	private String status;
	private Double frete;
	private Integer cupom_id;
	private Carrinho carrinho;
	private List<FormaPagamento> formapagto;
	private LocalDate dataPedido;
	
	public Integer getCli_id() {
		return cli_id;
	}
	public void setCli_id(Integer cli_id) {
		this.cli_id = cli_id;
	}
	public Integer getEntrega_id() {
		return entrega_id;
	}
	public void setEntrega_id(Integer entrega_id) {
		this.entrega_id = entrega_id;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getFrete() {
		return frete;
	}
	public void setFrete(Double frete) {
		this.frete = frete;
	}
	public Integer getCupom_id() {
		return cupom_id;
	}
	public void setCupom_id(Integer cupom_id) {
		this.cupom_id = cupom_id;
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public List<FormaPagamento> getFormapagto() {
		return formapagto;
	}
	public void setFormapagto(List<FormaPagamento> formapagto) {
		this.formapagto = formapagto;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	
	
	
	
}
