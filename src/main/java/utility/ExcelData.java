package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public  HashMap<String,String> getExcelData(String path,int index) throws IOException {
		FileInputStream fileStream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		int count = workbook.getSheetIndex("Sheet1");
		XSSFSheet sheet = workbook.getSheetAt(count);
		XSSFRow row1 = sheet.getRow(0);
		Iterator<Cell> cells1 = row1.cellIterator();
		XSSFRow row2 = sheet.getRow(index);
		Iterator<Cell> cells2 = row2.cellIterator();
		HashMap<String, String> map = new HashMap<String, String>();
		DataFormatter formatter = new DataFormatter();
		while(cells1.hasNext() && cells2.hasNext()) {
			String st1 = formatter.formatCellValue(cells1.next());
			String st2 = formatter.formatCellValue(cells2.next());
			map.put(st1,st2);
			System.out.println(st1);
			System.out.println(st2);
		}
		return map;
	}
}
