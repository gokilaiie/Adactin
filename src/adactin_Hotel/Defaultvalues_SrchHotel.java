package adactin_Hotel;


import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Defaultvalues_SrchHotel
{
	@Test
	public void main()
	{
		try
		{
			System.setProperty("driver.webdriver.chromedriver", "C:\\Users\\gokil\\Documents\\lib\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			driver.get("https://adactinhotelapp.com/index.php");
			
			driver.findElement(By.id("username")).sendKeys("ADTraining102");
			driver.findElement(By.id("password")).sendKeys("Password102");
			
			driver.findElement(By.id("login")).click();
			
			 String spagetitle = driver.getTitle();
			
			if(spagetitle.equalsIgnoreCase("Adactin.com - Search Hotel"))
			 {
			 
			 	System.out.println("Page title is correct : " +spagetitle);
			 	
			 	//Location  Default
			 	WebElement Locatn= driver.findElement(By.id("location"));
			 	Select Slctd = new Select(Locatn);
			 	WebElement Sdptn = Slctd.getFirstSelectedOption();
			 	String Slcdop= Sdptn.getText();
			 	
			 	if(Slcdop.equalsIgnoreCase("- Select Location -"))
			 		System.out.println("Location is default");
			 	else
			 		System.out.println("Location Not default");
			 
			 	//Hotel  Default
			 	WebElement Htl= driver.findElement(By.id("hotels"));
			 	Select Slct = new Select(Htl);
			 	WebElement Optn = Slct.getFirstSelectedOption();
			 	String SlctdTxt= Optn.getText();
			 	
			 	if(SlctdTxt.equalsIgnoreCase("- Select Hotel -"))
			 		System.out.println("Hotel is default");
			 	else
			 		System.out.println("Hotel Not default");
			 	
			 	//Room type  Default
			 	
			 	WebElement Rmtyp= driver.findElement(By.id("room_type"));
			 	Select Rmty = new Select(Rmtyp);
			 	WebElement Roomtype = Rmty.getFirstSelectedOption();
			 	String Rmtyo= Roomtype.getText();
			 	
			 	if(Rmtyo.equalsIgnoreCase("- Select Room Type -"))
			 		System.out.println("Roomtype is default");
			 	else
			 		System.out.println("Roomtype Not default");
			 	
			 	//No of Rooms Default
			 	
			 	WebElement NoofRoom= driver.findElement(By.id("room_nos"));
			 	Select NoR = new Select(NoofRoom);
			 	WebElement RoomNo = NoR.getFirstSelectedOption();
			 	String RoomNos= RoomNo.getText();
			 	
			 	if(RoomNos.equalsIgnoreCase("- Select Number of Rooms -"))
			 		System.out.println("No of Rooms is default");
			 	else
			 		System.out.println("No of Rooms Not default");
			 		
			 	 			 	
			 	//Check In DAte  Default
			 	WebElement ChkInDt= driver.findElement(By.id("datepick_in"));
			 	String Chk=ChkInDt.getAttribute("value");
			 			 	
			 	System.out.println(Chk);
				//Check Out DAte  Default
			 	
			 	String ChkOutDt= driver.findElement(By.xpath("//input[@id='datepick_out']")).getAttribute("value");
			 	System.out.println(ChkOutDt);
			 	
				//Adult Default
			 	WebElement ADPR= driver.findElement(By.id("adult_room"));
			 	Select Select = new Select(ADPR);
			 	WebElement Selectdoptn = Select.getFirstSelectedOption();
			 	String SlctedText= Selectdoptn.getText();
			 	
			 	if(SlctedText.equalsIgnoreCase("- Select Adults per Room -"))
			 		System.out.println("Adult is default");
			 	else
			 		System.out.println("Adult Not default");
			 	
			 	//Child Default
			 	WebElement CPR= driver.findElement(By.id("child_room"));
			 	Select St = new Select(CPR);
			 	WebElement Sdoptn = St.getFirstSelectedOption();
			 	String Slcdoptn= Sdoptn.getText();
			 	
			 	if(Slcdoptn.equalsIgnoreCase("0 - None"))
			 		System.out.println("Child is default");
			 	else
			 		System.out.println("Child Not default");
			 		 	
			}
			 
			else
			 {
				 System.out.println ("Page title is not correct : "+spagetitle);
			 }
			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
