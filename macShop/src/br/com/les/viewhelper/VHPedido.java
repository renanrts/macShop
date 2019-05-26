package br.com.les.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Carrinho;
import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.FormaPagamento;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.TipoCupom;
import br.com.les.util.Resultado;

public class VHPedido implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Pedido pedido = new Pedido();
		FormaPagamento formapagto = new FormaPagamento();
		FormaPagamento formapagto2 = new FormaPagamento();
		List<FormaPagamento> listPgto = new ArrayList<FormaPagamento>();
		CartaoCredito cart1 = new CartaoCredito();
		CartaoCredito cart2 = new CartaoCredito();
		Cupom cupom = new Cupom();

		String[] strIdCuponsTroca = request.getParameterValues("cupom-troca");

		ArrayList<Cupom> cuponsSelecionados = new ArrayList<>();

		if (null != strIdCuponsTroca) {
			for (int i = 0; i < strIdCuponsTroca.length; i++) {

				if (strIdCuponsTroca[i] != null) {
					Cupom cup = new Cupom();
					cup.setId(Integer.parseInt(strIdCuponsTroca[i]));
					cup.setTipoCupom(TipoCupom.TROCA);
					cuponsSelecionados.add(cup);
				}
			}
		}

		pedido.setCuponsTroca(cuponsSelecionados);

		if (request.getParameter("pedStatus") != null) {
			pedido.setStatus(request.getParameter("pedStatus"));
		}

		if (request.getParameter("idcartaoPagamento1") != null) {
			cart1.setId(Integer.parseInt(request.getParameter("idcartaoPagamento1")));
		}

		if (request.getParameter("pedID") != null) {
			pedido.setId(Integer.parseInt(request.getParameter("pedID")));
		}

		formapagto.setCartao(cart1);

		if (request.getParameter("idcartaoPagamento2") != null) {
			cart2.setId(Integer.parseInt(request.getParameter("idcartaoPagamento2")));
		}

		formapagto2.setCartao(cart2);

		if (request.getParameter("parcelasCartao1") != null) {
			if (request.getParameter("parcelasCartao1") == "") {
				formapagto.setParcela(0);
			} else {
			formapagto.setParcela(Integer.parseInt(request.getParameter("parcelasCartao1")));
			}
		}

		if (request.getParameter("valorCartao1") != null) {
			if (request.getParameter("valorCartao1") == "") {
				formapagto.setValor(0.0);
			} else {
			formapagto.setValor(Double.parseDouble(request.getParameter("valorCartao1")));
			}
		}

		if (request.getParameter("parcelasCartao2") != null) {
			if (request.getParameter("valorCartao2") == "") {
				formapagto2.setValor(0.0);
			} else {
				formapagto2.setParcela(Integer.parseInt(request.getParameter("parcelasCartao2")));
			}

		}

		if (request.getParameter("valorCartao2") != null) {
			if (request.getParameter("valorCartao2") == "") {
				formapagto2.setValor(0.0);
				formapagto2.setParcela(0);
			} else {
				formapagto2.setValor(Double.parseDouble(request.getParameter("valorCartao2")));
			}

		}

		if (request.getParameter("idcupom") != null) {
			cupom.setId(Integer.parseInt(request.getParameter("idcupom")));
		}
		
		if (request.getParameter("idcupom") == null) {
			cupom.setId(0);
			cupom.setValor(0.0);
		}

		pedido.setCupom_id(cupom);

		listPgto.add(formapagto);
		listPgto.add(formapagto2);

		if (request.getSession().getAttribute("carrinho") != null) {
			pedido.setCarrinho((Carrinho) request.getSession().getAttribute("carrinho"));
		}

		pedido.setFormapagto(listPgto);

		if (request.getParameter("cli_id") != null) {
			pedido.setCli_id(Integer.parseInt(request.getParameter("cli_id")));
		}

		if (request.getParameter("enderecoselecionado_id") != null) {
			Endereco end = new Endereco();
			end.setId(Integer.parseInt(request.getParameter("enderecoselecionado_id")));
			pedido.setEndEntrega(end);
		}

		if (request.getSession().getAttribute("frete") != null) {

			pedido.setFrete((Double) request.getSession().getAttribute("frete"));
		}

		return pedido;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		if (resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);

		try {
			if (operacao.equals("SALVAR")) {
				if (resultado.getErro()) {
					RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
					rd.forward(request, response);
				} else {
					request.getSession().setAttribute("carrinho", null);
					request.getSession().setAttribute("frete", 0.0);
					request.getSession().setAttribute("cep", "");
					RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
					rd.forward(request, response);
				}

			} else if (operacao.equals("CONSULTAR")) {
				request.setAttribute("pedidos", resultado.getListaResultado());
				if (request.getParameter("Direcionamento").equals("CLIENTE")) {
					RequestDispatcher rd = request.getRequestDispatcher("pedidos-cli.jsp");
					rd.forward(request, response);
				} else

				{
					RequestDispatcher rd = request.getRequestDispatcher("area-cli.jsp");
					rd.forward(request, response);
				}

			} else if (operacao.equals("VISUALIZAR")) {
				request.setAttribute("pedidos", resultado.getListaResultado());
				RequestDispatcher rd = request.getRequestDispatcher("detalhes-compra.jsp");
				rd.forward(request, response);

			} else if (operacao.equals("INATIVAR")) {

				RequestDispatcher rd = request.getRequestDispatcher("consulta-cli.jsp");
				rd.forward(request, response);

			} else if (operacao.equals("ALTERAR")) {

				RequestDispatcher rd = request.getRequestDispatcher("area-cli.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
