package br.com.les.negocio;

import java.util.List;

import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cupom;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.dominio.Pedido;

public class StValidarFormaDePagamento implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		 String mensagem = null;
		    Pedido pedido = (Pedido) entidade;
		   
		    Cupom cupomPromocional = pedido.getCupom_id();
		    List<Cupom> cuponsTroca = pedido.getCuponsTroca();
		    boolean usouCupomPromocional = false;
		    boolean usouCupomTroca = false;
		    boolean usouCartao = false;
		    
		    for(Cupom cupom : cuponsTroca) {
		      if(!cupom.getId().equals(0)) {
		        usouCupomTroca = true;
		        break;
		      }
		    }
		    
		    usouCupomPromocional = !cupomPromocional.getId().equals(0) ? true : false;
		    
		    CartaoCredito cartao1 = (CartaoCredito) pedido.getFormapagto().get(0).getCartao();
		    CartaoCredito cartao2 = (CartaoCredito) pedido.getFormapagto().get(1).getCartao();
		    
		    
		    usouCartao = cartao1.getId().equals(0) 
		        && cartao2.getId().equals(0) ? false : true;
		    
		    if(!usouCartao && !usouCupomPromocional && !usouCupomTroca) {
		      mensagem = "Selecione uma forma de pagamento";
		    }
		    
		    if(mensagem == null){
				return null;
			}
		    
		    return mensagem;
	}

}
