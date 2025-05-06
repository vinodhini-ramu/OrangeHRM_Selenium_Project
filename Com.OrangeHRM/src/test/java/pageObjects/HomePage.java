package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]")
	WebElement txtDashBoard;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement drpIcon;

	@FindBy(xpath="//a[text()='Logout']")
	WebElement drpOpt_logout;
	
	@FindBy(xpath="//ul[contains(@class,'oxd-main-menu')]/li[2]//a")
	WebElement lnkPIM;
	
	
	public boolean isDashboardpresent()
	{
		try 
		{
		return txtDashBoard.isDisplayed();
	    }
		catch(Exception e)
		{
			System.out.println("Dashboard elen]ment not found"+e.getMessage());
			return false;
		}
	
	}
	
	public void clickDropdown()
	{
		drpIcon.click();
	}
	
	public void clickLogout()
	{
		drpOpt_logout.click();
	}
	
   public String chkTitle()
   {
	return driver.getTitle(); 
   }
   
	public void clickPIM()
	{
		lnkPIM.click();
	}

}
