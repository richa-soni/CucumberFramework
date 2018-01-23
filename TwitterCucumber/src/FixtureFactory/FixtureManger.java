package FixtureFactory;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import cucumber.api.java.Before;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import stepsLibrary.commonSteps;

public class FixtureManger {
	
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  String path;
	public String rowKey;
	
		
	public FileInputStream fileLoad(String path) throws IOException {
		FileInputStream file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheetAt(0);
		
		return file;
	}
    
	public String fileRead(String column) throws IOException {
		this.rowKey=commonSteps.rowKey;
		if(column.contains("#")) {
		String col=column.substring(1, column.length());
		int coulmnIndex=0;
		String cellValue=null;
		int coloumnLength=sheet.getRow(0).getLastCellNum();
		Map<Integer,String> columnHeaders=new HashMap<Integer,String>();
		for(int i=0;i<coloumnLength;i++) {
			columnHeaders.put(i, sheet.getRow(0).getCell(i).getStringCellValue());
			System.out.println(columnHeaders.get(i).toString());
			if(columnHeaders.get(i).toString().equalsIgnoreCase(col)) {
				coulmnIndex=i;
				break;
			}
			
		}
		
		
		Iterator <Row> itRow=sheet.iterator();
		while(itRow.hasNext()) {
			Row row=itRow.next();
			String s=row.getCell(0).getStringCellValue();
			if(row.getCell(0).getStringCellValue().equals(rowKey)) {
				Iterator<Cell>itCell=row.iterator();
				while(itCell.hasNext()) {
					Cell cell=itCell.next();
					if(cell.getColumnIndex()==coulmnIndex) {
						cellValue=cell.getStringCellValue();
						break;
					}
					
				}
				break;
			}
		
		}
		return cellValue;
		}else {
			return column;
		}
	
		
		
	}
}
