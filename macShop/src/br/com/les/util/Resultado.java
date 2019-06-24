package br.com.les.util;

import java.util.List;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Relatorio;

public class Resultado {
	
	private List<EntidadeDominio> listaResultado;
	private EntidadeDominio resultado;
	private boolean erro;
	private String mensagem;
	private int contagem = 0;
	private List<EntidadeDominio> categoria;
	private List<Integer> qtdeRelatorio;
	
	public List<EntidadeDominio> getListaResultado() {
		return listaResultado;
	}
	public void setListaResultado(List<EntidadeDominio> listaResultado) {
		this.listaResultado = listaResultado;
	}
	public EntidadeDominio getResultado() {
		return resultado;
	}
	public void setResultado(EntidadeDominio resultado) {
		this.resultado = resultado;
	}
	public boolean getErro() {
		return erro;
	}
	public void sucesso( String mensagem ) {
		erro = false;
		this.mensagem = mensagem;
	}
	
	public void erro( String mensagem ) {
		erro = true;
		this.mensagem = mensagem;
	} 
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getContagem() {
		return contagem;
	}
	public void setContagem(int contagem) {
		this.contagem = contagem;
	}
	
	public void setCategoria (List<EntidadeDominio> categorias)
	{
		this.categoria = categorias;
	}
	
	public List<EntidadeDominio> getCategoria ()
	{
		return categoria;
	}
	public List<Integer> getQtdeRelatorio() {
		return qtdeRelatorio;
	}
	public void setQtdeRelatorio(List<Integer> qtdeRelatorio) {
		this.qtdeRelatorio = qtdeRelatorio;
	}


}
