package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BasePackage.driver;
import junit.framework.Assert;

/* ******************************************************
 * @Author Leeladhar -----------------------
 * 
 * This class will create objects of home page
 * 
 * 
 * *******************************************************
 */

public class HomePage extends driver
{
	By LoggedInUserName = By.id("greetings");
	By CreateButton = By.id("bAdd");
	By SearchEmployee = By.xpath("//*[@id=\"employee-list\"]/li");
	By LogOutButton = By.xpath("/html/body/div/header/div/p[1]");
	
	public String getLoggedInUserName() 
	{
		return driver.findElement(LoggedInUserName).getText();
		
	}
	
	public void clickOnCreateButton() 
	{
		driver.findElement(CreateButton).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public void clickOnLogOutButton() 
	{
		driver.findElement(LogOutButton).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	
	public String SearchEmployee(String employee)
	{
		String sEmployee = null;
		List<WebElement> allElements = driver.findElements(SearchEmployee); 
			for (WebElement element: allElements) 
			{
			      //System.out.println(element.getText());
			      if (element.getText().equalsIgnoreCase(employee))
			      {
			    	  sEmployee = element.getText();
			    	  break;
			      } else 
			      {
			    	  Assert.assertFalse("Employee "+ employee + " has not found", false);
			    	  sEmployee = "Employee "+ employee + " has not found";
			      }
			}
			return sEmployee;
	}
	
	
	public String doubleClickOnSearchedEmployee(String employee)
	{
		String sEmployee = null;
		Actions action = new Actions(driver);
		List<WebElement> allElements = driver.findElements(SearchEmployee); 
			for (WebElement element: allElements) 
			{
				//System.out.println(element.getText());  
				if (element.getText().equalsIgnoreCase(employee))
			      {
			    	  sEmployee = element.getText();
			    	  action.doubleClick(element).perform();
			    	  break;
			      } else 
			      {
			    	  Assert.assertFalse("Employee "+ employee + " has not been found", false);
			    	  sEmployee = "Employee "+ employee + " has not found";
			      }
			}
			return sEmployee;
			
	}
	
}
