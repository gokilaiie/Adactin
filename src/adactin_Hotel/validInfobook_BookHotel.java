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

public class validInfobook_BookHotel 
{
	public static void main (String[] args)
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
			 
			 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
			 Roomtype.selectByVisibleText("Deluxe");
			 
			 Select NoofRoom= new Select(driver.findElement(By.id("room_nos")));
			 NoofRoom.selectByVisibleText("2 - Two");
			 
			 driver.findElement(By.id("datepick_in")).click();
			 driver.findElement(By.id("datepick_in")).clear();
			 driver.findElement(By.id("datepick_in")).sendKeys("07/07/2024");
			 
	 	     driver.findElement(By.id("datepick_out")).click();
	 	     driver.findElement(By.id("datepick_out")).clear();
			 driver.findElement(By.id("datepick_out")).sendKeys("30/07/2024");
			
			 
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
				 	driver.findElement(By.id("first_name")).sendKeys("My Name");
				 	driver.findElement(By.id("last_name")).sendKeys("ADTrainee");
				 	driver.findElement(By.id("address")).sendKeys(" Unit 9, Marsden street, NSW");
				 	driver.findElement(By.id("cc_num")).sendKeys("1234569874121478");
				 	driver.findElement(By.id("cc_type")).sendKeys("American Express");
				 	
				 	driver.findElement(By.id("cc_exp_month")).sendKeys("June");
				 	driver.findElement(By.id("cc_exp_year")).sendKeys("2024");
				 	driver.findElement(By.id("cc_cvv")).sendKeys("123");
				 	
				 	driver.findElement(By.id("book_now")).click();
				 	
				 	//Explicit Wait for page loading
				 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				 	wait.until(ExpectedConditions.titleContains("Hotel Booking Confirmation"));
				 	
				 	//Checking Hotel booking has confirmed
				 	Stitle = driver.getTitle();
				 	System.out.println(Stitle);
				 	assertEquals(Stitle, "Adactin.com - Hotel Booking Confirmation");
				 	
				 	
				 }
				
			 }
			 else 
			 {
				System.out.println("Page title is incorrect :" +title);
			 	
			 }
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}

}
