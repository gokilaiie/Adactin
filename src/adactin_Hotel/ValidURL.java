package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidURL 
{
	@Test
	public void main ()
	{
		try
		{
			
			System.setProperty("Webdriver.chrome.driver","C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			
			
			
			driver.get("http://adactinhotelapp.com/index.php");
			
			String Stitle=driver.getTitle();
			System.out.println(Stitle);
			assertEquals(Stitle, "Adactin.com - Hotel Reservation System");
			driver.quit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
