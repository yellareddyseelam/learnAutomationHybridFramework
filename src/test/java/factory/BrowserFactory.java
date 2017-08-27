package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserFactory {
	static WebDriver webDriver;

	public static WebDriver getBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.configDataProvider().getFireFoxPath());
			webDriver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.configDataProvider().getChromePath());
			webDriver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", DataProviderFactory.configDataProvider().getIePath());
			webDriver = new InternetExplorerDriver();

		}
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return webDriver;
	}
   public static void closeBrowser(WebDriver webDriver) {
	   webDriver.quit();
	   
   }
}
