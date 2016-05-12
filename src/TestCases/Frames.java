package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames {
	   WebDriver driver;
	    @BeforeTest
	    public void invokeBrowser() {
	        driver = new FirefoxDriver();
	        driver.get("http://jqueryui.com/autocomplete/");
	        driver.manage().window().maximize();
	    }
	    @Test
	    public void frameTest(){
	    	driver.switchTo().frame("tags");
	    	driver.findElement(By.xpath("//*[@id='tags']")).sendKeys("Edden Jellis");  		
	    	//Switch back to main window
	    	//driver.switchTo().defaultContent();	
	    }
}


