import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleFrames 
{
	WebDriver driver ;
	
	    @BeforeTest
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
		public void FrameLeft() throws InterruptedException 
	    {
	    driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		WebElement leftText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
		String textInLeftFrame = leftText.getText();
		System.out.println(textInLeftFrame);}
	    
	    @Test(priority=2)
	    public void FrameMiddle() 
	    {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
		WebElement middleText = driver.findElement(By.id("content"));
		String textInMiddleFrame = middleText.getText();
		System.out.println(textInMiddleFrame);
	    }
	    
		@Test(priority=3)
	    public void FrameRight() 
	    {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		WebElement rightText = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        String textInRightFrame =rightText.getText();
        System.out.println(textInRightFrame);
	    }
		
	    @Test(priority=4)
	    public void FrameBottom() throws InterruptedException 
	    {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		WebElement bottomText = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String textInbottomFrame =bottomText.getText();
		System.out.println(textInbottomFrame);
		Thread.sleep(2000);
        }
        @AfterTest
        public void closeBrowser() 
        {	
	    driver.quit();
        }
}