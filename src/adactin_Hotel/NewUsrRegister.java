package adactin_Hotel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewUsrRegister 
{
	public static void main(String [] args)
	{
		System.setProperty("webdriver.driver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://adactinhotelapp.com/index.php");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("New User Register Here")).click();
		
	}

}
