package innovationsPortal;


import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelp {

	public int readExcel(String filePath, String sheetName, int rowNum, int cellNum ) throws IOException {

		// Create an object of File class to open xlsx file

		File file = new File(filePath);

		// Create an object of FileInputStream class to read excel file

		InputStream fis = new FileInputStream(file);

		@SuppressWarnings("resource")
		Workbook wb = new XSSFWorkbook(fis);

		// Read sheet inside the workbook by its name

		Sheet sh = wb.getSheet(sheetName);

		// Find number of rows in excel file

		//int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();

		//Reporter.log("Row count value is: " + rowCount, true);

		// Create a loop over all the rows of excel file to read it

		//for (int i = 1; i < rowCount + 1; i++) {

			// Print Excel data in console
			
			Cell cell = sh.getRow(rowNum).getCell(cellNum);
						
			return (int) cell.getNumericCellValue();

	//	}

	}

	// Test function is calling readExcel function to read data from excel file
	

}
