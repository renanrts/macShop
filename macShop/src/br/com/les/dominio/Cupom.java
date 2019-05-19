package br.com.les.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cupom extends EntidadeDominio {

	private String codigo;
	private Double valor;
	private String status;
	private  List<Cupom> cuponsTroca = new ArrayList<Cupom>();
	private TipoCupom tipoCupom;
	private LocalDate dataDeValidade; 
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Cupom> getCuponsTroca() {
		return cuponsTroca;
	}
	public void setCuponsTroca(List<Cupom> cuponsTroca) {
		this.cuponsTroca = cuponsTroca;
	}
	public TipoCupom getTipoCupom() {
		return tipoCupom;
	}
	public void setTipoCupom(TipoCupom tipoCupom) {
		this.tipoCupom = tipoCupom;
	}
	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}
	public void setDataDeValidade(LocalDate dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	
	
}
