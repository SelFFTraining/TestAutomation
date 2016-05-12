package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import TestNG.DemoTestNG;

public class HBI extends DemoTestNG {
	
	@Test
	public void Register() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='userId']")).sendKeys("Administrator");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Administrator");
		
		driver.findElement(By.xpath("//*[@id='loginButton']")).click();
		driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td/table[2]/tbody/tr/td[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='text']")).sendKeys("12233334");
		
		Select se=new Select(driver.findElement(By.xpath("//*[@id='textType']")));
		se.selectByIndex(2);
		
		
		Thread.sleep(900);
		driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td/form/table/tbody/tr/td[3]/input")).sendKeys("16");
		Thread.sleep(100);
		
		driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td/form/table/tbody/tr/td[4]/input")).click();
		
	}
}
