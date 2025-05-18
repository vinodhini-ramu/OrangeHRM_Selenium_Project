package test.LeavePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LeavePage;
import testBase.BaseClass;

public class TC04_LeavePage extends BaseClass
{
	 static WebDriverWait wait;
	   static JavascriptExecutor js;
@Test
public void ConfigDelHoliday()
{  
    try {
        logger.info("TC04_LeavePage Started");
        
        HomePage hp = new HomePage(driver);
        LeavePage lp = new LeavePage(driver);

        BasePage.Click(hp.lnkLeave);
        logger.info("Navigated to Leave page");
        
        BasePage.Click(lp.lnkConfigure);
        logger.info("Clicked on Configure");
        
        BasePage.Click(lp.ddHolidays);
        logger.info("Selected Holiday dropdown");
        
        BasePage.Click(lp.txtFromDate);
        logger.info("Clicked on From field");
        
        BasePage.Click(lp.lnktoday);
        logger.info("Clicked on today in the fromField");
        
        BasePage.Click(lp.btnSearch);
        logger.info("Clicked on Search button");
        
        String recbefdel = BasePage.CaptureMsg(lp.recordmsg);
        logger.info("No of records before deleting :"+ recbefdel);
        
        
        int rows = BasePage.GetNoOfElements(lp.NoofRows);
        int cols = BasePage.GetNoOfElements(lp.Noofcolumn);
        Thread.sleep(3000);

  
  	  for (int r = 1 ; r <=rows; r++) 
  	  {
  		String name = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div["+r+"]//div[2]/div")).getText();
  		if(name.equals("Victoria Day (Canada)")) 
     	{
  		driver.findElement(By.xpath("//div[@class='oxd-table-body']/div["+r+"]//div[1]//span/i")).click();
  		Thread.sleep(2000);
  		BasePage.Click(lp.btndelete);
  		Thread.sleep(2000);
  		BasePage.Click(lp.btnYesdelete);
  		break;
     	}
  	  }  
  	  
  	   Thread.sleep(2000);
  	   
  	   String recaftdel = BasePage.CaptureMsg(lp.recordmsg);
       logger.info("No of records after deleting :"+ recaftdel);
       
       if(recaftdel != recbefdel) {
    	   logger.info("Successfully deleted Victoria Day (Canada) day");
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
   
      
  	   
  	   
  	   
  	  


