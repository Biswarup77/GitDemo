package ipg.StaffAug;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_ExcelData {

	// Identify testcases column by scanning the entire first row
	// Once column is identified then scan entire testcase column to identify
	// Purchase Testcase
	// After you grab Purchase testcase row = pull all the data of that row and feed
	// into test

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
//		  FileInputStream fis = new FileInputStream(
//		  "C:\\Users\\04819I744\\eclipse-workspace\\StaffAug\\src\\main\\java\\resource\\data.properties"
//		  ); Properties prop = new Properties(); prop.load(fis); String site =
//		  prop.getProperty("site");
//		  
//		  System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
//		  WebDriver driver = new ChromeDriver();
//		  
//		  driver.get(site); driver.manage().window().maximize();
//		  
//		  driver.findElement(By.name("email")).sendKeys("test");
//		  driver.findElement(By.name("pass")).sendKeys("test");
		 
		
		//Fatching file by file path
		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\04819I744\\eclipse-workspace\\StaffAug\\StaffAug_data1.xlsx");
		
		//Creating workbook object of the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis2);
		
		//Counting the worksheet 
		int sheetCount = workbook.getNumberOfSheets();
		
		//Looping through the worksheets
		for (int i = 0; i < sheetCount; i++) {
			
			//Fetching worksheet name
			String sheetName = workbook.getSheetName(i);
						
			//Comparing worksheet name with the desired one
			if (sheetName.equalsIgnoreCase("facebook")) {
				
				//Creating Worksheet object of the desired Worksheet
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//XSSFSheet sheet2 = workbook.createSheet("Amazon");	//Creating a sheet
				
				//Creating row iterator for the desired Worksheet, preaparing row for Iteration
				Iterator<Row> rows = sheet.rowIterator();
				
				
				//First Row specific Block
				Row firstrow = rows.next();
				
				//Creating cell iterator for first row, preparing cell for iteration
				Iterator<Cell> cells = firstrow.cellIterator();
				int colUsername = 0;
				
				////iterating through all the cell from left to right of first Row {rows.next} by using while loop
				while (cells.hasNext()) {
					
					//capturing the first immediate cell of row 1 {Cause writing cells.next first time}
					Cell firstCell = cells.next();

					if (firstCell.getStringCellValue().equalsIgnoreCase("Username")) {

						colUsername = firstCell.getColumnIndex();
						System.out.println(colUsername);

					}

				}
				
				
				//Visit all row one by one, when the row is available
				while(rows.hasNext())
				{
					//Capturing the specific row 
					Row desiredrow = rows.next();
					
					//Creating cell iterator for specific row, preparing cell for iteration
					Iterator<Cell> nextCells = desiredrow.cellIterator();
					
					////iterating through all the cell from left to right of that specific Row
					while (nextCells.hasNext()) {
							
							Cell desiredCell = nextCells.next();
						
							int colIndex = desiredCell.getColumnIndex();
							if (colIndex == colUsername)
							{
								System.out.println(desiredCell.getStringCellValue());
								
							}
							

				}	

				}

			}

		}

		// Identify testcases column by scanning the entire first row

	}

}
