package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;

public class TC04_EmpList extends BaseClass 
{
@Test()
 public void searchByvalidEmpname()
 { try {
	 logger.info("*****TC04_EmpList  Started*****");
	HomePage hp = new HomePage(driver);
	hp.clickPIM();
	PIMPage pp = new PIMPage(driver);
	String EmpName=pp.getEmpname();
	pp.search_Emp_name(EmpName);
	pp.clkSearch();
	
	if(pp.emp_record_msg()==true)
	{
		logger.info("Employee name satus:"+pp.getrecordsts());
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	 logger.info("*****TC04_EmpList  completed*****");
 }catch(Exception e) {
	 e.getMessage();
	 Assert.fail();
	 }
	
}
}
