package br.com.les.negocio;


import br.com.les.dominio.Acessorio;
import br.com.les.dominio.Eletronico;
import br.com.les.dominio.EntidadeDominio;

public class StValidarDadosObrigatorios implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		
		
		
		
		StringBuilder mensagem = new StringBuilder();
		
		if (entidade.getTipo().equals("VHELETRONICO"))
		{
			Eletronico eletronico = (Eletronico) entidade;
			if(eletronico.getNome() == null || eletronico.getNome().equals("")){
				mensagem.append("Nome é um campo obrigatório\n");
			}
			
			if(eletronico.getAlimentacao() == null || eletronico.getAlimentacao().equals("")){
				mensagem.append("Alimentação é um campo obrigatório\n");
			}
			
			if(eletronico.getCaminhoFoto() == null || eletronico.getCaminhoFoto().equals("")){
				mensagem.append("Foto é um campo obrigatório\n");
			}
			

			if(eletronico.getCategoria().getDescricao() == null || eletronico.getCategoria().getDescricao().equals("")){
				mensagem.append("Categoria é um campo obrigatório\n");
			}
			
			if(eletronico.getCodigoBarras() == null || eletronico.getCodigoBarras().equals("")){
				mensagem.append("Código de Barras é um campo obrigatório\n");
			}
			
			if(eletronico.getConteudoEmbalagem() == null || eletronico.getConteudoEmbalagem().equals("")){
				mensagem.append("Conteúdo da embalagem é um campo obrigatório\n");
			}
			
			if(eletronico.getCor() == null || eletronico.getCor().equals("")){
				mensagem.append("Cor é um campo obrigatório\n");
			}
			
			if(eletronico.getDataaFabricacao() == null || eletronico.getDataaFabricacao().equals("")){
				mensagem.append("Ano de Fabricação é um campo obrigatório\n");
			}
			
			if(eletronico.getDescricao() == null || eletronico.getDescricao().equals("")){
				mensagem.append("Descrição é um campo obrigatório\n");
			}
			
			if(eletronico.getDimensoes() == null || eletronico.getDimensoes().equals("")){
				mensagem.append("Dimensões é um campo obrigatório\n");
			}
			
			if(eletronico.getMemoria() == null || eletronico.getMemoria().equals("")){
				mensagem.append("Memória é um campo obrigatório\n");
			}
			
			if(eletronico.getModelo() == null || eletronico.getModelo().equals("")){
				mensagem.append("Modelo é um campo obrigatório\n");
			}
			
			if(String.valueOf(eletronico.getPreco()) == null || String.valueOf(eletronico.getPreco()).equals("")){
				mensagem.append("Preço é um campo obrigatório\n");
			}
			
			if(eletronico.getProcessador() == null || eletronico.getProcessador().equals("")){
				mensagem.append("Processador é um campo obrigatório\n");
			}
			
			
			if(eletronico.getRAM() == null || eletronico.getRAM().equals("")){
				mensagem.append("RAM é um campo obrigatório\n");
			}
			
			if(eletronico.getResolucaoCamera() == null || eletronico.getResolucaoCamera().equals("")){
				mensagem.append("Resolução da Camera é um campo obrigatório\n");
			}
				
			if(eletronico.getSistemaOperacional() == null || eletronico.getSistemaOperacional().equals("")){
				mensagem.append("Sistema Operacional é um campo obrigatório\n");
			}
			
			if(eletronico.getTamanhoDisplay() == null || eletronico.getTamanhoDisplay().equals("")){
				mensagem.append("Tamanho do Display é um campo obrigatório\n");
			}
			
			
			if(mensagem.length() == 0){
				return null;
			}
		}
		
		else
		{
			Acessorio acessorio = (Acessorio) entidade;
			if(acessorio.getNome() == null || acessorio.getNome().equals("")){
				mensagem.append("Nome é um campo obrigatório\n");
			}
			
				
			if(acessorio.getCaminhoFoto() == null || acessorio.getCaminhoFoto().equals("")){
				mensagem.append("Foto é um campo obrigatório\n");
			}
			

			if(acessorio.getCategoria().getDescricao() == null || acessorio.getCategoria().getDescricao().equals("")){
				mensagem.append("Categoria é um campo obrigatório\n");
			}
			
			if(acessorio.getCodigoBarras() == null || acessorio.getCodigoBarras().equals("")){
				mensagem.append("Código de Barras é um campo obrigatório\n");
			}
			
			if(acessorio.getCor() == null || acessorio.getCor().equals("")){
				mensagem.append("Cor é um campo obrigatório\n");
			}
			
			if(acessorio.getDataaFabricacao() == null || acessorio.getDataaFabricacao().equals("")){
				mensagem.append("Ano de Fabricação é um campo obrigatório\n");
			}
			
			if(acessorio.getDescricao() == null || acessorio.getDescricao().equals("")){
				mensagem.append("Descrição é um campo obrigatório\n");
			}
			
			if(acessorio.getDimensoes() == null || acessorio.getDimensoes().equals("")){
				mensagem.append("Dimensões é um campo obrigatório\n");
			}
			
			if(String.valueOf(acessorio.getPreco()) == null || String.valueOf(acessorio.getPreco()).equals("")){
				mensagem.append("Preço é um campo obrigatório\n");
			}
			
			if(acessorio.getModeloCompativel() == null || acessorio.getModeloCompativel().equals("")){
				mensagem.append("Modelo Compatível é um campo obrigatório\n");
			}
			
			if(!acessorio.isSeloMfi() ){
				mensagem.append("Todo acessório deve possuir selo MFi.\n");
			}
			
			
			if(mensagem.length() == 0){
				return null;
			}
		}
		
		
		
		
		return mensagem.toString();
				
	}
	

}
