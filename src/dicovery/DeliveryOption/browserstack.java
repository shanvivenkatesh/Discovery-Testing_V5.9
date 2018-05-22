package dicovery.DeliveryOption;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class browserstack {
	
	public static final String USERNAME = "emmabayne";
	  public static final String AUTOMATE_KEY = "NuCceJunBumUR6nLqu63";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException {
		
DesiredCapabilities caps = new DesiredCapabilities(); 
		
		caps.setCapability("browser", "safari");
		caps.setCapability("browser_version", "10.0");
		
		 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		 
		 File src = new File("./data/ALLOptions.xlsx");	
	        XSSFWorkbook book = new XSSFWorkbook(src);
			
	        
	        
			XSSFSheet sheet = book.getSheetAt(0);
			
			String deliveryOptionType = sheet.getRow(0).getCell(22).getStringCellValue();
			String iaid = sheet.getRow(1).getCell(22).getStringCellValue();
			String expectedStaffDo = sheet.getRow(2).getCell(22).getStringCellValue();
			String expectedOnsitePublicDo = sheet.getRow(3).getCell(22).getStringCellValue();
			String expectedOffisteDo = sheet.getRow(4).getCell(22).getStringCellValue();
			
		/*	
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_win32/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();*/
			
			
			
	         driver.manage().window().maximize();
		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		    driver.get(iaid);
			
			
			driver.findElement(By.xpath("(//a[@class='discoveryPrimaryCallToActionLink'])[3]")).click();
			
			Thread.sleep(3000);
		            
				
					
			String deliveryOptionStaff =driver.findElement(By.xpath("(//div[@class='order-option-wrapper'])[1]")).getText();
			
		    System.out.println(deliveryOptionStaff);
			
			Assert.assertEquals(expectedStaffDo, deliveryOptionStaff);
					
			
			String Staffcheck= driver.findElement(By.xpath("(//div[@class='order-option-wrapper'])[1]")).getAttribute("innerHTML");
			
			 Assert.assertTrue(Staffcheck.contains("StaffIn"));
			 
			Assert.assertTrue(Staffcheck.contains("AcademicSubscription"));
			
			
	         String deliveryOptionOnsitePublic =driver.findElement(By.xpath("(//div[@class='order-option-wrapper'])[2]")).getText();
			
		    System.out.println(deliveryOptionOnsitePublic);
			
			Assert.assertEquals(expectedOnsitePublicDo, deliveryOptionOnsitePublic);
			
		   		
			String onsitepublic= driver.findElement(By.xpath("(//div[@class='order-option-wrapper'])[2]")).getAttribute("innerHTML");
			
			Assert.assertTrue(onsitepublic.contains("OnSitePublic"));
			
			Assert.assertTrue(onsitepublic.contains("AcademicSubscription"));
			
			
	       String deliveryOptionOffsite =driver.findElement(By.xpath("(//div[@class='order-option-wrapper'])[3]")).getText();
			
		    System.out.println(deliveryOptionOffsite);
			
			Assert.assertEquals(expectedOffisteDo, deliveryOptionOffsite);    
			
			
	System.out.println(driver.findElement(By.xpath("(//div[@class='order-option-wrapper'])[3]")).getAttribute("innerHTML"));
			
			String Offsitecheck= driver.findElement(By.xpath("(//div[@class='order-option-wrapper'])[3]")).getAttribute("innerHTML");
			
			Assert.assertTrue(Offsitecheck.contains("OffSite"));
			
			Assert.assertTrue(Offsitecheck.contains("AcademicSubscription"));
			System.out.println("AcademicSubscription");
			
			driver.quit();
			
		
	}

}
