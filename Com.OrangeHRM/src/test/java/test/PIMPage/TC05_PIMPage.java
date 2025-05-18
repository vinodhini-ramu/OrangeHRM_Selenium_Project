package test.PIMPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC05_PIMPage extends BaseClass {

    @Test(dataProvider ="Employee3Data", dataProviderClass=DataProviders.class)
    public void searchByInvalidEmpname(String empname) {
        try {
            logger.info("*****TC05_EmpList Started*****");

            HomePage hp = new HomePage(driver);
            PIMPage pp = new PIMPage(driver);
            BasePage.Click(hp.lnkPIM);
            
            BasePage.InputText(pp.txtSearchEmpname, empname);
            BasePage.Click(pp.btnSearch);
            
            Thread.sleep(2000);
            boolean emp_record_msg = BasePage.ElementDisplayStatus(pp.msgrecordsts);
            if (emp_record_msg==true) 
            {
                logger.info("Employee name status:"+ BasePage.CaptureMsg(pp.msgrecordsts));
                Assert.assertTrue(true, "Record not found as expected.");
            } else {
                logger.error("Expected 'No Records Found' but got something else.");
                Assert.fail("Unexpected record found for invalid employee name: " + empname);
            }

            logger.info("*****TC05_EmpList completed*****");

        } 
        catch (Exception e) 
        {
            logger.error(e.getMessage());
            Assert.fail();
        }
    }
}
