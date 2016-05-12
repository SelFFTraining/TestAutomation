package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCookies {
	WebDriver driver;
	
	@BeforeTest
	public void invokeBroseer(){
		driver = new FirefoxDriver();
		driver.get("http://timesofindia.indiatimes.com/");
	    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	public void MouseOver(){
		
		
		//Invoke Actions
		Actions act= new Actions(driver);
		
		//MAin Menu
		WebElement mainmenu =driver.findElement(By.cssSelector("html.gecko.ff.ff31.ff31_0.win.js.portrait body center div#netspidersosh div div.navlft div.padlftrgt div.wdh983 div.world_green_nav ul li a")); 
		
		act.moveToElement(mainmenu);
		
		
		act.click().build().perform();
		
		
		
		
		
		

		

		
		
		
		
		
	}
	
	

}
