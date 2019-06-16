package myproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class datadriven {
	@SuppressWarnings("deprecation")
	public ArrayList<String> GetDataFromExcelSheet(String sheetname, String testcasename) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream testdatasheet = new FileInputStream("C:\\Users\\User\\mvnsample\\Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(testdatasheet);

		int sheetcount = workbook.getNumberOfSheets();

		for (int i = 0; i < sheetcount; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase(sheetname)) {
				XSSFSheet expectedsheet = workbook.getSheetAt(i);// expected sheet is got
				Iterator<Row> rows = expectedsheet.iterator();

				while (rows.hasNext()) {
					Row findrow = rows.next();
					Iterator<Cell> searchcell = findrow.cellIterator();

					int k = 0;
					int coloumn = 0;
					while (searchcell.hasNext()) {
						Cell searchcellvalue = searchcell.next();
						if (searchcellvalue.getStringCellValue().equalsIgnoreCase("testcase")) {
							coloumn = k;
						}
						k++;
					}
					if (coloumn != 0) {
						System.out.println(coloumn);
					}

					if (findrow.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> cv = findrow.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();

							a.add(c.getStringCellValue());

						}
					}
				}
			}
		}
		return a;
	}

}