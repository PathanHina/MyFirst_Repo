import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class FileUpload 
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
		     public void uploading() throws InterruptedException
		     {
		     WebElement E = driver.findElement(By.xpath("//*[text()='File Upload']"));
		     E.click();	
		     WebElement chooseFile = driver.findElement(By.id("file-upload"));
		     chooseFile.sendKeys("C:\\Users\\Admin\\OneDrive\\Desktop\\Index.png");
		     WebElement upload = driver.findElement(By.id("file-submit"));   	     
		     Thread.sleep(1000);
		     upload.click();
		     try
		      {
		    	 System.out.println("File has been uploaded Successfully");
		      }
		       catch(Exception e)
		       {    	  
		       } 
		     }
		     
		     @AfterTest
		     public void closing() throws InterruptedException 
		     {
		     Thread.sleep(2000); 
             driver.close();
		     }
		     
}
