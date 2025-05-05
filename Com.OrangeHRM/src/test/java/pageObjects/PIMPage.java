package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage 
{
   public PIMPage(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(xpath="//a[contains(text(),'Add Employee')]")
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
   
   public void setemployeeid(String emplyid)
	{
		txtempid.clear();
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
  
   



 
 

}
