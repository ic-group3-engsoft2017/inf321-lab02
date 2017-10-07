package entrega;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class ConsultaEntregaStep {
  @Given("^Eu tenho um Código de rastreio válido$")
  public void eu_tenho_codigo_rastreio_valido() throws Throwable {
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
