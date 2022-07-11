package ipg.StaffAug;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	
	
	
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook objWorkbook;
		
		
		//File src = new File(".\\TestData\\StaffAug_dataPractice.xlsx");
		FileInputStream fis = new FileInputStream(".\\TestData\\StaffAug_dataPractice.xlsx");
	
		objWorkbook = new XSSFWorkbook(fis);
		
		
		int noOfSheets = objWorkbook.getNumberOfSheets();
		int desiredSheetIndex = 0;
		
		for(int i=0;i<noOfSheets;i++)
		{
			
			String sheetName = objWorkbook.getSheetAt(i).getSheetName();
			if(sheetName.equalsIgnoreCase("Sheet1"))
			{
				desiredSheetIndex = i;
				break;
				
			}
			
		}
		
		XSSFSheet objSheet = objWorkbook.getSheetAt(desiredSheetIndex);
		
		int	scenarioNameCol = 0;
		
		for(int j=0;j<10;j++)
		{
			String firstCellValue = objSheet.getRow(0).getCell(j).getStringCellValue();
			if(firstCellValue.equalsIgnoreCase("Scenario Name"))
			{
				
				scenarioNameCol = j;
				break;
				
			}
			
		}
		
		
		//Get no of Rows in sheet/ Used Range
		
		int rowCount = objWorkbook.getSheetAt(0).getLastRowNum();
		
		System.out.println("Number Of rows present "+rowCount);
		
		//Get Cell Data
		
		String cellData = objWorkbook.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
		
		System.out.println("Cell Value of Row 1+1 col 2+1 "+cellData);
		
		
		Cell objCell = objWorkbook.getSheetAt(0).getRow(2).createCell(10);
		
		objCell.setCellValue("TestColAddagain");
		Cell objCell1 = objWorkbook.getSheetAt(0).getRow(2).getCell(2);
		
		objCell1.setCellValue("Testscadd");
		
		fis.close();
		
		FileOutputStream foutFile = new FileOutputStream(new File(".\\TestData\\StaffAug_dataPractice.xlsx"));
		
		objWorkbook.write(foutFile);
		
		foutFile.close();
		
	}
	
	
	
	
	
	

}


