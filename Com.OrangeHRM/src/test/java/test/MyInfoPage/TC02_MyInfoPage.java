package test.MyInfoPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.MyInfoPage;
import testBase.BaseClass;

public class TC02_MyInfoPage extends BaseClass
{

    @Test
    public void validateGenderRadioButtons() {
        try {
            logger.info("TC02_MyInfoPage Started");

            HomePage hp = new HomePage(driver);
            MyInfoPage mi = new MyInfoPage(driver);

            BasePage.Click(hp.lnkMyInfo);
            logger.info("Navigated to My Info page");

            Thread.sleep(3000);
            
            BasePage.Click(mi.radioGenderMale);
            Thread.sleep(3000);
            Assert.assertFalse(mi.radioGenderFemale.isSelected());
            logger.info("Male selected, Female deselected");

            BasePage.Click(mi.radioGenderFemale);
            Assert.assertFalse(mi.radioGenderMale.isSelected());
            logger.info("Female selected, Male deselected");

            logger.info("TC02_MyInfoPage Completed Successfully");

        } catch (Exception e) {
            logger.error("Test Failed: " + e.getMessage());
            Assert.fail();
        }
    }
}


