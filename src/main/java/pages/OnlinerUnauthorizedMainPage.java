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
	 * Button for user logging in
	 */
	private WebElement loginButton;

	/**
	 * Constructor
	 *
	 * @param browser Browser with loaded onliner's main page with unauthorized user
	 */
	public OnlinerUnauthorizedMainPage(Browser browser) {
		this.loginButton = browser.getDriver().findElement(By.xpath(loginFormButtonXpath));
	}

	/**
	 * Click "Open login form" button
	 */
	public void clickLoginFormButton() {
		loginButton.click();
	}
}
