package br.com.les.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Carrinho;
import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cliente;
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
		
		if(request.getParameter("idcartaoPagamento1") != null)
		{
			cart.setId(Integer.parseInt(request.getParameter("idcartaoPagamento1")));
		}
		
		
		formapagto.setCartao(cart);
		
		if(request.getParameter("parcelasCartao1")!=null) {
			formapagto.setParcela(Integer.parseInt(request.getParameter("parcelasCartao1")));
		}
		
		if(request.getParameter("valorCartao1")!=null)
		{
			formapagto.setValor(Double.parseDouble(request.getParameter("valorCartao1")));
		}
		
		if (request.getParameter("idcupom")!=null)
		{
			cupom.setId(Integer.parseInt(request.getParameter("idcupom")));
		}
		
		formapagto.setCupom(cupom);
		listPgto.add(formapagto);
		
		if(request.getSession().getAttribute("carrinho")!=null)
		{
			pedido.setCarrinho((Carrinho) request.getSession().getAttribute("carrinho"));
		}
		
		pedido.setFormapagto(listPgto);
		
		if(request.getParameter("cli_id")!=null)
		{
			pedido.setCli_id(Integer.parseInt(request.getParameter("cli_id")));
		}
		
		if(request.getParameter("enderecoselecionado_id")!=null)
		{
			pedido.setEntrega_id(Integer.parseInt(request.getParameter("enderecoselecionado_id")));
		}
		
	
		return pedido;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");		
		
		if(resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);
	
		
		
		try {
			if(operacao.equals("SALVAR")){
				if(resultado.getErro()) {
					RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("pedidos-cli.jsp");
					rd.forward(request, response);
				}
			
			}
			else if(operacao.equals("CONSULTAR")){	
				request.setAttribute("pedidos", resultado.getResultado());
				if(request.getParameter("Direcionamento").equals("CLIENTE"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("pedidos-cli.jsp");
					rd.forward(request, response);
				}
				else
					
				{
					RequestDispatcher rd = request.getRequestDispatcher("area-cli.jsp");
					rd.forward(request, response);
				}
				
			}
			else if(operacao.equals("VISUALIZAR")){

					RequestDispatcher rd = request.getRequestDispatcher("consulta-cli.jsp");
					rd.forward(request, response);

			}
			else if(operacao.equals("INATIVAR")){
								
					RequestDispatcher rd = request.getRequestDispatcher("consulta-cli.jsp");
					rd.forward(request, response);

			}
			else if(operacao.equals("ALTERAR")){
				
				RequestDispatcher rd = request.getRequestDispatcher("area-cli.jsp");
				rd.forward(request, response);

		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
