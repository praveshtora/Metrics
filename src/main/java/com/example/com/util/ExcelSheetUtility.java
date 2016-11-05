package com.example.com.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by torap on 05/11/16.
 */
public class ExcelSheetUtility {

    private int maxColoumn=5;

    public List<List<String>> readExcelFilebySheet(String fileName, int sheetNum)
{
    List<List<String>> excelData=new ArrayList<>();
    try
    {

        FileInputStream file = new FileInputStream(new File(fileName));

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(sheetNum);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int rownum=0,columnnum;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                columnnum=0;
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                List<String> rowData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()){
                        case  Cell.CELL_TYPE_STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case  Cell.CELL_TYPE_NUMERIC:
                            rowData.add(cell.getNumericCellValue()+"");
                    }

                    columnnum+=1;

                }
                excelData.add(rowData);
                rownum+=1;
                System.out.println("");
            }
        file.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
return excelData;
}
}
