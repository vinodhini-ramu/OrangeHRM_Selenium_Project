package test.PIMPage;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC07_PIMPage extends BaseClass
{
    @Test
    public void Del_EmpBy_EmpSts() throws InterruptedException {
      try { 
    	   logger.info("*** TC07 - Started ***");
    	HomePage hp = new HomePage(driver); 
        PIMPage pp = new PIMPage(driver);
        BasePage.Click(hp.lnkPIM);
        
        BasePage.Click(pp.drpdnempsts);
        Thread.sleep(2000); 
        BasePage.Click(pp.opt_three);
        Thread.sleep(2000); 
        if(pp.isNoRecordFound())
        {
        	 logger.info("→ No Records Found");
             Assert.assertTrue(true);
        }
        else
        {  	
           logger.info(BasePage.CaptureMsg(pp.msgrecordsts)+" →  Attempting to delete...");
            
          BasePage.Click(pp.chkbox);
          BasePage.Click(pp.btndelete);
          BasePage.Click(pp.btnYesdelete);

                Thread.sleep(2000); 
          BasePage.Click(pp.btnSearch);
                logger.info("→ Deletion successful. No records found now.");
                Assert.assertTrue(pp.isNoRecordFound());
            }
        logger.info("*** TC07 - copmleted ***");
        } 
      catch(Exception e) 
      {
          logger.error(e.getMessage());
          Assert.fail();
      }
    }
}
