package BasePackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/* ******************************************************
 * @Author Leeladhar -----------------------
 * 
 * This class will create the WebDriver Instance which will be used across all other classes
 * 
 * 
 * *******************************************************
 */

public class driver 
{
	public static WebDriver driver = null;
	public static String URL;
	public static String UserName;
	public static String Password;
	
	/* ******************************************************
	 * @Author Leeladhar -----------------------
	 * 
	 * This method will read the values from the config file which contains the URL and login credentials.
	 * 
	 * 
	 * *******************************************************
	 */
	
	@BeforeClass
	public void readProperty()
	{
		Properties prop = new Properties();
		InputStream input = null;

	    try {

	    	input = getClass().getClassLoader().getResourceAsStream("Config.properties");

	        // load a properties file
	        prop.load(input);

	        // get the property value and print it out
	        URL = prop.getProperty("URL");
	        UserName = prop.getProperty("UserName");
	        Password = prop.getProperty("Password");

	    } catch (IOException ex) 
	    {
	        ex.printStackTrace();
	    } finally 
	    {
	        if (input != null) 
	        {
	            try 
	            {
	                input.close();
	            } catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	/* ******************************************************
	 * @Author Leeladhar -----------------------
	 * 
	 * This method will Launch the chrome browser and loads the url
	 * *******************************************************
	 */
	@BeforeMethod
	public void OpenApplication()
	{
		Reporter.log("-----------Starting a new Chrome Browser Session-------------");
		String url = ClassLoader.getSystemResource("chromedriver.exe").getPath();
		System.setProperty("webdriver.chrome.driver",url);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		Assert.assertEquals("CafeTownsend-AngularJS-Rails", driver.getTitle());
		
	}
	/* ******************************************************
	 * @Author Leeladhar -----------------------
	 * 
	 * This method close the WebDriver instance
	 * *******************************************************
	 */
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		Reporter.log("-----------Ended Chrome Browser Session-------------");
	}
	
}
