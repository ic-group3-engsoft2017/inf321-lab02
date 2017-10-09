package br.unicamp.bookstore.dao;

public interface ConsultaEntregaDAO {
	
	public boolean salvarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio);
	
	public boolean removerDadosConsultaEntrega(String codigoRastreio);
	
	public boolean atualizarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio);;
	
	public String consultarDadosConsultaEntrega(String codigoRastreio);
	

}
