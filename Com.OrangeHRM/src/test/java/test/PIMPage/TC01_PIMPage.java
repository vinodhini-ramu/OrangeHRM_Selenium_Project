package test.PIMPage;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC01_PIMPage extends BaseClass
{
@Test(dataProvider ="EmployeeData", dataProviderClass=DataProviders.class )
public void validAddEmployee(String fname, String mname, String lname)
{
	try {
	logger.info("****TC01_AddEmp Started****");
	HomePage hp = new HomePage(driver);
	PIMPage pp = new PIMPage(driver);
	BasePage.Click(hp.lnkPIM);
	logger.info(" Clicked PIM link");
	BasePage.Click(pp.lnkaddemployee);
	logger.info(" Clicked Add Employee");
	
	
	logger.info("***  adding new employeee ***");
	BasePage.InputText(pp.txtfstname, fname);
	logger.info("Entered Firstname");
	BasePage.InputText(pp.txtmidname, mname);
	logger.info("Entered Middlename");
	BasePage.InputText(pp.txtlstname, lname);
	logger.info("Entered lastname");
	BasePage.Click(pp.btnsave);
	logger.info("Clicked Save Button");

	
	boolean prsnldetailpg = BasePage.ElementDisplayStatus(hp.txtDashBoard);

	if(prsnldetailpg==true)
	 {
		logger.info("employee added sucessfully");
		BasePage.Click(pp.lnkaddemployee);
		Assert.assertTrue(true);
	 }
	else
	 {
		Assert.assertTrue(false);
	 }
	logger.info("****TC01_AddEmp Completed****");
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		Assert.fail();
	}
}
}

