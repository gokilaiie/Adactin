package adactin_Hotel;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrctInfo_BookingConf 
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
			 String SLoc= Location.getFirstSelectedOption().getText();
			 System.out.println(SLoc);
			 
			 Select Roomtype= new Select(driver.findElement(By.id("room_type")));
			 Roomtype.selectByVisibleText("Deluxe");
			 String Rmtyp= Roomtype.getFirstSelectedOption().getText();
			 System.out.println(Rmtyp);
			 
			 Select NoofRoom= new Select(driver.findElement(By.id("room_nos")));
			 NoofRoom.selectByVisibleText("2 - Two");
			 String NFR= NoofRoom.getFirstSelectedOption().getText();
			 System.out.println(NFR);
			 
			 driver.findElement(By.id("datepick_in")).click();
			 driver.findElement(By.id("datepick_in")).clear();
			 driver.findElement(By.id("datepick_in")).sendKeys("30/06/2024");
			 String ChkINDt = driver.findElement(By.id("datepick_in")).getAttribute("value");
			 System.out.println(ChkINDt);
			 
			 driver.findElement(By.id("datepick_out")).click();
			 driver.findElement(By.id("datepick_out")).clear();
			 driver.findElement(By.id("datepick_out")).sendKeys("01/07/2024");
			 String ChkOutdt = driver.findElement(By.id("datepick_out")).getAttribute("value");
			 System.out.println(ChkOutdt);
			
			 
			 Select AdRoom= new Select(driver.findElement(By.id("adult_room")));
			 AdRoom.selectByVisibleText("2 - Two");
			 String AR= AdRoom.getFirstSelectedOption().getText();
			 System.out.println(AR);
			 
			 Select ChRoom= new Select(driver.findElement(By.id("child_room")));
			 ChRoom.selectByVisibleText("2 - Two");
			 String CR= ChRoom.getFirstSelectedOption().getText();
			 System.out.println(CR);
			 
			 driver.findElement(By.id("Submit")).click();
			 String title = driver.getTitle();
			 if (title.equalsIgnoreCase("Adactin.com - Select Hotel"))
			 {
				 System.out.println("Page title is correct:" +title);
				 driver.findElement(By.id("radiobutton_1")).click();
				 String HTLNM= driver.findElement(By.id("hotel_name_1")).getAttribute("value");
				 
				 driver.findElement(By.id("continue")).click();
				 String Stitle = driver.getTitle();
				 if (Stitle.equalsIgnoreCase("Adactin.com - Book A Hotel"))
				 {
				 	System.out.println("Page title is correct:" +Stitle);
				 	
				 	driver.findElement(By.id("first_name")).sendKeys("ADTrainee");
				 	String FN = driver.findElement(By.id("first_name")).getAttribute("value");
				 	System.out.println(FN);
				 	
				 	driver.findElement(By.id("last_name")).sendKeys("Trainee");
				 	String LN = driver.findElement(By.id("last_name")).getAttribute("value");
				 	System.out.println(LN);
				 	
				 	driver.findElement(By.id("address")).sendKeys(" Unit 9, Marsden street, NSW");
				 	String AD = driver.findElement(By.id("address")).getAttribute("value");
				 	System.out.println(AD);
				 	
				 	driver.findElement(By.id("cc_num")).sendKeys("1234569874121478");
				 	
				 	Select CCTyp = new Select(driver.findElement(By.id("cc_type")));
				 	CCTyp.selectByVisibleText("American Express");
				 	
				 	Select ExpMnth = new Select(driver.findElement(By.id("cc_exp_month")));
				 	ExpMnth.selectByVisibleText("July");
				 	
				 	Select ExpYr= new Select(driver.findElement(By.id("cc_exp_year")));
				 	ExpYr.selectByVisibleText("2024");
				 	
				 	driver.findElement(By.id("cc_cvv")).sendKeys("123");
				 	
				 	driver.findElement(By.id("book_now")).click();
				 	
				 	//Explicit wait for page loading
				 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				 	wait.until(ExpectedConditions.titleContains("Hotel Booking Confirmation"));
				 	
				 	String St = driver.getTitle();
				 	System.out.println(St);
					 if (St.equalsIgnoreCase("Adactin.com - Hotel Booking Confirmation"))
					 {
						 String BHN= driver.findElement(By.id("hotel_name")).getAttribute("value");
						 String BL = driver.findElement(By.id("location")).getAttribute("value");
						 String BRT = driver.findElement(By.id("room_type")).getAttribute("value");
						 String BARDT = driver.findElement(By.id("arrival_date")).getAttribute("value");
						 String BDDT = driver.findElement(By.id("departure_text")).getAttribute("value");
						 String BTR = driver.findElement(By.id("total_rooms")).getAttribute("value");
						 String BADR = driver.findElement(By.id("adults_room")).getAttribute("value");
						 String BCHR = driver.findElement(By.id("children_room")).getAttribute("value");
						 String BFN = driver.findElement(By.id("first_name")).getAttribute("value");
						 String BLN = driver.findElement(By.id("last_name")).getAttribute("value");
						 String Baddr = driver.findElement(By.id("address")).getAttribute("value");
						 
						 assertEquals(HTLNM, BHN);
						 assertEquals(SLoc, BL);
						 assertEquals(Rmtyp, BRT);
						 assertEquals(ChkINDt, BARDT);
						 assertEquals(ChkOutdt, BDDT);
						 assertEquals(NFR, BTR);
						 assertEquals(AR, BADR);
						 assertEquals(CR, BCHR);
						 assertEquals(FN, BFN);
						 assertEquals(LN, BLN);
						 assertEquals(AD, Baddr);
					}
				 }
			 }
			 else 
			 {
				System.out.println("Page title is incorrect :" +title);
			 	
			 }
			 //driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
	}
	

}
