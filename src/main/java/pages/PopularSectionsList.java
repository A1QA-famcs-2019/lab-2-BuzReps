package pages;

import driver.Browser;
import driver.ResourceManager;
import elements.Button;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Class for interacting with onliner's main page's popular sections list
 */
public class PopularSectionsList {

	private final static String menuItemsXpath = ResourceManager.getLocatorValue("menuItemsXpath");
	private final static String menuItemLinkSubElementXpath = ResourceManager.getLocatorValue("menuItemLinkSubElementXpath");
	private final static String menuItemSignSubElementXpath = ResourceManager.getLocatorValue("menuItemSignSubElementXpath");

	public int getRandomSectionIndex() {
		final int listItemsCount = Browser.getDriver().findElements(By.xpath(menuItemsXpath)).size();
		return new Random().nextInt(listItemsCount);
	}

	public String getSectionText(int sectionIndex) {
		String locator = menuItemsXpath + String.format("[%d]", sectionIndex) + menuItemLinkSubElementXpath + menuItemSignSubElementXpath;
		return Browser.getDriver().findElement(By.xpath(locator)).getText();
	}

	public void clickSection(int sectionIndex) {
		String locator = menuItemsXpath + String.format("[%d]", sectionIndex) + menuItemLinkSubElementXpath;
		new Button(By.xpath(locator)).click();
	}
}
