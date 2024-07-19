package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CrctINfo_BookAHotel 
{
	@Test
	public void main ()
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
			 driver.findElement(By.id("datepick_in")).sendKeys("30/06/2024");
			 
	 	     driver.findElement(By.id("datepick_out")).click();
	 	    driver.findElement(By.id("datepick_out")).clear();
			 driver.findElement(By.id("datepick_out")).sendKeys("01/07/2024");
			
			 
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
				 String SHtlNm=driver.findElement(By.id("hotel_name_1")).getAttribute("value");
				 String SLoc=driver.findElement(By.id("location_1")).getAttribute("value");
				 String SR=driver.findElement(By.id("rooms_1")).getAttribute("value");
				 String SND=driver.findElement(By.id("no_days_1")).getAttribute("value");
				 String SRT=driver.findElement(By.id("room_type_1")).getAttribute("value");
				 String SPN=driver.findElement(By.id("price_night_1")).getAttribute("value");
				 String STP=driver.findElement(By.id("total_price_1")).getAttribute("value");//hotel_name_dis
				 
				 
				 driver.findElement(By.id("continue")).click();
				 String Stitle = driver.getTitle();
				 if (Stitle.equalsIgnoreCase("Adactin.com - Book A Hotel"))
				 {
				 	System.out.println("Page title is correct:" +Stitle);
				 	
				 	String BHNM=driver.findElement(By.id("hotel_name_dis")).getAttribute("value");
				 	String BLoc=driver.findElement(By.id("location_dis")).getAttribute("value");
				 	String BRT=driver.findElement(By.id("room_type_dis")).getAttribute("value");
				 	String BRN=driver.findElement(By.id("room_num_dis")).getAttribute("value");
				 	String BTD=driver.findElement(By.id("total_days_dis")).getAttribute("value");
				 	String BPN=driver.findElement(By.id("price_night_dis")).getAttribute("value");
				 	String BTP=driver.findElement(By.id("total_price_dis")).getAttribute("value");
				 	
				 	//Removing brackets
				 	String Brkts = "\\p{Ps}|\\p{Pe}";
				 	String Rslt = (BRN.replaceAll(Brkts,""));
				 	String Rlt =(BTD.replaceAll(Brkts,""));
				 	
				 	//Comparing both the page values to see whether same values are displayed
				 	assertEquals(SHtlNm, BHNM);
				 	assertEquals(SLoc, BLoc);
				 	assertEquals(SRT, BRT);
				 	assertEquals(SR, Rslt);
				 	assertEquals(SND, Rlt);
				 	assertEquals(SPN, BPN);
				 	assertEquals(STP, BTP);
				 	
				}
				
			 }
			 else 
			 {
				System.out.println("Page title is incorrect :" +title);
			 	
			 }
			 driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
	}


}
