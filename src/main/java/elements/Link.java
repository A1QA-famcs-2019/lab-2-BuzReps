package elements;

import org.openqa.selenium.By;

public class Link extends BaseElement implements Clickable {
	public Link(By locator) {
		super(locator);
	}

	@Override
	public void click() {
		getElement().click();
	}

	public String getLinkText()
	{
		return getElement().getAttribute("href");
	}


}
