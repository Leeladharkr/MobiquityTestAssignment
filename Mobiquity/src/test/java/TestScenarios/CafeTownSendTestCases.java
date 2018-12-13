package TestScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.driver;
import FunctionalLibraries.FunctionLibraries;
import PageObjects.CreateEmployeePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Util.TestUtil;

/* ******************************************************
 * @Author Leeladhar -----------------------
 * 
 * This class will create all the tests 
 * 
 * 
 * *******************************************************
 */


public class CafeTownSendTestCases extends driver
{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	CreateEmployeePage createEmployee = new CreateEmployeePage();
	FunctionLibraries FuncLib = new FunctionLibraries();
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "CreateEmployee" , priority=0)
	public void CreateNewEmployee(String FirstName, String LastName , String StartDate, String EmailID)
	{	
		FuncLib.LoginToApplication();
		// Click on create button to create new employee
		homePage.clickOnCreateButton();
		
		// Type First Name of the employee
		createEmployee.typeEmployeeFirstName(FirstName);
		
		// Type Last Name of the employee
		createEmployee.typeEmployeeLastName(LastName);
		
		// Type date
		createEmployee.typeEmployeeStartDate(StartDate);
		
		// Type email id of the employee
		createEmployee.typeEmployeeEmailId(EmailID);
		
		// Click on add Employee button
		createEmployee.clickOnAddEmployeeButton();
		
		// verify the new employee created
		//String employee = "LeeluTestFirstName LeeluTestLastName";
		homePage.SearchEmployee(FirstName + " " + LastName);
		System.out.println("The new employee " + FirstName + " " + LastName + "has been created successfully !");
	}

	@Test(dataProviderClass = TestUtil.class, dataProvider = "CreateEmployee" , priority=1)
	public void UpdateEmployeeDetail(String FirstName, String LastName , String StartDate, String EmailID)
	{
		FuncLib.LoginToApplication();
		
		homePage.doubleClickOnSearchedEmployee(FirstName + " " + LastName);

		//Update the details of the employee
		// Type First Name of the employee
		FirstName = FirstName + "_Updated";
		LastName = LastName + "_Updated";
		createEmployee.typeEmployeeFirstName(FirstName);
				
		// Type Last Name of the employee
		createEmployee.typeEmployeeLastName(LastName);
				
		// Type date
		createEmployee.typeEmployeeStartDate(StartDate);
				
		// Type email id of the employee
		createEmployee.typeEmployeeEmailId(EmailID);
				
		// Click on add Employee button
		createEmployee.clickOnUpdateEmployeeDetailButton();
		
		String employeeUpdated = (FirstName + " " + LastName);
	
		Assert.assertEquals(homePage.SearchEmployee(employeeUpdated), employeeUpdated);
		System.out.println("The details of the employee has been updated successfully !");
		
	}
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "CreateEmployee" , priority=2)
	public void DeleteEmployee(String FirstName, String LastName , String StartDate, String EmailID)
	{
		FirstName = FirstName + "_Updated";
		LastName = LastName + "_Updated"; 
		
		FuncLib.LoginToApplication();
		
		String employeeUpdated = FirstName + " " + LastName;
		homePage.doubleClickOnSearchedEmployee(employeeUpdated);
		
		//Click on Delete Button and then Accept the Alert 
		createEmployee.clickOnDeleteEmployeeButton();
		
		//Search Deleted Employee 
		Assert.assertNotEquals(homePage.SearchEmployee(employeeUpdated), employeeUpdated, employeeUpdated+" has not been deleted!");
	}

}
