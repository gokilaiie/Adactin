package adactin_Hotel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ResetBtn_SrchHotel {
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
		 
		 Select Hotel= new Select(driver.findElement(By.id("hotels")));
		 Hotel.selectByVisibleText("Hotel Sunshine");
		 		 
		 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
		 Roomtype.selectByVisibleText("Deluxe");
		 
		 Select NoofRoom= new Select(driver.findElement(By.id("room_nos")));
		 NoofRoom.selectByVisibleText("2 - Two");
		 
		 //driver.findElement(By.id("datepick_out")).clear();
		 
		 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
		 AdRoom.selectByVisibleText("2 - Two");
		 
		 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
		 ChRoom.selectByVisibleText("2 - Two");
		 
		 driver.findElement(By.id("Reset")).click();
		 
		 //Verify Default Location
		 //Select Location= new Select(driver.findElement(By.id("location")));
		 WebElement Locatn= Location.getFirstSelectedOption();
		 String Loc= Locatn.getText();
		 if(Loc.equalsIgnoreCase("- Select Location -"))
		 	 System.out.println("Default Locatn");
		 else
		 	 System.out.println("Not Default Locatn");
		 		 
		 //Verify Default Hotels		 
		 WebElement Hotl= Hotel.getFirstSelectedOption();
		 String Hot= Hotl.getText();
		 if (Hot.equalsIgnoreCase("- Select Hotel -"))
			 System.out.println("Default Hotel");
		 else
		 	 System.out.println("Not Default Hotel");
		
		 //Verify Room Type	 
		 WebElement Rmtyp = Roomtype.getFirstSelectedOption();
		 String Roomtyp = Rmtyp.getText();
		 if (Roomtyp.equalsIgnoreCase("- Select Room Type -"))
			 System.out.println("Default Room type");
		 else
		 	 System.out.println("Not Default Room type");
		
		 //Verify default No of Rooms
		 WebElement NOR=NoofRoom.getFirstSelectedOption();
		 String NR=NOR.getText();
		 if (NR.equalsIgnoreCase("- Select Number of Rooms -"))
			 System.out.println("Default No of Room");
		 else
		 	 System.out.println("Not Default No of Room");
		 
		 //driver.findElement(By.id("datepick_out")).clear();
		 
		 //Verify default Adult room
		 WebElement ADR= AdRoom.getFirstSelectedOption();
		 String AD= ADR.getText();
		 if (AD.equalsIgnoreCase("- Select Adults per Room -"))
			 System.out.println("Default Adult");
		 else
		 	 System.out.println("Not Default Adult");
		 
		 //Verify CHild room
		 WebElement CHR = ChRoom.getFirstSelectedOption();
		 String CR= CHR.getText();
		 if (CR.equalsIgnoreCase("0 - None"))
			 System.out.println("Default Child");
		 else
		 	 System.out.println("Not Default Adult");
		 
		
	}
}


