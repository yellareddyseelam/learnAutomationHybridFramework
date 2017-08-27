package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage {
	WebDriver webDriver;
	public LogInPage(WebDriver webDriver) {
		this.webDriver=webDriver;
		
	}
	@FindBy(id="account_sign_in_form_email_id")
	WebElement userName;
	
	@FindBy(id="account_sign_in_form_passwd_id")
	WebElement passWord;
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement singUpButton;
	/*@FindBy(xpath="//div[@class='pre-header']//a[text()='Sign Out']")
	WebElement sighOutLink;*/
	By signOut=By.xpath("//div[@class='pre-header']//a[text()='Sign Out']");
	
	public void logInApplication(String user,String pass) {
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		singUpButton.click();
		
	}
	public void verifySignOutLink() {
		WebDriverWait webDriverWait=new WebDriverWait(webDriver, 20);
		WebElement webElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(signOut));
		String signOutText=webElement.getText();
		Assert.assertEquals(signOutText, "Sign Out","Sign out link is not verified properly");
		
		
	}

	

}
