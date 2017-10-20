package entrega;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.ConsultaEntrega;
import br.unicamp.bookstore.dao.ConsultaEntregaDAO;
import br.unicamp.bookstore.service.BuscaStatusEntregaService;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

public class ConsultaEntregaStep {

	public WireMockServer wireMockServer;

	@Mock
	private Configuracao configuration;
	
	@InjectMocks
	private BuscaStatusEntregaService buscaStatusEntregaService;

	private ConsultaEntregaDAO ConsultaEntregaDAO;

	private String codigorastreio;
	
	private Rastreio Rastreio;
	
	private ConsultaEntrega ConsultaEntrega;

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
		this.Rastreio = new Rastreio("123","Entregue");
	}

	@Dado("^Eu tenho um Codigo de rastreio valido$")
	public void eu_tenho_codigo_rastreio_valido() throws Throwable {
		String codigoRastreio = "";
		wireMockServer.stubFor(get(urlMatching("/ws/" + codigoRastreio + ".*")).willReturn(aResponse().withStatus(200)
				.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-ConsultaEntrega.xml")));

	}

	@Dado("^Eu tenho um Codigo de rastreio invalido:$")
	public void eu_tenho_codigo_rastreio_invalido(Map<String, String> map) throws Throwable {
		codigorastreio = map.get("codigorastreio");
		wireMockServer.stubFor(get(urlMatching("/ws/" + codigorastreio + ".*")).willReturn(aResponse().withStatus(400)
				.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-ConsultaEntrega_BAD.xml")));

	}

	@Quando("^eu informo o Codigo de rastreio na busca de status de entrega$")
	public void eu_informo_codigo_rastreio() throws Throwable {
		throwable = catchThrowable(() -> this.statusentrega = buscaStatusEntregaService.buscar(codigorastreio));
	}

	@Então("^uma excecao deve ser lancada com a mensagem de erro Codigo de rastreio invalido$")
	public void uma_execao_deve_ser_lancada_codigo_invalido(String message) throws Throwable {
		assertThat(throwable).hasMessage(message);
	}

    @Então("^o resultado deve ser o:$")
    public void o_resultado_deve_ser(List<Map<String,String>> resultado) throws Throwable {
        assertThat(this.Rastreio.getCodigoRastreio()).isEqualTo(resultado.get(0).get("codigorastreio"));
        assertThat(Rastreio.getStatusEntrega()).isEqualTo(resultado.get(0).get("status"));
        assertThat(throwable).isNull();

    }

    @E("^armazena essa informação no banco de dados$")
    public void armazenaEssaInforma��oNoBancoDeDados() throws Throwable {

    }

	@Então("^ uma excecao deve ser lancada com a mensagem de erro Servico indisponivel$")
	public void uma_execao_deve_ser_lancada_servico_indisponivel() throws Throwable {
		wireMockServer.stubFor(get(urlMatching("/ws/.*")).willReturn(aResponse().withStatus(200).withFixedDelay(6000)
				.withBodyFile("resultado-pesquisa-ConsultaEntrega_out.xml")));

	}

	@Então("^uma excecao deve ser lancada com a mensagem de erro:$")
	public void umaExcecaoDeveSerLancadaComAMensagemDeErro() throws Throwable {
		throwable = catchThrowable(() -> this.buscaStatusEntregaService.buscar(codigorastreio));
	}

	@Dado("^Eu tenho um Codigo de rastreio valido:$")
	public void euTenhoUmCodigoDeRastreioValido(Map<String, String> map) throws Throwable {
		codigorastreio = map.get("codigorastreio");
		wireMockServer.stubFor(get(urlMatching("/ws/" + codigorastreio + ".*")).willReturn(aResponse().withStatus(200)
				.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-ConsultaEntrega.xml")));
	}

    @After
    public void tearDown() throws Exception {
        wireMockServer.stop();
    }

}
