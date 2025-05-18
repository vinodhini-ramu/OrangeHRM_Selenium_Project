package test.PIMPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC04_PIMPage extends BaseClass 
{
@Test()
 public void searchByvalidEmpname()
 { try {
	 logger.info("*****TC04_EmpList  Started*****");
	HomePage hp = new HomePage(driver);
	PIMPage pp = new PIMPage(driver);
	BasePage.Click(hp.lnkPIM);
	
	String EmpName= BasePage.CaptureMsg(pp.emplistname);
	BasePage.InputText(pp.txtSearchEmpname, EmpName);
    BasePage.Click(pp.btnSearch);
	
    boolean emp_record_msg = BasePage.ElementDisplayStatus(pp.msgrecordsts);
    
	if(emp_record_msg==true)
	{
		logger.info("Employee name satus:"+ BasePage.CaptureMsg(pp.msgrecordsts));
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	 logger.info("*****TC04_EmpList  completed*****");
 }
 catch(Exception e) {
	 logger.error(e.getMessage());
	 Assert.fail();
	 }
	
}
}
