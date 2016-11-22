package com.example.controller;

import com.example.dto.DataServicePOJO;
import com.example.service.PopulateTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by palsulea on 11/8/2016.
 */
@RestController
public class Controller {
    @Autowired
    private PopulateTableService populateTableService;

    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    public void add(){
        populateTableService.populatedDatabaseTables("/Users/torap/Documents/metrics/src/main/resources/static/DataServices.xlsx");
    }
    @RequestMapping(value="/get",method = RequestMethod.GET)
    @ResponseBody
    public DataServicePOJO getFromTable(){
        return populateTableService.getDataServicePOJO();
    }

}
