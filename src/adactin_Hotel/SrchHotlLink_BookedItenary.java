package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SrchHotlLink_BookedItenary 
{
	public static void main(String[] args)
	{
		try 
		{

			System.setProperty("driver.webdriver.chromedriver",
					"C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.get("https://adactinhotelapp.com/index.php");

			driver.findElement(By.id("username")).sendKeys("ADTraining102");
			driver.findElement(By.id("password")).sendKeys("Password102");

			driver.findElement(By.id("login")).click();

driver.findElement(By.linkText("Booked Itinerary")).click();
			
			// Explicit wait for page loading
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains("Select Hotel"));
			
			String St = driver.getTitle();
			System.out.println(St);
			if(St.equalsIgnoreCase("Adactin.com - Select Hotel"))
			{
				driver.findElement(By.linkText("Search Hotel")).click();
				St = driver.getTitle();
				System.out.println(St);
				assertEquals(St,"Adactin.com - Search Hotel");
			}
			else
			{
				System.out.println("Page title is incorrect :" + St);
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
	}
	
}

