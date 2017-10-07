package br.unicamp.bookstore.service;

import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.model.PrecoPrazo;
import br.unicamp.bookstore.model.Produto;

import java.util.List;

public class FreteService extends RemoteService {

    public PrecoPrazo getPrecoPrazo(Endereco endereco, List<Produto> produtoList) {


        return new PrecoPrazo();
    }
}
