package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(linkText = "Logout")
	WebElement btnLogout;
	
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	public void clickLogot() {
		btnLogout.click();
	}
	
	public boolean isMyAccountPageExist() {
		try {
			return(msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
	}
	
}
