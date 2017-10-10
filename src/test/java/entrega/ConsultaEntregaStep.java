package entrega;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import java.util.Map;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.*;
import br.unicamp.bookstore.dao.ConsultaEntregaDAO;
import br.unicamp.bookstore.model.StatusEntregaEnum;
import br.unicamp.bookstore.service.BuscaStatusEntregaService;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ConsultaEntregaStep {

	public WireMockServer wireMockServer;

	@Mock
	private Configuracao configuration;
	
	@InjectMocks
	private BuscaStatusEntregaService buscaStatusEntregaService;

	private ConsultaEntregaDAO ConsultaEntregaDAO;

	private String codigorastreio;
	
	private StatusEntregaEnum statusentrega;
	
	private br.unicamp.bookstore.ConsultaEntrega ConsultaEntrega;

	private Throwable throwable;

	@Before
	public void setUp() {
		ConsultaEntregaDAO = Mockito.mock(ConsultaEntregaDAO.class);
		ConsultaEntrega = new ConsultaEntrega(ConsultaEntregaDAO);

		// Configuração do Mokito
		wireMockServer = new WireMockServer(9876);
		wireMockServer.start();
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getStatusEntregaUrl()).thenReturn("http://localhost:9876/ws");

		codigorastreio = null;

	}

	@Given("^Eu tenho um Codigo de rastreio valido$")
	public void eu_tenho_codigo_rastreio_valido() throws Throwable {

		String codigoRastreio = "";

		wireMockServer.stubFor(get(urlMatching("/ws/" + codigoRastreio + ".*")).willReturn(aResponse().withStatus(200)
				.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-ConsultaEntrega.xml")));

	}

	@Given("^Eu tenho um Codigo de rastreio invalido$")
	public void eu_tenho_codigo_rastreio_invalido(Map<String, String> map) throws Throwable {

		codigorastreio = map.get("codigorastreio");
		wireMockServer.stubFor(get(urlMatching("/ws/" + codigorastreio + ".*")).willReturn(aResponse().withStatus(400)
				.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-ConsultaEntrega_BAD.xml")));

	}

	@When("^eu informo o Codigo de rastreio na busca de status de entrega$")
	public void eu_informo_codigo_rastreio() throws Throwable {
		throwable = catchThrowable(() -> this.statusentrega = buscaStatusEntregaService.buscar(codigorastreio));
	}

	@Then("^o resultado deve ser o$")
	public void o_resultado_deve_ser() throws Throwable {
	}

	@Then("^uma excecao deve ser lancada com a mensagem de erro Codigo de rastreio invalido$")
	public void uma_execao_deve_ser_lancada_codigo_invalido(String message) throws Throwable {
		assertThat(throwable).hasMessage(message);
	}

	@Then("^ uma excecao deve ser lancada com a mensagem de erro Servico indisponivel$")
	public void uma_execao_deve_ser_lancada_servico_indisponivel() throws Throwable {
		wireMockServer.stubFor(get(urlMatching("/ws/.*")).willReturn(aResponse().withStatus(200).withFixedDelay(6000)
				.withBodyFile("resultado-pesquisa-ConsultaEntrega_out.xml")));
	}
}
