package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeavePage extends BasePage {

	public LeavePage(WebDriver driver)
	{
		super(driver);
	}
	


    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']/ul/li[1]") public WebElement lnkApply;
    
    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']/ul/li[2]") public WebElement lnkMyLeave;
    
    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']/ul/li[3]") public WebElement lnkEntitlements;
    
    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']/ul/li[5]") public WebElement lnkConfigure;
    
    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']//li[3]//li[1]/a") public WebElement ddAddEntitlements;
    
    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']//li[5]//li[4]/a") public WebElement ddHolidays;
    
    @FindBy( xpath = "//nav[@class='oxd-topbar-body-nav']//li[5]//li[3]/a") public WebElement ddWorkWeek;
    
    @FindBy(xpath = "//input[@placeholder='Type for hints...']") public WebElement txtEmployeename;
    
    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']//span") public WebElement autoCompleteFirstOption;
    
    @FindBy(xpath = "//label[text()='Entitlement']/following::input[1]") public WebElement txtEntitlement;
    
    @FindBy(xpath = "//label[text()='Leave Type']/following::div[1]") public WebElement ddLeaveType;

    @FindBy(xpath = "//div[@role='listbox']/div[2]/span")  public WebElement firstLeaveOption;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]") public WebElement txtFromDate;

    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]") public WebElement txtToDate;
    
    @FindBy(xpath = "//div[@class='oxd-date-input-link --today']") public WebElement lnktoday;

    @FindBy(xpath = "//textarea[@placeholder='Type a comment']")  public WebElement txtComment;

    @FindBy(xpath = "//button[@type='submit']") public WebElement btnApply;
    
    @FindBy(xpath = "//button[@type='submit']") public WebElement btnSave;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-leave-balance-text']") public WebElement lblLeaveBalance;
    
    @FindBy(xpath = "//h6[normalize-space()='Apply Leave']") public WebElement titlrApplyLeave;
    
    @FindBy(xpath = "//button[normalize-space()='Confirm']") public WebElement btnconfirm;
    
    @FindBy(xpath = "//h5[normalize-space()='Leave Entitlements']") public WebElement titleLeaveEntitlement;
    
    @FindBy(xpath = "//p[contains(text(),'Successfully')]") public WebElement sucessmsg;
    
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]") public WebElement ddshow;
    
    @FindBy(xpath = "//i[@class='oxd-icon bi-x --clear']") public WebElement clrallopt;
    
    @FindBy(xpath = "//label[text()='Cancelled']/preceding-sibling::input") public WebElement chkCancelled;
    @FindBy(xpath = "//span[normalize-space()='Cancelled']/i") public WebElement clrCancelled;

    @FindBy(xpath = "//label[text()='Rejected']/preceding-sibling::input") public WebElement chkRejected;
    @FindBy(xpath = "//span[normalize-space()='Rejected']/i") public WebElement clrRejected;
    
    @FindBy(xpath = "//label[text()='Pending Approval']/preceding-sibling::input")  public WebElement chkPending;
    @FindBy(xpath = "//span[normalize-space()='Pending Approval']/i") public WebElement clrPending;
    
    @FindBy(xpath = "//label[text()='Scheduled']/preceding-sibling::input") public WebElement chkScheduled;
    @FindBy(xpath = "//span[normalize-space()='Scheduled']/i") public WebElement clrScheduled;
    
    @FindBy(xpath = "//label[text()='Taken']/preceding-sibling::input") public WebElement chkTaken;
    @FindBy(xpath = "//span[normalize-space()='Taken']/i") public WebElement clrTaken;
    
    @FindBy(xpath = "//div[@class='oxd-multiselect-chips-area']/span") public List<WebElement> selectedopt;
    
    @FindBy(xpath = "//button[@type='submit']") public WebElement btnSearch;
    
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement msgreq;
    
    @FindBy(xpath = "//div[@class='oxd-table-body']/div//div[2]/div") public List<WebElement> holidaynames;
    
    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']") public List<WebElement> NoofRows;
    
    @FindBy(xpath = "//div[@role='table']//div[@role='columnheader']") public List<WebElement> Noofcolumn;    
    
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']") public WebElement recordmsg;
    
    @FindBy(xpath="//button[normalize-space()='Delete Selected']")  public WebElement btndelete;
    
    @FindBy(xpath="//button[normalize-space()='Yes, Delete']") public WebElement btnYesdelete;
    

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    public WebElement ddMonday;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    public WebElement ddTuesday;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[3]")
    public WebElement ddWednesday;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[4]")
    public WebElement ddThursday;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[5]")
    public WebElement ddFriday;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[6]")
    public WebElement ddSaturday;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[7]")
    public WebElement ddSunday;

    @FindBy(xpath = "//div[@role='listbox']//span[text()='Non-working Day']")
    public WebElement optNonWorking;
    
    @FindBy(xpath = "(//div[@id='oxd-toaster_1'])[1]") public WebElement errmsg;

    public void setAllDaysToNonWorking() throws InterruptedException {
        WebElement[] days = {
            ddMonday, ddTuesday, ddWednesday, ddThursday,
            ddFriday, ddSaturday, ddSunday
        };

        for (WebElement dayDropdown : days) {
         BasePage.Click(dayDropdown);
            Thread.sleep(1000);
            BasePage.Click(optNonWorking);
        }
    }
    

}
