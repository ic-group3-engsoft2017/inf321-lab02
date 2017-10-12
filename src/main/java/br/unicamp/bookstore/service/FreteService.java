package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.model.PrecoPrazo;
import br.unicamp.bookstore.model.Produto;

import java.util.List;

public class FreteService extends RemoteService {

    private Configuracao configuracao;

    public PrecoPrazo getPrecoPrazo(Endereco endereco, List<Produto> produtoList) throws Exception {
        String url = String.format("%s/%s/xml", configuracao.getConsultaPrecoPrazoUrl(), endereco, produtoList);
        return new RemoteService().getAndParseXml(url, PrecoPrazo.class);
    }
}
