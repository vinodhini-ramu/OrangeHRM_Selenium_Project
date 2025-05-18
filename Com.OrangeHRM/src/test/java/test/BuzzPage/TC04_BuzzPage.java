package test.BuzzPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.BuzzPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC04_BuzzPage extends BaseClass
{
	 @Test
	    public void verifyLikeButtonIncreasesCount() {
	        try {
	            logger.info("TC04_BuzzPage Started");

	            HomePage hp = new HomePage(driver);
	            BuzzPage bp = new BuzzPage(driver);

	           
	            BasePage.Click(hp.lnkBuzz);
	            logger.info("Clicked on Buzz link");


	            Thread.sleep(2000); 
	            
	            String likeCountBeforeStr = BasePage.CaptureMsg(bp.lblLikeCount).replaceAll("[^0-9]", "");
	            int likeCountBefore = likeCountBeforeStr.isEmpty() ? 0 : Integer.parseInt(likeCountBeforeStr);
	            logger.info("Like count before clicking: " + likeCountBefore);

	          
	            BasePage.Click(bp.btnLikeHeart);
	            logger.info("Clicked on Like (heart) icon");

	            Thread.sleep(2000); 

	            String likeCountAfterStr = BasePage.CaptureMsg(bp.lblLikeCount).replaceAll("[^0-9]", "");
	            int likeCountAfter = likeCountAfterStr.isEmpty() ? 0 : Integer.parseInt(likeCountAfterStr);
	            logger.info("Like count after clicking: " + likeCountAfter);

	            Assert.assertEquals(likeCountAfter, likeCountBefore + 1);

	            logger.info("TC04_BuzzPage - Like count increased as expected. Test Passed.");

	        } catch (Exception e) {
	            logger.error("Test Failed: " + e.getMessage());
	            Assert.fail();
	        }
	    }
	}


