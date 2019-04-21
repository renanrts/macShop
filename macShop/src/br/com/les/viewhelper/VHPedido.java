package br.com.les.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Carrinho;
import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.FormaPagamento;
import br.com.les.dominio.Pedido;
import br.com.les.util.Resultado;

public class VHPedido implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Pedido pedido = new Pedido();
		FormaPagamento formapagto = new FormaPagamento();
		List<FormaPagamento> listPgto = new ArrayList<FormaPagamento>();
		CartaoCredito cart = new CartaoCredito();
		Cupom cupom = new Cupom();
		cart.setId(Integer.parseInt(request.getParameter("idcartaoPagamento1")));
		
		formapagto.setCartao(cart);
		formapagto.setParcela(request.getParameter("parcelasCartao1"));
		formapagto.setValor(Double.parseDouble(request.getParameter("valorCartao1")));
		cupom.setId(Integer.parseInt(request.getParameter("idcupom")));
		formapagto.setCupom(cupom);
		
		pedido.setCarrinho((Carrinho) request.getSession().getAttribute("carrinho"));
		pedido.setFormapagto(listPgto);
		pedido.setCli_id(Integer.parseInt(request.getParameter("cli_id")));
		pedido.setEntrega_id(Integer.parseInt(request.getParameter("cup_id")));
		pedido.setFrete(Double.parseDouble(request.getParameter("cup_id")));
	
		return pedido;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
