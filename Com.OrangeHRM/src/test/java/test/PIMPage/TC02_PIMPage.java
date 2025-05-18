package test.PIMPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC02_PIMPage extends BaseClass 
{
	@Test(dataProvider ="Employee1Data", dataProviderClass=DataProviders.class )
	public void invalidAddEmployee(String fname, String mname, String lname)
	{
		try {
		logger.info("****TC02_AddEmp Started****");
		HomePage hp = new HomePage(driver);
		PIMPage  pp = new PIMPage(driver);
		
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
		
		
		boolean fname_required_msg = BasePage.ElementDisplayStatus(pp.msgfnamerequired);
		boolean lname_required_msg = BasePage.ElementDisplayStatus(pp.msglnamerequired);
		
		if(fname_required_msg==true  && lname_required_msg==false)
		{  
			logger.info("Employee cannot be added");
			logger.info("FirstName required");
		}
		driver.navigate().refresh();
		
		if(lname_required_msg==true  && fname_required_msg==false)
		{
			logger.info("Employee cannot be added");
			logger.info("LastName required");
		}
		driver.navigate().refresh();
		
		if(fname_required_msg==true  && lname_required_msg==true)
		{
			logger.info("Employee cannot be added");
			logger.info("FirstName and LastName required");
		}
		driver.navigate().refresh();

		
		   logger.info("****TC02_AddEmp Completed****");
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			Assert.fail();
		}
   }
}
