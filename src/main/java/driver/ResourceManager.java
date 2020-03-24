package driver;

import java.util.ResourceBundle;

/**
 * Class for fetching resource values
 */
public class ResourceManager {

	private static ResourceBundle testResources = ResourceBundle.getBundle("testResources");
	private static ResourceBundle locatorResources = ResourceBundle.getBundle("elementLocators");
	
	public static String getTestValue(String key) {
		return testResources.getString(key);
	}

	public static String getLocatorValue(String key) {
		return locatorResources.getString(key);
	}

}
