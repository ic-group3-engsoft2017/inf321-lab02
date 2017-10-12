package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Rastreio;

public class BuscaStatusEntregaService {
	
	  private Configuracao configuracao;

	  public Rastreio buscar(String statusentrega) throws Exception {
	    String url = String.format("%s/%s/xml", configuracao.getStatusEntregaUrl(), statusentrega);
	    return new RemoteService().getAndParseXml(url,Rastreio.class);
	  }

}
