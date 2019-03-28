package br.com.les.dominio;

public class Telefone extends EntidadeDominio{
	
	private String ddd;
	private String numero;
	private String tipoTelefone;
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(String tipo) {
		this.tipoTelefone = tipo;
	}
	
	
	

}
