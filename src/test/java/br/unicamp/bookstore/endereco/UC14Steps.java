package br.unicamp.bookstore.endereco;
import static org.assertj.core.api.Assertions.assertThat;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.model.PrecoPrazo;
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
import org.junit.After;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mortbay.jetty.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.mockito.Mockito.when;

public class UC14Steps {

    public WireMockServer wireMockServer;

    @Mock
    private Configuracao configuration;

    @InjectMocks
    private FreteService freteService;

    @Mock
    private BuscaEnderecoService buscaEnderecoService;

    private Endereco endereco;

    private List<Produto> produtoList = new ArrayList<>();

    private PrecoPrazo precoPrazo;

    private TipoEntregaEnum tipoEntregaEnum;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        wireMockServer = new WireMockServer(9875);
        wireMockServer.start();
        when(configuration.getConsultaPrecoPrazoUrl()).thenReturn("http://localhost:9875/ws/calcprecoprazo");
    }

    /** Fluxo Basico */

    @Dado("^Lista de Produtos:$")
    public void listaDeProdutos(List<List<String>> resultado) {
        // Peso      | Altura    | Largura     | Comprimento |
    	for (List<String> prodValues : resultado) {
    	    if(prodValues.contains("Peso")) {
    	        continue;
            }
            Produto produto = new Produto(
                    Double.valueOf(prodValues.get(0)),
                    Double.valueOf(prodValues.get(1)),
    				Double.valueOf(prodValues.get(2)),
                    Double.valueOf(prodValues.get(3))
            );
        	produtoList.add(produto);
    	}
        assertThat(produtoList.size()).isEqualTo(3);
    }


    @E("^um tipo de entrega \"([^\"]*)\"$")
    public void umTipoDeEntrega(String tipoEntrega) throws Throwable {
        tipoEntregaEnum = TipoEntregaEnum.valueOf(tipoEntrega);
    }

    @E("^um endereço com CEP \"([^\"]*)\"$")
    public void umEndereçoComCEP(String cep) throws Throwable {
        when(buscaEnderecoService.buscar(cep)).thenReturn(endereco);
        this.endereco = buscaEnderecoService.buscar(cep);
    }

    @Então("^o resultado deve ser:$")
    public void oResultadoDeveSer(Map<String, String> result) throws Throwable {
        wireMockServer.stubFor(get(urlMatching("/ws/calcprecoprazo/.*"))
                .willReturn(aResponse().withStatus(554)
                        .withBodyFile("resultado-pesquisa-calcprezoprazo-erro001.xml")));
        PrecoPrazo precoPrazo = freteService.getPrecoPrazo(endereco, produtoList);
        assertThat(precoPrazo.getErro()).isEqualTo(result.get("MensagemDeErro"));
    }


    @Quando("^eu pesquiso o preço do frete para o endereço e a lista de produtos e o tipo de entrega$")
    public void euPesquisoOPreçoDoFreteParaOEndereçoEAListaDeProdutosEOTipoDeEntrega() throws Throwable {
        wireMockServer.stubFor(get(urlMatching("/ws/calcprecoprazo/.*"))
                .willReturn(aResponse().withStatus(554)
                        .withBodyFile("resultado-pesquisa-calcprezoprazo-success.xml")));
        precoPrazo = freteService.getPrecoPrazo(endereco, produtoList);
    }

    @E("^armazena essa informação no banco de dados$")
    public void armazenaEssaInformaçãoNoBancoDeDados() throws Throwable {

    }

    @Então("^a mensagem de erro dos correios é do código \"([^\"]*)\"$")
    public void aMensagemDeErroDosCorreiosÉDoCódigo(String errorCode) throws Throwable {
        wireMockServer.stubFor(get(urlMatching("/ws/cep/.*"))
        		.willReturn(aResponse().withStatus(Integer.valueOf(errorCode))));

    }

    @Então("^o resultado deve ser o preco e prazo$")
    public void oResultadoDeveSerOPrecoEPrazo(Map<String, String> result) throws Throwable {
        assertThat(precoPrazo.getPrazoEntrega()).isEqualTo(result.get("Prazo"));
        assertThat(precoPrazo.getValor()).isEqualTo(result.get("Preco"));
    }

    @After
    public void tearDown() throws Exception {
        wireMockServer.stop();
    }
}
