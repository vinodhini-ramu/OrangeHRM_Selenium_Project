package test.BuzzPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.BuzzPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC05_BuzzPage extends BaseClass 
{
	 @Test
	    public void shareBuzzPost() {
	        try {
	            logger.info("TC05_BuzzPage Started");

	            HomePage hp = new HomePage(driver);
	            BuzzPage bp = new BuzzPage(driver);

	            BasePage.Click(hp.lnkBuzz);
	            logger.info("Clicked on Buzz link");

	            Thread.sleep(2000); 

	            BasePage.Click(bp.btnSharePost);
	            logger.info("Clicked on Share icon");

	    
	            BasePage.InputText(bp.txtShareComment, p.getProperty("ShareComment"));
	            logger.info("Entered comment for shared post");

	            BasePage.Click(bp.btnConfirmShare);
	            logger.info("Clicked on Share/Post to confirm");

	            Thread.sleep(2000); 

	            String sharedMsg = BasePage.CaptureMsg(bp.lblSharedPost);
	            logger.info("Shared Post Message: " + sharedMsg);

	            Assert.assertEquals(sharedMsg, p.getProperty("ShareComment"));
	            logger.info("TC05_BuzzPage Completed Successfully");

	        } catch (Exception e) {
	            logger.error("TC05_BuzzPage Failed: " + e.getMessage());
	            Assert.fail();
	        }
	    }
	}


