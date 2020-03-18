import driver.Browser;
import driver.BrowserType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class OnlinerTest {

	/**
	 * User login for tests
	 */
	private String login;

	/**
	 * User password for tests
	 */
	private String password;

	/*
	 * Fetching tests data
	 */
	@BeforeTest
	public void beforeTest() {
		ResourceBundle testResources = ResourceBundle.getBundle("testResources");
		login = testResources.getString("login");
		password = testResources.getString("password");
		final String browserType = testResources.getString("browser");
		Browser.setBrowser(BrowserType.valueOf(browserType));
	}

	@Test
	public void test1() {
		WebDriver driver = Browser.getDriver();
		// Setup browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Go to main page and validate that we unauthorized user
		driver.get(OnlinerUnauthorizedMainPage.url);
		OnlinerUnauthorizedMainPage onlinerUnauthorizedMainPage = new OnlinerUnauthorizedMainPage();
		Assert.assertNotNull(onlinerUnauthorizedMainPage.getLoginFormButton(), "Unauthorized page should have 'Open login form' button");

		// Open login form, enter credentials and click login.
		onlinerUnauthorizedMainPage.clickLoginFormButton();
		LoginForm loginForm = new LoginForm();
		loginForm.writeCredentials(login, password);
		loginForm.clickLoginButton();

		// Wait until login form disappears
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(loginForm.getLoginFormBackground()));

		// Validate that we authorized user
		OnlinerAuthorizedMainPage onlinerAuthorizedMainPage = new OnlinerAuthorizedMainPage();
		Assert.assertNotNull(onlinerAuthorizedMainPage.getUnfoldUserMenuButton(), "Authorized page should have 'Open user menu' button");

		// Get random section from popular sections list
		PopularSectionsList popularSectionsList = new PopularSectionsList();
		Random rand = new Random();
		final int count = popularSectionsList.getList().size();
		WebElement randomSection = popularSectionsList.getList().get(rand.nextInt(count));
		String linkText = PopularSectionsList.getSectionText(randomSection);

		// Go to this section and compare its title and link text
		randomSection.click();
		ProductSectionPage sectionPage = new ProductSectionPage();
		Assert.assertEquals(linkText, sectionPage.sectionTitleText(), "Link and section text should match.");

		// Go back to main page and logout
		driver.navigate().back();
		onlinerAuthorizedMainPage.waitUntilUserMenuIsVisible(60);
		onlinerAuthorizedMainPage.clickUnfoldUserMenuButton();
		onlinerAuthorizedMainPage.clickLogoutButton();

		// Validate that we unauthorized user
		Assert.assertNotNull(onlinerUnauthorizedMainPage.getLoginFormButton(), "Unauthorized page should have 'Open login form' button");

		driver.quit();
	}
}
