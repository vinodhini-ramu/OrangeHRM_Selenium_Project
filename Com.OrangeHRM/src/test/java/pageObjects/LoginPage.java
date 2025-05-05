package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage 
	{

		public LoginPage(WebDriver driver)
		{
			super(driver);	
		}

		
		@FindBy(xpath="//input[@name='username']")
		WebElement txt_username;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement txt_password ;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement btn_login;
		
		@FindBy(xpath="(//img[@alt='orangehrm-logo'])[2]")
		WebElement img_logo;
		
		
		
		public void setUserName(String user)
		{
			txt_username.sendKeys(user);
		}
		
		public void setPassword(String pwd)
		{
			txt_password.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			btn_login.click();
			
			//sol2 
					//btn_login.submit();
					
					//sol3
					//Actions act=new Actions(driver);
					//act.moveToElement(btn_login).click().perform();
								
					//sol4
					//JavascriptExecutor js=(JavascriptExecutor)driver;
					//js.executeScript("arguments[0].click();", btn_login);
					
					//Sol 5
					//btn_login.sendKeys(Keys.RETURN);
					
					//Sol6  
					//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
					//mywait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();
					
		}
		
		
		public boolean logoDisplayStatus() 
		{
		    try 
		    {
		    	return img_logo.isDisplayed();	
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Error: Logo element not found or other issue: " + e.getMessage());
		        return false; 
		    }
			
		}
		 
}
