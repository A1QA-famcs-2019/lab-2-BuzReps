package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Class for interacting with browser.
 */
public abstract class Browser {

	private static WebDriver browserDriver;

	/**
	 * Get active browser driver
	 *
	 * @return Active browser driver object
	 */
	public static WebDriver getDriver() {
		if (null == browserDriver) {
			final String name = ResourceManager.getTestValue("browser").toUpperCase();
			switch (name) {
				case "FIREFOX": {
					browserDriver = createFirefox();
					break;
				}
				case "CHROME": {
					browserDriver = createChrome();
					break;
				}
				case "IE": {
					browserDriver = createIE();
					break;
				}
				default:
					throw new InvalidArgumentException("Browser not supported.");
			}
		}
		return browserDriver;
	}

	/**
	 * Instantiate Firefox browser driver
	 *
	 * @return Chrome Firefox browser driver
	 */
	private static WebDriver createFirefox() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	/**
	 * Instantiate Chrome browser driver
	 *
	 * @return Chrome browser driver
	 */
	private static WebDriver createChrome() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}

	/**
	 * Instantiate IE browser driver
	 *
	 * @return IE browser driver
	 */
	private static WebDriver createIE() {
		WebDriverManager.iedriver().setup();
		return new InternetExplorerDriver();
	}

}
