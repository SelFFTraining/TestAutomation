package TestCases;

import java.util.ArrayList;









import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Libraries.Excel;
import Misc.Constants;
import PageObjects.BusesPage;
import TestNG.DemoTestNG;

//Searches for available Buses
public class Batch3 extends DemoTestNG {
	
	//Test Case1:Method for searching Available Buses and updating
	@Test
	@SuppressWarnings("static-access")
	public void BusSearch() throws Exception {
		
		//Navigate to Buses page
		driver.findElement(By.xpath(".//*[@id='Home']/div/aside[1]/nav/ul[1]/li[5]/a")).click();
		Thread.sleep(5000);

		//Call Excel to get the test data
		Constants Path=new Constants();	 
		Excel.setExcelFile(Path.excelpath,"Buses");
		String strFrom=Excel.getCellData(0,0);
		String strTo=Excel.getCellData(0,1);		
		//String ,strDepartDt=Excel.getCellData(0,2);
		String strDepartDt="29";
		
		//Call Bus Search function and get the available Bus details
		BusesPage BsPage= new BusesPage();
		ArrayList<String> rowname=BsPage.fnsearchBuses(strFrom, strTo, strDepartDt);
		int count=rowname.size()-1;			
		for (int i=0;i<=count;i++){		
			//System.out.println("Available Buses are:"+rowname.get(i));	
			Excel.setCellData(Path.excelpath,"Buses",rowname.get(i),i,3);
		}		
	}
	//Test Case2:Method for searching Depart Time for required bus and updating
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void BusSearchforPrice() throws Exception	{
		//Call Excel Path
		Constants Path=new Constants();	 
		Excel.setExcelFile(Path.excelpath,"Buses");
		String strFrom=Excel.getCellData(0,0);
		String strTo=Excel.getCellData(0,1);	
		//String strDepartDt=Excel.getCellData(0,2);
		String strDepartDt="29";
		
		//Navigate to the Bus Page
		driver.findElement(By.xpath(".//*[@id='Home']/div/aside[1]/nav/ul[1]/li[5]/a")).click();
		Thread.sleep(1000);
		
		//Call function for find depart time
		BusesPage BsPage= new BusesPage();
		ArrayList<String> rowname1=BsPage.fnSearchPrice(strFrom, strTo, strDepartDt);
		int count1=rowname1.size();
		System.out.println("Range for Arraylist is:::"+count1);
		
		for (int i=0;i<count1;i++){		
			//System.out.println("Available Buses are:"+rowname1.get(i));	
			Excel.setCellData(Path.excelpath,"Buses",rowname1.get(i),i,4);
		}
	
	}

}





