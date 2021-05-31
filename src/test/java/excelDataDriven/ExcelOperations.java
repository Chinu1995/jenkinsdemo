package excelDataDriven;

public class ExcelOperations {

	public static void main(String[] args) throws Exception {
		
		ExcelAPI e=new ExcelAPI("C:\\Users\\chinmaya\\Desktop\\testdata1.xlsx");
		System.out.println(e.getCellData("login", 1, 2));//column no
		System.out.println(e.getCellData("login", 4, 2));//column no
		System.out.println(e.getCellData("login", "UserName", 2));//column name

	e.setCellData("login", 4, 4, "Passed");
		e.setCellData("login", 4, 2, "Skipped");
	}

}
