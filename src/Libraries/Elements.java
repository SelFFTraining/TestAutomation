package Libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestNG.DemoTestNG;

public class Elements extends DemoTestNG{
	
	public WebElement WebText(String strName){
		System.out.println("dirver:"+driver);
		return driver.findElement(By.xpath("//input[@name='"+strName+"']"));
	}												
	
	public WebElement WebRadioButton(String strName){
		return driver.findElement(By.xpath("//label[@title='"+strName+"']/input[@type='radio']"));		
	}
	
	public WebElement WebSelect(String strName){
		return driver.findElement(By.xpath("//*[@name='"+strName+"']"));
		
	}
	
	public WebElement WebCalander(String strName){
		//return driver.findElement(By.xpath("//div[@class='span span15 datePicker']/input[@title='"+strName+"']"));
		return driver.findElement(By.xpath("//input[@title='"+strName+"']"));
	}
	
	public WebElement WebButton(String strName){
		return driver.findElement(By.xpath("//*[@id='"+strName+"']"));
				
	}
	
	public WebElement Weblogo(String strName){
		return driver.findElement(By.xpath("//span[@title='"+strName+"']"));
	}

}
