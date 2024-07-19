package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DefaultLocatn_SrchHotel
{
	@Test
	public void main()
	{
		try
		{
			System.setProperty("driver.webdriver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.get("https://adactinhotelapp.com/SearchHotel.php");
			
			 driver.findElement(By.id("username")).sendKeys("ADTraining102");
			 driver.findElement(By.id("password")).sendKeys("Password102");
			 
			 driver.findElement(By.id("login")).click();
			 
			 Select Location= new Select(driver.findElement(By.id("location")));
			 Location.selectByVisibleText("- Select Location -");
			 
			 Select Hotel= new Select(driver.findElement(By.id("hotels")));
			 Hotel.selectByVisibleText("Hotel Creek");
			 		 
			 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
			 Roomtype.selectByVisibleText("Double");
			 
			 Select NoofRoom= new Select(driver.findElement(By.id("room_nos")));
			 NoofRoom.selectByVisibleText("3 - Three");
			 
			 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
			 AdRoom.selectByVisibleText("4 - Four");
			 
			 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
			 ChRoom.selectByVisibleText("2 - Two");
			 
			 driver.findElement(By.id("Submit")).click();
			 
			 String Spagetitle = driver.getTitle();
			 if (Spagetitle.equalsIgnoreCase("Adactin.com - Select Hotel"))
			 {
				 	System.out.println("Page title is correct :" +Spagetitle);
			 		assertEquals(Spagetitle, "Adactin.com - Select Hotel");
			 }	
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
