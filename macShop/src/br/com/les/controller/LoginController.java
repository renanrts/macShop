package br.com.les.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dao.DAOCliente;
import br.com.les.dominio.Cliente;
import br.com.les.viewhelper.VHCliente;
import br.com.les.viewhelper.VHUsuario;

/**
 * Servlet Filter implementation class LoginController
 */
@WebFilter({ "/Pages/LoginController", "/Pages/LoginControllerPedidos", "/Pages/LoginControllerMeusDados", "/Pages/LoginControllerPagamento" })
public class LoginController implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String direcionamento = req.getRequestURI();
		RequestDispatcher rd = null;

		System.out.println(direcionamento);

		boolean usuarioLogado = false;

		Integer userid = 0;

		if (req.getSession().getAttribute("idUsuario") == null) {
			userid = null;
		}

		else {
			userid = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUsuario")));
		}

		if (userid != null) {
			usuarioLogado = true;
			if (req.getRequestURI().equals("/macShop/Pages/LoginControllerPagamento")) {
				rd = request.getRequestDispatcher(
						"contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=PAGAMENTO");
				rd.forward(request, response);
				return;
			} else if (direcionamento.equals("/macShop/Pages/LoginControllerPedidos")) 
			{
				rd = request
						.getRequestDispatcher("orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&Direcionamento=CLIENTE");
				rd.forward(request, response);
				return;
			} else if (direcionamento.equals("/macShop/Pages/LoginControllerMeusDados")) 
			{
				rd = request
						.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=DADOS");
				rd.forward(request, response);
				return;
			}

		}
		
		else if (!direcionamento.equals("/macShop/Pages/LoginController") )
		{
			if (req.getRequestURI().equals("/macShop/Pages/LoginControllerPagamento"))
			{
				request.setAttribute("direcionamento", "pagamento");
			}
			else if (direcionamento.equals("/macShop/Pages/LoginControllerPedidos")) 
			{
				request.setAttribute("direcionamento", "pedidos");
			}
			else if (direcionamento.equals("/macShop/Pages/LoginControllerDados")) 
			{
				request.setAttribute("direcionamento", "dados");
			}

			rd = request
					.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		
			return;
		}

		VHCliente vh = new VHCliente();

		String idCliente = "-1";

		Cliente cli = (Cliente) vh.getEntidade(req);

		DAOCliente dao = new DAOCliente();

		Boolean resultado = dao.validarLogin(cli);

		req.getSession().setAttribute("sessionId", req.getSession().getId());

		if (resultado == true) {
			cli.setId(Integer.parseInt(dao.consultarID(cli)));
			idCliente = cli.getId().toString();
			Cookie logado = new Cookie("clienteLogado", idCliente);
			res.addCookie(logado);
			req.getSession().setAttribute("idUsuario", cli.getId().toString());
			direcionamento = request.getParameter("direcionamento");
			if (direcionamento.equals("pedidos")) {
				rd = request
						.getRequestDispatcher("orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&Direcionamento=CLIENTE");

			}
			
			else if (direcionamento.equals("pagamento")) {
				rd = request
						.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=PAGAMENTO");

			}

			else if (direcionamento.equals("dados")){
				rd = request.getRequestDispatcher(
						"contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=DADOS");

			}

			rd.forward(request, response);

			return;
		}

		if (!usuarioLogado) {
			// Redireciona para a página de login
			res.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
