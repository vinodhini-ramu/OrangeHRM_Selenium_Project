package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
   
   @FindBy(xpath="//nav[@class='oxd-topbar-body-nav']/ul/li[3]/a") WebElement lnkaddemployee; 
   @FindBy(xpath="//input[@placeholder='First Name']") WebElement txtfstname ; 
   @FindBy(xpath="//input[@placeholder='Middle Name']") WebElement txtmidname; 
   @FindBy(xpath="//input[@placeholder='Last Name']") WebElement txtlstname; 
   @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
   WebElement txtempid; 
   @FindBy(xpath="//button[normalize-space()='Save']") WebElement btnsave; 
   @FindBy(xpath="//a[contains(text(),'Employee List')]")WebElement lnkemplist;
   @FindBy(xpath="//div[@class='orangehrm-edit-employee-name']/h6")WebElement txtempname; 
   @FindBy(xpath="//div[@class='oxd-input-group']//div[1]//span[1]")WebElement msgfnamerequired; 
   @FindBy(xpath=" //div[@class='oxd-layout-container']//div[3]//span[1]")WebElement msglnamerequired; 
   @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
   WebElement msgerrempId;
   @FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]") WebElement txtSearchEmpname;
   @FindBy(xpath="//div[@class='oxd-table-body']/div[1]//div[3]") WebElement emplistname;
   @FindBy(xpath="//button[@type='submit']")WebElement btnSearch;
   @FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span") WebElement msgrecordsts; 
   @FindBy(xpath="//label[text()='Employment Status']/following::div[contains(@class,'oxd-select-text')][1]")
   WebElement drpdnempsts;
   @FindBy(xpath="//div[@role='listbox']//span") List<WebElement> drpdnelements;
   @FindBy(xpath="//div[@class='oxd-table-body']//div[@role='row']//div[@role='cell'][3]") List<WebElement> txtfnamelist;
   
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
   
   public void search_Emp_name(String empname)
   {
	   txtSearchEmpname.sendKeys(empname);
   }
   
   public String getEmpname()
   {
	   return emplistname.getText();
   }
   
   public void clkSearch()
   {
	   btnSearch.click();
   }
   
   public String getrecordsts()
   {
	   return msgrecordsts.getText();
   }
   public boolean emp_record_msg() {
	   try {
	        return msgrecordsts.isDisplayed(); 
	    } catch(Exception e) {
	        return false;
	    }
   }
   public boolean isNoRecordFound() 
   {
	    try {
	        return msgrecordsts.isDisplayed() && msgrecordsts.getText().equalsIgnoreCase("No Records Found");
	    } catch(Exception e) {
	        return false;
	    }
	}
 
   public List<String> getAllEmploymentStatuses() {
	   drpdnempsts.click();
       List<String> statusNames = new ArrayList<>();

       for (WebElement option : drpdnelements) 
       {
           statusNames.add(option.getText());
       }
       return statusNames;
   }


   public void selectEmploymentStatus(String statusName) {
	   drpdnempsts.click();
       for (WebElement option : drpdnelements) 
       {
           if (option.getText().equals(statusName)) 
           {
               option.click();
               break;
           }
       }
   }
   
   public List<String> getAllFirstNames() {
      
       List<String> firstNames = new ArrayList<>();

       for (WebElement name : txtfnamelist) {
           firstNames.add(name.getText());
       }
       return firstNames;
   }

}
