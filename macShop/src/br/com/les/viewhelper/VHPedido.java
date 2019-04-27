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
		cart.setId(Integer.parseInt(request.getParameter("idcartaoPagamento1")));
		
		formapagto.setCartao(cart);
		formapagto.setParcela(Integer.parseInt(request.getParameter("parcelasCartao1")));
		formapagto.setValor(Double.parseDouble(request.getParameter("valorCartao1")));
		cupom.setId(Integer.parseInt(request.getParameter("idcupom")));
		formapagto.setCupom(cupom);
		listPgto.add(formapagto);
		pedido.setCarrinho((Carrinho) request.getSession().getAttribute("carrinho"));
		pedido.setFormapagto(listPgto);
		pedido.setCli_id(Integer.parseInt(request.getParameter("cli_id")));
		pedido.setEntrega_id(Integer.parseInt(request.getParameter("enderecoselecionado_id")));
		
	
		return pedido;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");		
		
		if(resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);
		
		if(operacao.equals("SALVAR")){
			if(resultado.getErro()){

					request.setAttribute("cliente", (Cliente) resultado.getListaResultado().get(0));
					
					
			}
			else
			{
				request.setAttribute("resultado", resultado.getCategoria());
			}
		} else if(operacao.equals("CONSULTAR")){
			if(!resultado.getErro()){
				
					request.setAttribute("cliente", (Cliente) resultado.getListaResultado().get(0));
					VHBaseCadastro viewHelper = new VHBaseCadastro();
					
					EntidadeDominio baseCadastro = viewHelper.getEntidade(request);
			
					request.setAttribute("baseCadastro", baseCadastro);
		
			}
		}
		else if(operacao.equals("VISUALIZAR")){

		
				request.setAttribute("cliente", (Cliente) resultado.getListaResultado().get(0));
		
			

		}
		else if(operacao.equals("ALTERAR")){

		
				request.setAttribute("cliente", (Cliente) resultado.getListaResultado().get(0));

			


}
		
		try {
			if(operacao.equals("SALVAR")){
				if(resultado.getErro()) {
					RequestDispatcher rd = request.getRequestDispatcher("pedidos-cli.jsp");
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("pedido.jsp");
					rd.forward(request, response);
				}
			
			}
			else if(operacao.equals("CONSULTAR")){	
				if(request.getParameter("Direcionamento").equals("PAGAMENTO"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("pedido.jsp");
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
