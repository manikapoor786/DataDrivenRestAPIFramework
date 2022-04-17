package files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
//import org.testng.annotations.Test;

public class dataDriven {
	//String Testcasename="Delete Profile";
	ArrayList<String> al= new ArrayList<String>();
	
	@Test
	public ArrayList<String> excelIntegration(String Testcasename) throws IOException
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\manish.kapoor\\Documents\\excel1.xlsx");
		XSSFWorkbook xssfworkbook= new XSSFWorkbook(fis);
		int sheets=xssfworkbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(xssfworkbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
			{
				XSSFSheet xssfsheet= xssfworkbook.getSheetAt(i);
				int rowNum= (xssfsheet.getLastRowNum()-xssfsheet.getFirstRowNum())+1;
				for(int j=1;j<rowNum;j++)
				{
					XSSFRow row= xssfsheet.getRow(j);
					int columnNum=(row.getLastCellNum()-row.getFirstCellNum());
					for(int k=1;k<columnNum;k++)
					{
						String Testcases= row.getCell(0).getStringCellValue();
						if(Testcases.equalsIgnoreCase(Testcasename))
						{
							String xssfcell= row.getCell(k).getStringCellValue();
							al.add(xssfcell);
							System.out.println(al);
							
						}
					}
					
				}
				break;
			}
			
		}
		
		xssfworkbook.close();
		return al;
	}
	
}
