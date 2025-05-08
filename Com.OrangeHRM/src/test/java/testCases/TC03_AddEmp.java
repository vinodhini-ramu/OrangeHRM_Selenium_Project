package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_AddEmp extends BaseClass
{
	@Test(dataProvider="Employee2Data",dataProviderClass=DataProviders.class)
	public void validEmloyeeId(String fname, String mname, String lname, String empid) throws InterruptedException 
	{ try {
		logger.info("****TC03_AddEmp Started****");
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		PIMPage  pp = new PIMPage(driver);
		pp.clkaddemployee();
		
		logger.info("adding employeee");
		pp.setfirstname(fname);
		pp.setmiddlename(mname);
		pp.setlastname(lname);
		pp.clremployeeid();
		pp.setemployeeid(empid);
		logger.info("set new employee id");
		pp.clicksave();
		
		boolean prsnldetailpg = pp.isempnameDisplayed();

		if(prsnldetailpg==true)
		{
			logger.info("employee added sucessfully");
			pp.clkaddemployee();
			Assert.assertTrue(true);
		}
		else if(pp.ds_empId_err_msg()==true)
		{
			logger.info("error msg:"+pp.empId_err_msg());
			driver.navigate().refresh();
		}
		else
		{
			Assert.assertTrue(false);
		}
	}catch(Exception e)
	{
		Assert.fail();
	}
	}

}
