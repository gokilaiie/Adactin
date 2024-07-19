package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InvalidchkInDt_SrchHotel 
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
			 
			 Date dat = new Date();
			 SimpleDateFormat sd= new SimpleDateFormat("dd/mm/YYYY");
			 String CurrentD=sd.format(dat);
			 WebElement Dt= driver.findElement(By.id("datepick_in"));
			 Dt.clear();
			 Dt.sendKeys("07/22/2024");
			 
			 driver.findElement(By.id("datepick_out")).sendKeys(CurrentD);
			 
			 
			 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
			 AdRoom.selectByVisibleText("2 - Two");
			 
			 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
			 ChRoom.selectByVisibleText("0 - None");
			 
			 //Click on Submit
			 driver.findElement(By.id("Submit")).click();
			 
			//Verifying error
				WebElement Error = driver.findElement(By.id("checkin_span"));
				if(Error.isDisplayed())
				{
					System.out.println(Error.getText());
					assertEquals(Error.getText(), "Check-In Date shall be before than Check-Out Date");
								
				}
				else
				{
					assertEquals(Error.getText(), "Check-In Date shall be before than Check-Out Date");
				}
				
			 
			 //driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
