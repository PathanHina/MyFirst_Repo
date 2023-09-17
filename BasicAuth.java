import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAuth {
	WebDriver driver ;
	 
		@BeforeTest
		public void LaunchDriver() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");  
		driver=new ChromeDriver();	
		driver.manage().window().maximize();	
	} 
	
		@Test
		public void Auth() throws InterruptedException {
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String message= driver.findElement(By.cssSelector("p")).getText();
		System.out.println(message);
		Thread.sleep(2000);
  }
		@AfterTest
	    public void closeDriver() 
	    {		
	    driver.quit();    
	    }
}