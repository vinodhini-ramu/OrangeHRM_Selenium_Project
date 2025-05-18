package test.MyInfoPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.MyInfoPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC01_MyInfoPage extends BaseClass
{

    @Test(dataProvider ="Employee4Data", dataProviderClass=DataProviders.class )
    public void editPersonalDetails(String fname,String mname,String lname,String empid,String lnum,String lexpd,String dob,String EmpName) 
    {
        try {
            logger.info("TC01_MyInfoPage Started");

            HomePage hp = new HomePage(driver);
            MyInfoPage mi = new MyInfoPage(driver);

            BasePage.Click(hp.lnkMyInfo);
            logger.info("Navigated to My Info page");

            BasePage.waitForPresenceOfElement(mi.txtFName);

            BasePage.ClearAndType(mi.txtFName,fname);
            logger.info("Entered Firstname");
            BasePage.ClearAndType(mi.txtMName,mname);
            logger.info("Entered Middlename");
            BasePage.ClearAndType(mi.txtLName, lname);
        	logger.info("Entered lastname");
            BasePage.ClearAndType(mi.txtEmpId,empid);
            logger.info("Entered EmpId");
            BasePage.ClearAndType(mi.txtDriverLicense,lnum);
            logger.info("Entered License Num");
            BasePage.ClearAndType(mi.txtLicenseExpiry, lexpd);
            logger.info("Entered License Exp Date");

            BasePage.Click(mi.ddlNationality);
            BasePage.Click(mi.optIndian);
            logger.info("Selected Nationality");
            
            BasePage.Click(mi.ddlMaritalStatus);
            BasePage.Click(mi.optMarried);
            logger.info("Selected MaritalStatus");
            
            BasePage.ClearAndType(mi.txtDOB, dob);
            logger.info("Entered DOB");

            BasePage.Click(mi.radioGenderMale);
            logger.info("Selected Male gender");

            BasePage.Click(mi.btnSave);
            logger.info("Clicked Save");

            driver.navigate().refresh();
            logger.info("Page refreshed");
            
            BasePage.waitForElementVisible(mi.lblProfileName);

            String nameDisplayed = BasePage.CaptureMsg(mi.lblProfileName);
            Assert.assertEquals(nameDisplayed, EmpName);

            logger.info("TC01_MyInfoPage Completed Successfully");

        } catch (Exception e) {
            logger.error("Test Failed: " + e.getMessage());
            Assert.fail();
        }
    }
}
