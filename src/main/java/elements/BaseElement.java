package elements;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {
	private By locator;

	public BaseElement(By locator) {
		this.locator = locator;
	}

	public By getLocator() {
		return locator;
	}

	protected WebElement getElement() {
		return Browser.getDriver().findElement(locator);
	}

	protected List<WebElement> getElements() {
		return Browser.getDriver().findElements(locator);
	}

	public boolean isPresent() {
		return getElements().size() > 0;
	}

	public String getText() {
		return getElement().getText();
	}
}
