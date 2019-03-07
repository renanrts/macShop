package br.com.les.viewhelper;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;

public class VHEletronico implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		Eletronico eletronico = new Eletronico();
		
		eletronico.setAlimentacao(request.getParameter("txtAlimentacao"));
		eletronico.setCaminhoFoto(request.getParameter("txtFoto"));
		//eletronico.setCategoria(request.getParameter("txtCategoria"));
		eletronico.setCodigoBarras(request.getParameter("txtCodBarras"));
		eletronico.setConteudoEmbalagem(request.getParameter("txtConteudoEmbalagem"));
		eletronico.setCor(request.getParameter("txtCor"));
		eletronico.setDimensoes(request.getParameter("txtDimensoes"));		
		eletronico.setDataaFabricacao(request.getParameter("txtAnoFabricacao"));	
		eletronico.setConteudoEmbalagem(request.getParameter("txtConteudoEmbalagem"));
		//eletronico.setDescricao(request.getAttribute("txtDescricao"));
		eletronico.setMemoria(request.getParameter("txtMemoria"));
		eletronico.setModelo(request.getParameter("txtModelo"));
		eletronico.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
		eletronico.setProcessador(request.getParameter("txtProcessador"));
		eletronico.setRAM(request.getParameter("txtRAM"));
		eletronico.setResolucaoCamera(request.getParameter("txtResolucaoCamera"));
		eletronico.setSistemaOperacional(request.getParameter("txtSO"));
		eletronico.setTamanhoDisplay(request.getParameter("txtTamanhoDisplay"));
		eletronico.setNome(request.getParameter("txtQtde"));
		
		
		return eletronico;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
