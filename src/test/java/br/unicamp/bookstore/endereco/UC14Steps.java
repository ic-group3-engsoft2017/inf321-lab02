package br.unicamp.bookstore.endereco;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.model.Produto;
import br.unicamp.bookstore.model.TipoEntregaEnum;
import br.unicamp.bookstore.service.BuscaEnderecoService;
import br.unicamp.bookstore.service.FreteService;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

public class UC14Steps {

    public WireMockServer wireMockServer;

    @Mock
    private Configuracao configuration;

    @InjectMocks
    private FreteService freteService;

    private Endereco endereco;

    private List<Produto> produtoList;

    private String cep;

    private TipoEntregaEnum tipoEntregaEnum;

    @Before
    public void setUp() throws Exception {
        wireMockServer = new WireMockServer(9875);
        wireMockServer.start();
        MockitoAnnotations.initMocks(this);
        when(configuration.getConsultaPrecoPrazoUrl()).thenReturn("http://localhost:9875/ws");
    }

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
        
    }

    @E("^um tipo de entrega \"([^\"]*)\"$")
    public void umTipoDeEntrega(String tipoEntrega) throws Throwable {
        tipoEntregaEnum = TipoEntregaEnum.valueOf(tipoEntrega);
    }
}
