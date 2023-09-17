import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

	public class KeyPress 
	{
	WebDriver driver ;
	
	@BeforeTest	
	   	public void launchBrowser()throws InterruptedException 
		{
		  System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe"); 
		 driver=new ChromeDriver(); 
		 driver.manage().window().maximize();
		 String Url = "https://the-internet.herokuapp.com/"; 
	     driver.get(Url);  
	     Thread.sleep(1000);
	    }
         @Test
         public void pressKeys() throws InterruptedException, AWTException
        {
	     WebElement Web = driver.findElement(By.xpath("//*[text()='Key Presses']"));
	     Web.click();
	     
	     Robot robot= new Robot();
	     Thread.sleep(2000);        
	     robot.keyPress(KeyEvent.VK_TAB);
	     Thread.sleep(2000);     
	     robot.keyPress(KeyEvent.VK_ENTER);	           
        }  
         
         @AfterTest
	     public void terminateBrowser() 
	     {     
	    driver.quit();    
	     }          
	}