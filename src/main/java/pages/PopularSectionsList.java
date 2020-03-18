package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Class for interacting with onliner's main page's popular sections list
 */
public class PopularSectionsList {

	/**
	 * XPath for popular section list elements
	 */
	private final static String itemsXpath = "//ul[contains(@class, 'project-navigation__list')]//a[contains(@class, 'project-navigation__link')]";

	/**
	 * Get List of elements of popular sections list
	 *
	 * @return List of elements of popular sections list
	 */
	public List<WebElement> getList() {
		return Browser.getDriver().findElements(By.xpath(itemsXpath));
	}

	/**
	 * Get section text
	 *
	 * @param section Section to fetch text from
	 * @return Section Text
	 */
	public static String getSectionText(WebElement section) {
		return section.findElement(By.xpath(".//span[@class='project-navigation__sign']")).getText();
	}

	/**
	 * Constructor
	 */
	public PopularSectionsList() {}
}
