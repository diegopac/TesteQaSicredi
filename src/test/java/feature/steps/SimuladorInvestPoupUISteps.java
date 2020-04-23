package feature.steps;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverTestInstance;
import interactions.SimuladorInvestPoupUIPageInteractions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimuladorInvestPoupUISteps extends DriverTestInstance {
	
	// Parametros
	private static final String URL_SIMULADOR = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";  
	private static final Long TEMPO_TIMEOUT_SEGUNDOS = 5L;
	
	SimuladorInvestPoupUIPageInteractions simulador = PageFactory.initElements(getDriver(),
			SimuladorInvestPoupUIPageInteractions.class);	
	
	@Before
	public void printNomeCenario(Scenario scenario) {
		System.out.println("Cenario de teste: " + scenario.getName());
	}
	
	@Given("associado acessa tela Simulador de investimento Poupança Sicredi")
	public void acessarTelaSimulInvestPoupComoAssociado() throws Throwable {
		driver.get(URL_SIMULADOR);
	}

	@When("informa campo Qual o valor que você quer aplicar? {string}")
	public void informarValorAplicar(String valorAplicar) throws Throwable {
		simulador.inputValorAplicar(valorAplicar);
	}

	@When("informa campo Quanto você quer poupar todo mês? {string}")
	public void informarValorInvestir(String valorInvestir) throws Throwable {
		simulador.inputValorInvestir(valorInvestir);
	}

	@When("informa campo Por quanto tempo você quer poupar? {string}")
	public void informarTempo(String tempo) throws Throwable {
		simulador.inputTempo(tempo);
	}

	@When("clica no botao Simular")
	public void clicarBotaoSimular() throws Throwable {
		simulador.clickSimular();
	}

	@Then("visualiza na tela os resultados da simulacao")
	public void exibirNaTelaResultadosSimulacao() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TEMPO_TIMEOUT_SEGUNDOS);
		wait.until(ExpectedConditions.visibilityOf(simulador.exibeBlocoResultado()));
	}
	
	@Then("visualiza na tela a mensagem de erro de valor minimo no campo Qual o valor que você quer aplicar?")
	public void exibirNaTelaMensagemValorAplicarError() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TEMPO_TIMEOUT_SEGUNDOS);
		wait.until(ExpectedConditions.visibilityOf(simulador.exibeMsgValorAplicarError()));
	}
	
	@Then("visualiza na tela a mensagem de erro de valor minimo no campo Quanto você quer poupar todo mês?")
	public void exibirNaTelaMensagemValorInvestirError() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, TEMPO_TIMEOUT_SEGUNDOS);
		wait.until(ExpectedConditions.visibilityOf(simulador.exibeMsgValorInvestirError()));
	}
	
	@After
	public void aposExecucao() {
		System.out.println("----");
		driver.quit();
	}

}
