package br.com.les.viewhelper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.TipoCupom;
import br.com.les.util.Resultado;

public class VHCupom implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		Cupom cupom = new Cupom();

		if (request.getParameter("codCupom") != null) {
			cupom.setCodigo(request.getParameter("codCupom"));
		}

		if (request.getParameter("txtDataVencimento") != null) {
			String strDataVencimento = null != request.getParameter("txtDataVencimento")
					&& !"".equals(request.getParameter("txtDataVencimento")) ? request.getParameter("txtDataVencimento")
							: "1800-01-01";

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dataVencimento = LocalDate.parse(strDataVencimento, formatter);

			cupom.setDataDeValidade(dataVencimento);
		}

		if (request.getParameter("txtStatus") != null) {
			cupom.setStatus(request.getParameter("txtStatus"));
		}

		if (request.getParameter("txtId") != null) {
			cupom.setId(Integer.parseInt(request.getParameter("txtId")));
		}

		cupom.setValor(Double.parseDouble(request.getParameter("txtValor")));

		System.out.println(request.getParameter("txtTipo"));

		cupom.setTipoCupom(TipoCupom.PROMOCIONAL);

		return cupom;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		if (resultado.getErro())
			request.setAttribute("erro", mensagem);
		else
			request.setAttribute("sucesso", mensagem);

		if (operacao.equals("SALVAR")) {
			RequestDispatcher rd = request.getRequestDispatcher("gerarCupom.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
