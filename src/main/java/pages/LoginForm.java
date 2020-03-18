package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class for interacting with onliner's main page login form
 */
public class LoginForm {

	/**
	 * Xpath for login form background
	 */
	private final static String loginFormBackgroundXpath = "//div[@class='auth-content']";

	/**
	 * Xpath for login button
	 */
	private final static String loginButtonXPath = "//div[contains(@class, 'auth-form__control')]//button[@type='submit']";

	/**
	 * Xpath for login field
	 */
	private final static String loginTextFieldXPath = "//div[contains(@class,'auth-form__line')]//input[@type=\"text\"]";

	/**
	 * Xpath for password field
	 */
	private final static String passwordFieldXPath = "//div[contains(@class,'auth-form__line')]//input[@type=\"password\"]";

	/**
	 * loginForm constructor
	 */
	public LoginForm() {
	}

	/**
	 * Get form background element
	 *
	 * @return Form background element
	 */
	public WebElement getLoginFormBackground() {
		return Browser.getDriver().findElement(By.xpath(loginFormBackgroundXpath));
	}

	/**
	 * Fill login and password fields
	 *
	 * @param login    user login
	 * @param password user password
	 */
	public void writeCredentials(String login, String password) {
		WebElement loginTextField = Browser.getDriver().findElement(By.xpath(loginTextFieldXPath));
		WebElement passwordTextField = Browser.getDriver().findElement(By.xpath(passwordFieldXPath));
		loginTextField.sendKeys(login);
		passwordTextField.sendKeys(password);
	}

	/**
	 * Click login button
	 */
	public void clickLoginButton() {
		WebElement loginButton = Browser.getDriver().findElement(By.xpath(loginButtonXPath));
		loginButton.click();
	}
}
