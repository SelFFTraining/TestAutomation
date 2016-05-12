package TestCases;

import java.util.ArrayList;





import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Libraries.Excel;
import Misc.Constants;
import PageObjects.TrainsPage;
import TestNG.DemoTestNG;

//Searches for available Trains
public class Batch2 extends DemoTestNG {
	
	//Test Case1:Method for searching Available Trains and updating
	@Test
	@SuppressWarnings("static-access")
	public void TrainSearch() throws Exception {
		//Navigate to Trains page
		driver.findElement(By.xpath(".//*[@id='Home']/div/aside[1]/nav/ul[1]/li[4]/a")).click();
		Thread.sleep(500);
		
		//Call Excel Path to get test data
		Constants Path=new Constants();	 
		Excel.setExcelFile(Path.excelpath,"Trains");
		String strFrom=Excel.getCellData(0,0);
		String strTo=Excel.getCellData(0,1);
		//String strClass=Excel.getCellData(0,2);
		String strClass="AC First Class (1A)"; 
		//String strJourneyDt=Excel.getCellData(0,3);	
		String strJourneyDt="4/3/2016";
		//String strAdult=Excel.getCellData(0,4);
		String strAdult="3";
	
		//Call Search function for Train and get the available Train details
		TrainsPage TrPage= new TrainsPage();
		ArrayList<String> rowname=TrPage.fnsearchTrains(strFrom, strTo, strClass, strJourneyDt, strAdult);
		int count=rowname.size()-1;			
		for (int i=0;i<=count;i++){		
			Excel.setCellData(Path.excelpath,"Trains",rowname.get(i),i,5);
		}	
		
	}
			
}


