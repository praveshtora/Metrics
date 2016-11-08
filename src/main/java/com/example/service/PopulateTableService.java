package com.example.service;

import com.example.com.util.ExcelSheetUtility;
import com.example.dao.*;
import com.example.domain.*;
import com.example.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

/**
 * Created by palsulea on 11/5/2016.
 */
@Service
public class PopulateTableService {
    @Autowired
    DdxDAO ddxDAO;
    @Autowired
    IaDAO iaDAO;
    @Autowired
    IcapDAO icapDAO;
    @Autowired
    ThreePADAO threePADAO;
    @Autowired
    AttritionDAO attritionDAO;


    private List<List<String>> excelData;
    private IA ia = new IA();
    private ICAP icap = new ICAP();
    private ThreePA threePA = new ThreePA();
    private DDX ddx = new DDX();
    private Attrition attrition = new Attrition();
    private static final int HEADCOUNT = 0;
    private static final int ATTRITION = 1;
    private static final int PRODUCTIVITY = 2;

    private static final int ROW_NAME =0;
    private static final int ROW_VALUE = 1;
    private void populateHeadCount(String filePath){
        excelData = ExcelSheetUtility.readExcelFilebySheet(filePath,HEADCOUNT);
        for (List<String> row : excelData){
            switch (row.get(ROW_NAME)){
                case "IA":
                    ia.setHeadCount((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
                case "ICAP":
                    icap.setHeadCount((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
                case "DDX":
                    ddx.setHeadCount((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
                case "3PA":
                    threePA.setHeadCount((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
            }
        }
    }
    private void populateProductivity(String filePath){
        excelData = ExcelSheetUtility.readExcelFilebySheet(filePath,PRODUCTIVITY);
        for (List<String> row : excelData){
            switch (row.get(ROW_NAME)){
                case "IA":
                    ia.setProductivity((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
                case "ICAP":
                    icap.setProductivity((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
                case "DDX":
                    ddx.setProductivity((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
                case "3PA":
                    threePA.setProductivity((int)Double.parseDouble(row.get(ROW_VALUE)));
                    break;
            }
        }
    }
    private void populateAttrition(String filepath){
        excelData = ExcelSheetUtility.readExcelFilebySheet(filepath,ATTRITION);
        for (List<String> row : excelData){
        if(row.get(0).equals("Retention Score")){
            attrition.setRetentionRate((int)Double.parseDouble(row.get(1)));
        }else{
            attrition.setAttritionRate((int)Double.parseDouble(row.get(1)));
        }
        }
    }
    public void populatedDatabaseTables(String filepath){
        populateHeadCount(filepath);
        populateProductivity(filepath);
        populateAttrition(filepath);
        ddxDAO.save(ddx);
        icapDAO.save(icap);
        iaDAO.save(ia);
        threePADAO.save(threePA);
        attritionDAO.save(attrition);
    }
    public DataServicePOJO getDataServicePOJO(){
        DDX ddxDomain = ddxDAO.findOne((long) 1);
        IA iaDomain= iaDAO.findOne((long)1);
        ICAP icapDomain=icapDAO.findOne((long)1);
        ThreePA threeDomain=threePADAO.findOne((long)1);
        Attrition attrition = attritionDAO.findOne((long)1);
        DDXPojo ddxPojo=new DDXPojo(ddxDomain.getHeadCount(),ddxDomain.getProductivity());
        IAPojo iaPojo=new IAPojo(iaDomain.getHeadCount(),iaDomain.getProductivity());
        IcapPojo icapPojo=new IcapPojo(icapDomain.getHeadCount(),icapDomain.getProductivity());
        ThreePAPojo threePAPojo=new ThreePAPojo(threeDomain.getHeadCount(),threeDomain.getProductivity());
        AttritionPojo attritionPojo = new AttritionPojo(attrition.getRetentionRate(),attrition.getAttritionRate());
        DataServicePOJO dataServicePOJO=new DataServicePOJO(ddxPojo,iaPojo,icapPojo,threePAPojo,attritionPojo);
        return dataServicePOJO;
    }
}
