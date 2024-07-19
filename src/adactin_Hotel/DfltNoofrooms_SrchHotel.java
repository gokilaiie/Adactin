package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DfltNoofrooms_SrchHotel 
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
			 Location.selectByVisibleText("Sydney");
			 
			 Select Hotel= new Select(driver.findElement(By.id("hotels")));
			 Hotel.selectByVisibleText("Hotel Sunshine");
			 		 
			 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
			 Roomtype.selectByVisibleText("Deluxe");
			 
			 Select NoofRoom= new Select(driver.findElement(By.id("room_nos")));
			 NoofRoom.selectByVisibleText("- Select Number of Rooms -");
			 
			 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
			 AdRoom.selectByVisibleText("4 - Four");
			 
			 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
			 ChRoom.selectByVisibleText("2 - Two");
			 
			 driver.findElement(By.id("Submit")).click();
			 
			 WebElement Error = driver.findElement(By.xpath("//span[@id='num_room_span']"));
				if(Error.isDisplayed())
				{
					String Serror = Error.getText();
					System.out.println();
					assertEquals(Serror, "Please Select Total Number of Rooms");
								
				}
				else
				{
					assertEquals(Error, "Please Select Total Number of Rooms");
				}
			 
			 driver.quit();
		}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
	}
}
		 



