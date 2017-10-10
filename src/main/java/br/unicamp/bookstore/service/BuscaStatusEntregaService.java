package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.StatusEntrega;

public class BuscaStatusEntregaService {
	
	  private Configuracao configuracao;

	  public StatusEntrega buscar(String cep) throws Exception {
	    String url = String.format("%s/%s/xml", configuracao.getStatusEntregaUrl(), cep);
	    return new RemoteService().getAndParseXml(url, StatusEntrega.class);
	  }

}
