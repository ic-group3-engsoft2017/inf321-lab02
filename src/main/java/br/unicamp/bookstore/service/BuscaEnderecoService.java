package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import org.apache.http.client.HttpResponseException;

public class BuscaEnderecoService {

  private Configuracao configuracao;

  public Endereco buscar(String cep) throws Exception {
    try {
      String url = String.format("%s/%s/xml", configuracao.getBuscarEnderecoUrl(), cep);
      return new RemoteService().getAndParseXml(url, Endereco.class);
    } catch (HttpResponseException ex) {
      throw new Exception("O CEP informado é invalido");
    }
  }

}
