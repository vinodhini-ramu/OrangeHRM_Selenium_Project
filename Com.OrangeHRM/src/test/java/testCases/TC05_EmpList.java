package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.PIMPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC05_EmpList extends BaseClass {

    @Test(dataProvider ="Employee3Data", dataProviderClass=DataProviders.class)
    public void searchByInvalidEmpname(String empname) {
        try {
            logger.info("*****TC05_EmpList Started*****");

            HomePage hp = new HomePage(driver);
            hp.clickPIM();

            PIMPage pp = new PIMPage(driver);
            pp.search_Emp_name(empname);
            pp.clkSearch();
            
            Thread.sleep(2000);
     	     
            if (pp.emp_record_msg()==true) {
                logger.info("Employee name status: " + pp.getrecordsts());
                Assert.assertTrue(true, "Record not found as expected.");
            } else {
                logger.error("Expected 'No Records Found' but got something else.");
                Assert.fail("Unexpected record found for invalid employee name: " + empname);
            }

            logger.info("*****TC05_EmpList completed*****");

        } catch (Exception e) {
            logger.error("Exception occurred: ", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
