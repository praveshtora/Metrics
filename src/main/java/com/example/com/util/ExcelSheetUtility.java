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


public class ExcelSheetUtility {

    private int maxColoumn = 5;

    public static List<List<String>> readExcelFilebySheet(String fileName, int sheetNum) {
        List<List<String>> excelData = new ArrayList<List<String>>();
        try {

            FileInputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(sheetNum);
            Iterator<Row> rowIterator = sheet.iterator();
            int rownum = 0, columnnum;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                columnnum = 0;
                Iterator<Cell> cellIterator = row.cellIterator();
                List<String> rowData = new ArrayList<String>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            rowData.add(cell.getNumericCellValue() + "");
                    }
                    columnnum += 1;
                }
                excelData.add(rowData);
                rownum += 1;
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelData;
    }
}
