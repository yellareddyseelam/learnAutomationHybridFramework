package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	 Properties properties;

	public ConfigDataProvider() {
		File configData = new File(".\\Configuration\\config.properties");
		try {
			FileInputStream fileInputStream = new FileInputStream(configData);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("Exception is:" + e.getMessage());
		}

	}

	public String getApplicationUrl() {
		String appUrl = properties.getProperty("url");
		return appUrl;

	}

	public String getChromePath() {
		String chromePath = properties.getProperty("chromePath");
		return chromePath;
	}

	public String getIePath() {
		String iePath = properties.getProperty("iePath");
		return iePath;
	}

	public String getFireFoxPath() {
		String fireFoxParh = properties.getProperty("fireFoxParh");
		return fireFoxParh;
	}

	public String getBrowserName() {
		String browser = properties.getProperty("Browser");
		System.out.println(browser);
		return browser;
	}
}
