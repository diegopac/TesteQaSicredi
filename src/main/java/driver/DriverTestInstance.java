package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverTestInstance {
	
	public WebDriver driver;
	
	public DriverTestInstance() {
		driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		
		if (driver == null) {
			driver = new ChromeDriver();
			return driver;
		} else {
			return driver;
		}
	}

}
