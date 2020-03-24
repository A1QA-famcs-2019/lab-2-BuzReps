package elements;

import driver.Browser;
import driver.ResourceManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private static WebDriverWait driverWait = new WebDriverWait(Browser.getDriver(), Integer.parseInt(ResourceManager.getTestValue("wait_time")));

	public static void waitUntilStaleness(BaseElement element) {
		driverWait.until(ExpectedConditions.stalenessOf(element.getElement()));
	}

	public static void waitUntilClickable(BaseElement element) {
		driverWait.until(ExpectedConditions.elementToBeClickable(element.getElement()));
	}

	public static void waitUntilVisible(BaseElement element) {
		driverWait.until(ExpectedConditions.visibilityOf(element.getElement()));
	}
}
