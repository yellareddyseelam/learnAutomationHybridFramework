package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLoginPage {
	WebDriver webDriver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUP() {
		report=new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		logger=report.startTest("verify Test Login");
		
		
		webDriver = BrowserFactory.getBrowser(DataProviderFactory.configDataProvider().getBrowserName());
		webDriver.get(DataProviderFactory.configDataProvider().getApplicationUrl());
        logger.log(LogStatus.INFO, "Application up and running");
	}

	@Test
	public void testLoginPage() throws InterruptedException {
		HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
		String homePageTitle=homePage.getApplicationTilte();
		Assert.assertTrue(homePageTitle.contains("Avactis Demo Store"));
		 logger.log(LogStatus.PASS, "Home Page Loaded And Verified");
		homePage.clickOnSigninLink();
		logger.log(LogStatus.INFO, "Click on Sign in");
		LogInPage logInPage = PageFactory.initElements(webDriver, LogInPage.class);
		logInPage.logInApplication(DataProviderFactory.excelDataProvider().getData(0, 0, 0), DataProviderFactory.excelDataProvider().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Login to application");
		logInPage.verifySignOutLink();
		logger.log(LogStatus.PASS, "Sing out link present");
        
	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeBrowser(webDriver);
		report.endTest(logger);
		report.flush();

	}

}
