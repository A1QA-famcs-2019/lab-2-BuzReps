import driver.Browser;

import driver.ResourceManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class OnlinerTest {

	private String login;
	private String password;
	
	@BeforeTest
	public void beforeTest() {
		login = ResourceManager.getTestValue("login");
		password = ResourceManager.getTestValue("password");
	}

	@Test
	public void test1() {
		WebDriver driver = Browser.getDriver();
		// Setup browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(ResourceManager.getTestValue("wait_time")), TimeUnit.SECONDS);

		// Go to main page and validate that we unauthorized user
		driver.get(ResourceManager.getTestValue("page_location"));
		OnlinerUnauthorizedMainPage onlinerUnauthorizedMainPage = new OnlinerUnauthorizedMainPage();
		Assert.assertTrue(onlinerUnauthorizedMainPage.isOpenLoginFormButtonPresent(), "Unauthorized page should have 'Open login form' button");

		// Open login form, enter credentials and click login.
		onlinerUnauthorizedMainPage.clickLoginFormButton();
		LoginForm loginForm = new LoginForm();
		loginForm.writeCredentials(login, password);
		loginForm.clickLoginButton();

		// Wait until login form disappears
		loginForm.waitUntilBackgroundStaleness();

		// Validate that we authorized user
		OnlinerAuthorizedMainPage onlinerAuthorizedMainPage = new OnlinerAuthorizedMainPage();
		Assert.assertTrue(onlinerAuthorizedMainPage.isUnfoldUserMenuButtonPresent(), "Authorized page should have 'Unfold user menu' button");

		// Get random section from popular sections list
		PopularSectionsList popularSectionsList = new PopularSectionsList();
		final int sectionIdx = popularSectionsList.getRandomSectionIndex();
		String sectionLinkText = popularSectionsList.getSectionText(sectionIdx);

		// Go to this section and compare its title and link text
		popularSectionsList.clickSection(sectionIdx);
		ProductSectionPage sectionPage = new ProductSectionPage();
		sectionPage.waitUntilTitleIsVisible();
		Assert.assertEquals(sectionLinkText, sectionPage.getTitleText(), "Link and corresponding page title should match.");

		// Go back to main page and logout
		driver.navigate().back();
		onlinerAuthorizedMainPage.waitUntilUserMenuIsVisible();
		onlinerAuthorizedMainPage.clickUnfoldUserMenuButton();
		onlinerAuthorizedMainPage.clickLogoutButton();

		// Validate that we unauthorized user
		Assert.assertTrue(onlinerUnauthorizedMainPage.isOpenLoginFormButtonPresent(), "Unauthorized page should have 'Open login form' button");

		driver.quit();
	}
}
