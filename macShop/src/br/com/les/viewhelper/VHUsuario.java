package br.com.les.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Usuario;
import br.com.les.util.Resultado;

public class VHUsuario implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		

		Usuario user = new Usuario();
		List<String> senhas = new ArrayList<String>();
		user.setEmail(request.getParameter("txtEmail"));
		senhas.add(request.getParameter("txtSenha"));	
		user.setSenhas(senhas);
		
		return user;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
