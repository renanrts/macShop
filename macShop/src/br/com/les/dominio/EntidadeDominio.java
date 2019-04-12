package br.com.les.dominio;

public abstract class EntidadeDominio {
	
	protected Integer id;
	protected String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
