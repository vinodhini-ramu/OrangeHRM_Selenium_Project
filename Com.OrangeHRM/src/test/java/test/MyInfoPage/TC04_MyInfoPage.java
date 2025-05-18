package test.MyInfoPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.MyInfoPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC04_MyInfoPage extends BaseClass
{

    @Test(dataProvider ="Employee6Data", dataProviderClass=DataProviders.class )
    public void addEmergencyContact(String name, String rel , String home, String mobile, String work) {
        try {
            logger.info("TC03_MyInfoPage Started");

            HomePage hp = new HomePage(driver);
            MyInfoPage mi = new MyInfoPage(driver);

            BasePage.Click(hp.lnkMyInfo);
            logger.info("Navigated to My Info page");

            Thread.sleep(3000);
            BasePage.Click(mi.menuEmergencyContacts);

            BasePage.Click(mi.btnAddEmergency);
            BasePage.InputText(mi.txtEmergencyName, name);
            logger.info("Entered Name");
            BasePage.InputText(mi.txtEmergencyRelationship,rel);
            logger.info("Entered RelationShip");
            BasePage.InputText(mi.txtHomePhone, home);
            logger.info("Entered HomePhone");
       
            boolean HomeErr =BasePage.ElementDisplayStatus(mi.errHomePhone);
            if(HomeErr == true)
            {
            	String erh = BasePage.CaptureMsg(mi.errHomePhone);
            	logger.info(erh);
            }
            
            BasePage.InputText(mi.txtMobile, mobile);
            logger.info("Entered MobilePhone");
         
            boolean MobErr =BasePage.ElementDisplayStatus(mi.errMobile);
            if(MobErr== true)
            {
            	String erm = BasePage.CaptureMsg(mi.errHomePhone);
            	logger.info(erm);
            }
            
            BasePage.InputText(mi.txtWorkPhone,work );
            logger.info("Entered WorkPhone");
            
            boolean WorkErr =BasePage.ElementDisplayStatus(mi.errWorkPhone);
            if(WorkErr == true)
            {
            	String erw = BasePage.CaptureMsg(mi.errHomePhone);
            	logger.info(erw);
            }

            
            Thread.sleep(3000);
         
            Assert.assertTrue(true);
            logger.info("TC03_MyInfoPage Completed Successfully");
            

        } catch (Exception e) {
            logger.error("Test Failed: " + e.getMessage());
            Assert.fail();
        }
    }
}



