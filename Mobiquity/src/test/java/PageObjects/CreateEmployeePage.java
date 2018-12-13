package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import BasePackage.driver;

/* ******************************************************
 * @Author Leeladhar -----------------------
 * 
 * This class will create objects of createEmployee page
 * 
 * 
 * *******************************************************
 */

public class CreateEmployeePage extends driver
{
	By EmployeeFirstName = By.xpath("/html/body/div/div/div/form/fieldset/label[1]/input");
	By EmployeeLastName = By.xpath("/html/body/div/div/div/form/fieldset/label[2]/input");
	By EmployeeStartDate = By.xpath("/html/body/div/div/div/form/fieldset/label[3]/input");
	By EmployeeEmailId = By.xpath("/html/body/div/div/div/form/fieldset/label[4]/input");
	By AddEmployeeButton = By.xpath("/html/body/div/div/div/form/fieldset/div/button[2]");
	By UpdateEmployeeDetailButton = By.xpath("/html/body/div/div/div/form/fieldset/div/button[1]");
	By DeleteEmployeeButton = By.xpath("/html/body/div/div/div/form/fieldset/div/p");
	
	
	public void typeEmployeeFirstName(String tEmployeeFirstName)
	{
		driver.findElement(EmployeeFirstName).clear();
		driver.findElement(EmployeeFirstName).sendKeys(tEmployeeFirstName);
	}
	
	public void typeEmployeeLastName(String tEmployeeLastName)
	{
		driver.findElement(EmployeeLastName).clear();
		driver.findElement(EmployeeLastName).sendKeys(tEmployeeLastName);
	}
	
	public void typeEmployeeStartDate(String tEmployeeStartDate)
	{
		driver.findElement(EmployeeStartDate).clear();
		driver.findElement(EmployeeStartDate).sendKeys(tEmployeeStartDate);
	}
	
	public void typeEmployeeEmailId(String tEmployeeEmailId)
	{
		driver.findElement(EmployeeEmailId).clear();
		driver.findElement(EmployeeEmailId).sendKeys(tEmployeeEmailId);
	}
	
	public void clickOnAddEmployeeButton()
	{
		driver.findElement(AddEmployeeButton).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public void clickOnUpdateEmployeeDetailButton()
	{
		driver.findElement(UpdateEmployeeDetailButton).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public void clickOnDeleteEmployeeButton()
	{
		driver.findElement(DeleteEmployeeButton).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}
	
	
}
