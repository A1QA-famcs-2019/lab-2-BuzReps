package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements Browser {
	private static WebDriver driver = null;

	public WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}

	@Override
	public void quit() {
		driver.quit();
		driver = null;
	}
}
