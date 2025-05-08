package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC06_EmpList extends BaseClass 
{

	@Test
	public void SearchEmp_byEmpSts() throws InterruptedException
	{
	   try {
		   logger.info("*** TC06 - Started ***");
		 HomePage hp = new HomePage(driver);
         hp.clickPIM();

         PIMPage pp = new PIMPage(driver);
        
         
	
    List<String> statuses = pp.getAllEmploymentStatuses();
   
    for (String status : statuses) 
    {
        logger.info("Employmentstatus: " + status);
        pp.selectEmploymentStatus(status);
        pp.clkSearch();

        Thread.sleep(2000);
        
        if (pp.isNoRecordFound()) {
            logger.info("→ No Records Found");
            Assert.assertTrue(true);
        } else {
            List<String> names = pp.getAllFirstNames();
            for (String name : names) {
                logger.info(name);
            }
            Assert.assertTrue(true);
        }
    }
}
catch(Exception e)
    {
    	logger.error(e.getMessage());
    	Assert.fail();
    }
    }
}
