package pages;

import driver.ResourceManager;
import elements.BaseElement;
import elements.Button;
import elements.TextBox;
import elements.Wait;
import org.openqa.selenium.By;

/**
 * Class for interacting with onliner's main page login form
 */
public class LoginForm {

	private final static BaseElement loginFormBackground = new BaseElement(By.xpath(ResourceManager.getLocatorValue("loginFormBackground")));
	private final static Button loginButton = new Button(By.xpath(ResourceManager.getLocatorValue("loginButton")));
	private final static TextBox loginTextBox = new TextBox(By.xpath(ResourceManager.getLocatorValue("loginTextBox")));
	private final static TextBox passwordTextBox = new TextBox(By.xpath(ResourceManager.getLocatorValue("passwordTextBox")));

	/**
	 * Fill login and password fields
	 *
	 * @param login    user login
	 * @param password user password
	 */
	public void writeCredentials(String login, String password) {
		loginTextBox.sendKeys(login);
		passwordTextBox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void waitUntilBackgroundStaleness() {
		Wait.waitUntilStaleness(loginFormBackground);
	}

}
