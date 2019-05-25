package br.com.les.negocio;

import java.time.LocalDate;
import java.util.Random;

import br.com.les.dao.DAOCupom;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;
import br.com.les.dominio.TipoCupom;

public class StValidarValorExcendenteAoPagamento implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		  Pedido pedido = (Pedido) entidade;
	      double valorTotalAbater = 0;
	      DAOCupom daoCupom = new DAOCupom();
	      String mensagem = null;
	      LocalDate dataValidade = LocalDate.MIN;
	      
	      double totalAPagar = pedido.getValorTotal() + pedido.getFrete();
	      double valorCartao1 = pedido.getFormapagto().get(0).getValor();
	      double valorCartao2 = pedido.getFormapagto().get(1).getValor();
	      
	      double valorTotalEmCartoes = valorCartao1 + valorCartao2;
	      
	      if(valorTotalEmCartoes > totalAPagar) {
	        return "O valor do pagamento em cartão é superior ao total da compra";
	      }
	      
	      
	      for(int i = 0; i< pedido.getCuponsTroca().size() ; i++ ) {
	        valorTotalAbater += pedido.getCuponsTroca().get(i).getValor();
	        dataValidade = dataValidade.isBefore(pedido.getCuponsTroca().get(i).getDataDeValidade())  ?
	            pedido.getCuponsTroca().get(i).getDataDeValidade() :
	              dataValidade;
	      }
	     
	      
	      if(!pedido.getCupom_id().getId().equals(0)) {
	        valorTotalAbater += pedido.getCupom_id().getValor();
	        dataValidade = dataValidade.isBefore(pedido.getCupom_id().getDataDeValidade())  ?
	            pedido.getCupom_id().getDataDeValidade() :
	              dataValidade;
	      }
	      
	      valorTotalAbater += valorCartao1 + valorCartao2;     
	      
	      
	      double diferencaCupons = totalAPagar - valorTotalAbater;

	      if (diferencaCupons < 0) {
	        //gerar outro com diferença
	        Cupom novoCupom = new Cupom();
	        
	    	Random gerador = new Random();
	    	StringBuilder codigo = new StringBuilder();
	    	
	        for (int i = 0; i < 5; i++) {
				codigo.append(String.valueOf(gerador.nextInt(10)));
			}
	        
	        novoCupom.setCodigo(codigo.toString());
	        novoCupom.setDataDeValidade(dataValidade);
	        novoCupom.setCliId(pedido.getCli_id());
	        novoCupom.setTipoCupom(TipoCupom.TROCA);
	        novoCupom.setValor(diferencaCupons * -1);
	        daoCupom.salvar(novoCupom);       
	      }
	      
	      if(mensagem.length() == 0){
				return null;
			}
	      
	    return mensagem;
	}

}
