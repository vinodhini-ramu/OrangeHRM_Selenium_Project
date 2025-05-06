package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage extends BasePage 
{
   public PIMPage(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(xpath="//nav[@class='oxd-topbar-body-nav']/ul/li[3]/a")
   WebElement lnkaddemployee; 
   
   @FindBy(xpath="//input[@placeholder='First Name']")
   WebElement txtfstname ; 
   
   @FindBy(xpath="//input[@placeholder='Middle Name']")
   WebElement txtmidname; 

   @FindBy(xpath="//input[@placeholder='Last Name']")
   WebElement txtlstname; 

   @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
   WebElement txtempid; 
   
   @FindBy(xpath="//button[normalize-space()='Save']")
   WebElement btnsave; 

   @FindBy(xpath="//a[contains(text(),'Employee List')]")
   WebElement lnkemplist;
   
   @FindBy(xpath="//div[@class='orangehrm-edit-employee-name']/h6")
   WebElement txtempname;
   
   @FindBy(xpath="//div[@class='oxd-input-group']//div[1]//span[1]")
   WebElement msgfnamerequired;
   
   @FindBy(xpath=" //div[@class='oxd-layout-container']//div[3]//span[1]")
   WebElement msglnamerequired;
   
   @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
   WebElement msgerrempId;

 
   public void clkaddemployee()
    {
		lnkaddemployee.click();
	}
   
   public void setfirstname(String fname)
	{
		txtfstname.sendKeys(fname);
	}
  
   public void setmiddlename(String mname)
	{
		txtmidname.sendKeys(mname);
	}
  
   public void setlastname(String lname)
	{
		txtlstname.sendKeys(lname);
	}
   public void clremployeeid()
   { 
	   txtempid.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
	   
   }
   public void setemployeeid(String emplyid)
	{
	   txtempid.sendKeys(emplyid);

	}  
  
   public void clicksave()
	{
		btnsave.click();
	}
   
   public void clkEmployeelist()
   {
	   lnkemplist.click();
   }
   
   public boolean isempnameDisplayed()
   {
	   try 
		{
		return txtempname.isDisplayed();
	    }
		catch(Exception e)
		{
			System.out.println("Employee name not added"+e.getMessage());
			return false;
		}
   }
  
   public boolean fname_Field_msg()
   {
	   try 
		{
		return msgfnamerequired.isDisplayed();
	     }
		catch(Exception e)
		{
			e.getMessage();
			return false;
		}
   }
   
   public boolean lname_Field_msg()
   {
	   try 
		{
		return msglnamerequired.isDisplayed();
	     }
		catch(Exception e)
		{
			e.getMessage();
			return false;
		} 
   }
   
   public boolean ds_empId_err_msg()
   {
	   try 
		{
		return msgerrempId.isDisplayed();
	     }
		catch(Exception e)
		{
			e.getMessage();
			return false;
		} 
   }
   
   public String empId_err_msg()
   {
	   return msgerrempId.getText();
   }
   
   
   
}
