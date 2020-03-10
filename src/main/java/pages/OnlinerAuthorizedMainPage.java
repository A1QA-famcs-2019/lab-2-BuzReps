package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Class for interacting with onliner's main page as authorized user
 */
public class OnlinerAuthorizedMainPage {

	/**
	 * XPath for user profile unfolding menu
	 */
	public static final String userMenuUnfoldButtonXpath = "//a[contains(@class, 'js-toggle-bar') and contains(@class, 'b-top-profile__preview')]";

	/**
	 * XPath for logout button
	 */
	public static final String logoutButtonXpath = "//div[@class='b-top-profile__logout']//a[contains(@class, 'b-top-profile__link')]";

	private Browser browser;

	/**
	 * Button for logging out
	 */
	private WebElement logoutButton;

	/**
	 * Button for unfolding user menu
	 */
	private WebElement userMenuButton;

	/**
	 * Constructor
	 *
	 * @param browser Browser with loaded onliner's main page with authorized user
	 */
	public OnlinerAuthorizedMainPage(Browser browser) {
		this.browser = browser;
		userMenuButton = browser.getDriver().findElement(By.xpath(userMenuUnfoldButtonXpath));
		logoutButton = browser.getDriver().findElement(By.xpath(logoutButtonXpath));
	}


	/**
	 * Wait until unfold button is visible
	 *
	 * @param timeInSeconds Max amount of seconds to wait
	 */
	public void waitUntilUserMenuIsVisible(int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), timeInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userMenuUnfoldButtonXpath)));
	}


	/**
	 * Click button that unfolds user profile
	 */
	public void clickUnfoldUserMenuButton() {
		userMenuButton.click();
	}


	/**
	 * Click logout button
	 */
	public void clickLogoutButton() {
		logoutButton.click();
	}

}
