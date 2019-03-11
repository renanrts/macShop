package br.com.les.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.les.negocio.StValidarDadosObrigatorios;
import br.com.les.dao.DAOCategoria;
import br.com.les.dao.DAOEletronico;
import br.com.les.dao.IDAO;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.negocio.IStrategy;
import br.com.les.util.Resultado;


public class Fachada implements IFachada {
	
	private Map<String, List<IStrategy>> mapStrategy;
	private Map<String, IDAO> mapDAO;
	private List<IStrategy> listStrategySalvar;

	public Fachada() {

		mapStrategy = new HashMap<String, List<IStrategy>>();
		mapDAO = new HashMap<String, IDAO>();

		listStrategySalvar = new ArrayList<IStrategy>();

		listStrategySalvar.add(new StValidarDadosObrigatorios());
	

		mapStrategy.put("SALVAR", listStrategySalvar);
		
		mapDAO.put("ELETRONICO", new DAOEletronico());
		mapDAO.put("CATEGORIA", new DAOCategoria());
		mapDAO.put("PRODUTO", new DAOEletronico());
		

	}

public Resultado validarStrategys(EntidadeDominio entidade, String operacao){
		
		Resultado resultado = new Resultado();
		String mensagem = "";
		String mensagens = "";
		
		List<IStrategy> listStrategy;
		listStrategy = mapStrategy.get(operacao);
		
		for (IStrategy iStrategy : listStrategy) {
			
			mensagem = iStrategy.processar(entidade);
			if(mensagem != null){
				mensagens += mensagem;
			}
		}
		
		if(mensagens == ""){
			resultado.sucesso("SUCESSO");
		}else{
			List<EntidadeDominio> l = new ArrayList<>();
			l.add(entidade);
			resultado.setListaResultado(l);
			resultado.erro(mensagens);
		}
		
		return resultado;
	}


	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		resultado = validarStrategys(entidade, "SALVAR");
	
		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName().toUpperCase());
			resultado = dao.salvar(entidade);
		}
		
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		IDAO dao = mapDAO.get(entidade.getClass().getSimpleName().toUpperCase());
		return dao.consultar(entidade);
	}

	@Override
	public Resultado visualizar(EntidadeDominio e) {
		
		IDAO dao = mapDAO.get(e.getClass().getSimpleName().toUpperCase());
		return dao.visualizar(e);
	}

	@Override
	public Resultado excluir(EntidadeDominio e) {
		IDAO dao = mapDAO.get(e.getClass().getSimpleName().toUpperCase());
		return dao.excluir(e);
	}


}
