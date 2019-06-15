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
import br.com.les.viewhelper.VHUsuario;

/**
 * Servlet Filter implementation class LoginController
 */
@WebFilter("/LoginController")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	    
	    boolean usuarioLogado = false;
	    
	    VHUsuario vh = new VHUsuario();
	    
	    String idCliente="-1";
	      
	    Cliente cli = (Cliente) vh.getEntidade(req);
	    
	    DAOCliente dao = new DAOCliente();
	    
	    Boolean resultado = dao.validarLogin(cli);
	
	    req.getSession().setAttribute("sessionId", req.getSession().getId());

	      if (resultado == true) {
	        idCliente = cli.getId().toString();
	        Cookie logado = new Cookie("clienteLogado", idCliente);
	        res.addCookie(logado);
	       
	        RequestDispatcher rd = request.getRequestDispatcher("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=PAGAMENTO");
			
		    rd.forward(request, response);
	        
	        return;
	      } else {
	        req.getSession().setAttribute("usuario", "Usuário ou senha inválidos");     
	      }      
	    
	    if(req.getCookies()!=null){
	      for(Cookie cookie : req.getCookies()){
	        if(cookie.getName().equals("clienteLogado")) {
	          usuarioLogado = true;
	          if(req.getRequestURI().equals("/macShop/Pages/cart.jsp")) {
	            res.sendRedirect("contact?btnOperacao=CONSULTAR&FormName=VHCLIENTE&Direcionamento=PAGAMENTO");
	          } 
	          break;
	        }
	      }
	    }
	    if(!usuarioLogado){
	        //Redireciona para a página de login
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
