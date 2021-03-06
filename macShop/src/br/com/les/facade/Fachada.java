package br.com.les.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.les.command.CommandCarrinhoAlterar;
import br.com.les.command.CommandCarrinhoAdicionar;
import br.com.les.command.CommandCarrinhoExcluir;
import br.com.les.dao.DAOAcessorio;
import br.com.les.dao.DAOCartao;
import br.com.les.dao.DAOCategoria;
import br.com.les.dao.DAOCliente;
import br.com.les.dao.DAOCupom;
import br.com.les.dao.DAOEletronico;
import br.com.les.dao.DAOEndereco;
import br.com.les.dao.DAOItemProduto;
import br.com.les.dao.DAOPedido;
import br.com.les.dao.DAORelatorio;
import br.com.les.dao.IDAO;
import br.com.les.dominio.Bloqueio;
import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;
import br.com.les.dominio.Relatorio;
import br.com.les.negocio.IStrategy;
import br.com.les.negocio.StAlterarStatusItemProduto;
import br.com.les.negocio.StAlterarStatusPedido;
import br.com.les.negocio.StAprovarPedido;
import br.com.les.negocio.StCalcularTotalPedido;
import br.com.les.negocio.StComplementarCategoria;
import br.com.les.negocio.StComplementarCupom;
import br.com.les.negocio.StComplementarDTCadastro;
import br.com.les.negocio.StComplementarDTCadastroCliente;
import br.com.les.negocio.StComplementarDataPedido;
import br.com.les.negocio.StComplementarEnderecoCliente;
import br.com.les.negocio.StComplementarEnderecoEntrega;
import br.com.les.negocio.StComplementarInativacao;
import br.com.les.negocio.StComplementarVariaveis;
import br.com.les.negocio.StConsultarQuantidadeEstoque;
import br.com.les.negocio.StInutilizarCupom;
import br.com.les.negocio.StReprovarTroca;
import br.com.les.negocio.StValidarAtivacaoInativacao;
import br.com.les.negocio.StValidarBloqueio;
import br.com.les.negocio.StValidarCPF;
import br.com.les.negocio.StValidarCarrinhoExpirado;
import br.com.les.negocio.StValidarDadosObrigatorios;
import br.com.les.negocio.StValidarDadosObrigatoriosCartao;
import br.com.les.negocio.StValidarDadosObrigatoriosCliente;
import br.com.les.negocio.StValidarDadosObrigatoriosEndereco;
import br.com.les.negocio.StValidarDadosObrigatoriosPedido;
import br.com.les.negocio.StValidarDataValidadeCupom;
import br.com.les.negocio.StValidarExistencia;
import br.com.les.negocio.StValidarExistenciaCarrinhoSessao;
import br.com.les.negocio.StValidarExistenciaCliente;
import br.com.les.negocio.StValidarFormaDePagamento;
import br.com.les.negocio.StValidarQuantidadeAIncluirOuExcluirCarrinho;
import br.com.les.negocio.StValidarSenhasCliente;
import br.com.les.negocio.StValidarValorExcendenteAoPagamento;

import br.com.les.util.Resultado;
import service.CarrinhoAdicionar;
import service.CarrinhoAlterar;
import service.CarrinhoExcluir;
import service.CarrinhoServico;
import service.IServico;

public class Fachada implements IFachada {

	private Map<String, IDAO> mapDAO;

	private Map<String, Map<String, List<IStrategy>>> rns;
	
	private Map<String, IServico> mapServico;

	public Fachada() {

		mapDAO = new HashMap<String, IDAO>();
		mapDAO.put("ELETRONICO", new DAOEletronico());
		mapDAO.put("CATEGORIA", new DAOCategoria());
		mapDAO.put("PRODUTO", new DAOEletronico());
		mapDAO.put("ACESSORIO", new DAOAcessorio());
		mapDAO.put("CLIENTE", new DAOCliente());
		mapDAO.put("PEDIDO", new DAOPedido());
		mapDAO.put("CUPOM", new DAOCupom());
		mapDAO.put("ENDERECO", new DAOEndereco());
		mapDAO.put("CARTAOCREDITO", new DAOCartao());
		mapDAO.put("ITEMCARRINHO", new DAOItemProduto());
		mapDAO.put("RELATORIO", new DAORelatorio());

		rns = new HashMap<String, Map<String, List<IStrategy>>>();

		StComplementarCategoria StComplementarCategoria = new StComplementarCategoria();
		StComplementarDTCadastro StComplementarDTCadastro = new StComplementarDTCadastro();
		StValidarExistencia StValidarExistencia = new StValidarExistencia();
		StValidarDadosObrigatorios StValidarDadosObrigatorios = new StValidarDadosObrigatorios();
		StValidarAtivacaoInativacao StValidarAtivacaoInativacao = new StValidarAtivacaoInativacao();
		StComplementarInativacao StComplementarInativacao = new StComplementarInativacao();
		StValidarCPF StValidarCPF = new StValidarCPF();
		StComplementarDTCadastroCliente StComplementarDTCadastroCliente = new StComplementarDTCadastroCliente();
		StValidarDadosObrigatoriosCliente StValidarDadosObrigatoriosCliente = new StValidarDadosObrigatoriosCliente();
		StValidarExistenciaCliente StValidarExistenciaCliente = new StValidarExistenciaCliente();
		StComplementarEnderecoCliente StComplementarEnderecoCliente = new StComplementarEnderecoCliente();
		StValidarSenhasCliente StValidarSenhasCliente = new StValidarSenhasCliente();
		StValidarBloqueio StValidarBloqueio = new StValidarBloqueio();
		StCalcularTotalPedido StCalcularTotalPedido = new StCalcularTotalPedido();
		StInutilizarCupom StInutilizarCupom = new StInutilizarCupom();
		StComplementarDataPedido StComplementarDataPedido = new StComplementarDataPedido();
		StValidarDadosObrigatoriosPedido StValidarDadosObrigatoriosPedido = new StValidarDadosObrigatoriosPedido();
		StAprovarPedido StAprovarPedido = new StAprovarPedido();
		StComplementarCupom StComplementarCupom = new StComplementarCupom();

		// CUPOM
		List<IStrategy> rnsSalvarCupom = new ArrayList<IStrategy>();
		rnsSalvarCupom.add(new StValidarDataValidadeCupom());
		Map<String, List<IStrategy>> rnsCupom = new HashMap<String, List<IStrategy>>();
		rnsCupom.put("SALVAR", rnsSalvarCupom);
		rns.put(Cupom.class.getSimpleName().toUpperCase(), rnsCupom);

		// PRODUTO
		List<IStrategy> rnsSalvarProduto = new ArrayList<IStrategy>();
		rnsSalvarProduto.add(StComplementarCategoria);
		rnsSalvarProduto.add(StComplementarDTCadastro);
		rnsSalvarProduto.add(StValidarExistencia);
		rnsSalvarProduto.add(StValidarDadosObrigatorios);

		List<IStrategy> rnsInativarProduto = new ArrayList<IStrategy>();
		rnsInativarProduto.add(StValidarAtivacaoInativacao);
		rnsInativarProduto.add(StComplementarInativacao);

		List<IStrategy> rnsAlterarProduto = new ArrayList<IStrategy>();
		rnsAlterarProduto.add(StComplementarCategoria);
		rnsAlterarProduto.add(StValidarDadosObrigatorios);

		Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
		rnsProduto.put("SALVAR", rnsSalvarProduto);
		rnsProduto.put("ALTERAR", rnsAlterarProduto);
		rnsProduto.put("INATIVAR", rnsInativarProduto);

		rns.put(Produto.class.getSimpleName().toUpperCase(), rnsProduto);

		// CLIENTE
		List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
		rnsSalvarCliente.add(StValidarCPF);
		rnsSalvarCliente.add(StComplementarDTCadastroCliente);
		rnsSalvarCliente.add(StComplementarEnderecoCliente);
		rnsSalvarCliente.add(StValidarExistenciaCliente);
		rnsSalvarCliente.add(StValidarDadosObrigatoriosCliente);
		rnsSalvarCliente.add(StValidarSenhasCliente);

		List<IStrategy> rnsAlterarCliente = new ArrayList<IStrategy>();
		rnsAlterarCliente.add(StComplementarEnderecoCliente);
		rnsAlterarCliente.add(StValidarDadosObrigatoriosCliente);

		Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
		rnsCliente.put("SALVAR", rnsSalvarCliente);
		rnsCliente.put("ALTERAR", rnsAlterarCliente);

		rns.put(Cliente.class.getSimpleName().toUpperCase(), rnsCliente);

		// BLOQUEIO
		List<IStrategy> rnsConsultarBloqueio = new ArrayList<IStrategy>();
		rnsConsultarBloqueio.add(StValidarBloqueio);

		List<IStrategy> rnsInativarBloqueio = new ArrayList<IStrategy>();

		List<IStrategy> rnsAlterarBloqueio = new ArrayList<IStrategy>();
		rnsAlterarBloqueio.add(StValidarBloqueio);

		List<IStrategy> rnsSalvarBloqueioProduto = new ArrayList<IStrategy>();
		rnsSalvarBloqueioProduto.add(new StConsultarQuantidadeEstoque());
		rnsSalvarBloqueioProduto.add(new StValidarExistenciaCarrinhoSessao());

		List<IStrategy> rnsAlterarBloqueioProduto = new ArrayList<IStrategy>();
		rnsAlterarBloqueioProduto.add(new StValidarQuantidadeAIncluirOuExcluirCarrinho());

		Map<String, List<IStrategy>> rnsBloqueio = new HashMap<String, List<IStrategy>>();

		//rnsBloqueio.put("SALVAR", rnsConsultarBloqueio);
		rnsBloqueio.put("CARRINHOEXCLUIR", rnsInativarBloqueio);
		//rnsBloqueio.put("ALTERAR", rnsAlterarBloqueio);
		rnsBloqueio.put("CARRINHOADICIONAR", rnsSalvarBloqueioProduto);
		rnsBloqueio.put("CARRINHOALTERAR", rnsAlterarBloqueioProduto);

		rns.put(Bloqueio.class.getSimpleName().toUpperCase(), rnsBloqueio);

		// PEDIDO

		List<IStrategy> rnsSalvarPedido = new ArrayList<IStrategy>();
		rnsSalvarPedido.add(new StValidarCarrinhoExpirado());
		rnsSalvarPedido.add(StValidarDadosObrigatoriosPedido);
		rnsSalvarPedido.add(new StValidarFormaDePagamento());
		rnsSalvarPedido.add(StComplementarCupom);
		rnsSalvarPedido.add(StComplementarDataPedido);
		rnsSalvarPedido.add(StCalcularTotalPedido);
		rnsSalvarPedido.add(new StValidarValorExcendenteAoPagamento());
		rnsSalvarPedido.add(StAprovarPedido);
		rnsSalvarPedido.add(StInutilizarCupom);

		List<IStrategy> rnsAlterarPedido = new ArrayList<IStrategy>();
		rnsAlterarPedido.add(new StAlterarStatusPedido());

		Map<String, List<IStrategy>> rnsPedido = new HashMap<String, List<IStrategy>>();
		rnsPedido.put("SALVAR", rnsSalvarPedido);
		rnsPedido.put("ALTERAR", rnsAlterarPedido);
		rns.put(Pedido.class.getSimpleName().toUpperCase(), rnsPedido);

		// ENDERECO
		List<IStrategy> rnsSalvarEndereco = new ArrayList<IStrategy>();
		rnsSalvarEndereco.add(new StComplementarEnderecoEntrega());
		rnsSalvarEndereco.add(new StValidarDadosObrigatoriosEndereco());
		Map<String, List<IStrategy>> rnsEndereco = new HashMap<String, List<IStrategy>>();
		rnsEndereco.put("SALVAR", rnsSalvarEndereco);
		rns.put(Endereco.class.getSimpleName().toUpperCase(), rnsEndereco);

		// CARTAO
		List<IStrategy> rnsSalvarCartao = new ArrayList<IStrategy>();
		rnsSalvarCartao.add(new StValidarDadosObrigatoriosCartao());
		Map<String, List<IStrategy>> rnsCartao = new HashMap<String, List<IStrategy>>();
		rnsCartao.put("SALVAR", rnsSalvarCartao);
		rns.put(CartaoCredito.class.getSimpleName().toUpperCase(), rnsCartao);

		// ITEM PRODUTO
		List<IStrategy> rnsSalvarItemProduto = new ArrayList<IStrategy>();
		rnsSalvarItemProduto.add(new StAlterarStatusItemProduto());

		Map<String, List<IStrategy>> rnsItemProduto = new HashMap<String, List<IStrategy>>();
		rnsItemProduto.put("SALVAR", rnsSalvarItemProduto);
		
		
		List<IStrategy> rnsAlterarItemProduto = new ArrayList<IStrategy>();
		rnsAlterarItemProduto.add(new StAlterarStatusItemProduto());
		
		

		rnsItemProduto.put("ALTERAR", rnsAlterarItemProduto);
	
		
		List<IStrategy> rnsReprovarItemProduto = new ArrayList<IStrategy>();
		rnsReprovarItemProduto.add(new StReprovarTroca());

		rnsItemProduto.put("INATIVAR", rnsReprovarItemProduto);
		rns.put(ItemCarrinho.class.getSimpleName().toUpperCase(), rnsItemProduto);
		
		
		// RELATORIO
				List<IStrategy> rnsConsultarRelatorio = new ArrayList<IStrategy>();
				rnsConsultarRelatorio.add(new StComplementarVariaveis());
				
				Map<String, List<IStrategy>> rnsRelatorio = new HashMap<String, List<IStrategy>>();
				rnsRelatorio.put("CONSULTAR", rnsConsultarRelatorio);
				rns.put(Relatorio.class.getSimpleName().toUpperCase(), rnsRelatorio);
				
				
				//MAP SERVICO
				mapServico = new HashMap<String, IServico>();
	
				//Carrinho
				
				    mapServico.put(CommandCarrinhoAdicionar.class.getSimpleName(), new CarrinhoAdicionar());
				    mapServico.put(CommandCarrinhoExcluir.class.getSimpleName(), new CarrinhoExcluir());
				    mapServico.put(CommandCarrinhoAlterar.class.getSimpleName(), new CarrinhoAlterar());
			

	}

	public Resultado validarStrategys(EntidadeDominio entidade, String operacao) {

		Resultado resultado = new Resultado();
		String mensagem = "";
		String mensagens = "";
		String nmClasse = entidade.getClass().getSimpleName().toUpperCase();
		if (nmClasse.equals("ELETRONICO") || nmClasse.equals("ACESSORIO")) {
			nmClasse = "PRODUTO";
		}
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		List<IStrategy> listStrategy = regrasOperacao.get(operacao);

		for (IStrategy iStrategy : listStrategy) {

			mensagem = iStrategy.processar(entidade);
			if (mensagem != null) {
				mensagens += mensagem;
			}
		}

		if (mensagens == "") {

			resultado.sucesso("SUCESSO");
		} else {

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
			resultado = dao.alterar(e);
		}

		return resultado;
	}


	@Override
	public Resultado chamarServico(EntidadeDominio e, String cmd) {
		Resultado resultado = new Resultado();
		String operacao = cmd.toUpperCase().substring(7);
		
		resultado = validarStrategys(e,operacao);
		
		if (!resultado.getErro()) {
			IServico servico = mapServico.get(cmd);
			resultado = servico.executarServico(e);
		}

		return resultado;
	}

}
