package utilities;

import java.io.IOException;


import org.testng.annotations.DataProvider;

public class DataProviders 
{
@DataProvider(name="EmployeeData")
 public String[][] getData() throws IOException
 {
	ExcelUtility xlutil = new ExcelUtility(".\\testData\\OrangeHRM AddEmployeeData.xlsx");
	
	int totalrows =xlutil.getRowCount("AddEmployeeData");
	int totalcols =xlutil.getCellCount("AddEmployeeData", 1);
	
	String employeedata[][] = new String[totalrows][totalcols];
	 
	for (int r = 1; r <=totalrows; r++) 
	{
		for (int c = 0; c <totalcols; c++) 
		{
			employeedata[r-1][c] = xlutil.getCellData("AddEmployeeData", r, c);
		}
	}
	return employeedata;
 }

@DataProvider(name="Employee1Data")
public String[][] getData1() throws IOException
{
	ExcelUtility xlutil = new ExcelUtility(".\\testData\\OrangeHRM AddEmployeeData.xlsx");
	
	int totalrows =xlutil.getRowCount("BlankField");
	int totalcols =xlutil.getCellCount("BlankField", 1);
	
	String employeedata[][] = new String[totalrows][totalcols];
	 
	for (int r = 1; r <=totalrows; r++) 
	{
		for (int c = 0; c <totalcols; c++) 
		{
			employeedata[r-1][c] = xlutil.getCellData("BlankField", r, c);
		}
	}
	return employeedata;
}

@DataProvider(name="Employee2Data")
public String[][] getData2() throws IOException
{
	ExcelUtility xlutil = new ExcelUtility(".\\testData\\OrangeHRM AddEmployeeData.xlsx");
	
	int totalrows =xlutil.getRowCount("EmployeeId");
	int totalcols =xlutil.getCellCount("EmployeeId", 1);
	
	String employeedata[][] = new String[totalrows][totalcols];
	 
	for (int r = 1; r <=totalrows; r++) 
	{
		for (int c = 0; c <totalcols; c++) 
		{
			employeedata[r-1][c] = xlutil.getCellData("EmployeeId", r, c);
		}
	}
	return employeedata;

}
}
