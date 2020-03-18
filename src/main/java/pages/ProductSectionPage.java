package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class for interacting with section page
 */
public class ProductSectionPage {

	/**
	 * Section title element xpath
	 */
	public final static String sectionTitleXpath = "//div[@class='schema-header']//*[@class='schema-header__title']";

	/**
	 * Constructor
	 */
	public ProductSectionPage() {
	}

	/**
	 * Get section title text
	 *
	 * @return section title text
	 */
	public String sectionTitleText() {
		WebElement sectionTitle = Browser.getDriver().findElement(By.xpath(sectionTitleXpath));
		return sectionTitle.getText();
	}

}
