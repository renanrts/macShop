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
@WebFilter({ "/Pages/LoginController", "/Pages/LoginControllerPedidos", "/Pages/LoginControllerMeusDados",
		"/Pages/LoginControllerPagamento" })

// Controller para o Login
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

		// inicialização das variáveis
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String direcionamento = req.getRequestURI();
		RequestDispatcher rd = null;
		boolean usuarioLogado = false;
		Integer userid = 0;

		//verificar se o usuário não está logado
		if (req.getSession().getAttribute("idUsuario") == null) {
			userid = null;
		}

		//se estiver logado, captura o id do usuário na sessão
		else {
			userid = Integer.parseInt(String.valueOf(req.getSession().getAttribute("idUsuario")));
		}
		
		//direcionamento se o cliente já estiver logado, dependendo de que lugar foi feita a requisição

		if (userid != null) {
			usuarioLogado = true;
			//direciona para o pagamento
			if (req.getRequestURI().equals("/macShop/Pages/LoginControllerPagamento")) {
				rd = request.getRequestDispatcher(
						"contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=PAGAMENTO");
				rd.forward(request, response);
				return;
				//direciona para meus pedidos
			} else if (direcionamento.equals("/macShop/Pages/LoginControllerPedidos")) {
				rd = request
						.getRequestDispatcher("orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&Direcionamento=CLIENTE");
				rd.forward(request, response);
				return;
				//direciona para meus dados
			} else if (direcionamento.equals("/macShop/Pages/LoginControllerMeusDados")) {
				rd = request
						.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=DADOS");
				rd.forward(request, response);
				return;
			}

		}

		//se o cliente não estiver logado, redireciona para o login, passando o parâmetro do local da requisição para o futuro redirecionamento
		else if (!direcionamento.equals("/macShop/Pages/LoginController")) {
			if (req.getRequestURI().equals("/macShop/Pages/LoginControllerPagamento")) {
				request.setAttribute("direcionamento", "pagamento");
			} else if (direcionamento.equals("/macShop/Pages/LoginControllerPedidos")) {
				request.setAttribute("direcionamento", "pedidos");
			} else if (direcionamento.equals("/macShop/Pages/LoginControllerDados")) {
				request.setAttribute("direcionamento", "dados");
			}

			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

			return;
		}

		//a partir deste ponto, sabe-se que o cliente não está logado
		
		//inicialização das variáveis
		VHCliente vh = new VHCliente();
		String idCliente = "-1";
		
		//instanciar um cliente
		Cliente cli = (Cliente) vh.getEntidade(req);
		DAOCliente dao = new DAOCliente();
		
		//valida se o cliente exite e se o login/senha estão corretos
		Boolean resultado = dao.validarLogin(cli);
		req.getSession().setAttribute("sessionId", req.getSession().getId());

		//se login Ok
		if (resultado == true) {
			//consulta o ID do cliente
			cli.setId(Integer.parseInt(dao.consultarID(cli)));
			idCliente = cli.getId().toString();
			//seta um cookie
			Cookie logado = new Cookie("clienteLogado", idCliente);
			res.addCookie(logado);
			req.getSession().setAttribute("idUsuario", cli.getId().toString());
			//verificar o direcionamento de acordo com a requisicao
			direcionamento = request.getParameter("direcionamento");
			if (direcionamento.equals("pedidos")) {
				rd = request
						.getRequestDispatcher("orders?btnOperacao=CONSULTAR&FormName=VHPEDIDO&Direcionamento=CLIENTE");

			}
			else if (direcionamento.equals("pagamento")) {
				rd = request.getRequestDispatcher(
						"contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=PAGAMENTO");

			}
			else if (direcionamento.equals("dados")) {
				rd = request
						.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=DADOS");
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
