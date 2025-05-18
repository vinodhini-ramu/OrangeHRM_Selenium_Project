package pageObjects;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 public class BasePage 
{
   public static WebDriver driver;
   
   
   public BasePage(WebDriver driver)
   {
	   BasePage.driver= driver;
	   PageFactory.initElements(driver, this);
   }
   
   static public void InputText(WebElement element, String txt)
	{
	   element.sendKeys(txt);
	}
   
   static public void Click(WebElement element)
	{
	   element.click();
	}
   
   static public void Clear(WebElement element)
   {
	   element.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	 //  element.clear();
   }
   static public void ClearAndType(WebElement element, String txt)
   {
	  
	   element.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	   element.sendKeys(txt);
   }
   
   static public String CaptureMsg(WebElement element)
   {
	   return element.getText();
   }
   
   static public int GetNoOfElements(List<WebElement> element)
   {
	   return element.size();
   }
   
   static public void EnterKey(WebElement element)
   {
	   element.sendKeys(Keys.ENTER);
   }
   static public boolean ElementDisplayStatus(WebElement element)
	{
		try 
		{
		return element.isDisplayed();
	    }
		catch(Exception e)
		{
			System.out.println("Element not found"+e.getMessage());
			return false;
		}
	
	}
   static public boolean ElementEnabledStatus(WebElement element)
	{
		try 
		{
		return element.isEnabled();
	    }
		catch(Exception e)
		{
			System.out.println("Element not found"+e.getMessage());
			return false;
		}
	
	}
   static public boolean ElementSelectedStatus(WebElement element)
 	{
 		try 
 		{
 		return element.isSelected();
 	    }
 		catch(Exception e)
 		{
 			System.out.println("Element not found"+e.getMessage());
 			return false;
 		}
 	
 	}
   static public WebElement waitForElementVisible(WebElement element) {
       return new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.visibilityOfElementLocated((By) element));
   }

   static public WebElement waitForElementClickable(WebElement element) {
       return new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.elementToBeClickable(element));
   }

   static public WebElement waitForPresenceOfElement(WebElement txtFName) {
       return new WebDriverWait(driver, Duration.ofSeconds(20))
               .until(ExpectedConditions.presenceOfElementLocated((By) txtFName));
   }
   
   static public void scrollToElement(By element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
   
   
}
