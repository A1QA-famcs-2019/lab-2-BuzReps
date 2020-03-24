package pages;

import driver.Browser;
import driver.ResourceManager;
import elements.BaseElement;
import elements.Link;
import elements.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Class for interacting with onliner's main page as authorized user
 */
public class OnlinerAuthorizedMainPage {

	private static final Link unfoldUserMenuButton = new Link(By.xpath(ResourceManager.getLocatorValue("unfoldUserMenuButton")));
	private static final Link logoutButton = new Link(By.xpath(ResourceManager.getLocatorValue("logoutButton")));

	/**
	 * Wait until unfold button is visible
	 */
	public void waitUntilUserMenuIsVisible() {
		Wait.waitUntilVisible(unfoldUserMenuButton);
	}

	public boolean isUnfoldUserMenuButtonPresent() {
		return unfoldUserMenuButton.isPresent();
	}

	/**
	 * Click button that unfolds user profile
	 */
	public void clickUnfoldUserMenuButton() {
		unfoldUserMenuButton.click();
	}

	/**
	 * Click logout button
	 */
	public void clickLogoutButton() {
		logoutButton.click();
	}

}
