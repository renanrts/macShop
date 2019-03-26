package br.com.les.dominio;

import java.util.List;

public class BaseCadastro extends EntidadeDominio{
	
	 private List<Genero> listaGenero;
		private	List<Bandeira> listaBandeira;
		private	List<TipoTelefone> listaTipoTelefone;
		private	List<TipoEndereco> listaTipoEndereco;
		private List<TipoLogradouro> tiposLogradouro;
		private List<Cidade> listaCidades;
		private List<Estado> listaEstados;
		
		public List<Genero> getListaGenero() {
			return listaGenero;
		}
		public void setListaGenero(List<Genero> listaGenero) {
			this.listaGenero = listaGenero;
		}
		public List<Bandeira> getListaBandeira() {
			return listaBandeira;
		}
		public void setListaBandeira(List<Bandeira> listaBandeira) {
			this.listaBandeira = listaBandeira;
		}
		public List<TipoTelefone> getListaTipoTelefone() {
			return listaTipoTelefone;
		}
		public void setListaTipoTelefone(List<TipoTelefone> listaTipoTelefone) {
			this.listaTipoTelefone = listaTipoTelefone;
		}
		public List<TipoEndereco> getListaTipoEndereco() {
			return listaTipoEndereco;
		}
		public void setListaTipoEndereco(List<TipoEndereco> listaTipoEndereco) {
			this.listaTipoEndereco = listaTipoEndereco;
		}
		public List<TipoLogradouro> getTiposLogradouro() {
			return tiposLogradouro;
		}
		public void setTiposLogradouro(List<TipoLogradouro> listaTipoLogradouro) {
			this.tiposLogradouro = listaTipoLogradouro;
		}
		public List<Cidade> getListaCidades() {
			return listaCidades;
		}
		public void setListaCidades(List<Cidade> listaCidades) {
			this.listaCidades = listaCidades;
		}
		public List<Estado> getListaEstados() {
			return listaEstados;
		}
		public void setListaEstados(List<Estado> listaEstados) {
			this.listaEstados = listaEstados;
		}

}
