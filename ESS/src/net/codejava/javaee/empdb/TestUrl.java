package net.codejava.javaee.empdb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings("OBL_UNSATISFIED_OBLIGATION_EXCEPTION_EDGE")
public class TestUrl {

	public static final  String path = "C:\\cucumberRepo\\CucumberMavenBDD\\TestDataFiles\\TestData.xlsx";
	public static final String TestUrl = "http://localhost:8088/ESS/list";

	@SuppressFBWarnings("DMI_HARDCODED_ABSOLUTE_FILENAME")
	public static void main(String[] args) throws Exception {

		setcelldata(path, "Sheet1", "URL", TestUrl);

	}
	


	public static void setcelldata(String path, String sheetName, String colName, String data) throws IOException {
		// create an object of Workbook and pass the FileInputStream object into
		// it to create a pipeline between the sheet and eclipse.
		System.out.println("Writing Innertext in to" + path + " --" + sheetName + " --" + colName + "-- " + data + "");
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int col_Num = -1;
		XSSFRow row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
				col_Num = i;
			}
		}
		int rowNum = 1;

		row = sheet.getRow(rowNum);
		if (row == null)
			row = sheet.createRow(rowNum);

		XSSFCell cell = row.getCell(col_Num);
		if (cell == null)
			cell = row.createCell(col_Num);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		fos.close();
		System.out.println("End writing " + data + " into this file path: " + path + "   Sheet name: " + sheetName
				+ "   Column name: " + colName + "");
	}

	

	

}
