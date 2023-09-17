import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
	
	WebDriver driver ;
	  
	  @BeforeTest
	  public void LaunchDriver() throws InterruptedException  
	  {  
		 System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");  
		 driver=new ChromeDriver(); 
		 driver.manage().window().maximize();	 
		 String baseUrl = "https://the-internet.herokuapp.com/"; 	
	     driver.get(baseUrl);    
	     Thread.sleep(1000);
	  }
	    @Test
	     public void ClikCheckboxes() throws InterruptedException {
	     WebElement input = driver.findElement(By.xpath("//*[text()='Checkboxes']"));
	     input.click();         
	     
	     WebElement checkall = driver.findElement(By.xpath("//input[@type='checkbox']"));     
	     
	     boolean isSelected = checkall.isSelected();		
	     if(isSelected == false) 
	     {
	   	  checkall.click();
	     }
	     System.out.println("Clicked both Check Boxes..");
	     Thread.sleep(1000);
	  } 
	    
	    @AfterTest
		public void CloseDriver()   
		{
		     driver.close();
		}
    }