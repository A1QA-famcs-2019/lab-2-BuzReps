package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class for interacting with onliner's main page as unauthorized user
 */
public class OnlinerUnauthorizedMainPage {

	/**
	 * Page location
	 */
	public static final String url = "http://onliner.by/";

	/**
	 * XPath for login form button
	 */
	public static final String loginFormButtonXpath = "//div[contains(@class,'auth-bar__item--text')]";

	/**
	 * Constructor
	 */
	public OnlinerUnauthorizedMainPage() {
	}

	/**
	 * Get login button element
	 *
	 * @return Login button element or null in case of failure.
	 */
	public WebElement getLoginFormButton() {
		try {
			return Browser.getDriver().findElement(By.xpath(loginFormButtonXpath));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Click "Open login form" button
	 */
	public void clickLoginFormButton() {
		WebElement loginButton = Browser.getDriver().findElement(By.xpath(loginFormButtonXpath));
		loginButton.click();
	}
}
