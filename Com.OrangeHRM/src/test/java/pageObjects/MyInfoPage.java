package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoPage extends BasePage{

	public MyInfoPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 --strong']") public WebElement EmpName;
	

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement txtFName;
    
    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement txtMName;
    
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement txtLName;

    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div/input")
    public WebElement txtEmpId;

    @FindBy(xpath = "//label[text()=\"Driver's License Number\"]/../following-sibling::div/input")
    public WebElement txtDriverLicense;

    @FindBy(xpath = "//label[text()='License Expiry Date']/../following-sibling::div//input")
    public WebElement txtLicenseExpiry;

    @FindBy(xpath = "//label[text()='Date of Birth']/../following-sibling::div//input")
    public WebElement txtDOB;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    public WebElement ddlNationality;
    
    @FindBy(xpath = "(//div[@role='listbox'])[1]//span[contains(.,'Indian')]")
    public WebElement optIndian;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    public WebElement ddlMaritalStatus;
    
    @FindBy(xpath = "(//div[@role='listbox'])[1]//span[contains(.,'Married')]")
    public WebElement optMarried;

    @FindBy(xpath = "(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
    public WebElement radioGenderMale;

    @FindBy(xpath = "//label[normalize-space()='Female']")
    public WebElement radioGenderFemale;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement btnSave;

    @FindBy(xpath = "//div[contains(@class,'orangehrm-edit-employee-name')]/h6")
    public WebElement lblProfileName;

    // ---------------- EMERGENCY CONTACTS ----------------

    @FindBy(xpath = "//a[normalize-space()='Emergency Contacts']")
    public WebElement menuEmergencyContacts;

    @FindBy(xpath = "//h6[text()='Assigned Emergency Contacts']/following::button[1]")
    public WebElement btnAddEmergency;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[1]//input")
    public WebElement txtEmergencyName;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[2]//input")
    public WebElement txtEmergencyRelationship;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[3]//input")
    public WebElement txtHomePhone;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[4]//input")
    public WebElement txtMobile;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[5]//input")
    public WebElement txtWorkPhone;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSaveEmergency;

    @FindBy(xpath = "(//div[@id='oxd-toaster_1'])[1]")
    public WebElement lblSuccessMessage;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[3]/span")
    public WebElement errHomePhone;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[4]/span")
    public WebElement errMobile;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[5]/span")
    public WebElement errWorkPhone;

    // ---------------- DEPENDENTS ----------------

    @FindBy(xpath = "//a[normalize-space()='Dependents']")
    public WebElement menuDependents;

    @FindBy(xpath = "//h6[text()='Assigned Dependents']/following::button[1]")
    public WebElement btnAddDependent;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[1]//input")
    public WebElement txtDependentName;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    public WebElement ddlRelationship;
    
    @FindBy(xpath = "//div[@role='listbox']//div[3]")
    public WebElement optother;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElement txtSpecifyOther;

    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
    public WebElement txtDependentDOB;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement btnSaveDependent;
}




