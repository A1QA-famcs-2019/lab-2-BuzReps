package driver;

import org.openqa.selenium.WebDriver;

public interface Browser {
	WebDriver getDriver();

	void quit();
}
