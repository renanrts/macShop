package br.com.les.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Carrinho;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.ItemCarrinho;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.Produto;
import br.com.les.util.Resultado;

public class VHItemProduto implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		ItemCarrinho item = new ItemCarrinho();
		Produto prod = new Produto();
		if (request.getParameter("itemStatus") != null)
		{
			prod.setAtivo(request.getParameter("itemStatus"));
		}
		
		if (request.getParameter("itemID") != null)
		{
			item.setId(Integer.parseInt(request.getParameter("itemID")));
		}
		
		item.setProduto(prod);
		
		return item;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		if (resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);

		try {
			if (operacao.equals("TROCAR")) {
			
				request.setAttribute("pedidos", resultado.getListaResultado());
				if (request.getParameter("Direcionamento").equals("CLIENTE")) {
					RequestDispatcher rd = request.getRequestDispatcher("orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&cli_id=10&Direcionamento=CLIENTE");
					rd.forward(request, response);
				} else

				{
					RequestDispatcher rd = request.getRequestDispatcher("orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&Direcionamento=ADMIN");
					rd.forward(request, response);
				}
			}



	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	
}
