package FunctionalLibraries;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import BasePackage.driver;
import PageObjects.HomePage;
import PageObjects.LoginPage;

/* ******************************************************
 * @Author Leeladhar -----------------------
 * 
 * This class will create Application functional libraries which can be reused in any of the classes
 * 
 * 
 * *******************************************************
 */

public class FunctionLibraries extends driver
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	
	public void LoginToApplication()
	{
		//type username
		loginPage.typeUserName(UserName);
		
		//type password
		loginPage.typePassword(Password);
		
		//click on login page
		loginPage.clickOnLoginButton();
		
		//verify if the logged in user name is dispalyed on home page
		Assert.assertEquals(homePage.getLoggedInUserName(), "Hello "+UserName);
	}
}
