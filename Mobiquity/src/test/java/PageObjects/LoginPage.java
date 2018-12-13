package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import BasePackage.driver;

/**
*@author Leeladhar
*
*This class will store all the locators and methods of Login Page
*
*/

public class LoginPage extends driver
{
	By username = By.xpath("//*[@id=\"login-form\"]/fieldset/label[1]/input");
	By password = By.xpath("//*[@id=\"login-form\"]/fieldset/label[2]/input");
	By Loginbutton = By.xpath("//*[@id=\"login-form\"]/fieldset/button");
	

	public void typeUserName(String textusername)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(textusername);
	}
	
	public void typePassword(String textpassword)
	{
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(textpassword);
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(Loginbutton).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
}
