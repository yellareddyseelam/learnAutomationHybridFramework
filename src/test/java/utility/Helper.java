package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public static String getScreenShot(WebDriver driver,String screenShotName) {
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destFile="D:\\Selenium-framework\\com.learnautomation.hybrid\\Screenshots\\"+screenShotName+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(file, new File(destFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to capture the sreenshot:"+e.getMessage());
		}
		return destFile;
		
	}

}
