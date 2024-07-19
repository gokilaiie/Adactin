package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChkoutDtbeforeCurrDt_SrchHotel 
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
			 
			 //Entering values
			 Select Location= new Select(driver.findElement(By.id("location")));
			 Location.selectByVisibleText("Sydney");
			 
					 
			 Select Hotel= new Select(driver.findElement(By.id("hotels")));
			 Hotel.selectByVisibleText("Hotel Sunshine");
			 		 
			 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
			 Roomtype.selectByVisibleText("Deluxe");
			 
			 
			 WebElement CIDt = driver.findElement(By.id("datepick_in"));
			 CIDt.clear();
			 CIDt.sendKeys("02/06/2024");
			 
			 
			 WebElement Dt = driver.findElement(By.id("datepick_out"));
			 Dt.clear();
			 Dt.sendKeys("03/06/2024");
			 
			 
			 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
			 AdRoom.selectByVisibleText("2 - Two");
			 
			 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
			 ChRoom.selectByVisibleText("0 - None");
			 
			 //Click on Submit
			 driver.findElement(By.id("Submit")).click();
			 
			//Verifying Error
				WebElement Error = driver.findElement(By.xpath("//span[@id='checkin_span']"));
				if(Error.isDisplayed())
				{
					String Serror = Error.getText();
					System.out.println(Serror);
					assertEquals(Serror, "Check-In Date shall be before than Check-Out Date");
								
				}
				else
				{
					driver.quit();
				}
				
			 //Verifying whether Select hotel page loaded
			 String title = driver.getTitle();
			 if (title.equalsIgnoreCase("Adactin.com - Select Hotel"))
			 {
				 System.out.println("Page title is correct:" +title);
			 	assertEquals(title,"Adactin.com - Select Hotel" );
			 	
			 }
			 else 
			 {
				System.out.println("Page title is incorrect :" +title);
			 	assertEquals(title,"Adactin.com - Select Hotel" );
			 	driver.quit();
			 }
			 driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
