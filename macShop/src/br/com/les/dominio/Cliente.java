package br.com.les.dominio;

import java.util.Calendar;
import java.util.List;

public class Cliente extends Pessoa{
	
	private List<CartaoCredito> listCartoes;
	private List<Endereco> listEnderecos;
	private Telefone telefone;
	protected Calendar dataCadastro;
	
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public List<CartaoCredito> getListCartoes() {
		return listCartoes;
	}
	public void setListCartoes(List<CartaoCredito> listCartoes) {
		this.listCartoes = listCartoes;
	}
	public List<Endereco> getListEnderecos() {
		return listEnderecos;
	}
	public void setListEnderecos(List<Endereco> listEnderecos) {
		this.listEnderecos = listEnderecos;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	
	

}
