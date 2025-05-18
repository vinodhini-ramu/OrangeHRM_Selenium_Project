package test.TimePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.TimePage;
import testBase.BaseClass;

public class TC05_TimePage extends BaseClass{
	@Test
	public void disable_PunchInOut_Field()
	{
		try {
            logger.info(" TC05_TimePage Started");

            HomePage hp = new HomePage(driver);
            TimePage tp = new TimePage(driver);

 
            BasePage.Click(hp.lnkTime);
            logger.info("Clicked on Time");

            BasePage.Click(tp.lnkAttendance);
            logger.info("Clicked on Attendance");

            BasePage.Click(tp.drpdnConfig);
            logger.info("Clicked on Configuration");

            Thread.sleep(5000);
            BasePage.Click(tp.chkboxopt1);
            logger.info("Unchecked 'Employee can change current time when punching in/out'");
            

            BasePage.Click(tp.btnsave);
            logger.info("Clicked Save button in Configuration");

           
            BasePage.Click(tp.lnkAttendance);
            logger.info("Re-clicked on Attendance");

            BasePage.Click(tp.drpdnPunchIn);
            logger.info("Clicked on Punch In menu");

      
            boolean isDateDisabled = !tp.dateField.isEnabled();
            boolean isTimeDisabled = !tp.timeField.isEnabled();

            logger.info("Date Field Enabled: " + tp.dateField.isEnabled());
            logger.info("Time Field Enabled: " + tp.timeField.isEnabled());

            Assert.assertTrue(isDateDisabled);
            Assert.assertTrue(isTimeDisabled);

            logger.info(" TC05_TimePage Completed ");

        } catch (Exception e) {
            logger.error("Test failed due to exception: " + e.getMessage());
            Assert.fail("Test case failed due to exception.");
        }
    }

	}


