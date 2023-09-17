import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows 
{
	WebDriver driver ;
	  
	        @Test(priority=0)
			public void LaunchBrowser() throws InterruptedException 
			{		
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver(); 
			driver.manage().window().maximize();
			String baseUrl = "https://the-internet.herokuapp.com/"; 
		    driver.get(baseUrl);
		    Thread.sleep(1000);
			} 
	        
		    @Test(priority=1)
		    public void OpenWindowsURL() throws InterruptedException  
			{
		    driver.findElement(By.xpath("//*[text()='Multiple Windows']")).click();		       
		    driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		    Thread.sleep(1000);	
			}
		    
		    @Test(priority=2)
		    public void HandleWindows() throws InterruptedException  
			{	    
		    Set<String> handler = driver.getWindowHandles();
			Iterator<String> it = handler.iterator();
			String parentWindowId = it.next();
			String childWindowId = it.next();
			
			driver.switchTo().window(childWindowId);
			String childWindowTitle = driver.getTitle();
			System.out.println(childWindowTitle);
			System.out.println(driver.getCurrentUrl());	
			
			driver.switchTo().window(parentWindowId);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(1000);
	        }    
	       @Test(priority=3)
	        public void CloseBrowser() 
	       {  	 
			 driver.quit();
	       }
}