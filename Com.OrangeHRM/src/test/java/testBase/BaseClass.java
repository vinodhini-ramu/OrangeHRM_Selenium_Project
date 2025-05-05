package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public Properties p;
	public Logger logger;
@BeforeClass
@Parameters({"browser"})

    public void setup(String br) throws IOException 
    {   
      	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\config.properties");
     	p = new Properties();
    	p.load(file);
    	
    	logger=LogManager.getLogger(this.getClass());
    	
	    switch(br)
	    {
	    case "chrome" : driver= new ChromeDriver(); break;
	    case "edge"   : driver= new EdgeDriver(); break;
	    case "firefox": driver= new FirefoxDriver(); break;
	    default : System.out.println("invalid browser");return;
	    }
	    
	    driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get(p.getProperty("url"));
    	
    	LoginPage lp = new LoginPage(driver);
    	lp.setUserName(p.getProperty("username"));
    	lp.setPassword(p.getProperty("password"));
    	lp.clickLogin();
    }
@AfterClass
   public void closeWindow() 
   {
	   driver.close();
	   driver.quit();
   }
}

