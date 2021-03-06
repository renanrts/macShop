package br.com.les.dominio;

import java.util.Calendar;
import java.util.List;

public class Cliente extends Pessoa{
	
	private List<CartaoCredito> listCartoes;
	private List<Endereco> listEnderecosEntrega;
	private Telefone telefone;
	private Endereco enderecoResidencial;
	private Endereco enderecoCobranca;
	private List<Cupom> cupons;
	private List<Cupom> cuponsPromocionais;
 	
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

	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}
	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}
	public Endereco getEnderecoCobranca() {
		return enderecoCobranca;
	}
	public void setEnderecoCobranca(Endereco enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}
	public List<Endereco> getListEnderecosEntrega() {
		return listEnderecosEntrega;
	}
	public void setListEnderecosEntrega(List<Endereco> listEnderecosEntrega) {
		this.listEnderecosEntrega = listEnderecosEntrega;
	}
	public List<Cupom> getCupons() {
		return cupons;
	}
	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}
	public List<Cupom> getCuponsPromocionais() {
		return cuponsPromocionais;
	}
	public void setCuponsPromocionais(List<Cupom> cuponsPromocionais) {
		this.cuponsPromocionais = cuponsPromocionais;
	}

	
	
	

}
