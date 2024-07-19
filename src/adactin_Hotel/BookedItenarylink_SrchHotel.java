package adactin_Hotel;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookedItenarylink_SrchHotel 
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
			 
			 driver.findElement(By.linkText("Booked Itinerary")).click();
			 
			 String Spagetitle= driver.getTitle();
			 
			 if (Spagetitle.equalsIgnoreCase("Adactin.com - Select Hotel"))
				 
			 	System.out.println("Page title is correct :" +Spagetitle);
			 else
				 System.out.println("Page title is Not correct :" +Spagetitle);
			 
			 driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		 		
	}

}
