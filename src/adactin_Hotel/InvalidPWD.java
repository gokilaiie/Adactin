package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidPWD 
{
	@Test
	public void main ()
	{
		try
		{
			System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("http://adactinhotelapp.com/index.php");
			
			driver.manage().window().maximize();
			
			driver.findElement(By.id("username")).sendKeys("ADTraining102");
			driver.findElement(By.id("password")).sendKeys("Password");
			
			driver.findElement(By.id("login")).click();
			
			//Verifying error
			WebElement Error = driver.findElement(By.xpath("//b[contains(text(),'Invalid Login details or Your Password might have ')]"));
			if(Error.isDisplayed())
			{
				System.out.println(Error.getText());
				assertEquals(Error.getText(), "Invalid Login details or Your Password might have expired. Click here to reset your password");
							
			}
			else
			{
				assertEquals(Error.getText(), "Invalid Login details or Your Password might have expired. Click here to reset your password");
			}
			
			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
 	
	

}
