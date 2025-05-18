package test.LeavePage;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LeavePage;
import testBase.BaseClass;

public class TC03_LeavePage extends BaseClass {
	@Test
	public void DeSelectallSelectedOpt()
	{
		try {
            logger.info("TC03_LeavePage Started");
            
            HomePage hp = new HomePage(driver);
            LeavePage lp = new LeavePage(driver);

            BasePage.Click(hp.lnkLeave);
            logger.info("Navigated to Leave page");
            
            BasePage.Click(lp.lnkMyLeave);
            logger.info("Clicked on Myleave");
            
          /*  BasePage.Click(lp.clrCancelled);
            logger.info("DeSelected Cancelled option");
            
            BasePage.Click(lp.clrPending);
            logger.info("DeSelected Pending option");
            
            BasePage.Click(lp.clrRejected);
            logger.info("DeSelected Rejected option");
            
            BasePage.Click(lp.clrScheduled);
            logger.info("DeSelected Scheduled option");
            
            BasePage.Click(lp.clrTaken);
            logger.info("DeSelected Taken option");   */
            
            List<WebElement> selectedopt = lp.selectedopt;
            int totselectedopt =  selectedopt.size();
            for (int i = 0; i <totselectedopt; i++) 
            {
				BasePage.Click(lp.clrallopt);
				Thread.sleep(2000);
			}

            logger.info("DeSelected all the options");
            
            if(BasePage.ElementDisplayStatus(lp.msgreq)) {
            	logger.info("Successfully Deselected all the Selected option");
                 Assert.assertTrue(true);
            }
            else
            {
            	Assert.assertTrue(false);
            }
		}
		catch(Exception e)
		{
			logger.error("Test Failed - " + e.getMessage());
            Assert.fail();
		}
	}

}
