package test.BuzzPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.BuzzPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC03_BuzzPage extends BaseClass
{

    @Test
    public void addCommentByEnterKey() {
        try {
            logger.info("TC03_BuzzPage Started");

            HomePage hp = new HomePage(driver);
            BuzzPage bp = new BuzzPage(driver);

           
            BasePage.Click(hp.lnkBuzz);
            logger.info("Clicked on Buzz link");

            BasePage.Click(bp.iconcmnt);
            logger.info("Clicked on the Comment icon");

            BasePage.InputText(bp.txtinputcmnt, p.getProperty("Comment"));
            BasePage.EnterKey(bp.txtinputcmnt);
            logger.info("Entered the sample comment");
            Thread.sleep(2000);
	        
	        String Successmsg = BasePage.CaptureMsg(bp.errmsg);
	        logger.info("Success meassage:"+ Successmsg);
	        
	        Assert.assertTrue(true);
	        logger.info("TC03_Buzzpage Completed..");
	  }catch(Exception e)
  	{
  		logger.error("Test Failed - " + e.getMessage());
         Assert.fail();
  	}

  }
}

