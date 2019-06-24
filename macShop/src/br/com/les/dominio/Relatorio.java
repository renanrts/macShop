package br.com.les.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Relatorio extends EntidadeDominio {
	
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private List<EntidadeDominio> variavel1;
	private List<String> meses;
	private List<Integer> mesesNumber;
	private Map<Integer, Map<String, Integer>> valoresM;
	private Map<Integer, Map<String, Integer>> valoresF;
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public List<EntidadeDominio> getVariavel1() {
		return variavel1;
	}
	public void setVariavel1(List<EntidadeDominio> variavel1) {
		this.variavel1 = variavel1;
	}
	
	public List<String> getMeses() {
		return meses;
	}
	public void setMeses(List<String> meses) {
		this.meses = meses;
	}
	public Map<Integer, Map<String, Integer>> getValoresM() {
		return valoresM;
	}
	public void setValoresM(Map<Integer, Map<String, Integer>> valoresM) {
		this.valoresM = valoresM;
	}
	public Map<Integer, Map<String, Integer>> getValoresF() {
		return valoresF;
	}
	public void setValoresF(Map<Integer, Map<String, Integer>> valoresF) {
		this.valoresF = valoresF;
	}
	public List<Integer> getMesesNumber() {
		return mesesNumber;
	}
	public void setMesesNumber(List<Integer> mesesNumber) {
		this.mesesNumber = mesesNumber;
	}

	
	

}
