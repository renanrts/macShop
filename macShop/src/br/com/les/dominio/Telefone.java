package br.com.les.dominio;

public class Telefone extends EntidadeDominio{
	
	private String ddd;
	private String numero;
	private TipoTelefone tipoTelefone;
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
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TipoTelefone tipo) {
		this.tipoTelefone = tipo;
	}
	
	
	

}
