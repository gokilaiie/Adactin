package adactin_Hotel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchHotel 
{
	public static void main (String[] args)
	{
	
		System.setProperty("Webdriver.chrome.driver", "C:\\\\Users\\\\gokil\\\\Documents\\\\lib\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://adactinhotelapp.com/index.php");
		
		driver.findElement(By.id("username")).sendKeys("ADTraining102");
		driver.findElement(By.id("password")).sendKeys("Password102");
		
		driver.findElement(By.id("login")).click();
		
		WebElement Location = driver.findElement(By.id("location"));
		
		Select Loc  = new Select(Location);
		Loc.selectByVisibleText("Sydney");
		
		WebElement Hotel = driver.findElement(By.id("hotels"));
		
		Select Hotl= new Select(Hotel);
		Hotl.selectByVisibleText("Hotel Creek");
		
		WebElement Room_type= driver.findElement(By.id("room_type"));
		
		Select Roomtyp = new Select(Room_type);
		Roomtyp.selectByVisibleText("Double");
		
		WebElement NoOfRooms = driver.findElement(By.id("room_nos"));
		
		Select NoofRoom = new Select(NoOfRooms);
		NoofRoom.selectByValue("3");
		
		WebElement AdPerRoom = driver.findElement(By.id("adult_room"));
		
		Select APR = new Select(AdPerRoom);
		APR.selectByValue("2");
		
		WebElement ChildPerRoom = driver.findElement(By.id("child_room"));
		
		Select CPR = new Select(ChildPerRoom);
		CPR.selectByValue("3");
		
		driver.findElement(By.id("Submit")).click();
		
		
		
		
		
		
	}

}
