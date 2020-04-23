package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimuladorInvestPoupUIPage {
	
	@FindBy(id = "valorAplicar")
	protected WebElement textValorAplicar;
	
	@FindBy(id = "valorInvestir")
	protected WebElement textValorInvestir;
	
	@FindBy(id = "tempo")
	protected WebElement textTempo;
	
	@FindBy(css = ".btn.btnAmarelo.btnSimular")
	protected WebElement btnSimular;
	
	@FindBy(className = "blocoResultadoSimulacao")
	protected WebElement divBlocoResultadoSimulacao;
	
	@FindBy(id = "valorAplicar-error")
	protected WebElement labelValorAplicarError;
	
	@FindBy(id = "valorInvestir-error")
	protected WebElement labelValorInvestirError;
}
