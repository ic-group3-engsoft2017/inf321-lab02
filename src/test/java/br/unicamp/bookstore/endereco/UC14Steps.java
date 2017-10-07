package br.unicamp.bookstore.endereco;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.service.BuscaEnderecoService;
import br.unicamp.bookstore.service.FreteService;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UC14Steps {

    public WireMockServer wireMockServer;

    @Mock
    private Configuracao configuration;

    @InjectMocks
    private FreteService freteService;

    private Endereco endereco;

    private String cep;



    @Dado("^Lista de Produtos:$")
    public void listaDeProdutos() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @E("^um tipo de entrega:$")
    public void umTipoDeEntrega() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Quando("^eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega$")
    public void euPesquisoOPreçoDoFreteParaOEndereçoEAListaDeProdutosEOTipoDeEntrega() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^o resultado deve ser$")
    public void oResultadoDeveSer() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @E("^armazena essa informação no banco de dados$")
    public void armazenaEssaInformaçãoNoBancoDeDados() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^a mensagem de erro dos correios é do código \"([^\"]*)\"$")
    public void aMensagemDeErroDosCorreiosÉDoCódigo(String errorCode) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
