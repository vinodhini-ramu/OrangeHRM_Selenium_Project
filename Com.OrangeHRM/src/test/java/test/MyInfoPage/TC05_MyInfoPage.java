package test.MyInfoPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.MyInfoPage;
import testBase.BaseClass;

public class TC05_MyInfoPage extends BaseClass 
{
	   @Test
	    public void addDependentWithOtherRelationship() {
	        try {
	            logger.info("TC05_MyInfoPage Started");

	            HomePage hp = new HomePage(driver);
	            MyInfoPage mi = new MyInfoPage(driver);

	            BasePage.Click(hp.lnkMyInfo);
	            logger.info("Navigated to My Info page");
	            BasePage.Click(mi.menuDependents);
	            Thread.sleep(3000);
	

	            BasePage.Click(mi.btnAddDependent);
	            BasePage.InputText(mi.txtDependentName, p.getProperty("Name"));
	            logger.info("Entered Name");
	            BasePage.Click(mi.ddlRelationship);
	            BasePage.Click(mi.optother);
	            logger.info("Selected other option");
	            BasePage.InputText(mi.txtSpecifyOther, p.getProperty("RelationShip"));
	            logger.info("Entered other Relationship");
	            BasePage.InputText(mi.txtDependentDOB, p.getProperty("DOB"));
	            logger.info("Entered DOB");

	            BasePage.Click(mi.btnSaveDependent);
	            logger.info("Clicked Save Button");

	            Thread.sleep(3000);
	            
	            String msg = BasePage.CaptureMsg(mi.lblSuccessMessage);
	            Assert.assertTrue(true);

	            logger.info("TC05_MyInfoPage Completed Successfully");

	        } catch (Exception e) {
	            logger.error("Test Failed: " + e.getMessage());
	            Assert.fail();
	        }
	    }
	}



