package PageObjects;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Libraries.Elements;
import TestNG.DemoTestNG;

public class FlightsPage extends DemoTestNG{

	Elements ele = new Elements();
	public WebElement rdb_oneway = ele.WebRadioButton("One way");
	public WebElement rdb_roundway = ele.WebRadioButton("Round trip");
	public WebElement rdb_multy = ele.WebRadioButton("Multi-city");
	public WebElement rdb_flthtl = ele.WebRadioButton("Flight + Hotel");
	public WebElement txt_From= ele.WebText("origin");
	public WebElement txt_To=ele.WebText("destination");
	public WebElement Dt_Depart=ele.WebCalander("Depart date");
	public WebElement Dt_Return=ele.WebCalander("Return date");
	public WebElement sel_Adult=ele.WebSelect("adults");
	public WebElement btn_Search=ele.WebButton("SearchBtn");
	public WebElement logo_Cleartrip=ele.Weblogo("Cleartrip ");
	
	//Function for Searching one way flights and gives the return value
	public ArrayList<String> 	fnsearchOneWayFlights(String strFrom,String strTo,String strDate,String strAdult) throws InterruptedException{
		   ArrayList<String> rowname = new ArrayList<String>();
		try{
		rdb_oneway.click();
		txt_From.clear();
		txt_From.sendKeys(strFrom);
		txt_To.clear();
		txt_To.sendKeys(strTo);
		Dt_Depart.clear();
		Dt_Depart.sendKeys(strDate);
		Dt_Depart.sendKeys(Keys.ENTER);
		Select sel = new Select(sel_Adult);
		sel.selectByValue(strAdult);
				
		btn_Search.click();
		Thread.sleep(2500);
		//Take the Screenshot
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile,new File("D:\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		java.util.List<WebElement>  name = driver.findElements(By.xpath("//ul[contains(@class,'listView ')]/li"));
		int Count=name.size();
		for(int i = 1; i<Count; i++)
			{
			rowname.add(name.get(i).getText());
			System.out.println("Row Name = "+name.get(i).getText());
			}
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		logo_Cleartrip.click();
		Thread.sleep(10000);
		return rowname;
	}

	
	//Function for Searching two way flights and gives the return value
	public  ArrayList<String> fnsearchRndTripFlights(String strFrom1,String strTo1,String strDate1,String strRtnDate1,String strAdult1){
		 ArrayList<String> rowname1 = new ArrayList<String>();
		try{
		rdb_roundway.click();
		txt_From.clear();
		txt_From.sendKeys(strFrom1);
		txt_To.clear();
		txt_To.sendKeys(strTo1);
		Dt_Depart.clear();
		Dt_Depart.sendKeys(strDate1);
		Dt_Depart.sendKeys(Keys.ENTER);
		Dt_Return.clear();
		Dt_Return.sendKeys(strRtnDate1);
		Dt_Return.sendKeys(Keys.ENTER);
		Select sel=new Select(sel_Adult);
		sel.selectByValue(strAdult1);
		btn_Search.click();
		Thread.sleep(29000);
		java.util.List<WebElement> name1 = driver.findElements(By.xpath("//ul[contains(@class,'listView ')]/li"));
		int count1=name1.size();
		for(int i = 1; i < count1; i++)
		{
			rowname1.add(name1.get(i).getText());
			System.out.println("Row Name = "+name1.get(i).getText());
		}
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		return rowname1;
	}
	
}




