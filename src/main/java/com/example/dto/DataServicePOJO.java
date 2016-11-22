package com.example.dto;

/**
 * Created by torap on 07/11/16.
 */
public class DataServicePOJO {
    private DDXPojo ddxPojo;
    private IAPojo iaPojo;
    private IcapPojo icapPojo;
    private ThreePAPojo threePAPojo;

    public AttritionPojo getAttritionPojo() {
        return attritionPojo;
    }

    public void setAttritionPojo(AttritionPojo attritionPojo) {
        this.attritionPojo = attritionPojo;
    }

    private AttritionPojo attritionPojo;
    public DataServicePOJO(DDXPojo ddxPojo, IAPojo iaPojo, IcapPojo icapPojo, ThreePAPojo threePAPojo,AttritionPojo attrition) {
        this.ddxPojo = ddxPojo;
        this.iaPojo = iaPojo;
        this.icapPojo = icapPojo;
        this.threePAPojo = threePAPojo;
        this.attritionPojo = attrition;
    }

    public DDXPojo getDdxPojo() {
        return ddxPojo;
    }

    public void setDdxPojo(DDXPojo ddxPojo) {
        this.ddxPojo = ddxPojo;
    }

    public IAPojo getIaPojo() {
        return iaPojo;
    }

    public void setIaPojo(IAPojo iaPojo) {
        this.iaPojo = iaPojo;
    }

    public IcapPojo getIcapPojo() {
        return icapPojo;
    }

    public void setIcapPojo(IcapPojo icapPojo) {
        this.icapPojo = icapPojo;
    }

    public ThreePAPojo getThreePAPojo() {
        return threePAPojo;
    }

    public void setThreePAPojo(ThreePAPojo threePAPojo) {
        this.threePAPojo = threePAPojo;
    }
}
