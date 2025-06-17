package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement ckdPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelePhone(String telephone)
	{
		txTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void setPrivacyPolicy()
	{
		ckdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
		
		//sol2
//		btnContinue.submit();
		
		//sol3
//		Actions act = new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();
		
		//sol4
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click();", btnContinue);
		
		//sol5
//		btnContinue.sendKeys(Keys.RETURN);
		
		//sol6
//		WebDriverWait myWait =new WebDriverWait(driver,Duration.ofSeconds(10));
//		myWait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
		
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (msgConfirmation.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
}
