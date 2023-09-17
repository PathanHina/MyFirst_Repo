import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inputs 
{
	WebDriver driver ;
	
    @BeforeTest
	public void launchDriver()throws InterruptedException 
{ 
	 System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");	  
	 driver=new ChromeDriver(); 
	 driver.manage().window().maximize(); 
	 String baseUrl = "https://the-internet.herokuapp.com/"; 
     driver.get(baseUrl);  
     Thread.sleep(1000);
  } 
     @Test
	 public void passinput() throws InterruptedException
	 {
	 driver.findElement(By.xpath("//*[text()='Inputs']")).click();   
	 driver.findElement(By.xpath("//input[@type='number']")).sendKeys("5");  
	 System.out.println("Value Passed Successfully in Input Field");
     Thread.sleep(1000);
	 } 
	 
     @AfterTest
	 public void CloseDriver()
	 {
	 driver.close();
     }
}
