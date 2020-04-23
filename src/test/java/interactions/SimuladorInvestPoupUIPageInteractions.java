package interactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pages.SimuladorInvestPoupUIPage;

public class SimuladorInvestPoupUIPageInteractions extends SimuladorInvestPoupUIPage {
	
	public void inputValorAplicar(String valorAplicar) {
		textValorAplicar.clear();
		textValorAplicar.sendKeys(valorAplicar);
		// Tira o foco do campo usando tab
		textValorAplicar.sendKeys(Keys.TAB);
	}
	
	public void inputValorInvestir(String valorInvestir) {
		textValorInvestir.clear();
		textValorInvestir.sendKeys(valorInvestir);
		// Tira o foco do campo usando tab
		textValorInvestir.sendKeys(Keys.TAB);
	}
	
	public void inputTempo(String tempo) {
		textTempo.clear();
		textTempo.sendKeys(tempo.toString());
	}
	
	public void clickSimular() {
		btnSimular.click();
	}
	
	public WebElement exibeBlocoResultado() {
		return divBlocoResultadoSimulacao;
	}
	
	public WebElement exibeMsgValorAplicarError() {
		return labelValorAplicarError;
	}	
	
	public WebElement exibeMsgValorInvestirError() {
		return labelValorInvestirError;
	}

}
