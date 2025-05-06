package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_AddEmp_01 extends BaseClass
{
@Test(dataProvider ="EmployeeData", dataProviderClass=DataProviders.class )
public void validAddEmployee(String fname, String mname, String lname)
{
	try {
	logger.info("****TC_AddEmp_01 Started****");
	HomePage hp = new HomePage(driver);
	hp.clickPIM();
	PIMPage  pp = new PIMPage(driver);
	pp.clkaddemployee();
	
	logger.info("adding employeee");
	pp.setfirstname(fname);
	pp.setmiddlename(mname);
	pp.setlastname(lname);
	pp.clicksave();
	
	boolean prsnldetailpg = pp.isempnameDisplayed();

	if(prsnldetailpg==true)
	{
		logger.info("employee added sucessfully");
		pp.clkaddemployee();
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	logger.info("****TC_AddEmp_01 Completed****");
	}catch(Exception e)
	{
		Assert.fail();
	}
}
}

