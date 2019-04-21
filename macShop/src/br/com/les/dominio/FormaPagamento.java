package br.com.les.dominio;

public class FormaPagamento extends EntidadeDominio {
	
	private CartaoCredito cartao;
	private Cupom cupom;
	private String parcela;
	private Double valor;
	public CartaoCredito getCartao() {
		return cartao;
	}
	public void setCartao(CartaoCredito cartao) {
		this.cartao = cartao;
	}
	public Cupom getCupom() {
		return cupom;
	}
	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
