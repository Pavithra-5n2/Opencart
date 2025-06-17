package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test(groups={"sanity","Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***** starting TC001_AccountRegistrationTest ****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myAccount link");
		hp.clickRegister();
		logger.info("clicked on registered link");
			
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("providing customer details");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelePhone(randomNumber());
		
		String Password = randomAlphaNumeric();
		regPage.setPassword(Password);
		regPage.setConfirmPassword(Password);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		logger.info("Validating expceted massage");
		String confMsg = regPage.getConfirmationMsg();
		if(confMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** finished TC001_AccountRegistrationTest ****");
		}
	
}
