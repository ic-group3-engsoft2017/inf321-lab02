package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Rastreio;
import org.apache.http.client.HttpResponseException;

public class BuscaStatusEntregaService {
	
	  private Configuracao configuracao;

	  public Rastreio buscar(String codigoRastreio) throws Exception {
	  	try {
			String url = String.format("%s/%s/xml", configuracao.getStatusEntregaUrl(), codigoRastreio);
			return new RemoteService().getAndParseXml(url, Rastreio.class);
		} catch (HttpResponseException ex) {
	  		throw new Exception("Codigo de rastreio invalido");
		}
	  }

}
