package TestNG;
import Libraries.Excel;
import Misc.Constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class DemoTestNG {
	public static WebDriver driver;
	
  @SuppressWarnings("static-access")
  @BeforeTest
  public void f() throws Exception {
	  
	//Fetch the Driver and URL from Excel
	  Constants Path=new Constants();	
	  Excel.setExcelFile(Path.excelpath,"Misc");
	  
	//Excel.setExcelFile("D://SeleniumTest/TestData.xlsx","Misc");
	String strDriver=Excel.getCellData(0,0);
	String strURL=Excel.getCellData(0,1);
	 
	  switch (strDriver.toLowerCase()){
	  case "ie":
		  driver = new InternetExplorerDriver();
	  case "chrome":
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\chromedriver.exe");
		  driver = new ChromeDriver();
	  case "firefox":
		  //System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\IEDriverServer.exe");
		 driver = new FirefoxDriver();		  	  
	  }	
	  driver.get(strURL);
	  System.out.println(strURL);
	  //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  Thread.sleep(20000);
	 // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  
//  @AfterTest
//  public void f2(){
//  driver.quit();
//  }
}
