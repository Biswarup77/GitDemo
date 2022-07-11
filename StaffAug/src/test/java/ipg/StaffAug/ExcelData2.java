package ipg.StaffAug;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData2 {
	
	
	public static void main (String args[]) throws IOException
	{
		ArrayList a = new ArrayList();
		String path = System.getProperty("user.dir")+"\\StaffAug_data1.xlsx";		
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int noOfSheet = workbook.getNumberOfSheets();
		
		for(int i=0;i<noOfSheet;i++)
		{
			
			XSSFSheet sheet = workbook.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			
			if(sheetName.equalsIgnoreCase("facebook"))
			{
				
				Iterator<Row> rows = sheet.rowIterator();
				
				Row firstRow = rows.next();
								
				Iterator<Cell> cells = firstRow.cellIterator();
					
				int desiredHeaderCell = 0;						
				while(cells.hasNext())
				{	
					
					Cell firstCell = cells.next();
					String cellValue_FirstRow = firstCell.getStringCellValue();
					if(cellValue_FirstRow.equalsIgnoreCase("Name"))
					{
						
						desiredHeaderCell = firstCell.getColumnIndex();		
						
					}
					
					
					
				}
				while(rows.hasNext())
				{
					
					Row desiredrow = rows.next();
					Cell desiredCell = desiredrow.getCell(desiredHeaderCell);
					if(desiredCell.getStringCellValue().equalsIgnoreCase("Biswarup"))
					{
						
						System.out.println(desiredCell.getRowIndex());
						System.out.println(desiredCell.getColumnIndex());	
						
						Iterator<Cell> cells_desiredrow = desiredrow.cellIterator();
						
						while(cells_desiredrow.hasNext())
						{
							Cell newdesired_Cell = cells_desiredrow.next();
							if(newdesired_Cell.getCellType()==CellType.STRING)
							{
								
								a.add(newdesired_Cell.getStringCellValue());
								
							}
							else
							{							
								a.add(NumberToTextConverter.toText(newdesired_Cell.getNumericCellValue()));
							}
							
							
							
							
						}
					}
					
					
				}
				for(int j=0;j<a.size();j++)
				{
					System.out.println(""+a.get(j));
					
				}
					
				
			}
			
			
			
			
		}
		
	}
	
	
	
	
}
