package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyEmail_NUR 
{
	@Test
	public void main()
	{
		try
		{
			System.setProperty("driver.webdriver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.get("https://adactinhotelapp.com/index.php");
			
			driver.findElement(By.linkText("New User Register Here")).click();
			
			driver.findElement(By.id("username")).sendKeys("Traineee");
			driver.findElement(By.id("password")).sendKeys("Password");
			driver.findElement(By.id("re_password")).sendKeys("Password");
			driver.findElement(By.id("full_name")).sendKeys("My Name");
			driver.findElement(By.id("email_add")).sendKeys("");
			driver.findElement(By.id("captcha-form")).sendKeys("nonhuman");
			
			WebElement Chkbox = driver.findElement(By.id("tnc_box"));
			Chkbox.click();
			
			driver.findElement(By.id("Submit")).click();
			
			//Verifying Error
			WebElement Error = driver.findElement(By.id("email_add_span"));
			if(Error.isDisplayed())
			{
				System.out.println(Error.getText());
				assertEquals(Error.getText(), "Email Address is Empty");
							
			}
			else
			{
				assertEquals(Error.getText(), "Email Address is Empty");
			}
			driver.quit();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
