package adactin_Hotel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://adactinhotelapp.com/index.php");
		
		driver.findElement(By.id("username")).sendKeys("ADTraining102");
		driver.findElement(By.id("password")).sendKeys("Password102");;
		
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		//driver.close();

	}
}
