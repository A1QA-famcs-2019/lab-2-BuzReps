package elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement implements KeyInputable {
	public TextBox(By locator) {
		super(locator);
	}

	@Override
	public void sendKeys(String text) {
		getElement().sendKeys(text);
	}
}
