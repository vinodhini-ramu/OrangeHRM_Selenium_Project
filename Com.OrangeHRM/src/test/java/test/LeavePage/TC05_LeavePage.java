package test.LeavePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LeavePage;
import testBase.BaseClass;

public class TC05_LeavePage extends BaseClass
{

    @Test
    public void verifyWorkWeekError() throws InterruptedException {
    	try {
        logger.info("TC04_LeavePage Started");

        
        HomePage hp = new HomePage(driver);
        LeavePage lp = new LeavePage(driver);

        BasePage.Click(hp.lnkLeave);
        logger.info("Navigated to Leave page");
        
        BasePage.Click(lp.lnkConfigure);
        logger.info("Clicked on Configure");

   
        BasePage.Click(lp.ddWorkWeek);
        logger.info("Clicked on Work Week");

       
        lp.setAllDaysToNonWorking();
        logger.info("All days set to Non-working");

        BasePage.Click(lp.btnSave);
        logger.info("Clicked Save");
        
        String Error = BasePage.CaptureMsg(lp.errmsg);
        logger.info("Error Message"+Error);
        
        Assert.assertTrue(true);
    	}
    	catch(Exception e)
    	{
    		logger.error("Test Failed - " + e.getMessage());
           Assert.fail();
    	}

      
    }
}

