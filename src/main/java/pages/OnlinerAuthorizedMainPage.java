package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	public static final String logoutButtonXpath = "//div[@class='b-top-profile__header']//div[@class='b-top-profile__logout']//a[contains(@class, 'b-top-profile__link')]";

	/**
	 * Constructor
	 */
	public OnlinerAuthorizedMainPage() {
	}

	/**
	 * Wait until unfold button is visible
	 *
	 * @param timeInSeconds Max amount of seconds to wait
	 */
	public void waitUntilUserMenuIsVisible(int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(userMenuUnfoldButtonXpath)));
	}

	/**
	 * Get 'unfold user menu' button
	 *
	 * @return Button element or null in case of failure.
	 */
	public WebElement getUnfoldUserMenuButton() {
		try {
			return Browser.getDriver().findElement(By.xpath(userMenuUnfoldButtonXpath));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Click button that unfolds user profile
	 */
	public void clickUnfoldUserMenuButton() {
		WebElement userMenuButton = Browser.getDriver().findElement(By.xpath(userMenuUnfoldButtonXpath));
		userMenuButton.click();
	}


	/**
	 * Click logout button
	 */
	public void clickLogoutButton() {
		WebElement logoutButton = Browser.getDriver().findElement(By.xpath(logoutButtonXpath));
		logoutButton.click();
	}

}
