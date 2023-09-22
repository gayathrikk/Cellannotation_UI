package Sanitytesting.CellanotationUI;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cell {
	 
	   private RemoteWebDriver driver;
	   private WebDriverWait wait;
		
		@BeforeTest
		
		public void setup() throws Exception
		{
			
			  DesiredCapabilities dc = DesiredCapabilities.chrome();
		        URL url = new URL("http://172.12.20.118:5555/wd/hub");
		        driver = new RemoteWebDriver(url, dc);
		
		       
		}
		@Test(priority=1)
		public void login() throws InterruptedException
		{
			driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
			 driver.manage().window().maximize();
			 driver.findElement(By.xpath("//a[@title='Viewer']")).click();
			 
			 String parentWindow = driver.getWindowHandle();
			 driver.findElement(By.xpath("//button[text()=' Log In ']")).click();
			 Thread.sleep(4000);
			 Set<String> allWindows = driver.getWindowHandles();
			 for (String window : allWindows) {
				    if (!window.equals(parentWindow)) {
				        driver.switchTo().window(window);
				        break;
				    }
				}
			 Thread.sleep(4000);	
		            driver.findElement(By.xpath("//input[@type='email']")).sendKeys("teamsoftware457@gmail.com");
		            driver.findElement(By.xpath("//span[text()='Next']")).click();
		            Thread.sleep(3000);
		            driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("Health#123");
		            driver.findElement(By.xpath("//span[text()='Next']")).click();
		            Thread.sleep(5000);
		            driver.switchTo().window(parentWindow);
		            Thread.sleep(5000);
		            System.out.println("Login successfully");
		        
		}
		
		@Test(priority=2)
		public void sectionselect() throws InterruptedException
		{
		     WebElement tableElement = driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[7]"));
		     tableElement.click();
		     Thread.sleep(3000);
		     WebElement tableElement1=driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[8]//td[2]"));
		     tableElement1.click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[9]//td[3]")).click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("(//span[text()='382'])[1]")).click();
		}
		@Test(priority=3)
		public void cellannotation() throws InterruptedException
		{
			driver.findElement(By.xpath("//a[@title='Cell Annotation']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//nb-icon[@pack='nebular-essentials'])[6]")).click();
			driver.findElement(By.xpath("//input[@placeholder='Tile Number']")).sendKeys("860");
			driver.findElement(By.xpath("//button[text()='Go to']")).click();
			driver.findElement(By.xpath("//a[@title='Tile Annotation']")).click();
			Thread.sleep(2000);
			WebElement toaster=driver.findElement(By.xpath("//div[text()='Annotated Data loaded successfully']"));
			String Toaster=toaster.getText();
			String Expected="Annotated Data loaded successfully";
			Assert.assertEquals(Expected, Toaster);
			System.out.println("Tile loaded succesfully");
			Thread.sleep(8000);
			 
			
		}
		@Test(priority=4)
		public void celldetection() throws InterruptedException
		{
			driver.findElement(By.xpath("(//select[@status='primary'])[2]")).click();
			  driver.findElement(By.xpath("//option[text()=' CellDetection ']")).click();
			  Thread.sleep(6000);
			  WebElement toast2 = driver.findElement(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']"));
			  String actualFileName2 = toast2.getText();
			  String expectedFileName2 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName2, actualFileName2);
			  System.out.println("EP1 firstpass Relearn success");
			  Thread.sleep(3000);
		}
		@Test(priority=5)

		  public void centroidDetection() throws InterruptedException {
			
			  driver.findElement(By.xpath("(//select[@status='primary'])[2]")).click();
			  driver.findElement(By.xpath("//option[text()=' CentroidDetection ']")).click();
			  Thread.sleep(6000);
			  WebElement toast2 = driver.findElement(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']"));
			  String actualFileName2 = toast2.getText();
			  String expectedFileName2 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName2,actualFileName2);
			  System.out.println("EP4 firstpass Relearn success");
			  Thread.sleep(3000);

		  }

		  @Test(priority=6)

		  public void Rabies() throws InterruptedException {
			  
			  driver.findElement(By.xpath("(//select[@status='primary'])[2]")).click();
			  driver.findElement(By.xpath("//option[text()=' Rabies ']")).click();
			  Thread.sleep(6000);
			  WebElement toast3 = driver.findElement(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']"));
			  String actualFileName3 = toast3.getText();
			  String expectedFileName3 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName3, actualFileName3);
			  System.out.println("EP7 firstpass Relearn success");
			  Thread.sleep(3000);
		  }
		  @Test(priority=7)

		  public void Annotation() throws InterruptedException {
			 
			 driver.findElement(By.xpath("//a[@title='Annotation']")).click();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//a[@title='Clear and Add  First Pass']")).click();
			  Thread.sleep(2000);
			  System.out.println("Cleared and First pass added");
		  }

		  @Test(priority=8)

		  public void save() throws InterruptedException {

			 driver.findElement(By.xpath("//a[@title='Actions']")).click();
			  Thread.sleep(2000);
			 driver.findElement(By.xpath("//a[@title='Save']")).click();
			  Thread.sleep(3000);
			  WebElement toast4 = driver.findElement(By.xpath("//nb-toast//span[text()='Save']/following-sibling::div[@class='message']"));
			  String actualFileName4 = toast4.getText();
			  String expectedFileName4 = "Saved Successfullly"; 
			  Assert.assertEquals(actualFileName4, expectedFileName4);
			  System.out.println("Saved Successfully");
		  }
		  @AfterTest

		  public void afterTest() {

			  driver.quit();

		  }
		

}
