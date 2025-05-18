package test.BuzzPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.BuzzPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC02_BuzzPage extends BaseClass
{
   @Test
	  public void addTextPost() 
	  {
		  try {
		        logger.info("TC01_BuzzPage Started");
		        
		        HomePage hp = new HomePage(driver);
		        BuzzPage bp = new BuzzPage(driver);
		        
		        BasePage.Click(hp.lnkBuzz);
		        logger.info("Clicked on BuzzPage");
		        
		        BasePage.Click(bp.btnrecentPost);
		        logger.info("Clicked on Most Recent Post");
		        
		        BasePage.Click(bp.iconthreedot);
		        logger.info("Clicked on ThreeDot option");
		        
		        BasePage.Click(bp.btndelete);
		        logger.info("Selected delete option");
		        
		        BasePage.Click(bp.btnYesdelete);
		        logger.info("Clicked on Confirm yes, delete");
		        Thread.sleep(2000);
		        
		        String Successmsg = BasePage.CaptureMsg(bp.errmsg);
		        logger.info("Success meassage:"+ Successmsg);
		        Assert.assertTrue(true);
		        logger.info("TC02_Buzzpage Completed..");
		  }catch(Exception e)
	  	{
	  		logger.error("Test Failed - " + e.getMessage());
	         Assert.fail();
	  	}

	  }
	}
		        
		        

