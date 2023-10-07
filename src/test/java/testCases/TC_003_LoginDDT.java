package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String email, String password, String exp) {
		logger.info("*** Starting TC_003__LoginDDT");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			//Thread.sleep(3000);
			logger.info("clicked on MyAccount ");
			hp.clickLogin();
			//Thread.sleep(3000);
			logger.info("clicked on login link");
			
			LoginPage lp = new LoginPage(driver);
			
			lp.setEmail(email);
			lp.setPassword(password);
			//Thread.sleep(3000);
			lp.clickLogin();
			
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExist();
			macc.clickMyAccount();
			
			if(exp.equals("Valid")) {
				if(targetPage==true) {
					macc.clickLogot();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			if(exp.equals("Invalid")) {
				if(targetPage==true) {
					macc.clickLogot();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
			catch(Exception e) {
				Assert.fail();
			}
		logger.info("*** Finished TC_003__LoginDDT");
	}

}
