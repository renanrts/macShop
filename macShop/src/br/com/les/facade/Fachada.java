package br.com.les.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.les.negocio.StValidarDadosObrigatorios;
import br.com.les.negocio.StValidarExistencia;
import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOCategoria;
import br.com.les.dao.DAOEletronico;
import br.com.les.dao.IDAO;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.negocio.IStrategy;
import br.com.les.negocio.StComplementarCategoria;
import br.com.les.negocio.StComplementarDTCadastro;
import br.com.les.negocio.StComplementarInativacao;
import br.com.les.negocio.StValidarAtivacaoInativacao;
import br.com.les.util.Resultado;


public class Fachada implements IFachada {
	
	private Map<String, List<IStrategy>> mapStrategy;
	private Map<String, IDAO> mapDAO;
	private List<IStrategy> listStrategySalvar;
	private List<IStrategy> listStrategyAlterar;
	private List<IStrategy> listStrategyInativar;


	public Fachada() {

		mapStrategy = new HashMap<String, List<IStrategy>>();
		mapDAO = new HashMap<String, IDAO>();

		listStrategySalvar = new ArrayList<IStrategy>();
		listStrategySalvar.add(new StComplementarCategoria());
		listStrategySalvar.add(new StComplementarDTCadastro());
		listStrategySalvar.add(new StValidarExistencia());
		listStrategySalvar.add(new StValidarDadosObrigatorios());
		
		
		listStrategyAlterar = new ArrayList<IStrategy>();
		listStrategyAlterar.add(new StComplementarCategoria());
		listStrategyAlterar.add(new StValidarDadosObrigatorios());
		
		listStrategyInativar = new ArrayList<IStrategy>();
		listStrategyInativar.add(new StValidarAtivacaoInativacao());
		listStrategyInativar.add(new StComplementarInativacao());

		mapStrategy.put("SALVAR", listStrategySalvar);
		mapStrategy.put("ALTERAR", listStrategyAlterar);
		mapStrategy.put("INATIVAR", listStrategyInativar);
		
		mapDAO.put("ELETRONICO", new DAOEletronico());
		mapDAO.put("CATEGORIA", new DAOCategoria());
		mapDAO.put("PRODUTO", new DAOEletronico());
		mapDAO.put("ACESSORIO", new DAOAcessorio());
		

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
		Resultado resultado = new Resultado();
		resultado = validarStrategys(e, "INATIVAR");
		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(e.getClass().getSimpleName().toUpperCase());
			return dao.excluir(e);
		}
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio e) {
		Resultado resultado = new Resultado();
		resultado = validarStrategys(e, "ALTERAR");
	
		if (!resultado.getErro()) {
		IDAO dao = mapDAO.get(e.getClass().getSimpleName().toUpperCase());
		return dao.alterar(e);
		}
		
		return resultado;
	}


}
