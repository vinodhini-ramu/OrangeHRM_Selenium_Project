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

}
