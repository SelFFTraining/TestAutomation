package TestCases;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Misc.Constants;
import Libraries.Excel;
import PageObjects.FlightsPage;
import TestNG.DemoTestNG;

//Searches for available Flights
public class Batch1 extends DemoTestNG{
	
	//Test Case1:Method for searching One Way flights and updating
	@SuppressWarnings("static-access")
	@Test(priority=0)
	public void flightsSeach() throws Exception {
		//Navigate to Flights page
		driver.findElement(By.xpath(".//*[@id='Home']/div/aside[1]/nav/ul[1]/li[1]/a[1]")).click();
		Thread.sleep(5000);
		
		//Get the data form Excel
		Constants Path=new Constants();	 
		Excel.setExcelFile(Path.excelpath,"OneWay");
		String strFrom=Excel.getCellData(0,0);
		String strTo=Excel.getCellData(0,1);
		String strDate=Excel.getCellData(0,2);
		String strAdult="3";
			
		//Call One way flight function and get the available flight details
		FlightsPage flpage = new FlightsPage();
		ArrayList<String> rowname = flpage.fnsearchOneWayFlights (strFrom,strTo,strDate,strAdult);
		int count=rowname.size()-1;			
		for (int i=0;i<=count;i++){		
			//System.out.println("Available Tickets one way are:"+rowname.get(i));	
			Excel.setCellData(Path.excelpath,"OneWay",rowname.get(i),i,4);
		}	
	}
	
	//Test Case1:Method for searching round trip flights and updating
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void flightsSearchRoundTrip() throws Exception{
		
		//Fetch Data
		Constants Path=new Constants();		
		Excel.setExcelFile(Path.excelpath,"RoundTrip");
		String strFrom1=Excel.getCellData(0,0);
		String strTo1=Excel.getCellData(0,1);	
		String strDate1=Excel.getCellData(0,2);
		String strRtnDate1=Excel.getCellData(0, 3);
		String strAdult1="4";
		//String strAdult1=TestData.getCellData(0,4);
		System.out.println(strAdult1);	
		
		//Call RoundTrip Function
		FlightsPage flpage=new FlightsPage();
		ArrayList<String> rowname1=flpage.fnsearchRndTripFlights(strFrom1,strTo1,strDate1,strRtnDate1,strAdult1);
		int count1=rowname1.size()-1;			
		for (int i=0;i<=count1;i++){		
			//System.out.println("Available Tickets for round trip are:"+rowname1.get(i));	
			Excel.setCellData(Path.excelpath,"RoundTrip",rowname1.get(i),i,5);
		}
	}
}
