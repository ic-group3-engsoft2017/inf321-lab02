package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.StatusEntregaEnum;

public class BuscaStatusEntregaService {
	
	  private Configuracao configuracao;

	  public StatusEntregaEnum buscar(String codigoRastreio) throws Exception {
	    String url = String.format("%s/%s/xml", configuracao.getStatusEntregaUrl(), codigoRastreio);
	    return new RemoteService().getAndParseXml(url, StatusEntregaEnum.class);
	  }

}
