package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups = {"Regression","Master"})
	public void test_account_Registration() {
		logger.debug("application logs.....");
		logger.info("Starting TC_001_AccountRegistrationTest ***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			logger.info("clicked on my account link");
			
			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			
			logger.info("providing customer data");
			arp.setFirstName("manu");
			arp.setLastName("manu");
			arp.setEmail(randomString()+"@gmail.com");
			arp.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			arp.setPassword(password);
			arp.setCPassword(password);
			arp.setPrivacyPolicy();
			arp.clickContinue();
			logger.info("clicked on continue");
			String confmsg = arp.getConfirmationMsg(); 
			logger.info("validating expected message");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "not getting expected message");
		}
		catch(Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("**** Finished TC_001_AccountRegistrationTest ***");

	}
}
