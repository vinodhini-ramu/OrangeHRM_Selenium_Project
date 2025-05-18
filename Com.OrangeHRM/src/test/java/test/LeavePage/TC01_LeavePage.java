package test.LeavePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LeavePage;
import testBase.BaseClass;

public class TC01_LeavePage extends BaseClass
{
    @Test
    public void ApplyLeaveOneday()
    {
    	try {
            logger.info("TC01_LeavePage Started");
            
            HomePage hp = new HomePage(driver);
            LeavePage lp = new LeavePage(driver);

            BasePage.Click(hp.lnkLeave);
            logger.info("Navigated to Leave page");

            BasePage.Click(lp.lnkApply);
            logger.info("Clicked Apply");

            BasePage.Click(lp.ddLeaveType);
            
            BasePage.Click(lp.firstLeaveOption);
            logger.info("Leave type selected");

            String balance = BasePage.CaptureMsg(lp.lblLeaveBalance);
            logger.info("Leave balance available: " + balance);
            
            if(balance.equals("0.00 Day(s)"))
            {
            	logger.info("leave Balance is not sufficient..");
            }
            else {
            BasePage.InputText(lp.txtFromDate, p.getProperty("FromDate"));
            logger.info("Entered From Date");
            BasePage.InputText(lp.txtToDate, p.getProperty("ToDate"));
            logger.info("Entered To Date");

            lp.btnApply.click();
            logger.info("Clicked Apply button");

            String title = BasePage.CaptureMsg(lp.titlrApplyLeave);
            boolean titlepresent = title.equals("Apply Leave");
            if(titlepresent==true)
            {
            	logger.info("Leave Applied Sucessfully");
            	 Assert.assertTrue(titlepresent);
            }
            else
            {
            	Assert.assertTrue(false);
            }
            }
            
        } catch (Exception e) {
            logger.error("Test Failed - " + e.getMessage());
            Assert.fail();;
        }
    }

    }

