import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop 
 {
	WebDriver driver ;
	
	  @BeforeTest
	  public void LaunchDriver() throws InterruptedException 
	  {
		  System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		  driver=new ChromeDriver();	 
		  driver.manage().window().maximize();
	      String Url = "https://the-internet.herokuapp.com/"; 
	      driver.get(Url);
		  Thread.sleep(1000);
	  }   
	      @Test
      public void DragDrop() throws InterruptedException
       {     
	     WebElement input = driver.findElement(By.xpath("//*[text()='Drag and Drop']"));
	     input.click();	   
	     Thread.sleep(1000);	 
	     WebElement from = driver.findElement(By.id("column-a"));
		 WebElement to = driver.findElement(By.id("column-b"));	 
		 
		 Actions Act = new Actions(driver);
		 Act.clickAndHold(from).moveToElement(to).release().build().perform();
		 Thread.sleep(2000);
		 System.out.println("Drag and drop action has been performed successfully");
       } 
		 
	      @AfterTest
	 public void closeBrowser() throws InterruptedException 
	  {
		Thread.sleep(2000);
		driver.close();
	  }
 }