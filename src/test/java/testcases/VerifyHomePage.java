package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {
	WebDriver webDriver;
	
	@BeforeMethod
	public void setUP() {
		webDriver = BrowserFactory.getBrowser(DataProviderFactory.configDataProvider().getBrowserName());
		webDriver.get(DataProviderFactory.configDataProvider().getApplicationUrl());

	}

	@Test
	public void testHomePage() {
		HomePage homePage=PageFactory.initElements(webDriver, HomePage.class);
		String homePageTitle=homePage.getApplicationTilte();
		Assert.assertTrue(homePageTitle.contains("Avactis Demo Store"));
		System.out.println("Home Application Title:"+homePageTitle);
		
	}
	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeBrowser(webDriver);
		
	}

}
