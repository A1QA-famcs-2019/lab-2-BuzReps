package pages;

import driver.ResourceManager;
import elements.BaseElement;
import elements.Wait;
import org.openqa.selenium.By;

/**
 * Class for interacting with section page
 */
public class ProductSectionPage {

	private final static BaseElement sectionTitle = new BaseElement(By.xpath(ResourceManager.getLocatorValue("sectionTitle")));

	public String getTitleText() {
		return sectionTitle.getText();
	}

	public void waitUntilTitleIsVisible() {
		Wait.waitUntilVisible(sectionTitle);
	}

}
