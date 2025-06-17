package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","Master"})
	public void verify_login()
	{
		logger.info("**** starting TC002_LoginTest ***");
		
		//homepage
		try {
			
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(pr.getProperty("email"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLogin();
		
		//myaccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
//		Assert.assertEquals(targetPage, true,"login failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** finished TC002_LoginTest ***");
	}
	
}
