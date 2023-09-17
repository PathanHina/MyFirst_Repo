import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFile 
{
	WebDriver driver ;
  
	      @BeforeTest
          public void Setup()throws Exception
	     {
	 		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		  	driver=new ChromeDriver();		 
			driver.manage().window().maximize();
			String Url = "https://the-internet.herokuapp.com/"; 
		    driver.get(Url);
		    Thread.sleep(1000);
         }
	      
           @Test
           public void FileDownload() throws InterruptedException
         {
	       WebElement File= driver.findElement(By.xpath("//*[text()='File Download']"));
	       File.click();	  
	       driver.findElement(By.xpath("//a[text()='LambdaTest.txt']")).click();
	       try
	       {
	    	  System.out.println("File has been downloaded Successfully");
	       }
	       catch(Exception e)
	       {    	  
	       }    
          }   
	     
           
           @AfterTest
	       public void Closing() 
         { 
	 		 driver.close();
	 	 }

}