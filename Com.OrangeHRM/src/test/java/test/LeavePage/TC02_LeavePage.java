package test.LeavePage;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LeavePage;
import pageObjects.MyInfoPage;
import testBase.BaseClass;

public class TC02_LeavePage extends BaseClass 
{
	WebDriverWait wait ;
  @Test
  public void AddLeaveEntitlement() 
  {
	        try {
	            logger.info(" TC02_LeavePage Started ");
	            
	            HomePage hp = new HomePage(driver);
	            LeavePage lp = new LeavePage(driver);
	            MyInfoPage mp = new MyInfoPage(driver);

	            BasePage.Click(hp.lnkMyInfo);
	            logger.info("Navigated to MyInfo page");
	            
	            Thread.sleep(3000);
	            
	            String crntuser = BasePage.CaptureMsg(mp.EmpName);
	            logger.info(" Current user name:"+ crntuser);
	            
	            BasePage.Click(hp.lnkLeave);
	            logger.info("Navigated to Leave page");
	            
	            BasePage.Click(lp.lnkEntitlements);
	            logger.info("Opened Entitlement");
	            
	            BasePage.Click(lp.ddAddEntitlements);
	            logger.info("Selected AddEntitlements");
	         

	            BasePage.InputText(lp.txtEmployeename, crntuser);
	            BasePage.Click(lp.autoCompleteFirstOption);
	            logger.info("Entered Employee Name");
	            
	            BasePage.Click(lp.ddLeaveType);
	            BasePage.Click(lp.firstLeaveOption);
	            logger.info("Selected Firstleavetype");
	           
	            BasePage.InputText(lp.txtEntitlement,p.getProperty("Entitlement"));
	            logger.info("Entered Entitlement");
	            
	            BasePage.Click(lp.btnSave);
	            logger.info("Clicked Save");

	            BasePage.Click(lp.btnconfirm);
	            logger.info("Clicked confirm button");
	   
	            
	            String title = BasePage.CaptureMsg(lp.titleLeaveEntitlement);
	            
	            if(title.equals("Leave Entitlements")) {
	            	logger.info("Entitlement added Successfully");
	            	 Assert.assertTrue(true);
	            }
	            else
	            {
	            	Assert.assertTrue(false);
	            }
	           

	        } catch (Exception e) {
	            logger.error("Test failed: " + e.getMessage());
	            Assert.fail();
	        }
	    }
	
  }

