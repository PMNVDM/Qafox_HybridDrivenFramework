package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(name = "firstname")
	WebElement txtFirstName;
	
	@FindBy(name = "lastname")
	WebElement txtLastName;
	
	@FindBy(name = "email")
	WebElement txtEmail;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "telephone")
	WebElement txtTelephone;
	
	@FindBy(name = "confirm")
	WebElement txtCPassword;
	
	@FindBy(name = "agree")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setCPassword(String cPassword) {
		txtCPassword.sendKeys(cPassword);
	}
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	public void clickContinue() {
		btnContinue.click();
	}
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
}
