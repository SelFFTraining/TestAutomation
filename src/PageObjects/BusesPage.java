package PageObjects;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thoughtworks.selenium.Wait;

import Libraries.Elements;
import TestNG.DemoTestNG;

public class BusesPage extends DemoTestNG {
	
	Elements ele = new Elements();
	public WebElement txt_From= ele.WebText("from");
	public WebElement txt_To=ele.WebText("to");
	public WebElement Dt_Depart=ele.WebCalander("Depart date");
	public WebElement btn_Search=ele.WebButton("SearchBtn");
	public WebElement logo_Cleartrip=ele.Weblogo("Cleartrip ");
	
	//Function for Searching Buses and gives the return value
	//@SuppressWarnings("deprecation")
	public ArrayList<String> fnsearchBuses(String strFrom,String strTo,String strDepartDt) throws InterruptedException{
		   ArrayList<String> rowname = new ArrayList<String>();
		try{
			txt_From.clear();
			txt_From.sendKeys(strFrom);		
			txt_From.findElement(By.xpath("//*[@id='ui-id-1']/li[1]")).click();
			txt_To.clear();
			txt_To.sendKeys(strTo);				
			driver.findElement(By.xpath("//*[@id='ui-id-2']/li[1]")).click();
			driver.findElement(By.linkText("28")).click(); 
			btn_Search.click();
			System.out.println("Sucessfully quaried Buses");
			Thread.sleep(50000);
			
			//Take the Screenshot
			File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(scrFile,new File("D:\\screenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			java.util.List<WebElement> name=driver.findElements(By.xpath("//ul[contains(@class,'listView')]/li"));
			int count=name.size();
			
			for(int i=0;i<count;i++){
				System.out.println(name.get(i).getText());
				rowname.add(name.get(i).getText());
				System.out.println("Row Name ="+name);
			}
			
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		logo_Cleartrip.click();
		Thread.sleep(10000);
		return rowname;
	}


	//Function for Searching depart time for required bus and gives the return value
		public ArrayList<String> fnSearchPrice(String strFrom,String strTo,String strDepartDt) throws InterruptedException{
			   ArrayList<String> rowname1 = new ArrayList<String>();
			try{
				txt_From.clear();
				txt_From.sendKeys(strFrom);
				txt_From.findElement(By.xpath("//*[@id='ui-id-1']/li[1]")).click();
				txt_To.clear();
				txt_To.sendKeys(strTo);				
				driver.findElement(By.xpath("//*[@id='ui-id-2']/li[1]")).click();
				driver.findElement(By.linkText("28")).click(); 
				btn_Search.click();
				System.out.println("Sucessfully quaried Buses");
				Thread.sleep(2000);
				java.util.List<WebElement> Depart=driver.findElements(By.xpath("//ul[contains(@class,'listView')]/li[2]//span[contains(@class,'depart')]"));
				int count1=Depart.size();			
				for(int i=0;i<count1;i++){
					rowname1.add(Depart.get(i).getText());
					System.out.println("Row Name for Price is ="+Depart);
				}

			}catch(Exception e){
				System.out.println(e.getStackTrace());
			}
			//logo_Cleartrip.click();
			Thread.sleep(10000);
			return rowname1;
		}
}




