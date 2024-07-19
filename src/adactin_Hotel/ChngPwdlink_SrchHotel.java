package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChngPwdlink_SrchHotel 
{
	@Test
	public void main ()
	{
		try
		{
			System.setProperty("driver.webdriver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.get("https://adactinhotelapp.com/index.php");
			
	
			 driver.findElement(By.id("username")).sendKeys("ADTraining102");
			 driver.findElement(By.id("password")).sendKeys("Password102");
			 
			 driver.findElement(By.id("login")).click();
			 
			 driver.findElement(By.linkText("Change Password")).click();
			 
			 String Spagetitle= driver.getTitle();
			 
			 if (Spagetitle.equalsIgnoreCase("Adactin.com - Search Hotel"))
			 {	 
			 	System.out.println("Page title is correct :" +Spagetitle);
			 	assertEquals(Spagetitle,"Adactin.com - Search Hotel" );
			 }
			 else
				 System.out.println("Page title is Not correct :" +Spagetitle);
			 driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		 		
	}


}
