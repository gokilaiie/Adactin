package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Slctaentry_SlctHotel
{
	public static void main (String[] args)
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
		 
		 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
		 Roomtype.selectByVisibleText("Deluxe");
		 
		 Select NoofRoom= new Select(driver.findElement(By.id("room_nos")));
		 NoofRoom.selectByVisibleText("2 - Two");
		 
		
		 WebElement Chk=driver.findElement(By.id("datepick_in"));
		 Chk.clear();
		 Chk.sendKeys("30/07/2024");
 	     
		 WebElement ChkOut = driver.findElement(By.id("datepick_out"));
		 ChkOut.clear();
		 ChkOut.sendKeys("31/07/2024");
		
		 
		 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
		 AdRoom.selectByVisibleText("2 - Two");
		 
		 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
		 ChRoom.selectByVisibleText("2 - Two");
		 
		 driver.findElement(By.id("Submit")).click();
		 
		 String title = driver.getTitle();
		 if (title.equalsIgnoreCase("Adactin.com - Select Hotel"))
		 {
			 System.out.println("Page title is correct:" +title);
			 driver.findElement(By.id("radiobutton_1")).click();
			 driver.findElement(By.id("continue")).click();
			 String Stitle = driver.getTitle();
			 if (Stitle.equalsIgnoreCase("Adactin.com - Book A Hotel"))
			 {
			 	System.out.println("Page title is correct:" +Stitle);
			 	assertEquals(Stitle, "Adactin.com - Book A Hotel");
			 }
			
		 }
		 else 
		 {
			System.out.println("Page title is incorrect :" +title);
		 	
		 }
	}
}


