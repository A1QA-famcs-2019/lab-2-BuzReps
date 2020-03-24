package pages;

import driver.ResourceManager;
import elements.Button;
import org.openqa.selenium.By;

/**
 * Class for interacting with onliner's main page as unauthorized user
 */
public class OnlinerUnauthorizedMainPage {

	private static final Button openLoginFormButton = new Button(By.xpath(ResourceManager.getLocatorValue("openLoginFormButton")));

	public boolean isOpenLoginFormButtonPresent() {
		return openLoginFormButton.isPresent();
	}

	public void clickLoginFormButton() {
		openLoginFormButton.click();
	}
}
