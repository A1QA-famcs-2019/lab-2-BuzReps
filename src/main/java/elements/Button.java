package elements;

import org.openqa.selenium.By;

public class Button extends BaseElement implements Clickable {

	public Button(By locator) {
		super(locator);
	}

	@Override
	public void click() {
		getElement().click();
	}
}
