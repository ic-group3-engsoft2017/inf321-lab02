package br.unicamp.bookstore;

import br.unicamp.bookstore.dao.ConsultaEntregaDAO;


public class ConsultaEntrega implements ConsultaEntregaDAO {

	private int result;
	private ConsultaEntregaDAO consultaEntregaDAO;
	
	public ConsultaEntrega(ConsultaEntregaDAO dao){
		consultaEntregaDAO = dao;
		
	}
	
	@Override
	public boolean salvarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerDadosConsultaEntrega(String codigoRastreio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String consultarDadosConsultaEntrega(String codigoRastreio) {
		// TODO Auto-generated method stub
		return null;
	}



}
