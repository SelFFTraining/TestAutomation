package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestNG.DemoTestNG;

@SuppressWarnings("unused")

public class Practice {
	
	public WebDriver driver=null;
	
	@Parameters({"Browser"})
	@BeforeTest
	public void openSite(String browserName) {
		
		if (browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();	
		}else{
			driver=new InternetExplorerDriver();
			
			int FILE;
			File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(scrFile,new File("D:\\screenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}


//To close the Browser After Test
@AfterTest
public void closeBrowser() {
    driver.quit();
}



@Test
public void opensite(){
	driver.get("www.Cleartrip.com");
	driver.findElement(By.xpath("//*[@id='OneWay']")).click();
	
}

}




