package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage 
{
   public PIMPage(WebDriver driver)
   {
	   super(driver);
   }
   
   @FindBy(xpath="//nav[@class='oxd-topbar-body-nav']/ul/li[3]/a") public WebElement lnkaddemployee; 
   @FindBy(xpath="//input[@placeholder='First Name']") public WebElement txtfstname ; 
   @FindBy(xpath="//input[@placeholder='Middle Name']") public WebElement txtmidname; 
   @FindBy(xpath="//input[@placeholder='Last Name']") public WebElement txtlstname; 
   @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
   public WebElement txtempid; 
   @FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--focus']")
   public WebElement txtempid1;
   @FindBy(xpath="//button[@type='submit']") public WebElement btnsave; 
   @FindBy(xpath="//a[contains(text(),'Employee List')]") public WebElement lnkemplist;
   @FindBy(xpath="//div[@class='orangehrm-edit-employee-name']/h6") public WebElement txtempname; 
   @FindBy(xpath="//div[@class='oxd-input-group']//div[1]//span[1]")  public WebElement msgfnamerequired; 
   @FindBy(xpath=" //div[@class='oxd-layout-container']//div[3]//span[1]") public WebElement msglnamerequired; 
   @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
   public WebElement msgerrempId;
   @FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]") public WebElement txtSearchEmpname;
   @FindBy(xpath="//div[@class='oxd-table-body']/div[1]//div[3]") public WebElement emplistname;
   @FindBy(xpath="//button[@type='submit']") public WebElement btnSearch;
   @FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span") public WebElement msgrecordsts; 
   @FindBy(xpath="//label[text()='Employment Status']/following::div[contains(@class,'oxd-select-text')][1]")
   public WebElement drpdnempsts;
   @FindBy(xpath="//div[@role='listbox']/div[3]/span") public WebElement opt_three;
   @FindBy(xpath="//div[@role='listbox']//span")  public List< WebElement> drpdnelements;
   @FindBy(xpath="//div[@class='oxd-table-body']//div[@role='row']//div[@role='cell'][3]") public List<WebElement> txtfnamelist;
   @FindBy(xpath="//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']") public WebElement chkbox;
   @FindBy(xpath="//button[normalize-space()='Delete Selected']")  public WebElement btndelete;
   @FindBy(xpath="//button[normalize-space()='Yes, Delete']") public WebElement btnYesdelete;
  

 

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
