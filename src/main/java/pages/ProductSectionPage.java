package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductSectionPage {

	public final static String sectionTitleXpath = "//h1[contains(@class, 'schema-header__title')]";

	private WebElement sectionTitle;

	public ProductSectionPage(Browser browser) {
		sectionTitle = browser.getDriver().findElement(By.xpath(sectionTitleXpath));
	}

	public String sectionTitleText() {
		return sectionTitle.getText();
	}

}
