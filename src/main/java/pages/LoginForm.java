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
	 * Login field
	 */
	private WebElement loginTextField;

	/**
	 * Password field
	 */
	private WebElement passwordTextField;

	/**
	 * Button for logging in
	 */
	private WebElement loginButton;

	/**
	 * Background that covers main page
	 */
	private WebElement loginFormBackground;

	/**
	 * loginForm constructor
	 *
	 * @param browser Browser with loaded login form
	 */
	public LoginForm(Browser browser) {
		loginTextField = browser.getDriver().findElement(By.xpath(loginTextFieldXPath));
		passwordTextField = browser.getDriver().findElement(By.xpath(passwordFieldXPath));
		loginButton = browser.getDriver().findElement(By.xpath(loginButtonXPath));
		loginFormBackground = browser.getDriver().findElement(By.xpath(loginFormBackgroundXpath));
	}

	public WebElement getLoginFormBackground() {
		return loginFormBackground;
	}

	/**
	 * Fill login and password fields
	 *
	 * @param login    user login
	 * @param password user password
	 */
	public void writeCredentials(String login, String password) {
		loginTextField.sendKeys(login);
		passwordTextField.sendKeys(password);
	}

	/**
	 * Click login button
	 */
	public void clickLoginButton() {
		loginButton.click();
	}
}
