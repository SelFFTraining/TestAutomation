package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@Test
public class SwitchWindow {
	
	WebDriver  driver;
	
	public void SwitchWindowPopup() throws InterruptedException{
	 driver=new FirefoxDriver();
	 String URL="https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm";
	 driver.get(URL);
	 driver.manage().window().maximize();
	 Thread.sleep(500);
	 driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/a")).click();
	 Thread.sleep(1000);
	 
	// Storing parent window reference into a String Variable
	 String parentWindow=driver.getWindowHandle();
	 System.out.println("Parent Windowi is"+parentWindow);
	 
	 
	 //Switching from parent to child window
	 for (String ChildWindow : driver.getWindowHandles()){
		 
		 driver.switchTo().window(ChildWindow);
		 System.out.println("Chilad Window is"+ChildWindow);
		 
		 //perform operations on child window
		driver.findElement(By.xpath("//*[@id='User_Id']")).sendKeys("GSUNNY");
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().getText();	
		 
		 
		 
//		 driver.findElement(By.xpath("//*[@id='skImg']")).click();
//		 driver.findElement(By.xpath("//*[@id='password']")).sendKeys("WrongP");
//		 driver.findElement(By.xpath("//*[@id='main-wrapper']/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/div/a/div")).click();
		 
		 //Switch to parent window
		 driver.switchTo().window(parentWindow);
		 
		 driver.findElement(By.xpath("//*[@id='topMnu']")).click();
		 Thread.sleep(500);
		 //driver.close();	
		 
		// driver.switchTo().window(ChildWindow);
		 //driver.close();
		 
		 //
		 
		 
		 //table[@id='1223']/tbody/tr[2]
		 //table[@id='12345']/tbody/tr[2]/tr[3]
		 
		 //table[@id='2333']/tbody/tr/tr[3]
		 
		 //table[@id='324r23r']/tbody/tr/tr
		 
	//	 ["//*[@id='12333']/tbody/tr[0]/td"]
		 
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	}

}
