package br.com.les.dominio;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

public class Bloqueio extends EntidadeDominio{
	
	private Carrinho carrinho;
	private LocalDate timeStamp;
	private HttpSession sessao;
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	public HttpSession getSessao() {
		return sessao;
	}
	public void setSessao(HttpSession sessao) {
		this.sessao = sessao;
	}
	
	

}
