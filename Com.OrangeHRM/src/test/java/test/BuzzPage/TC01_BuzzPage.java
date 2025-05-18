package test.BuzzPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.BuzzPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC01_BuzzPage extends BaseClass
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
	        
	        BasePage.Click(bp.txtinputmsg);
	        logger.info("Clicked on input textBox");
	        
	        BasePage.InputText(bp.txtinputmsg, p.getProperty("SampleText"));
	        logger.info("Entered Sample text");
	        
	        BasePage.Click(bp.btnPost);
	        logger.info("Clicked on Post button");
	        
	        String NewTextPost = BasePage.CaptureMsg(bp.txtnewpost);
	        if(NewTextPost.equals(p.getProperty("SampleText"))) {
	        	logger.info("Text Post Updated Successfully...");
	        	Assert.assertTrue(true);
	        }
	        else {
	        	Assert.assertTrue(false);
	        }
	        logger.info("TC01_Buzzpage Completed..");
	  }catch(Exception e)
  	{
  		logger.error("Test Failed - " + e.getMessage());
         Assert.fail();
  	}

  }
}
