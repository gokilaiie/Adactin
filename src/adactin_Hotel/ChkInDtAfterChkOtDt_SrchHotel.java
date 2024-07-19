package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChkInDtAfterChkOtDt_SrchHotel 
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
			 CIDt.sendKeys("02/08/2024");

			 WebElement Dt = driver.findElement(By.id("datepick_out"));
			 Dt.clear();
			 Dt.sendKeys("02/07/2024");

			 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
			 AdRoom.selectByVisibleText("2 - Two");
			 
			 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
			 ChRoom.selectByVisibleText("0 - None");
			 
			 //Click on Search
			 driver.findElement(By.id("Submit")).click();
			 
			 WebElement Error = driver.findElement(By.id("checkout_span"));
			if(Error.isDisplayed())
			{
				System.out.println(Error.getText());
			}
			else
			{
				assertEquals(Error, "Check-Out Date shall be after than Check-In Date");
			}
			 driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
	}


}
