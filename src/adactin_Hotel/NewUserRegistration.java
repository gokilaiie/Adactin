package adactin_Hotel;

import java.awt.Checkbox;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewUserRegistration 
{
	public static void main (String[] args)
	{
		System.setProperty("driver.webdriver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://adactinhotelapp.com/index.php");
		
		driver.findElement(By.linkText("New User Register Here")).click();
		
		driver.findElement(By.id("username")).sendKeys("ADtrainee");
		driver.findElement(By.id("password")).sendKeys("Password@101");
		driver.findElement(By.id("re_password")).sendKeys("Password@101");
		driver.findElement(By.id("full_name")).sendKeys("My_Name");
		driver.findElement(By.id("email_add")).sendKeys("Myname@adactin.com");
		driver.findElement(By.id("captcha-form")).sendKeys("truelove");
		
		WebElement chkbox = driver.findElement(By.id("tnc_box"));
		chkbox.click();
		
		driver.findElement(By.id("Submit")).click();
		
		
		
	}
	

}
