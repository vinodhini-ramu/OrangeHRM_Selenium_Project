package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuzzPage extends BasePage
{

	public BuzzPage(WebDriver driver) 
	{
		super(driver);	
	}
	
	@FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']") public WebElement   txtinputmsg;
	@FindBy(xpath = "//button[@type='submit']") public WebElement btnPost;
	@FindBy(xpath = "(//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text'])[1]") public WebElement  txtnewpost;
	@FindBy(xpath = "(//div[@id='oxd-toaster_1'])[1]") public WebElement errmsg;
	@FindBy(xpath = "//button[normalize-space()='Most Recent Posts']") public WebElement btnrecentPost;
	@FindBy(xpath = "(//i[@class='oxd-icon bi-three-dots'])[1]") public WebElement  iconthreedot;
	@FindBy(xpath = "//li[@class='orangehrm-buzz-post-header-config-item']") public WebElement btndelete;
	@FindBy(xpath="//button[normalize-space()='Yes, Delete']") public WebElement btnYesdelete;
	@FindBy(xpath ="(//i[@class='oxd-icon bi-chat-text-fill'])[1]") public WebElement iconcmnt;
	@FindBy(xpath ="//input[@placeholder='Write your comment...']") public WebElement txtinputcmnt;
    @FindBy(xpath = "(//div[contains(@class,'orangehrm-buzz-post-footer')])[1]/div[@class='orangehrm-buzz-post-actions']/div" )
    public WebElement btnLikeHeart;
    @FindBy(xpath = "(//div[@class='orangehrm-buzz-stats-row'])[1]/p") public WebElement lblLikeCount;
	
    @FindBy(xpath = "(//i[@class='oxd-icon bi-share-fill'])[1]") 
    public WebElement btnSharePost;

    @FindBy(xpath = "(//textarea[@placeholder=\"What's on your mind?\"])[2]")
    public WebElement txtShareComment;

    @FindBy(xpath = "//button[normalize-space()='Share']")
    public WebElement btnConfirmShare;

    @FindBy(xpath = "(//div[@class='orangehrm-buzz-post-body'])[1]//p[1]")
    public WebElement lblSharedPost;

}
