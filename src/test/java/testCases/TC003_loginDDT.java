package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/* Data is valid  -  login success - test pass - logout
 * Data is valid  - login failed - test fail
 * 
 * Data is invalid  -  login success - test fail - logout
 * Data is invalid  -  login failed - test pass
 */

public class TC003_loginDDT extends BaseClass  {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")
	public void verify_login(String email, String pwd, String exp)
	{
		logger.info("**** starting TC002_LoginTest ***");
		
		//homepage
		try {
			
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//myaccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		System.out.println(targetPage);
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
				macc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("InValid")) {
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** finished TC002_LoginTest ***");
		
	}
}
