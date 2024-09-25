package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="APIData")
	public String[][]	getAllData() throws IOException {
		
		String path = System.getProperty("user.dir")+"//TestData//userdata.xlsx";
		
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowNum = xl.getRowCount("sheet1");
		int colCount = xl.getCellCount("sheet1", 1);
		
		String apiData[][] = new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colCount;j++) {
				apiData[i-1][j]=xl.getCellData("sheet1", i, j);
			}
		}
		
		
		return apiData;
	}
	
	@DataProvider(name="username")
	public String[]	getUsernames() throws IOException {
		
		String path = System.getProperty("user.dir")+"//TestData//userdata.xlsx";
		
		ExcelUtility xl = new ExcelUtility(path);
		
		int rowNum = xl.getRowCount("sheet1");
		
		String apiData[]= new String[rowNum];
		
		for(int i=1;i<=rowNum;i++) {
				apiData[i-1]=xl.getCellData("sheet1", i, 1);
			
		}
		
		
		return apiData;
	}
	
	
	
}
