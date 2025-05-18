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
	@DataProvider(name="Employee3Data")
	public String[][] getData3() throws IOException
	{
		ExcelUtility xlutil = new ExcelUtility(".\\testData\\OrangeHRM AddEmployeeData.xlsx");
		
		int totalrows =xlutil.getRowCount("EmpName");
		int totalcols =xlutil.getCellCount("EmpName", 1);
		
		String employeedata[][] = new String[totalrows][totalcols];
		 
		for (int r = 1; r <=totalrows; r++) 
		{
			for (int c = 0; c <totalcols; c++) 
			{
				employeedata[r-1][c] = xlutil.getCellData("EmpName", r, c);
			}
		}
		return employeedata;
	}		
		@DataProvider(name="Employee4Data")
		public String[][] getData4() throws IOException
		{
			ExcelUtility xlutil = new ExcelUtility(".\\testData\\OrangeHRM AddEmployeeData.xlsx");
			
			int totalrows =xlutil.getRowCount("MyInfo");
			int totalcols =xlutil.getCellCount("MyInfo", 1);
			
			String employeedata[][] = new String[totalrows][totalcols];
			 
			for (int r = 1; r <=totalrows; r++) 
			{
				for (int c = 0; c <totalcols; c++) 
				{
					employeedata[r-1][c] = xlutil.getCellData("MyInfo", r, c);
				}
			}
			return employeedata;
}
		
		@DataProvider(name="Employee5Data")
		public String[][] getData5() throws IOException
		{
			ExcelUtility xlutil = new ExcelUtility(".\\testData\\OrangeHRM AddEmployeeData.xlsx");
			
			int totalrows =xlutil.getRowCount("Emgncy Con");
			int totalcols =xlutil.getCellCount("Emgncy Con", 1);
			
			String employeedata[][] = new String[totalrows][totalcols];
			 
			for (int r = 1; r <=totalrows; r++) 
			{
				for (int c = 0; c <totalcols; c++) 
				{
					employeedata[r-1][c] = xlutil.getCellData("Emgncy Con", r, c);
				}
			}
			return employeedata;
}
		
		@DataProvider(name="Employee6Data")
		public String[][] getData6() throws IOException
		{
			ExcelUtility xlutil = new ExcelUtility(".\\testData\\OrangeHRM AddEmployeeData.xlsx");
			
			int totalrows =xlutil.getRowCount("Invalid Emgncy");
			int totalcols =xlutil.getCellCount("Invalid Emgncy", 1);
			
			String employeedata[][] = new String[totalrows][totalcols];
			 
			for (int r = 1; r <=totalrows; r++) 
			{
				for (int c = 0; c <totalcols; c++) 
				{
					employeedata[r-1][c] = xlutil.getCellData("Invalid Emgncy", r, c);
				}
			}
			return employeedata;



}
}
