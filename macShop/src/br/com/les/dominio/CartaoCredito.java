package br.com.les.dominio;

import java.time.LocalDate;
import java.util.Calendar;

public class CartaoCredito extends EntidadeDominio{
	
	private String numero;
	private String nome;
	private String codSeguranca;
	private boolean preferencial;
	private LocalDate dtVenciamento;
	private String bandeira;
	private int cliId;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodSeguranca() {
		return codSeguranca;
	}
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	public boolean isPreferencial() {
		return preferencial;
	}
	public void setPreferencial(boolean preferencial) {
		this.preferencial = preferencial;
	}
	
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public int getCliId() {
		return cliId;
	}
	public void setCliId(int cliId) {
		this.cliId = cliId;
	}
	public LocalDate getDtVenciamento() {
		return dtVenciamento;
	}
	public void setDtVenciamento(LocalDate dtVenciamento) {
		this.dtVenciamento = dtVenciamento;
	}
	
	
	
	

}
