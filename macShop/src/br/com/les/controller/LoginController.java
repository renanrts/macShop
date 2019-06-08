//package br.com.les.controller;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.les.dominio.Cliente;
//import br.com.les.viewhelper.VHUsuario;
//
///**
// * Servlet Filter implementation class LoginController
// */
//@WebFilter("/LoginController")
//public class LoginController implements Filter {
//
//    /**
//     * Default constructor. 
//     */
//    public LoginController() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//	    HttpServletResponse res = (HttpServletResponse) response;
//	    boolean usuarioLogado = false;
//	    VHUsuario vh = new VHUsuario();
//	    String email = request.getParameter("email");
//	    String password = request.getParameter("senha");
//	    String idCliente="-1";
//	 
//	      
//	      String operacao = request.getParameter("operacao");
//	      
// 
//	      Cliente cli = (Cliente) vh.getEntidade(req);
//	
//	      req.getSession().setAttribute("sessionId", req.getSession().getId());
//
//	      if (cli != null) {
//	        idCliente = cli.getId().toString();
//	        Cookie logado = new Cookie("clienteLogado", idCliente);
//	        res.addCookie(logado);
//	        vh.setView(resultado, req, res);
//	        return;
//	      } else {
//	        req.getSession().setAttribute("usuario", "Usuário ou senha inválidos");     
//	      }      
//	    }
//	   
//
//	    if(req.getCookies()!=null){
//	      for(Cookie cookie : req.getCookies()){
//	        if(cookie.getName().equals("clienteLogado")) {
//	          usuarioLogado = true;
//	          if(req.getRequestURI().equals("/livraria/Pages/lumino/comprar")) {
//	            res.sendRedirect("checkout.jsp");
//	          } else if (req.getRequestURI().equals("/livraria/Pages/lumino/buscarDados")) {
//	            res.sendRedirect("autenticaCliente?operacao=CONSULTAR&formName=checkout&id="+cookie.getValue());
//	          }          
//
//	          break;
//	        }
//	      }
//	    }
//	    if(!usuarioLogado){
//	        //Redireciona para a página de login
//	        res.sendRedirect("loginCliente.jsp");
//	      }
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
