package br.com.les.dominio;

public class Acessorio extends Produto{
	
	private String modeloCompativel;
	private boolean seloMfi;
	
	
	public String getModeloCompativel() {
		return modeloCompativel;
	}
	public void setModeloCompativel(String modeloCompativel) {
		this.modeloCompativel = modeloCompativel;
	}
	public boolean isSeloMfi() {
		return seloMfi;
	}
	public void setSeloMfi(boolean seloMfi) {
		this.seloMfi = seloMfi;
	}
	
	

}
