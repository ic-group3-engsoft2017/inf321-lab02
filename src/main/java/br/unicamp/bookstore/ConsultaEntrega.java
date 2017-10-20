package br.unicamp.bookstore;

import br.unicamp.bookstore.dao.ConsultaEntregaDAO;


public class ConsultaEntrega implements ConsultaEntregaDAO {

	private int result;
	private ConsultaEntregaDAO consultaEntregaDAO;
	
	public ConsultaEntrega(ConsultaEntregaDAO dao){
		consultaEntregaDAO = dao;
		
	}
	
	@Override
	public void salvarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void removerDadosConsultaEntrega(String codigoRastreio) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void atualizarDadosConsultaEntrega(Double valorFrete, Integer diasEntrega, String codigoRastreio) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public String consultarDadosConsultaEntrega(String codigoRastreio) {
		// TODO Auto-generated method stub
		return null;
	}



}
