package com.example.com.util;

import com.example.domain.DDX;
import com.example.domain.IA;
import com.example.domain.ICAP;
import com.example.domain.ThreePA;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

/**
 * Created by palsulea on 11/5/2016.
 */
public class PopulateTableUtility {
    private List<List<String>> excelData;
    private IA ia = new IA();
    private ICAP icap = new ICAP();
    private ThreePA threePA = new ThreePA();
    private DDX ddx = new DDX();
    private static final int HEADCOUNT = 0;
    private static final int PORTFOLIOS_MANAGED = 1;
    private static final int ATTRITION = 2;
    private static final int SCORECARD = 3;
    private static final int ROW_NAME =0;
    private static final int ROW_VALUE = 1;
    public void populateHeadCount(String filePath){
        excelData = ExcelSheetUtility.readExcelFilebySheet(filePath,HEADCOUNT);
        for (List<String> row : excelData){
            switch (row.get(ROW_NAME)){
                case "IA":
                    ia.setHeadCount(Integer.parseInt(row.get(ROW_VALUE)));
                    break;
                case "ICAP":
                    ia.setHeadCount(Integer.parseInt(row.get(ROW_VALUE)));
                    break;
                case "DDX":
                    ia.setHeadCount(Integer.parseInt(row.get(ROW_VALUE)));
                    break;
                case "3PA":
                    ia.setHeadCount(Integer.parseInt(row.get(ROW_VALUE)));
                    break;
            }


        }
    }
}
