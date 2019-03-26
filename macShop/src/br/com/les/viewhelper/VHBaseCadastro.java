package br.com.les.viewhelper;



import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dao.DAOEndereco;
import br.com.les.dominio.Bandeira;
import br.com.les.dominio.BaseCadastro;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Genero;
import br.com.les.dominio.TipoEndereco;
import br.com.les.dominio.TipoLogradouro;
import br.com.les.dominio.TipoTelefone;
import br.com.les.util.Resultado;

public class VHBaseCadastro implements IViewHelper{


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		BaseCadastro base = new BaseCadastro();
		
		List<Genero> listaGenero = Arrays.asList(Genero.values());
		base.setListaGenero(listaGenero);
		
		List<Bandeira> listaBandeira = Arrays.asList(Bandeira.values());
		base.setListaBandeira(listaBandeira);
		
		List<TipoTelefone> listaTipoTelefone = Arrays.asList(TipoTelefone.values());
		base.setListaTipoTelefone(listaTipoTelefone);
		
		List<TipoEndereco> listaTipoEndereco = Arrays.asList(TipoEndereco.values());
		base.setListaTipoEndereco(listaTipoEndereco);
		
		List<TipoLogradouro> listaTipoLogradouro = Arrays.asList(TipoLogradouro.values());
		base.setTiposLogradouro(listaTipoLogradouro);
		
		DAOEndereco dao = new DAOEndereco();
		
		base.setListaCidades(dao.completarCidades(base));
		base.setListaEstados(dao.completarEstados(base));

		return base;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
