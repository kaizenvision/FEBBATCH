package com.utility;

import com.baseclass.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader extends BaseClass {

    // excel-sheet read done
    // sheet done
    // particular cell data done
    // particular row data done
    // all data need improvement

    public static FileInputStream readExcelSheet(String excelName) throws FileNotFoundException {
       // System.out.println(projectpath+"src/test/resources/data/hr.xlsx");
        FileInputStream fis = new FileInputStream(projectpath+"/src/test/resources/data/"+excelName);
        return fis;
    }

    public static Sheet getSheet(FileInputStream fis, String sheetName) throws IOException {
        Sheet sh = WorkbookFactory.create(fis).getSheet(sheetName);
        return sh;
    }

    public static Object getSingleCellData(Sheet sh, int rowNum, int cellNum){
        if(sh.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("string"))
            return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
        else
            return sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
    }

    public static Map getRowData(Sheet sh, int rowNum){
        Map<String,Object> rowData = new HashMap<>();

        int cellNum = sh.getRow(rowNum).getLastCellNum();
        for(int i=0; i<cellNum ; i++){

            if(sh.getRow(rowNum).getCell(i).getCellType().toString().equalsIgnoreCase("string"))
                rowData.put(sh.getRow(0).getCell(i).getStringCellValue(),
                        sh.getRow(rowNum).getCell(i).getStringCellValue());

            else
                rowData.put(sh.getRow(0).getCell(i).getStringCellValue(),
                        sh.getRow(rowNum).getCell(i).getNumericCellValue());

        }
        return rowData;

    }

    public void getAllExcelData(Sheet sh){

        for (int row=0; row<sh.getLastRowNum();row++){
            Map<String,Object> rowData = new HashMap<>();
            int cellNum = sh.getRow(row).getLastCellNum();
            for(int cell=0; cell<cellNum;cell++){
                if(sh.getRow(row).getCell(cellNum).getCellType().toString().equalsIgnoreCase("string"))
                    rowData.put(sh.getRow(0).getCell(cell).getStringCellValue(),
                            sh.getRow(row).getCell(cell).getStringCellValue());

                else
                    rowData.put(sh.getRow(0).getCell(cell).getStringCellValue(),
                            sh.getRow(row).getCell(cell).getNumericCellValue());
            }
        }
    }

}
