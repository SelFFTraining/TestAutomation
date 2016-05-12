package PageObjects;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.eclipse.jetty.util.log.JavaUtilLog;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Libraries.Elements;
import TestNG.DemoTestNG;

public class TrainsPage extends DemoTestNG {
	
	private static final int OutputType = 0;
	Elements ele = new Elements();
	public WebElement txt_From= ele.WebText("from_station");
	public WebElement txt_To=ele.WebText("to_station");
	public WebElement Dt_Date=ele.WebCalander("Journey date");
	public WebElement sel_Class=ele.WebSelect("train[class]");
	public WebElement sel_Adult=ele.WebSelect("adults");
	public WebElement sel_Child=ele.WebSelect("children");
	public WebElement sel_SrMen=ele.WebSelect("male_seniors");
	public WebElement sel_SrWomen=ele.WebSelect("female_seniors");
	public WebElement btn_Search=ele.WebButton("trainFormButton");
	public WebElement logo_Cleartrip=ele.Weblogo("Cleartrip Home");
	
	
	
	//Function for Searching trains and gives the return value
	public ArrayList<String> fnsearchTrains(String strFrom,String strTo,String strClass,String strJourneyDt,String strAdult) throws InterruptedException{
		   ArrayList<String> rowname = new ArrayList<String>();
		
		try{
		txt_From.clear();
		txt_From.sendKeys(strFrom);
		txt_From.findElement(By.xpath("//ul[contains(@referer,'from_station')]")).click();
		txt_To.clear();
		txt_To.sendKeys(strTo);
		txt_To.findElement(By.xpath("//ul[contains(@referer,'to_station')]")).click();		
		
		Select sel=new Select(sel_Class);
		sel.selectByVisibleText(strClass);
		
		Dt_Date.clear();
		Dt_Date.sendKeys(strJourneyDt);
			
		Select sel1 = new Select(sel_Adult);
		sel1.selectByValue(strAdult);
	
		
		btn_Search.click();
		Thread.sleep(10000);
		

		
		
				
		
		
		java.util.List<WebElement> name=driver.findElements(By.xpath("//tr[contains(@id,'train')]"));
		int count=name.size();
		System.out.println("Row Count for Table Tains are"+count);
		
		for(int i = 1; i < count; i++)
			{													
				rowname.add(name.get(i).getText());
				System.out.println("Available Trains are ="+name);
			}
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		//logo_Cleartrip.click();
		Thread.sleep(10000);
		return rowname;
	}
}
