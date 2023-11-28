package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	public static void main(String[] args) {

	}

	@DataProvider
	public String[][] getData() throws EncryptedDocumentException, IOException {
		File excelfile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		System.out.println(excelfile.exists());
		FileInputStream fis = new FileInputStream(excelfile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Login");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(sheet.getPhysicalNumberOfRows());
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println(sheet.getRow(0).getLastCellNum());

		String[][] data = new String[noOfRows - 1][noOfColumns];
		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
				sheet.getRow(i).getCell(j).getStringCellValue();
			}

		}
		wb.close();
		fis.close();
		return data;
	}

}
