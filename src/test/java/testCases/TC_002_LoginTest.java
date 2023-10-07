package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void test_login() {
		try {
			logger.info("***Starting TC_02_LoginTest ****");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount ");
			hp.clickLogin();
			logger.info("clicked on login link");
			
			LoginPage lp = new LoginPage(driver);
			logger.info("providing the login details");
			lp.setEmail(rb.getString("email"));
			lp.setPassword(rb.getString("password"));
			lp.clickLogin();
			logger.info("clicked on login");
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExist();
			Assert.assertEquals(targetPage, true, "Invalid Login Data");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*** Finished TC_002_LoginTest ****");
		
	}
}
