package br.com.les.dominio;

public class Eletronico extends Produto{
	
	private String memoria;
	private String processador;
	private String tamanhoDisplay;
	private String resolucaoCamera;
	private String conteudoEmbalagem;
	private String alimentacao;
	private String RAM;
	private String sistemaOperacional;
	private String modelo;
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getTamanhoDisplay() {
		return tamanhoDisplay;
	}
	public void setTamanhoDisplay(String tamanhoDisplay) {
		this.tamanhoDisplay = tamanhoDisplay;
	}
	public String getResolucaoCamera() {
		return resolucaoCamera;
	}
	public void setResolucaoCamera(String resolucaoCamera) {
		this.resolucaoCamera = resolucaoCamera;
	}
	public String getConteudoEmbalagem() {
		return conteudoEmbalagem;
	}
	public void setConteudoEmbalagem(String conteudoEmbalagem) {
		this.conteudoEmbalagem = conteudoEmbalagem;
	}
	public String getAlimentacao() {
		return alimentacao;
	}
	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getSistemaOperacional() {
		return sistemaOperacional;
	}
	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}
	
	
	

}
