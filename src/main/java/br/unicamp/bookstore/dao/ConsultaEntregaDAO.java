package br.unicamp.bookstore.dao;

public interface ConsultaEntregaDAO {
	
	public void salvarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio);
	
	public void removerDadosConsultaEntrega(String codigoRastreio);
	
	public void atualizarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio);;
	
	public String consultarDadosConsultaEntrega(String codigoRastreio);
	

}
