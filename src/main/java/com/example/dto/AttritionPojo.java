package com.example.dto;


/**
 * Created by palsulea on 11/8/2016.
 */
public class AttritionPojo {

    private int retentionRate;
    private int attritionRate;

    public AttritionPojo(int retentionRate, int attritionRate) {
        this.retentionRate = retentionRate;
        this.attritionRate = attritionRate;
    }

    public int getRetentionRate() {
        return retentionRate;
    }

    public void setRetentionRate(int retentionRate) {
        this.retentionRate = retentionRate;
    }

    public int getAttritionRate() {
        return attritionRate;
    }

    public void setAttritionRate(int attritionRate) {
        this.attritionRate = attritionRate;
    }
}
