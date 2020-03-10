import driver.Browser;
import driver.ChromeBrowser;
import driver.FirefoxBrowser;
import driver.IEBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class OnlinerTest {

	/**
	 * User login for tests
	 */
	private static final String login;

	/**
	 * User password for tests
	 */
	private static final String password;

	/*
	 * Fetching tests data
	 */
	static {
		ResourceBundle testResources = ResourceBundle.getBundle("testResources");
		login = testResources.getString("login");
		password = testResources.getString("password");
	}

	@DataProvider(name = "browserDataProvider")
	Object[][] getBrowsers() {
		return new Object[][]{
			{new FirefoxBrowser()},
			{new ChromeBrowser()},
			{new IEBrowser()}
		};
	}

	@Test(dataProvider = "browserDataProvider")
	public void test1(Browser browser) {
		browser.getDriver().manage().window().maximize();
		browser.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Go to main page and open login form.
		// Successful constructing OnlinerUnauthorizedMainPage guarantees that page is loaded successfully
		browser.getDriver().get(OnlinerUnauthorizedMainPage.url);
		OnlinerUnauthorizedMainPage onlinerUnauthorizedMainPage = new OnlinerUnauthorizedMainPage(browser);
		onlinerUnauthorizedMainPage.clickLoginFormButton();

		// Enter credentials and click login.
		LoginForm loginForm = new LoginForm(browser);
		loginForm.writeCredentials(login, password);
		loginForm.clickLoginButton();

		// Wait until login form disappears
		// Successful constructing OnlinerAuthorizedMainPage guarantees that user authorized successfully
		WebDriverWait wait = new WebDriverWait(browser.getDriver(), 10);
		wait.until(ExpectedConditions.stalenessOf(loginForm.getLoginFormBackground()));
		new OnlinerAuthorizedMainPage(browser);

		// Get random section from popular sections list
		PopularSectionsList popularSectionsList = new PopularSectionsList(browser);
		Random rand = new Random();
		final int count = popularSectionsList.getList().size();
		WebElement randomSection = popularSectionsList.getList().get(rand.nextInt(count));
		String linkText = PopularSectionsList.getSectionText(randomSection);

		// Go to this section and compare its title and link text
		randomSection.click();
		ProductSectionPage sectionPage = new ProductSectionPage(browser);
		Assert.assertEquals(linkText, sectionPage.sectionTitleText());

		// Go back to main page and logout
		browser.getDriver().navigate().back();
		OnlinerAuthorizedMainPage onlinerAuthorizedMainPage = new OnlinerAuthorizedMainPage(browser);
		onlinerAuthorizedMainPage.waitUntilUserMenuIsVisible(60);
		onlinerAuthorizedMainPage.clickUnfoldUserMenuButton();
		onlinerAuthorizedMainPage.clickLogoutButton();

		// Successful constructing OnlinerUnauthorizedMainPage guarantees that user unauthorized successfully
		new OnlinerUnauthorizedMainPage(browser);

		browser.quit();
	}
}
