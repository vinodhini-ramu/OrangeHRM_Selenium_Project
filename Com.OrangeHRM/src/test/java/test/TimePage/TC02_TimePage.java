package test.TimePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.TimePage;
import testBase.BaseClass;

public class TC02_TimePage extends BaseClass {
	@Test
	public void punchInWithoutNote() {
	    try {
	        logger.info("  TC08_TimePage Started  ");
	        HomePage hp = new HomePage(driver); 
	        TimePage tp = new TimePage(driver);

	        BasePage.Click(hp.lnkTime);
	        logger.info("Navigated to 'Time Page'.");

	        BasePage.Click(tp.lnkAttendance);
	        logger.info("Clicked on 'Attendance' submenu.");

	        BasePage.Click(tp.drpdnPunchIn);
	        logger.info("Selected 'Punch In/Out' from dropdown.");

	        boolean punchInOutPageVisible = BasePage.ElementDisplayStatus(tp.titleInOut);
	        String punchInOutTitle = BasePage.CaptureMsg(tp.titleInOut);

	        if (punchInOutPageVisible && punchInOutTitle.equals("Punch In")) {
	            logger.info("'Punch In' page is displayed.");

	        
	            logger.info("Leaving the 'Note' field blank.");

	            BasePage.Click(tp.btnInOut);
	            logger.info("Clicked on 'Punch In' button.");
	            Thread.sleep(5000);

	            punchInOutTitle = BasePage.CaptureMsg(tp.titleInOut);
	            if (punchInOutTitle.equals("Punch Out")) {
	                logger.info("Successfully punched in without note. 'Punch Out' now visible.");
	                Assert.assertTrue(true);
	            } else {
	                logger.warn("Punch In action may have failed. Title did not change.");
	                Assert.assertTrue(false);
	            }

	        } else if (punchInOutPageVisible && punchInOutTitle.equals("Punch Out")) {
	            logger.info("'Punch Out' page is displayed.");

	            logger.info("Leaving the 'Note' field blank.");
	            Thread.sleep(5000);
	            BasePage.Click(tp.btnInOut);
	            logger.info("Clicked on 'Punch Out' button.");
	            Thread.sleep(5000);

	            punchInOutTitle = BasePage.CaptureMsg(tp.titleInOut);
	            if (punchInOutTitle.equals("Punch In")) {
	                logger.info("Successfully punched out without note. 'Punch In' now visible.");
	                Assert.assertTrue(true);
	            } else {
	                logger.warn("Punch Out action may have failed. Title did not change.");
	                Assert.assertTrue(false);
	            }

	        } else {
	            logger.error("'Punch In' or 'Punch Out' page is not visible or title is incorrect.");
	            Assert.assertTrue(false);
	        }

	        logger.info("  TC08_TimePage Completed  ");
	    } catch (Exception e) {
	        logger.error("Exception occurred during Punch In/Out without note: " + e.getMessage());
	        Assert.fail("Test failed due to exception.");
	    }
	}


}
