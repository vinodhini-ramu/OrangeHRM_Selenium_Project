package testBase;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.BasePage;
import pageObjects.LoginPage;

public class BaseClass 
{
	static public WebDriver driver;
	static public Properties p;
	static public Logger logger;
	static public FileInputStream file;
	
	static public void getbrowser(String br)
	{
		 switch(br)
		    {
		    case "chrome" : driver = new ChromeDriver(); break;
		    case "edge"   : driver = new EdgeDriver(); break;
		    case "firefox": driver = new FirefoxDriver(); break;
		    default : System.out.println("invalid browser");return;
		    }
		    
	}
@BeforeClass
@Parameters({"browser"})

    public void setup(String br) throws IOException 
    {   
        file = new FileInputStream(".\\src\\test\\resources\\config.properties");
     	p = new Properties();
    	p.load(file);
    	
    	logger=LogManager.getLogger(this.getClass());
    	
	    getbrowser(br);
	    
	    driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get(p.getProperty("url"));
    	
    	LoginPage lp = new LoginPage(driver);
    	
    	BasePage.InputText(lp.txt_username, p.getProperty("username"));
    	logger.info("Entered username");
        BasePage.InputText(lp.txt_password, p.getProperty("password"));
        logger.info("Entered password");
    	BasePage.Click(lp.btn_login);
    	logger.info("Clicked Login button");
    }
@AfterClass
   public void closeWindow() 
   {
	   driver.close();
	   driver.quit();
   }
public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;
}
public String captureScreenforfail(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshotsOfFailed\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;
}
}

