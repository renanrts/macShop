package br.com.les.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class Bloqueio extends EntidadeDominio{
	
	private Carrinho carrinho;
	private LocalDateTime timeStamp;
	private HttpSession sessao;
	private String operation;
	private ServletContext servCon;
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public HttpSession getSessao() {
		return sessao;
	}
	public void setSessao(HttpSession sessao) {
		this.sessao = sessao;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ServletContext getServCon() {
		return servCon;
	}
	public void setServCon(ServletContext servCon) {
		this.servCon = servCon;
	}
	
	

}
