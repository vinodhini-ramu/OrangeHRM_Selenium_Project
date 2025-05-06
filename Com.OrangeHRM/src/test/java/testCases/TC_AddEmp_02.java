package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_AddEmp_02 extends BaseClass 
{
	@Test(dataProvider ="Employee1Data", dataProviderClass=DataProviders.class )
	public void invalidAddEmployee(String fname, String mname, String lname)
	{
		try {
		logger.info("****TC_AddEmp_02 Started****");
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		PIMPage  pp = new PIMPage(driver);
		pp.clkaddemployee();
		
		logger.info("adding employeee");
		pp.setfirstname(fname);
		pp.setmiddlename(mname);
		pp.setlastname(lname);
		pp.clicksave();
		logger.info("Employee cannot be added");
		boolean msg1 = pp.fname_Field_msg();
		boolean msg2 = pp.lname_Field_msg();
		
		if(msg1==true  && msg2==false)
		{
			logger.info("FirstName required");
		}
		driver.navigate().refresh();
		
		if(msg2==true  && msg1==false)
		{
			logger.info("LastName required");
		}
		driver.navigate().refresh();
		
		if(msg1==true  && msg2==true)
		{
			logger.info("FirstName required and LastName required");
		}
		driver.navigate().refresh();

		
		logger.info("****TC_AddEmp_02 Completed****");
		}catch(Exception e)
		{
			Assert.fail();
		}
   }
}
