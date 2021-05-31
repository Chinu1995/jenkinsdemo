package excelDataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterByColumnNumber 
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\chinmaya\\Desktop\\testdata1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row =sheet.getRow(1);
		XSSFCell cell = row.getCell(4);
		
		XSSFFont font = wb.createFont();
		XSSFCellStyle style = wb.createCellStyle();
		
		font.setFontName("algerian");
		font.setFontHeight(14.0);
		font.setBold(true);
		
		style.setFont(font);
		
		cell.setCellValue("Passed");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\chinmaya\\Desktop\\testdata1.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		
	}

}
