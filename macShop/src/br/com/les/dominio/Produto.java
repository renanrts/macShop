package br.com.les.dominio;

import java.util.Calendar;

public class Produto extends EntidadeDominio{
	

	protected String nome;
	protected double preco;
	protected Categoria categoria;
	protected String dataaFabricacao;
	protected String cor;
	protected String dimensoes;
	protected String codigoBarras;
	protected String caminhoFoto;
	protected String descricao;
	protected String ativo;
	protected Calendar dataCadastro;
	protected String motivo;
	protected Integer estoque;
	
	public String getMotivo() {
		return motivo;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getDataaFabricacao() {
		return dataaFabricacao;
	}
	public void setDataaFabricacao(String dataaFabricacao) {
		this.dataaFabricacao = dataaFabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getCaminhoFoto() {
		return caminhoFoto;
	}
	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	

}
