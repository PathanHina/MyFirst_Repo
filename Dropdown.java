import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

  public class Dropdown 
  {
   WebDriver driver ;	
		 
		 @BeforeTest	  
		 public void LaunchDriver() throws InterruptedException  {
		 System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");  
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();		 
		 String baseUrl = "https://the-internet.herokuapp.com/"; 		
	     driver.get(baseUrl);
	     Thread.sleep(1000);
	}
	     @Test
	     public void HandleDropdown() throws InterruptedException  {
	     driver.findElement(By.xpath("//*[text()='Dropdown']")).click();     
	     Select Option = new Select(driver.findElement(By.id("dropdown")));
		 Option.selectByVisibleText("Option 2");
		 System.out.println("Option 2 selected");
		 Thread.sleep(1000);
	}	
		 
	     @AfterTest
	     public void closeBrowser() 
		 { 
		 driver.close();
    }
  }
  