package com.example;

import com.example.com.util.ExcelSheetUtility;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

import org.apache.xmlbeans.XmlObject;
/**
 * Created by torap on 05/11/16.
 */
public class ReadExcelDemo {

    public static void main(String args[]){
        ExcelSheetUtility sheetUtility=new ExcelSheetUtility();
        List<List<String>> excelData = sheetUtility.readExcelFilebySheet("/Users/torap/metrics/src/main/java/com/example/DataServices.xlsx",0);
        System.out.println(excelData);

}
}


