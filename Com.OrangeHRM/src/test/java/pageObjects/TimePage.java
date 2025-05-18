package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePage extends BasePage{

	public TimePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//nav[@class='oxd-topbar-body-nav']/ul/li[2]/span")
	public WebElement lnkAttendance;
	
	@FindBy(xpath="//nav[@class='oxd-topbar-body-nav']//li[2]/a")
	public WebElement drpdnPunchIn;
	
	@FindBy(xpath="//nav[@class='oxd-topbar-body-nav']//li[4]/a")
	public WebElement drpdnConfig;
	
	@FindBy(xpath="//textarea[@placeholder='Type here']")
	public WebElement txtnote;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement btnInOut;
	
	@FindBy(xpath="//h6[contains(@class,'h6 orangehrm-main-title')]")
	public WebElement titleInOut;
	
	@FindBy(xpath="//input[@placeholder='yyyy-dd-mm']") 
	public WebElement dateField;
	
	@FindBy(xpath="	//input[@placeholder='hh:mm']") 
	public WebElement timeField;


	@FindBy(xpath="//div[@class='oxd-date-wrapper']/following::span[1]") 
	public WebElement dateFieldError;

	@FindBy(xpath="//div[@class='oxd-date-wrapper']/following::span[2]") 
	public WebElement timeFieldError;
	
    @FindBy(xpath="//div[@class='orangehrm-attendance-field-row'][1]//span")
    public WebElement chkboxopt1;
    
    @FindBy(xpath="//button[normalize-space()='Save']")
    public WebElement btnsave;


}
