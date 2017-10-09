package entrega;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.*;
import br.unicamp.bookstore.dao.ConsultaEntregaDAO;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class ConsultaEntregaStep {
	
	public WireMockServer wireMockServer;

	@Mock
	private Configuracao configuration;
	
   private ConsultaEntregaDAO ConsultaEntregaDAO;
	
	private br.unicamp.bookstore.ConsultaEntrega ConsultaEntrega;
	
	private Throwable throwable;
	
	@Before
	public void setUp() {
		ConsultaEntregaDAO = Mockito.mock(ConsultaEntregaDAO.class);
		ConsultaEntrega = new ConsultaEntrega(ConsultaEntregaDAO);

		
		//Configura��o do Mokito
		wireMockServer = new WireMockServer(9876);
		wireMockServer.start();
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getStatusEntregaUrl()).thenReturn("http://localhost:9876/ws");
		
	}

	
  @Given("^Eu tenho um Código de rastreio válido$")
  public void eu_tenho_codigo_rastreio_valido() throws Throwable {
	  
	  String codigoRastreio = "";
	  
	  wireMockServer.stubFor(get(urlMatching("/ws/"+ codigoRastreio + ".*")).willReturn(aResponse().withStatus(200)
				.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-StatusE	ntrega.xml")));
	  
  }

  @Given("^Eu tenho um Código de rastreio inválido$")
  public void eu_tenho_codigo_rastreio_invalido() throws Throwable {
  }
  
  @When("^eu informo o Codigo de rastreio na busca de status de entrega$")
  public void eu_informo_codigo_rastreio() throws Throwable {
  }

  @Then("^o resultado deve ser o$")
  public void o_resultado_deve_ser() throws Throwable {
  }

  @Then("^uma exceção deve ser lançada com a mensagem de erro Codigo de rastreio invalido$")
  public void uma_execao_deve_ser_lancada_codigo_invalido() throws Throwable {
  }

  @Then("^ uma exceção deve ser lançada com a mensagem de erro Serviço indisponivel$")
  public void uma_execao_deve_ser_lancada_servico_indisponivel() throws Throwable {
  }


  
}
