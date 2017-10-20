package entrega;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        glue = "br.unicamp.bookstore.endereco",
        features = "classpath:features/ConsultaEntrega.feature"
)
public class ConsultaEntregaTest {

}
