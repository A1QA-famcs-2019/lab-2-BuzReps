package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser implements Browser {
	private static WebDriver driver = null;

	public WebDriver getDriver() {
		if (driver == null) {
			/*
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			*/
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

	@Override
	public void quit() {
		driver.quit();
		driver = null;
	}
}
