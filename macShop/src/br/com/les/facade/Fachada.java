package br.com.les.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOBloqueio;
import br.com.les.dao.DAOCategoria;
import br.com.les.dao.DAOCliente;
import br.com.les.dao.DAOEletronico;
import br.com.les.dao.DAOPedido;
import br.com.les.dao.IDAO;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;
import br.com.les.negocio.IStrategy;
import br.com.les.negocio.StAprovarPedido;
import br.com.les.negocio.StCalcularFrete;
import br.com.les.negocio.StCalcularTotalPedido;
import br.com.les.negocio.StComplementarCategoria;
import br.com.les.negocio.StComplementarCupom;
import br.com.les.negocio.StComplementarDTCadastro;
import br.com.les.negocio.StComplementarDTCadastroCliente;
import br.com.les.negocio.StComplementarDataPedido;
import br.com.les.negocio.StComplementarEnderecoCliente;
import br.com.les.negocio.StComplementarInativacao;
import br.com.les.negocio.StInutilizarCupom;
import br.com.les.negocio.StValidarAtivacaoInativacao;
import br.com.les.negocio.StValidarBloqueio;
import br.com.les.negocio.StValidarCPF;
import br.com.les.negocio.StValidarDadosObrigatorios;
import br.com.les.negocio.StValidarDadosObrigatoriosCliente;
import br.com.les.negocio.StValidarDadosObrigatoriosPedido;
import br.com.les.negocio.StValidarExistencia;
import br.com.les.negocio.StValidarExistenciaCliente;
import br.com.les.negocio.StValidarSenhasCliente;
import br.com.les.util.Resultado;


public class Fachada implements IFachada {
	

	private Map<String, IDAO> mapDAO;

	
	private Map<String, Map<String, List<IStrategy>>> rns;


	public Fachada() {


		mapDAO = new HashMap<String, IDAO>();
		mapDAO.put("ELETRONICO", new DAOEletronico());
		mapDAO.put("CATEGORIA", new DAOCategoria());
		mapDAO.put("PRODUTO", new DAOEletronico());
		mapDAO.put("ACESSORIO", new DAOAcessorio());
		mapDAO.put("CLIENTE", new DAOCliente());
		mapDAO.put("BLOQUEIO", new DAOBloqueio());
		mapDAO.put("PEDIDO", new DAOPedido());
		
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		StComplementarCategoria StComplementarCategoria = new StComplementarCategoria();
		StComplementarDTCadastro StComplementarDTCadastro = new StComplementarDTCadastro();
		StValidarExistencia	StValidarExistencia = new StValidarExistencia();
		StValidarDadosObrigatorios StValidarDadosObrigatorios = new StValidarDadosObrigatorios();
		StValidarAtivacaoInativacao StValidarAtivacaoInativacao = new StValidarAtivacaoInativacao();
		StComplementarInativacao StComplementarInativacao = new StComplementarInativacao();
		StValidarCPF StValidarCPF = new StValidarCPF();
		StComplementarDTCadastroCliente StComplementarDTCadastroCliente = new StComplementarDTCadastroCliente();
		StValidarDadosObrigatoriosCliente StValidarDadosObrigatoriosCliente = new StValidarDadosObrigatoriosCliente();
		StValidarExistenciaCliente	StValidarExistenciaCliente = new StValidarExistenciaCliente();
		StComplementarEnderecoCliente StComplementarEnderecoCliente = new StComplementarEnderecoCliente();
		StValidarSenhasCliente StValidarSenhasCliente = new StValidarSenhasCliente();
		StValidarBloqueio StValidarBloqueio = new StValidarBloqueio();
		StCalcularTotalPedido StCalcularTotalPedido = new StCalcularTotalPedido();
		StInutilizarCupom StInutilizarCupom = new StInutilizarCupom();
		StCalcularFrete StCalcularFrete = new StCalcularFrete();
		StComplementarDataPedido StComplementarDataPedido = new StComplementarDataPedido();
		StValidarDadosObrigatoriosPedido StValidarDadosObrigatoriosPedido = new StValidarDadosObrigatoriosPedido();
		StAprovarPedido StAprovarPedido = new StAprovarPedido();
		StComplementarCupom StComplementarCupom = new StComplementarCupom();
		
		
		/* Criando uma lista para conter as regras de negócio de fornencedor
		 * quando a operação for salvar
		 */
		List<IStrategy> rnsSalvarProduto = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do fornecedor*/
		rnsSalvarProduto.add(StComplementarCategoria);
		rnsSalvarProduto.add(StComplementarDTCadastro);
		rnsSalvarProduto.add(StValidarExistencia);
		rnsSalvarProduto.add(StValidarDadosObrigatorios);
		
		/* Criando uma lista para conter as regras de negócio de produto
		 * quando a operação for inativar
		 */
		List<IStrategy> rnsInativarProduto = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação alterar do produto */
		rnsInativarProduto.add(StValidarAtivacaoInativacao);
		rnsInativarProduto.add(StComplementarInativacao);
		
		
		/* Criando uma lista para conter as regras de negócio de produto
		 * quando a operação for alterar
		 */
		List<IStrategy> rnsAlterarProduto = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação alterar do produto */
		rnsAlterarProduto.add(StComplementarCategoria);
		rnsAlterarProduto.add(StValidarDadosObrigatorios);
		

		/* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação do produto
		 */
		Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
		/*
		 * Adiciona a listra de regras na operação salvar no mapa do produto (lista criada na linha 114)
		 */
		rnsProduto.put("SALVAR", rnsSalvarProduto);
		/*
		 * Adiciona a listra de regras na operação alterar no mapa do produto (lista criada na linha 122)
		 */
		rnsProduto.put("ALTERAR", rnsAlterarProduto);
		/*
		 * Adiciona a listra de regras na operação alterar no mapa do produto (lista criada na linha 122)
		 */
		rnsProduto.put("INATIVAR", rnsInativarProduto);
		
		
		/* Adiciona o mapa(criado na linha 129) com as regras indexadas pelas operações no mapa geral indexado 
		 * pelo nome da entidade. Observe que este mapa (rns) é o mesmo utilizado na linha 88.
		 */
		rns.put(Produto.class.getSimpleName().toUpperCase(), rnsProduto);
		
		
		/* Criando uma lista para conter as regras de negócio de cliente
		 * quando a operação for salvar
		 */
		List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do cliente */
		rnsSalvarCliente.add(StValidarCPF);		
		rnsSalvarCliente.add(StComplementarDTCadastroCliente);
		rnsSalvarCliente.add(StComplementarEnderecoCliente);
		rnsSalvarCliente.add(StValidarExistenciaCliente);
		rnsSalvarCliente.add(StValidarDadosObrigatoriosCliente);
		rnsSalvarCliente.add(StValidarSenhasCliente);
		
		
		/* Criando uma lista para conter as regras de negócio de cliente
		 * quando a operação for salvar
		 */
		List<IStrategy> rnsAlterarCliente = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do cliente */
		rnsAlterarCliente.add(StComplementarEnderecoCliente);
		rnsAlterarCliente.add(StValidarDadosObrigatoriosCliente);
		/* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação do cliente
		 */
		Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
		/*
		 * Adiciona a listra de regras na operação salvar no mapa do cliente (lista criada na linha 93)
		 */
		rnsCliente.put("SALVAR", rnsSalvarCliente);	
		rnsCliente.put("ALTERAR", rnsAlterarCliente);	
		/* Adiciona o mapa(criado na linha 101) com as regras indexadas pelas operações no mapa geral indexado 
		 * pelo nome da entidade. Observe que este mapa (rns) é o mesmo utilizado na linha 88.
		 */
		rns.put(Cliente.class.getSimpleName().toUpperCase(), rnsCliente);
		
		
		List<IStrategy> rnsConsultarBloqueio = new ArrayList<IStrategy>();
		rnsConsultarBloqueio.add(StValidarBloqueio);
		
		Map<String, List<IStrategy>> rnsBloqueio = new HashMap<String, List<IStrategy>>();
		rnsBloqueio.put("SALVAR", rnsConsultarBloqueio);	
		rns.put(Bloqueio.class.getSimpleName().toUpperCase(), rnsBloqueio);
		
		List<IStrategy> rnsInativarBloqueio = new ArrayList<IStrategy>();

		rnsBloqueio.put("INATIVAR", rnsInativarBloqueio);	
		
		
		List<IStrategy> rnsAlterarBloqueio = new ArrayList<IStrategy>();
		rnsAlterarBloqueio.add(StValidarBloqueio);
		rnsBloqueio.put("ALTERAR", rnsAlterarBloqueio);
		
		rns.put(Bloqueio.class.getSimpleName().toUpperCase(), rnsBloqueio);
		
		
		List<IStrategy> rnsSalvarPedido = new ArrayList<IStrategy>();
		
		rnsSalvarPedido.add(StValidarDadosObrigatoriosPedido);
		rnsSalvarPedido.add(StCalcularFrete);
		rnsSalvarPedido.add(StComplementarDataPedido);
		rnsSalvarPedido.add(StComplementarCupom);
		rnsSalvarPedido.add(StCalcularTotalPedido);
		rnsSalvarPedido.add(StAprovarPedido);
		rnsSalvarPedido.add(StInutilizarCupom);

		Map<String, List<IStrategy>> rnsPedido = new HashMap<String, List<IStrategy>>();
		rnsPedido.put("SALVAR", rnsSalvarPedido);	
		rns.put(Pedido.class.getSimpleName().toUpperCase(), rnsPedido);
	}

public Resultado validarStrategys(EntidadeDominio entidade, String operacao){
		
		Resultado resultado = new Resultado();
		String mensagem = "";
		String mensagens = "";
		String nmClasse = entidade.getClass().getSimpleName().toUpperCase();
		if (nmClasse.equals("ELETRONICO") || nmClasse.equals("ACESSORIO"))
		{
			nmClasse = "PRODUTO";
		}
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		List<IStrategy> listStrategy = regrasOperacao.get(operacao);
		
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
