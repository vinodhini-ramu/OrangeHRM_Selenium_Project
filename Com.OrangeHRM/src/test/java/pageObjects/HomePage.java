package pageObjects;
/* 
*
*
**/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]")
	public WebElement txtDashBoard;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	public WebElement drpIcon;

	@FindBy(xpath="//a[text()='Logout']")
	public WebElement drpOpt_logout;
	
	@FindBy(xpath="//ul[contains(@class,'oxd-main-menu')]/li[2]//a")
	public WebElement lnkPIM;
	
	@FindBy(xpath="//ul[contains(@class,'oxd-main-menu')]/li[3]//a")
	public WebElement lnkLeave;
	
	@FindBy(xpath="//ul[contains(@class,'oxd-main-menu')]/li[4]//a")
	public WebElement lnkTime;
	
	@FindBy(xpath="//ul[contains(@class,'oxd-main-menu')]/li[6]//a")
	public WebElement lnkMyInfo;
	
	@FindBy(xpath="//ul[contains(@class,'oxd-main-menu')]/li[12]//a")
	public WebElement lnkBuzz;
   
	
}
