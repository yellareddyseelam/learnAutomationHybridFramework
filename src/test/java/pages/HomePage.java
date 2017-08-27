package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver webDriver;

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signInLink;

	@FindBy(xpath = "//a[text()='My Account']")
	WebElement myAccountLink;

	@FindBy(xpath = "//a[text()='My cart']")
	WebElement myCart;

	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement checkOut;

	public void clickOnSigninLink() {
		signInLink.click();
	}

	public void clickMyAccountLink() {
		myAccountLink.click();
	}

	public void clickOnMyCartLink() {
		myCart.click();

	}

	public void clickOnCheckOutLink() {
		checkOut.click();

	}

	public String getApplicationTilte() {
		return webDriver.getTitle();
	}
}
