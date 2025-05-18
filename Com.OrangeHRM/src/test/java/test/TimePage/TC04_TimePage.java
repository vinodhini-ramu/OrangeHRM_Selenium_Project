package test.TimePage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.TimePage;
import testBase.BaseClass;

public class TC04_TimePage extends BaseClass {
	@Test
    public void verifyInvalidFuturedatedPunchInOut() {
        try {
            logger.info("  TC04_TimePage Started  ");

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

            Assert.assertTrue(PunchInOutPage);
            logger.info("Page title displayed: " + PunchInOutTitle);

        
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, +2);
            String futureDate = new SimpleDateFormat("yyyy-dd-MM").format(calendar.getTime());
      
            BasePage.InputText(tp.dateField, futureDate);  
            logger.info("Entered Futuredated date: " + futureDate);
            Thread.sleep(5000);
         
           
            String dateError = BasePage.CaptureMsg(tp.dateFieldError); 
            Assert.assertTrue(dateError.contains("Overlapping Records Found") ||dateError.contains("Punch out Time Should Be Later Than Punch in Time") || !dateError.isEmpty(), "No error message for backdated entry.");
            logger.info("Date field error displayed: " + dateError);
           
            BasePage.Click(tp.btnInOut);
            logger.info("Clicked on 'Punch In/Out' but cannot Punch In/Out");
          
            String timeError = BasePage.CaptureMsg(tp.timeFieldError); 
            Assert.assertTrue(timeError.contains("Overlapping Records Found") ||timeError.contains("Punch out Time Should Be Later Than Punch in Time") || !timeError.isEmpty(), "No error message for backdated entry.");
            logger.info("Time field error displayed: " + timeError);


            logger.info("  TC04_TimePage Completed  ");

        } catch (Exception e) {
            logger.error("Test execution failed: " + e.getMessage());
            Assert.fail("Test case failed due to exception");
        }
    }
}



