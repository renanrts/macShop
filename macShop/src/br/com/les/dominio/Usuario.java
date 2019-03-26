package br.com.les.dominio;

import java.util.List;

public class Usuario extends EntidadeDominio{
	
	private String email;
	private List<String> senhas;
	private boolean ativo;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getSenhas() {
		return senhas;
	}
	public void setSenhas(List<String> senhas) {
		this.senhas = senhas;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	

}
