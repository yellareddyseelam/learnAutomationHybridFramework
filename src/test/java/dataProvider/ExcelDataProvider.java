package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook xssfWorkbook;

	public ExcelDataProvider() {
		File appData=new File("./ApplicationTestData/applicationData.xlsx");
		try {
			FileInputStream fileInputStream=new FileInputStream(appData);
			xssfWorkbook=new XSSFWorkbook(fileInputStream);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	
   public String getData(int sheetIndex,int row,int column) {
	  String data= xssfWorkbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();//return string data we can also return number
	return data;
	   
   }
   public String getData(String sheetName,int row,int column) {
		  String data= xssfWorkbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
		   
	   }
}
