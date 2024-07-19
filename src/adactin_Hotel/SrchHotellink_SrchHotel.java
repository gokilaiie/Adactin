package adactin_Hotel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SrchHotellink_SrchHotel
{
	public static void main (String[] args)
	{
		System.setProperty("driver.webdriver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://adactinhotelapp.com/index.php");
		

		 driver.findElement(By.id("username")).sendKeys("ADTraining102");
		 driver.findElement(By.id("password")).sendKeys("Password102");
		 
		 driver.findElement(By.id("login")).click();
		 
		//Entering values
		 Select Location= new Select(driver.findElement(By.id("location")));
		 Location.selectByVisibleText("Sydney");
		 
				 
		 Select Hotel= new Select(driver.findElement(By.id("hotels")));
		 Hotel.selectByVisibleText("Hotel Sunshine");
		 		 
		 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
		 Roomtype.selectByVisibleText("Deluxe");
		 
		 
		 driver.findElement(By.linkText("Search Hotel")).click();
		 
		 String Spagetitle= driver.getTitle();
		 
		 if (Spagetitle.equalsIgnoreCase("Adactin.com - Search Hotel"))
		 	System.out.println("Page title is correct :" +Spagetitle);
		 else
			 System.out.println("Page title is Not correct :" +Spagetitle);
		 		
	}
}
