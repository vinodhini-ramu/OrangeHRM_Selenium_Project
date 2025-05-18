package test.TimePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.TimePage;
import testBase.BaseClass;

public class TC01_TimePage extends BaseClass
{
	@Test
	public void punchIn_Witn_validTime()
	{
			try {
				logger.info("  TC08_TimePage Started  ");
			    HomePage hp = new HomePage(driver); 
			    TimePage tp = new TimePage(driver);

			    BasePage.Click(hp.lnkTime);
			    logger.info("Navigated to 'Time Page'");

			    BasePage.Click(tp.lnkAttendance);
			    logger.info("Clicked on 'Attendance' submenu.");

			    BasePage.Click(tp.drpdnPunchIn);
			    logger.info("Selected 'Punch In' from dropdown.");

			    boolean PunchInOutPage = BasePage.ElementDisplayStatus(tp.titleInOut);
			    String PunchInOutTitle = BasePage.CaptureMsg(tp.titleInOut);

			    if (PunchInOutPage == true && PunchInOutTitle.equals("Punch In")) 
			    {
			        logger.info("'Punch In' page is displayed with correct title.");

			        String note = p.getProperty("punchInNote");			        
			        BasePage.InputText(tp.txtnote, note);
			        logger.info("Entered note: " + note);
			     
			        BasePage.Click(tp.btnInOut);
			        logger.info("Clicked on 'Punch In' button.");
			        Thread.sleep(5000);

			        PunchInOutTitle = BasePage.CaptureMsg(tp.titleInOut);
			        if (PunchInOutTitle.equals("Punch Out")) 
			        {
			            logger.info("Successfully punched in. 'Punch Out' option now visible.");
			            Assert.assertTrue(true);
			        } else {
			            logger.info("Punch In Title did not change to 'Punch Out'.");
			            Assert.assertTrue(false);
			        }

			    } else if(PunchInOutPage == true && PunchInOutTitle.equals("Punch Out")) 
			    {
			    	logger.info("'Punch Out' page is displayed with correct title.");

			        String note = p.getProperty("punchOutNote");			        
			        BasePage.InputText(tp.txtnote, note);
			        logger.info("Entered note: " + note);
			     
			        Thread.sleep(5000);
			        BasePage.Click(tp.btnInOut);
			        logger.info("Clicked on 'Punch Out' button.");
			        Thread.sleep(5000);

			        PunchInOutTitle = BasePage.CaptureMsg(tp.titleInOut);
			        if (PunchInOutTitle.equals("Punch In")) 
			        {
			            logger.info("Successfully punched Out. 'Punch In' option now visible.");
			            Assert.assertTrue(true);
			        } else {
			            logger.info("Punch Out Title did not change to 'Punch In'.");
			            Assert.assertTrue(false);
			        }
			    }
			        else {
			        	logger.error("'Punch In' or 'Punch Out' page is not visible or title is incorrect.");
				        Assert.assertTrue(false);
			        }
			
			    logger.info("  TC08_TimePage Completed  ");
			} catch (Exception e) {
			    logger.error(e.getMessage());
			    Assert.fail("Test failed");
			}
			
		
		
	}
	

    
}
